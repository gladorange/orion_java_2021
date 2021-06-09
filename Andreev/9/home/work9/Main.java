package home.work9;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        App app = new App();
        app.doSequentialDownload();
        app.doParallelDownload();
    }
}
