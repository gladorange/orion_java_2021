package com.orion.java.homework10.main;

import com.orion.java.homework10.classes.Animal;
import com.orion.java.homework10.classes.Person;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.orion.java.homework10.xmltools.XmlTools.*;

/**
 * Класс,содержащий точку входа в приложение.
 */
public class Main {
    /**
     * Флаг необходимости отображения отладочно информации.Параметр задается при запуске программы.
     * Для установления флага необходимо указать ненулевое значение(-Dverbose=1) в опции VM.
     */
    static boolean Verbose = false;
    /**
     * Флаг необходимости очистки директории,содержащей xml-файлы.
     */
    static boolean isClearXmlFileDirectory = true;

    /**
     * Точка входа в приложение.
     * @param args
     * @throws IllegalAccessException
     * @throws IOException
     *
     * \n
     * Определяем необходимость вывода отладочной информации.
     * Формируем путь к директории для сохранения xml-файлов и дату сохранения файлов.
     * Для проверки корректности работы функци класса XmlTools производим действия.
     * Формируем ArrayList,содержащий два объекта класса Person.
     * Пытаемся получить строку,содержащую ArrayList в формате xml.
     * Пытаемся записть строку в файл.
     * Информацию об пути к записанному файлу,классе записанного объекта и количестве записанных объектов
     * сохраняем в колеекцию.
     * Формируем LinkedList,содержащий три объекта класса Animal.
     * Повторяем аналогичные действия.
     *
     * \n
     * Попытемся дессериализовать,записанные файлы.
     * Для этого проходим по коллекции,содержащей  пути к записанному файлу,
     * классе записанного объекта и количестве записанных объектов и вызываем соответсвующую функцию.
     *
     */
    public static void main(String[] args) throws IllegalAccessException, IOException {


        String verbose = System.getProperty("verbose");

        if( verbose!= null && !verbose.equals(0)){
            Verbose = true;
        }

        Collection<String> xmlFilesWays = new ArrayList<>();
        HashMap<String,Integer > xmlFileWaysAndMaxNodeNumber = new HashMap<>();
        HashMap<String, HashMap<Class<?>,Integer > > xmlFileWaysAndMaxNodeNumberWithType = new HashMap<>();
        String separator = File.separator;
        SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss");
        String xmlFileWayBegining = System.getProperty("user.dir")
                + separator + "Firsov"
                + separator + "src"
                + separator + "10"
                + separator + "com"
                + separator + "orion"
                + separator + "java"
                + separator + "homework10"
                + separator + "xmltools"
                + separator + "xmlFileExamples";
        if(isClearXmlFileDirectory){
            for (File myFile : new File(xmlFileWayBegining).listFiles()){
                if (myFile.isFile()) myFile.delete();
            }
        }

       {
            
            Person vasya = new Person("Vasya", "Vasilev", 18, false);
            vasya.setPassword(123234);
            Collection<Person> arrListPerson = new ArrayList<>();
            arrListPerson.add(vasya);
            Person petya = new Person("Petya", "Petrov", 21, true);
            arrListPerson.add(petya);
            vasya.setPassword(4321);
            try {
                String res = serialize(arrListPerson);
                if(Verbose){
                    System.out.println("-------The result of serialization----\n"
                            +"object was:\n"+arrListPerson+"\n serialized object is:\n"
                            +res
                            +"\n----end-------");
                }

                String xmlFileWay =  xmlFileWayBegining+ separator + "PeopleCollection" + formater.format(new Date()) + ".xml";
                try {
                    writeIntoXml(xmlFileWay, res);
                    xmlFilesWays.add(xmlFileWay);
                    xmlFileWaysAndMaxNodeNumber.put(xmlFileWay,arrListPerson.size());//
                    HashMap<Class<?>,Integer > classIntegerMap = new HashMap<>();
                    classIntegerMap.put(Person.class,arrListPerson.size());
                    xmlFileWaysAndMaxNodeNumberWithType.put(xmlFileWay,classIntegerMap);
                } catch (Exception e) {
                    System.out.printf("Can't write into file.Message |" + e.getMessage() + "|");
                }
            }catch (Exception e){
                System.out.printf("Can't serialize.Message |" + e.getMessage() + "|");
            }
           
        }
        {
            Animal barsik = new Animal("Barsik", "meet", 5, false);
            Collection<Animal> linkedListAnimal = new LinkedList<>();
            linkedListAnimal.add(barsik);
            Animal richard = new Animal("Richard", "fish", 12, true);
            linkedListAnimal.add(richard);
            Animal sonya = new Animal("Sonya", "kidneys", 12, false);
            linkedListAnimal.add(sonya);

            try {
                String res = serialize(linkedListAnimal);
                if(Verbose){
                    System.out.println("-------The result of serialization----\n"
                            +"object was:\n"+linkedListAnimal+"\n serialized object is:\n"
                            +res
                            +"\n----end-------");
                }
                String xmlFileWay =  xmlFileWayBegining+ separator + "AnimalCollection" + formater.format(new Date()) + ".xml";
                try {

                    writeIntoXml(xmlFileWay, res);
                    xmlFilesWays.add(xmlFileWay);
                    xmlFileWaysAndMaxNodeNumber.put(xmlFileWay,linkedListAnimal.size());

                    HashMap<Class<?>,Integer > classIntegerMap = new HashMap<>();
                    classIntegerMap.put(Animal.class,linkedListAnimal.size());
                    xmlFileWaysAndMaxNodeNumberWithType.put(xmlFileWay,classIntegerMap);

                } catch (Exception e) {
                    System.out.printf("Can't write into file.Message |" + e.getMessage() + "|");
                }
            }catch (Exception e){
                System.out.printf("Can't serialize.Message |" + e.getMessage() + "|");
            }
        }


        try {
            if(!xmlFileWaysAndMaxNodeNumberWithType.isEmpty()){
                if(Verbose){
                    System.out.println("-----The result of deserialization------");
                }
                for (Map.Entry entry: xmlFileWaysAndMaxNodeNumberWithType.entrySet()) {
                    for (Map.Entry entryInside: (xmlFileWaysAndMaxNodeNumberWithType.get(entry.getKey())).entrySet()) {
                        Class<?> clazz = (Class<?>) entryInside.getKey();
                        for (int i = 0; i < (int)entryInside.getValue() ; i++) {
                           Object obj =  deserialize(clazz,(String)entry.getKey(),i);
                            if(Verbose) {
                                System.out.println("  obj |"+obj+"|");
                            }
                        }
                    }
                }
                if(Verbose){
                    System.out.println("-----end------");
                }
            }
        }catch ( Exception e){
            System.out.println("Can't deserialize.Message |" + e.getMessage() + "|");
        }

    }
}
