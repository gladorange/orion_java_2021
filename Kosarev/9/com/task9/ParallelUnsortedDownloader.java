package com.task9;

import java.io.*;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

public class ParallelUnsortedDownloader extends ParallelSortedDownloader {
    /*
        мне было интерестно посмотреть насколько будет отличаться время
        при использовании ConcurrentHashMap и synchronizedMap(LinkedHashMap)

        UPD: не особо быстрее, а даже медленнее =/
    */

    public ParallelUnsortedDownloader(String containerName) {
        super(containerName);
    }

    @Override
    public Map<String, Boolean> writeAllSitesToStream(List<String> urls, OutputStream dest) {
        Map<String, File> urlToTmpFileMap = new ConcurrentHashMap<>();
        urls.forEach(u -> urlToTmpFileMap.put(u, NO_FILE));

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
}
