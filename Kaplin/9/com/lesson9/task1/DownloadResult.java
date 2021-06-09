package com.lesson9.task1;

public class DownloadResult {
    private final String link;
    private final boolean wasDownloaded;
    private final long size;
    private final String dataForWrite;

    public DownloadResult(boolean wasDownloaded, String link, long size, String dataForWrite) {
        this.wasDownloaded = wasDownloaded;
        this.link = link;

        this.size = size;
        this.dataForWrite = dataForWrite;
    }

    public String getLink() {
        return link;
    }

    public long getSize() {
        return size;
    }

    public String getDataForWrite() {
        return dataForWrite;
    }

    public boolean wasDownloaded() {
        return wasDownloaded;
    }
}
