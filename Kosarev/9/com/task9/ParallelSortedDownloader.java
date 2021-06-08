package com.task9;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;


public class ParallelSortedDownloader implements Downloader {

    protected static final File NO_FILE    = new File("");
    protected static final int BUFFER_SIZE = 8_000;
    private final File container;
    private long downloadedBytes;

    public ParallelSortedDownloader(String containerName) {
        this.container = createContainer(containerName);
        this.downloadedBytes = 0;
    }

    protected String getTmpContainerName(String url) {
        return String.format("tmp_%s.txt", url.replaceAll("\\W", "_"));
    }

    @Override
    public Map<String, Boolean> writeAllSitesToStream(List<String> urls, OutputStream dest) {
        // хотелось бы concurrent map, который бы итерировал пары в порядке добавления...
        Map<String, File> urlToTmpFileMap = Collections.synchronizedMap(new LinkedHashMap<>());
        urls.forEach(u -> urlToTmpFileMap.put(u, NO_FILE));

        // спасибо https://stackoverflow.com/a/51006865
        List<CompletableFuture<Boolean>> futures = new ArrayList<>();
        for (String url : urls) {
            futures.add(CompletableFuture.supplyAsync( () -> {
                SequentialDownloader s = new SequentialDownloader(getTmpContainerName(url));
                Boolean res = s.writeAllSites(List.of(url)).get(url);
                urlToTmpFileMap.put(url, s.getContainer());
                addDownloadedBytes(s.getDownloadedBytes());
                return res;
            } ));
        }
        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();

        for (Map.Entry<String, File> urlFileEntry : urlToTmpFileMap.entrySet()) {
            // пока доделывал услышал про Piped- стримы -- мб стоило сделать на них
            try (InputStream tmpfis = new BufferedInputStream(
                    new FileInputStream(urlFileEntry.getValue()), BUFFER_SIZE)) {
                int read;
                while ( (read = tmpfis.read()) != -1 )
                    dest.write(read);
            } catch (IOException e) {
                e.printStackTrace();
            }
            urlFileEntry.getValue().delete();
        }

        return urlToTmpFileMap.entrySet()
                              .stream()
                              .collect(Collectors.toMap(Map.Entry::getKey, e -> !e.getValue().equals(NO_FILE)));
    }

    @Override
    public File getContainer() {
        return container;
    }

    @Override
    public void addDownloadedBytes(long b) {
        downloadedBytes += b;
    }

    @Override
    public long getDownloadedBytes() {
        return downloadedBytes;
    }
}
