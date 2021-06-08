package com.orion.lesson12;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.orion.lesson12.ByteCounter.Pair;

@Component
public class CountA {


    final UrlRetriever urlRetriever;


    public CountA(UrlRetriever urlRetriever) {
        this.urlRetriever = urlRetriever;
    }


    public Map<String, Integer> countA(String ... urls) {
        return Stream.of(urls)
                .map(url -> new Pair(url, countWords(urlRetriever.getContent(url))))
                .collect(Collectors.toMap(Pair::getUrl, Pair::getSize));
    }



    private  Integer countWords(String content) {
        return content.split("a").length;
    }

}
