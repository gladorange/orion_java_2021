package com.orion.java.homework7;

import java.util.List;

/**
 * Класс,содержащий дополнительные методы для работы со "строковыми" коробочками.
 */
public class StringBoxUtils {


    /**
     * Функция соединения все строковых значений переданных коробочек как парметр в однустроку.
     * @param stringsBoxes Переданные коробочки.
     * @return Коробку с объедененной строкой.
     */
    public static Box<? extends CharSequence> join(Box<? extends CharSequence>... stringsBoxes) {
        StringBuilder res = new StringBuilder();
        for (Box<? extends CharSequence> box : stringsBoxes) {
            res.append(box.getValue().toString());
        }
        return Box.of(res.toString());
    }

    /**
     * Функция соединения все строковых значений переданных коробочек в листе как парметр в однустроку.
     * @param list Список строковых коробочек.
     * @return Коробку с объедененной строкой.
     */
    public static Box<? extends CharSequence> join( List<Box<? extends CharSequence>> list ){
        StringBuilder res = new StringBuilder();
        for (Box<? extends CharSequence> box : list) {
            res.append(box.getValue().toString());
        }
        return Box.of(res.toString());
    }

    /**
     * Функция копирования непустой строки в лист.
     * @param box
     * @param list
     * @param <T>
     */
    public static <T extends CharSequence> void copyNonEmptyStringBoxToList(Box<T> box, List<T> list){
        if (box.getValue().toString().trim().length()!=0){
            list.add(box.getValue());
        }
    }
}
