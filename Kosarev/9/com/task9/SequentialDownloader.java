package com.task9;

import java.io.File;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SequentialDownloader implements Downloader {

    private final File container;
    private long downloadedBytes;

    public SequentialDownloader(String containerName) {
        this.container = createContainer(containerName);
        this.downloadedBytes = 0;
    }

    @Override
    public Map<String, Boolean> writeAllSitesToStream(List<String> urls, OutputStream dest) {
        Map<String, Boolean> downloadStatus = new HashMap<>();

        for (String url : urls) {
            URL website;

            System.out.printf("Fetching \"%s\"%n", url);
            try {
                website = new URL(url);
            } catch (MalformedURLException e) {
                System.out.printf("Failed to fetch \"%s\"%n", url);
                downloadStatus.put(url, false);
                continue;
            }
            downloadStatus.put(url, writeSiteToStream(website, dest));
        }

        return downloadStatus;
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
