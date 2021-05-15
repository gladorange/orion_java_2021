package com.orion.lesson5;

import java.io.FileWriter;
import java.io.IOException;

public class Finally {


    public static void main(String[] args) throws Exception {


        boolean isFileWritten = false;
        while (true) {
            FileWriter fileWriter = null;
            try {
                Thread.sleep(5000);

                if (isFileWritten) {
                    System.out.println("Файл записан, ничего не делаю");
                }

                fileWriter = new FileWriter("someFile.txt");
                fileWriter.append("some text");
                fileWriter.flush();
                if (true) {
                    throw new IllegalArgumentException("Место закончилось");
                }
                isFileWritten = true;
            } catch (Exception e) {
                System.out.println("Записать не удалось, пробуем еще раз");
            } finally {
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (Exception e) {

                    }
                }
            }


            try ( FileWriter anotherFileWriter = new FileWriter("anotherFile") ) {
                Thread.sleep(5000);
                if (isFileWritten) {
                    System.out.println("Файл записан, ничего не делаю");
                }
                anotherFileWriter.append("some text");
                anotherFileWriter.flush();
                if (true) {
                    throw new IllegalArgumentException("Место закончилось");
                }
                isFileWritten = true;
            } catch (Exception e) {
                System.out.println("Записать не удалось, пробуем еще раз");
            }

        }
    }
}
