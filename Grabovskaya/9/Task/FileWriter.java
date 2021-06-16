package Task;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class FileWriter
{
    static public void writeToFile(List<Map.Entry<String, String>> linksAndTheirContent, String fileName)
    {
        try (OutputStream os = new FileOutputStream(fileName))
        {
            linksAndTheirContent.forEach(entry -> {
                String sb = "===== НАЧАЛО САЙТА <" + entry.getKey() + "> ======\n"
                        + entry.getValue() + "\n"
                        + "===== КОНЕЦ САЙТА <" + entry.getKey() + "> ======\n\n";
                try {
                    os.write(sb.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
