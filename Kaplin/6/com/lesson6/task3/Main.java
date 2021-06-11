package com.lesson6.task3;

import com.lesson6.utils.Triple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Triple<String, Integer, Double>> appList = new ArrayList<>(Arrays.asList(
                new Triple<>("Яндекс", PhoneApp.getRandomEstim(), PhoneApp.getRandomRating()),
                new Triple<>("Telegram", PhoneApp.getRandomEstim(), PhoneApp.getRandomRating()),
                new Triple<>("Shazam", PhoneApp.getRandomEstim(), PhoneApp.getRandomRating()),
                new Triple<>("Twitter", PhoneApp.getRandomEstim(), PhoneApp.getRandomRating()),
                new Triple<>("Dropbox", PhoneApp.getRandomEstim(), PhoneApp.getRandomRating()),
                new Triple<>("WatsApp", PhoneApp.getRandomEstim(), PhoneApp.getRandomRating()),
                new Triple<>("Viber", PhoneApp.getRandomEstim(), PhoneApp.getRandomRating()),
                new Triple<>("2GIS", PhoneApp.getRandomEstim(), PhoneApp.getRandomRating()),
                new Triple<>("Instagram", PhoneApp.getRandomEstim(), PhoneApp.getRandomRating()),
                new Triple<>("VK", PhoneApp.getRandomEstim(), PhoneApp.getRandomRating()),
                new Triple<>("Facebook", PhoneApp.getRandomEstim(), PhoneApp.getRandomRating())
        ));

        PhoneApp.showSortedByEstimCount(appList, false);
        PhoneApp.showMinMaxByRating(appList);
    }


}
