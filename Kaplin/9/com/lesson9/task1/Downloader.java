package com.lesson9.task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class Downloader {
    final private List<String> links;
    private CopyOnWriteArrayList<DownloadResult> downloadResults = new CopyOnWriteArrayList<>();


    public Downloader(List<String> links) {
        this.links = links;
    }

    public void sequentialDownload(String filePath) {
        long start = System.currentTimeMillis();
        downloadResults.clear();
        File file = new File(filePath);
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (String link : links) {
                DownloadResult downloadResult = getLinkDataForWrite(link);
                writeInfo(fileWriter, downloadResult);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long totalTime = System.currentTimeMillis() - start;
        showDownloadBenchmark(totalTime);
    }

    public void parallelDownload(String filePath) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        downloadResults.clear();
        ExecutorService executor = Executors.newFixedThreadPool(links.size());
        List<Future<DownloadResult>> futures = new ArrayList<>();
        for (String link : links) {
            final Future<DownloadResult> submit = executor.submit(() -> getLinkDataForWrite(link));
            futures.add(submit);
        }
        File file = new File(filePath);
        try (FileWriter fileWriter = new FileWriter(file)) {
            for(Future<DownloadResult> future : futures) {
                DownloadResult downloadResult = future.get();
                writeInfo(fileWriter, downloadResult);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        long totalTime = System.currentTimeMillis() - start;
        showDownloadBenchmark(totalTime);
    }



    private DownloadResult getLinkDataForWrite(String link) throws MalformedURLException {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(getStartMarker(link));
        URL website = new URL(link);
        DownloadResult downloadResult;
        try (InputStream uis = website.openStream()) {
            int read;
            long size = new byte[uis.available()].length;

            while ((read = uis.read()) != -1) {
                stringBuffer.append(read);
            }
            downloadResult = new DownloadResult( true, link, size, stringBuffer.toString());
            stringBuffer.append(getEndMarker(link));
        } catch (IOException e) {
            stringBuffer.append("Сайт не загружен");
            stringBuffer.append(getEndMarker(link));
            downloadResult = new DownloadResult( false, link, 0, stringBuffer.toString());
        }
        downloadResults.add(downloadResult);
        return downloadResult;
    }

    private void writeInfo(FileWriter fw, DownloadResult downloadResult) throws IOException {
        if(downloadResult.wasDownloaded()) {
            fw.write(downloadResult.getDataForWrite());
        }
    }

    private String getStartMarker(String link) {

        return String.format("===== НАЧАЛО САЙТА <%s> ======%n", link);
    }

    private String getEndMarker(String link) {

        return String.format("===== КОНЕЦ САЙТА <%s> ======%n", link);
    }

    private void showDownloadBenchmark(long totalTime) {
        Long sitesSize = downloadResults
                .stream()
                .mapToLong(DownloadResult::getSize).sum();
        System.out.printf("Было потрачено %s милисекунд, загружено %s байт%n", totalTime, sitesSize);
    }

}
