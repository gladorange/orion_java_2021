package home.work6.task.b.gasoline;

import home.work6.task.pairs.Triple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GasolineApp {
    public void doTaskOne(){
        List<Triple<String, GasolineType,Double>> list = new ArrayList<>();
        list.add(new Triple<>("Volkova, 34", GasolineType.AI_95, 34.23));
        list.add(new Triple<>("Lenina, 17", GasolineType.AI_98, 43.5));
        list.add(new Triple<>("Melnikova, 115", GasolineType.DT, 31.75));
        list.add(new Triple<>("Centralnaya, 2", GasolineType.AI_98, 42.8));
        list.add(new Triple<>("Volkova, 34", GasolineType.DT, 32.));
        findBestPrice(list,GasolineType.AI_98);
    }

    private void findBestPrice(List<Triple<String,GasolineType,Double>> list,GasolineType type){
        System.out.println(list.stream().filter(el->el.getSecond()==type).min(Comparator.comparing(Triple::getThird)).get().getFirst());
    }
}
