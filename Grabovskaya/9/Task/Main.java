package Task;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Main
{
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        List<String> links = List.of("https://tproger.ru/translations/java8-concurrency-tutorial-1/",
                                     "https://javarush.ru/quests/lectures/questsyntaxpro.level15.lecture06",
                                     "https://stackoverflow.com/questions/351565/system-currenttimemillis-vs-system-nanotime",
                                     "https://medium.com/german-gorelkin/low-coupling-high-cohesion-d36369fb1be9",
                                     "http://cpp-reference.ru/articles/lazy-initialization/",
                                     "http://java-online.ru/concurrent-executor.xhtml",
                                     "https://coderlessons.com/articles/java/executorservice-10-sovetov-i-podskazok",
                                     "https://pro-java.ru/java-dlya-opytnyx/interfejsy-callable-i-future-v-java/",
                                     "http://java-online.ru/concurrent-callable.xhtml",
                                     "https://howtodoinjava.com/java/multi-threading/java-callable-future-example/",
                                     "https://habr.com/ru/post/326146/",
                                     "https://dataart.team/ru/articles/mnogopotochnost-v-java-lekfiya-4-puly-potokov/",
                                     "https://tproger.ru/translations/java8-concurrency-tutorial-1/",
                                     "https://javarush.ru/quests/lectures/questsyntaxpro.level15.lecture06",
                                     "https://stackoverflow.com/questions/351565/system-currenttimemillis-vs-system-nanotime",
                                     "https://medium.com/german-gorelkin/low-coupling-high-cohesion-d36369fb1be9",
                                     "http://cpp-reference.ru/articles/lazy-initialization/",
                                     "http://java-online.ru/concurrent-executor.xhtml",
                                     "https://coderlessons.com/articles/java/executorservice-10-sovetov-i-podskazok",
                                     "https://pro-java.ru/java-dlya-opytnyx/interfejsy-callable-i-future-v-java/");

        LinkContentLoader linkContentLoader = new LinkContentLoader(links);

        System.out.println("Чтение содержимого одним потоком");
        long startTime = System.nanoTime();
        List<Map.Entry<String, String>> linksAndTheirContent = linkContentLoader.loadLinkContentSequentially();
        long estimatedTime = (System.nanoTime() - startTime) / 1000_000_000;
        System.out.println("Время, затраченное на загрузку содержимого = " + estimatedTime + " сек.");

        FileWriter.writeToFile(linksAndTheirContent, "sequential.txt");

        System.out.println("Чтение содержимого несколькими потоками");
        startTime = System.nanoTime();
        List<Map.Entry<String, String>> linksAndTheirContentParallel = linkContentLoader.loadLinkContentParallel();
        estimatedTime = (System.nanoTime() - startTime) / 1000_000_000;
        System.out.println("Время, затраченное на загрузку содержимого = " + estimatedTime + " сек.");

        FileWriter.writeToFile(linksAndTheirContentParallel, "parallel.txt");
    }
}
