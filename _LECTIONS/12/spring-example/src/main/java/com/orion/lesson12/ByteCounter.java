package com.orion.lesson12;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ByteCounter {


    UrlRetriever urlRetriever;
    NotASpringBean notASpringBean;

    public ByteCounter(UrlRetriever urlRetriever, NotASpringBean notASpringBean) {
        this.urlRetriever = urlRetriever;
        this.notASpringBean = notASpringBean;
    }

    static class Pair {
        String url;
        Integer size;

        public Pair(String url, Integer size) {
            this.url = url;
            this.size = size;
        }

        public String getUrl() {
            return url;
        }

        public Integer getSize() {
            return size;
        }
    }



    public  Map<String, Integer> countBytes(String ... urls) {

        notASpringBean.printSomething();
        return Stream.of(urls)
                .map(url -> new Pair(url, countWords(urlRetriever.getContent(url))))
                .collect(Collectors.toMap(Pair::getUrl, Pair::getSize));
    }




    private  Integer countWords(String content) {
        return content.split(" ").length;
    }



}
