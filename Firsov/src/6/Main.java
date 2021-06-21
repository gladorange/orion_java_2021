import com.orion.java.homework6.animals.Animal;
import com.orion.java.homework6.animals.AnimalTypesClass;
import com.orion.java.homework6.elementtypes.Pair;
import com.orion.java.homework6.elementtypes.Triple;
import com.orion.java.homework6.gasstation.GasStationsManager;
import com.orion.java.homework6.gasstation.GasolineTypeClass;
import com.orion.java.homework6.phoneapplication.PhoneApplicationClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        Pair<String, Integer> lastNameToAge = new Pair<> ("Пупкин", 18);


        String lastName = lastNameToAge.getFirst();
        Integer age = lastNameToAge.getSecond();
        System.out.println("Last name |"+lastName+"| |"+age+"|");

        Pair<String, List<String>> lastNameToPhoneNumbers = new Pair<>("Пупкин", Arrays.asList("+7 831 2112233", "+7 920 000 22 22"));
        String lastNameWitPhoneNumbers = lastNameToPhoneNumbers.getFirst();
        List<String> phoneNumbers = lastNameToPhoneNumbers.getSecond();
        System.out.println("lastNameWitPhoneNumbers |"+lastNameWitPhoneNumbers+"| phoneNumbers |"+phoneNumbers.toString()+"|");

        List<Pair<Animal,String >>pairList = new ArrayList<>( Arrays.asList(
                new Pair<>( new Animal( "Соня", AnimalTypesClass.CAT.getType() ), AnimalTypesClass.CAT.getFavoriteFood() ),
                new Pair<>( new Animal( "Ричард", AnimalTypesClass.CAT.getType() ), AnimalTypesClass.CAT.getFavoriteFood() ),
                new Pair<>( new Animal( "Шарик", AnimalTypesClass.DOG.getType() ), AnimalTypesClass.DOG.getFavoriteFood() ),
                new Pair<>( new Animal( "Лариска", AnimalTypesClass.MOUSE.getType() ), AnimalTypesClass.MOUSE.getFavoriteFood() )

        ));
        Animal.feedAnimals( pairList );

        List<Triple<String, GasolineTypeClass,Double>> gasStationList = new LinkedList<>( Arrays.asList(
                new Triple<>( "Shell", GasolineTypeClass.AI_92, 43.67 ),
                new Triple<>( "Shell", GasolineTypeClass.AI_95, 49.46 ),
                new Triple<>( "Shell", GasolineTypeClass.AI_98, 53.17 ),
                new Triple<>( "Shell", GasolineTypeClass.DT, 48.03 ),
                new Triple<>( "ГазпромНефть", GasolineTypeClass.AI_92, 46.84 ),
                new Triple<>( "ГазпромНефть", GasolineTypeClass.AI_95, 44.43 ),
                new Triple<>( "ГазпромНефть", GasolineTypeClass.AI_98, 48.37 ),
                new Triple<>( "ГазпромНефть", GasolineTypeClass.DT, 46.27 ),
                new Triple<>( "Neste", GasolineTypeClass.AI_92, 49.7 ),
                new Triple<>( "Neste", GasolineTypeClass.AI_95, 49.3 ),
                new Triple<>( "Neste", GasolineTypeClass.AI_98, 47.0 ),
                new Triple<>( "Neste", GasolineTypeClass.DT, 49.05 )
        ));


        GasStationsManager.findBestPrice( gasStationList, GasolineTypeClass.AI_92 );
        GasStationsManager.findBestPrice( gasStationList, GasolineTypeClass.AI_95 );
        GasStationsManager.findBestPrice( gasStationList, GasolineTypeClass.AI_98 );
        GasStationsManager.findBestPrice( gasStationList, GasolineTypeClass.DT );


        List<Triple<String, Integer ,Double>> appList = new ArrayList<>( Arrays.asList(
                new Triple<>( "VK      ", 300,  4.25),
                new Triple<>( "Telegram", 200, 5.26),
                new Triple<>( "Twitter ", 500, 3.4),
                new Triple<>( "WatsApp ",400, 3.5)
        ));

        PhoneApplicationClass.sortedApp( appList );

    }
}
