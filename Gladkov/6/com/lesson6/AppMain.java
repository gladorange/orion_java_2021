package com.lesson6;

import com.lesson6.task1.Animal;
import com.lesson6.task1.AnimalType;
import com.lesson6.task2.GasStation;
import com.lesson6.task2.GasolineType;
import com.lesson6.task3.PhoneApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AppMain {
    public static void main(String[] args) {
        System.out.println( "Задание А. Работа с парами:............" );

        List<Pair<Animal,String >>pairList = new ArrayList<>( Arrays.asList(
                new Pair<>( new Animal( "Бобик", AnimalType.DOG.getType() ), AnimalType.DOG.getFavoriteFood() ),
                new Pair<>( new Animal( "Муська", AnimalType.CAT.getType() ), AnimalType.CAT.getFavoriteFood() ),
                new Pair<>( new Animal( "Шарик", AnimalType.DOG.getType() ), AnimalType.DOG.getFavoriteFood() ),
                new Pair<>( new Animal( "Ка", AnimalType.SNAKE.getType() ), AnimalType.SNAKE.getFavoriteFood() ),
                new Pair<>( new Animal( "Мышка-норушка", AnimalType.MOUSE.getType() ), AnimalType.MOUSE.getFavoriteFood() )

        ));

        Animal.feedAnimals( pairList );

        System.out.println( "Задание Б. Списки, списки............" );

        List<Triple<String, GasolineType,Double>> gasStationList = new ArrayList<>( Arrays.asList(
                new Triple<>( "Газпром", GasolineType.AI_92, 45.45 ),
                new Triple<>( "Газпром", GasolineType.AI_95, 48.2 ),
                new Triple<>( "Газпром", GasolineType.AI_98, 49.6 ),
                new Triple<>( "Газпром", GasolineType.DT, 47.7 ),
                new Triple<>( "Лукоил", GasolineType.AI_92, 44.98 ),
                new Triple<>( "Лукоил", GasolineType.AI_95, 49.46 ),
                new Triple<>( "Лукоил", GasolineType.AI_98, 50.20 ),
                new Triple<>( "Лукоил", GasolineType.DT, 47.88 ),
                new Triple<>( "Терминал", GasolineType.AI_92, 45.7 ),
                new Triple<>( "Терминал", GasolineType.AI_95, 49.3 ),
                new Triple<>( "Терминал", GasolineType.AI_98, 50.0 ),
                new Triple<>( "Терминал", GasolineType.DT, 48.7 ),
                new Triple<>( "НТК", GasolineType.AI_92, 45.0 ),
                new Triple<>( "НТК", GasolineType.AI_95, 48.2 ),
                new Triple<>( "НТК", GasolineType.AI_98, 49.0 ),
                new Triple<>( "НТК", GasolineType.DT, 47.2 )
        ));

        GasStation.findBestPrice( gasStationList, GasolineType.AI_95 );

        System.out.println( "Список приложений на телефон............" );

        List<Triple<String, Integer ,Double>> appList = new ArrayList<>( Arrays.asList(
                new Triple<>( "Twitter", getRandomInteger( 100, 1000000 ), getRandomDouble( 1.0, 5.0 ) ),
                new Triple<>( "Instagram", getRandomInteger( 100, 1000000 ), getRandomDouble( 1.0, 5.0 ) ),
                new Triple<>( "VK", getRandomInteger( 100, 1000000 ), getRandomDouble( 1.0, 5.0 ) ),
                new Triple<>( "Mail.ru", getRandomInteger( 100, 1000000 ), getRandomDouble( 1.0, 5.0 ) ),
                new Triple<>( "Яндекс", getRandomInteger( 100, 1000000 ), getRandomDouble( 1.0, 5.0 ) ),
                new Triple<>( "Shazam", getRandomInteger( 100, 1000000 ), getRandomDouble( 1.0, 5.0 ) ),
                new Triple<>( "Dropbox", getRandomInteger( 100, 1000000 ), getRandomDouble( 1.0, 5.0 ) ),
                new Triple<>( "WatsApp", getRandomInteger( 100, 1000000 ), getRandomDouble( 1.0, 5.0 ) ),
                new Triple<>( "Viber", getRandomInteger( 100, 1000000 ), getRandomDouble( 1.0, 5.0 ) ),
                new Triple<>( "Telegram", getRandomInteger( 100, 1000000 ), getRandomDouble( 1.0, 5.0 ) ),
                new Triple<>( "2GIS", getRandomInteger( 100, 1000000 ), getRandomDouble( 1.0, 5.0 ) ),
                new Triple<>( "Skype", getRandomInteger( 100, 1000000 ), getRandomDouble( 1.0, 5.0 ) )
        ));

        PhoneApp.sortedApp( appList );

        }

    private static int getRandomInteger( int min, int max ){
        Random random = new Random();
        return random.ints( min, max )
                .findFirst()
                .getAsInt();
    }

    private static double getRandomDouble( double min, double max ){
        Random random = new Random();
        double scale = Math.pow( 10, 1 );
        return Math.ceil( random.doubles( min, max )
                .findFirst()
                .getAsDouble() * scale ) / scale;
    }
}
