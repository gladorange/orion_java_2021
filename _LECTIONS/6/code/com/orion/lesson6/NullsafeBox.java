package com.orion.lesson6;

public class NullsafeBox<T> {
    T content;


    public NullsafeBox(T content) {
        if (content == null) {
            throw new NullPointerException("Content can't be null");
        }
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public static void main(String[] args) {
        var integerBox = new NullsafeBox<Integer>(42);
        NullsafeBox<Integer> anotherIntegerBox = new NullsafeBox<>(34);


        System.out.println(integerBox.getContent() + anotherIntegerBox.getContent());

        final NullsafeBox<String> stringBox = new NullsafeBox<>("Some string");

        System.out.println(stringBox.getContent().length());
        printStringBoxContent(stringBox);

/*
        NullsafeBox rawIntBox = new NullsafeBox("42");
        System.out.println((Integer)rawIntBox.getContent());  */
    }


    public static void printStringBoxContent(NullsafeBox<String> box) {
        System.out.println(box.getContent().toUpperCase());
    }

}
