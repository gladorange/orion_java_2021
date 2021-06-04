package Task7;

import java.util.Comparator;
import java.util.List;

public class GasStation
{
    public enum GasolineType { DT, AI92, AI95, AI98 }

    static void findBestPrice(List<Triple<String, GasolineType, Double>> gasStations, GasolineType type)
    {
        gasStations.sort(Comparator.comparingDouble(Triple::getThird));

        for (var gasStation : gasStations)
        {
            if (gasStation.getSecond() == type)
            {
                System.out.println("Адрес бензоколонки с самой маленькой ценой на тип бензина " + type + ": " + gasStation.getFirst());
                break;
            }
        }
    }
}
