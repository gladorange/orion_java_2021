package com.orion.lesson12;

import java.io.IOException;
import java.net.URI;

import org.apache.commons.io.IOUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
//@Scope("prototype")
public class UrlRetriever {

    public UrlRetriever() {
        System.out.println("URL retrieve создался");
    }


    @Cacheable("url-retreiver-cache")
    public String getContent(String url) {

        System.out.println("Вызыван URL retreiver "+ url);

        // TODO add caching
        try {
            return IOUtils.toString(URI.create(url));
        } catch (IOException e) {
            return "";
        }
    }
}
