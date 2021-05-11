package read.usemsg;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Класс содержит функцию вывода Usemsg.
 */
public class Usemsg {
    /**
     * Функция вывод содержимого файла в консоль
     * @param inputFileName Имя файла,для вывода.
     */
    public static void show( String inputFileName ){

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line + "\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}
