package Task7;

import java.util.Comparator;
import java.util.List;

public class Application
{
    public static void printSortedByNumberRatings(List<Triple<String,Integer,Double>> applications)
    {
        applications.sort(Comparator.comparingInt(Pair::getSecond));
        System.out.println("Отсортируем приложения по количеству оценок");
        for (var application : applications)
        {
            System.out.println(application.getFirst() + ", " + application.getSecond());
        }
    }

    public static void printAppRating(List<Triple<String,Integer,Double>> applications)
    {
        applications.sort(Comparator.comparingDouble(Triple::getThird));

        var worstApp = applications.get(0);
        System.out.println("Приложение с худшим рейтингом: " + worstApp.getFirst() + ", " + worstApp.getThird());

        var bestApp = applications.get(applications.size() - 1);
        System.out.println("Приложение с лучшим рейтингом: " + bestApp.getFirst() + ", " + bestApp.getThird());
    }
}
