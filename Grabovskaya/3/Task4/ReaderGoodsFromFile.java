package Task4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReaderGoodsFromFile
{
    private static List<String> goods;

    static List<String> readGoodsFromFile()
    {
        goods = new ArrayList<>();
        String filePath = "Grabovskaya\\3\\GoodsCatalog";
        String absPath = Path.of(filePath).toAbsolutePath().toString();
        try (BufferedReader reader = new BufferedReader(new FileReader(absPath)))
        {
            String line = reader.readLine();
            while (line != null)
            {
                goods.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return goods;
    }
}
