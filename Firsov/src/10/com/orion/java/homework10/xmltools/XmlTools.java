package com.orion.java.homework10.xmltools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.security.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * Класс содержит функции для сериализации и десириализации.
 */
public class XmlTools {

    /**
     * Флаг необходимости вывода отлвдочно информации.
     */
    final static boolean PRINT_DEBUG = false;

    /**
     * Аннтотация для полей,которые не нужно сохранять в Xml файл.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public static @interface XmlIgnore{

    }

    /**
     * Аннтотация для полей,которые  нужно сохранять в Xml файл.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public static @interface XmlTypeName{
        String value();
    }

    /**
     * Аннотация для класса.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public static @interface XmlName{
        String value();
    }


    /**
     * Функция десирилизации.
     * @param aClass Тип класса.
     * @param xmlFileWay Путь к файлу в формате xml.
     * @param nodeNumber Номер узла в файле.
     * @return Возвращает объект,полученный в результате преобразования узла в файле.
     *
     * @throws InvalidParameterException
     * @throws IllegalAccessException
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     * @throws InstantiationException
     *
     * \n
     * Пытаемся считать файл.
     * Определяем корректность переданного номера узла.
     * Инстанцируем объект класса.
     * Получаем узел.
     * Определяем его поля и данные параметры записываем в поля объекта класса.
     */
   public static Object deserialize(final Class<?> aClass, String xmlFileWay, int nodeNumber) throws InvalidParameterException, IllegalAccessException, ParserConfigurationException, IOException, SAXException, InstantiationException {
       if(PRINT_DEBUG){
           System.out.println("function |"+new Throwable()
                   .getStackTrace()[0]
                   .getMethodName()
                   +"|");
       }

        // Получение фабрики, чтобы после получить билдер документов.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.
        Document document = builder.parse(new File(xmlFileWay));
        document.getDocumentElement().normalize();
        if(PRINT_DEBUG) {
            System.out.println("Root element : |" + document.getDocumentElement().getNodeName() + "|");
        }
        String classFieldName =  getXmlTypeName(aClass);
        NodeList nList = document.getElementsByTagName(classFieldName);
       if(nodeNumber < 0 ){
           throw new IllegalArgumentException("Error: Node number can't be less,than |0|.");
       }
       if(nodeNumber > nList.getLength()){
           throw new IllegalArgumentException("Error: Node number can't be more than node's list length |"+nList.getLength()+"|");
       }
       Object object = aClass.newInstance();
       Node nNode = nList.item(nodeNumber);
            if(PRINT_DEBUG) {
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
            }
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                for (Field declaredField : aClass.getDeclaredFields()) {
                    if (declaredField.isAnnotationPresent(XmlIgnore.class)) {
                        continue;
                    }
                    declaredField.setAccessible(true);
                    String fieldType = declaredField.getType().getSimpleName();

                    if( fieldType.equals("String")){

                        String fieldName = getXmlName(declaredField);
                        declaredField.set(object, eElement
                                .getElementsByTagName(fieldName)
                                .item(0)
                                .getTextContent());
                        if(PRINT_DEBUG) {
                            System.out.println("  fieldType|"+fieldType
                                    +"| fieldName |"+fieldName+"|");
                        }
                    }else if( fieldType.equals("int") ){

                        String fieldName = getXmlName(declaredField);

                        declaredField.set(object,Integer.parseInt ((eElement
                                .getElementsByTagName(fieldName)
                                .item(0)
                                .getTextContent())
                                .trim ()));
                        if(PRINT_DEBUG) {
                            System.out.println("  fieldType|"+fieldType
                                    +"| fieldName |"+fieldName+"|");
                        }
                    }else if( fieldType.equals("boolean") ){
                        String fieldName = getXmlName(declaredField);

                        declaredField.set(object,Boolean.valueOf(eElement
                                .getElementsByTagName(fieldName)
                                .item(0)
                                .getTextContent()));
                        if(PRINT_DEBUG) {
                            System.out.println("  fieldType|"+fieldType
                                    +"| fieldName |"+fieldName+"|");
                        }
                    }else{
                        throw new InvalidParameterException("Object |"+aClass.getSimpleName()+"| has undeclared field type |"+fieldType+"|");
                    }
                }
        }

       return object;
   }

    /**
     * Функция-обертка для записи в xml-файл.
     * @param writtenString
     * @throws IOException
     * @throws IllegalArgumentException
     *
     * \n
     * Применяется в случае,если не задан путь к файлу.
     */
    public static void writeIntoXml(String writtenString) throws IOException,IllegalArgumentException {
        writeIntoXml("",writtenString);
    }

    /**
     * Функция записи в xml-файл.
     * @param fileWay Путь к xml-файлу.
     * @param writtenString Данные для записи в файл.
     * @throws IOException
     * @throws IllegalArgumentException
     *
     * Проверяем кореектность строки для записи.
     * Если путь к xml-файлу не задан,то устанавливаем путь по умолчанию.
     * Пытаемся записать в файл.
     */
    public static void writeIntoXml(String fileWay,String writtenString) throws IOException,IllegalArgumentException {
        if(PRINT_DEBUG){
            System.out.println("function |"+new Throwable()
                    .getStackTrace()[0]
                    .getMethodName()
                    +"|");
        }
        if(writtenString == null || writtenString.isEmpty()){
            throw new IllegalArgumentException("String with data for XML file can't be empty or null.");
        }
        String inputFileName = "";
        if (fileWay == null ||  fileWay.isEmpty()) {
            SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss");

            inputFileName =  XmlTools.class.getResource("").toString().substring(5)+ "Collection"+ formater.format(new Date())
                    +".xml";
            System.out.println("Info:File way for saving of Xml file wasn't set.Use default :|" + inputFileName + "|");
        }else{
            inputFileName = fileWay;
        }
        try(FileWriter writer = new FileWriter(inputFileName, false))
        {
            // запись всей строки
            writer.write(writtenString);
            writer.flush();
        }
    }

    /**
     * Функция сериализации.
     * @param object Объект с данными для сериализации.
     * @return Сериадизованную строку,содержащую информацию  в формате xml.
     * @throws IllegalAccessException
     *
     * Убеждаемся в том,что размер переданного аргумента в функцию не равен нулю.
     * Получаем тип класса элемента в объекте.
     * Формируем строку.
     */
    public static String serialize(Collection<?> object) throws IllegalAccessException {
        if(PRINT_DEBUG){
            System.out.println("function |"+new Throwable()
                    .getStackTrace()[0]
                    .getMethodName()
                    +"|");
        }

        if(object.size() == 0){
            throw new IllegalArgumentException("The size of collection can't be |0|.");
        }
        final Class<? extends Collection> collectionClass = object.getClass();

        final Class<?> elementClass = Array.get(object.toArray(),0).getClass();

        if(PRINT_DEBUG){
            System.out.println("CollectionClass |"+collectionClass+"|");
            System.out.println("Element of collection class |"+elementClass+"|");
        }

        StringBuilder sb = new StringBuilder("<Collection>"+"\n");
        for (int i = 0; i < object.size(); i++) {
            String typeName = getXmlTypeName(elementClass);
            if(PRINT_DEBUG){
                System.out.println("  typeName |"+typeName+"|");
            }
            sb.append("  <"+typeName+">\n");
            for (Field declaredField: elementClass.getDeclaredFields()) {
                if( declaredField.isAnnotationPresent(XmlIgnore.class)){
                    continue;
                }
                declaredField.setAccessible(true);
                final String fieldName = getXmlName(declaredField);
                if(PRINT_DEBUG){
                    System.out.println("    fieldName |"+fieldName
                            +"| fieldValue |"+declaredField.get(Array.get(object.toArray(),i))+"|");
                }
                sb.append("    <"+fieldName+">"+declaredField.get(Array.get(object.toArray(),i))+"</"+fieldName+">\n");
            }
            sb.append("  </"+typeName+">\n");
        }
        sb.append("</Collection>"+"\n");

        return sb.toString();

    }

    /**
     * Функция получения имени класса.
     * @param aClass Тип класса.
     * @return Имя класса.
     *
     * Если аннотация к классу не задана,то возвращает имя класса,иначе значение аннотации.
     */
    private static String getXmlTypeName(Class<?> aClass){
        final XmlTypeName annotation = aClass.getAnnotation(XmlTypeName.class);
        if(annotation != null){
            return annotation.value();
        }
        return aClass.getSimpleName();
    }
    /**
     * Функция получения имени поля.
     * @param declaredField Поле в классе.
     * @return Имя поля.
     *
     * Если аннотация к полю не задана,то возвращает имя поля,иначе значение аннотации.
     */
    private static String getXmlName(Field declaredField){
        final XmlName annotation = declaredField.getAnnotation(XmlName.class);
        if(annotation !=null){
            return annotation.value();
        }
        return declaredField.getName();

    }

}
