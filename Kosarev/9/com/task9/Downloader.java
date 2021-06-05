package com.task9;

import java.io.*;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public interface Downloader {
    /*
        М.б. немного хитро получилось, зато для реализации последовательного и параллельного загрузчика
        необходимо только переопределить два метода - почти не придется дублировать код.
        UPD: 4 метода и 2 из них - дубликаты -- надо было абстрактный класс делать =/
    */

    String START_SITE_PATTERN = "\n\n===== НАЧАЛО САЙТА %s ======\n";
    String END_SITE_PATTERN   = "\n====== КОНЕЦ САЙТА %s ======\n";
    Map<String, Boolean> writeAllSitesToStream(List<String> urls, OutputStream dest);
    File getContainer();
    // а вообще можно было не мучаться с записью в переменных из многопотока, а просто взять размер файла 🤔
    void addDownloadedBytes(long b);
    long getDownloadedBytes();

    default void benchmark(List<String> urls) {
        Instant sequentialStartTime = Instant.now();
        Map<String, Boolean> sequentialStatus = writeAllSites(urls);
        Instant sequentialFinishTime = Instant.now();
        long sequentialDurationTime = Duration.between(sequentialStartTime, sequentialFinishTime).toMillis();
        System.out.println();
        System.out.println("Status report:");
        System.out.printf("    Start time       : %s%n", sequentialStartTime);
        System.out.printf("    Finish time      : %s%n", sequentialFinishTime);
        System.out.printf("    Duration         : %d ms%n", sequentialDurationTime);
        System.out.printf("    Bytes downloaded : %d B%n", getDownloadedBytes());
        System.out.printf("    Is content downloaded from site:%n");
        sequentialStatus.forEach((key, value) -> System.out.printf("        %s: %s%n", StringUtils.ljust(key, 40), value));
    }

    default Map<String, Boolean> writeAllSites(List<String> urls) {
        Map<String, Boolean> downloadStatus = new HashMap<>();
        try (FileOutputStream fos = new FileOutputStream(getContainer())) {
            downloadStatus = writeAllSitesToStream(urls, fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return downloadStatus;
    }

    default boolean writeSiteToStream(URL src, OutputStream dest) {
        try (InputStream uis = src.openStream()) {
            dest.write(String.format(START_SITE_PATTERN, src).getBytes());
            int read;
            while ((read = uis.read()) != -1) {
                dest.write(read);
                addDownloadedBytes(1);
            }
            dest.write(String.format(END_SITE_PATTERN, src).getBytes());
        } catch (IOException e) {
            System.out.printf("Failed to get site content \"%s\"%n", src);
            return false;
        }
        return true;
    }

    default File createContainer(String containerName) {
        Objects.requireNonNull(containerName, "containerName");
        File container = new File(containerName);
        try {
            container.createNewFile();
        } catch (IOException e) {
            System.out.printf("Failed to create file \"%s\"%n", container.getAbsolutePath());
        }
        return container;
    }

}

class StringUtils {
    public static String ljust(String str, int length) {
        if (str.length() >= length)
            return str;
        return str + " ".repeat(length - str.length());
    }
}
