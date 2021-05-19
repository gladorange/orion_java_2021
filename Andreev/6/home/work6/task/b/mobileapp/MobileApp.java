package home.work6.task.b.mobileapp;

import home.work6.task.pairs.Triple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MobileApp {

    public void doTaskTwo(){

        List<Triple<String,Double,Double>> listApp = new ArrayList<>();
        listApp.add(new Triple<>("Facebook",150.,3.5));
        listApp.add(new Triple<>("VK",134.,4.7));
        listApp.add(new Triple<>("Instagram",300.,4.9));
        listApp.add(new Triple<>("TikTok",264.,4.1));
        listApp.add(new Triple<>("Telegram",582.,4.6));
        findBestRatingApp(listApp);
        findWorstRatingApp(listApp);
        Collections.sort(listApp);
        listApp.forEach(System.out::println);
    }

    private void findBestRatingApp(List<Triple<String,Double,Double>> list){
        System.out.println("Приложение с лучшим рейтингом: "
                + list.stream().max(Comparator.comparing(Triple::getThird)).get().getFirst());
    }

    private void findWorstRatingApp(List<Triple<String,Double,Double>> list){
        System.out.println("Приложение с худшим рейтингом: "
                +list.stream().min(Comparator.comparing(Triple::getThird)).get().getFirst());
    }
}

