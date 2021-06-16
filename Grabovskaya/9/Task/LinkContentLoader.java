package Task;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap;
import java.util.concurrent.*;

public class LinkContentLoader
{
    final private List<String> links;

    public LinkContentLoader(List<String> links)
    {
        this.links = links;
    }

    private Map.Entry<String, String> loadLinkContent(String link)
    {
        byte[] buffer = new byte[0];
        try (InputStream is = new URL(link).openStream())
        {
            buffer = is.readAllBytes();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // А тут возможно такое, что подставится ссылка не для того содержимого?
        return new AbstractMap.SimpleEntry<>(link, new String(buffer));
    }

    public List<Map.Entry<String, String>> loadLinkContentSequentially()
    {
        List<Map.Entry<String, String>> linksAndTheirContent = new ArrayList<>();
        links.forEach(link -> linksAndTheirContent.add(loadLinkContent(link)));
        return linksAndTheirContent;
    }

    public List<Map.Entry<String, String>> loadLinkContentParallel() throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        List<Future<Map.Entry<String, String>>> futures = new ArrayList<>();
        for (String link : links)
        {
            Future<Map.Entry<String, String>> completableFuture = CompletableFuture.supplyAsync(() ->
                    loadLinkContent(link), threadPool);
            futures.add(completableFuture);
            // тут если получать данные из Future сразу и записывать в потокобезопасную коллекцию,
            // то на загрузку содержимого ссылок тратиться чуть меньше времени, чем в одном потоке,
            // т.е. разница совсем минимальна
        }

        List<Map.Entry<String, String>> linksAndTheirContent = new ArrayList<>();
        for (Future<Map.Entry<String, String>> future : futures)
        {
            linksAndTheirContent.add(future.get());
        }
        threadPool.shutdown();

        return linksAndTheirContent;
    }
}
