package Task7;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        // Работа с парами
        List<Pair<Animal,String>> animals = new ArrayList<>();
        animals.add(new Pair<>(new Animal("Василиса", "Кошка"), "Колбаса"));
        animals.add(new Pair<>(new Animal("Шарик", "Собака"), "Педигри"));
        animals.add(new Pair<>(new Animal("Зорька", "Корова"), "Трава"));
        animals.add(new Pair<>(new Animal("Ряба", "Курочка"), "Пшеница"));
        animals.add(new Pair<>(new Animal("Колючка", "Ёжик"), "Огурец"));

        Animal.feedAnimals(animals);

        // Список с бензоколонками и ценами на бензин
        System.out.println("");
        List<Triple<String,GasStation.GasolineType,Double>> gasStations = new ArrayList<>();
        gasStations.add(new Triple<>("Адрес 1", GasStation.GasolineType.DT, 47.60));
        gasStations.add(new Triple<>("Адрес 2", GasStation.GasolineType.AI92, 44.98));
        gasStations.add(new Triple<>("Адрес 3", GasStation.GasolineType.AI95, 48.96));
        gasStations.add(new Triple<>("Адрес 4", GasStation.GasolineType.AI98, 54.19));

        gasStations.add(new Triple<>("Адрес 5", GasStation.GasolineType.DT, 49.60));
        gasStations.add(new Triple<>("Адрес 6", GasStation.GasolineType.AI92, 43.89));
        gasStations.add(new Triple<>("Адрес 7", GasStation.GasolineType.AI95, 46.16));
        gasStations.add(new Triple<>("Адрес 8", GasStation.GasolineType.AI98, 56.19));

        GasStation.findBestPrice(gasStations, GasStation.GasolineType.AI92);
        GasStation.findBestPrice(gasStations, GasStation.GasolineType.AI95);

        // Список приложений на телефон
        System.out.println("");
        List<Triple<String,Integer,Double>> applications = new ArrayList<>();
        applications.add(new Triple<>("Название 1", 150, 3.6));
        applications.add(new Triple<>("Название 2", 63, 4.3));
        applications.add(new Triple<>("Название 3", 103, 3.9));
        applications.add(new Triple<>("Название 4", 87, 2.7));
        applications.add(new Triple<>("Название 5", 132, 4.5));

        Application.printSortedByNumberRatings(applications);
        Application.printAppRating(applications);
    }
}
