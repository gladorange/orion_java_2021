package com.orion.java.lesson2;
import java.util.Random;

public class ArrayTask {

    String name;
    int[] array;
    Random rand = new Random();

    public ArrayTask(String name, int arraySize){
        this.name = name;
        this.array = new int[arraySize];
    }

    String getName(){
        return this.name;
    }

    void generateWorkspace(){

        for(int i = 0; i < this.array.length; i++){
            this.array[i] = this.rand.nextInt();
        }
    }

    void showWorkspace(){

        System.out.println("Workspace:");

        for (int item : this.array){
            System.out.println(item);
        }
    }

    void getResult(){

        //TODO this?
        this.showWorkspace();
    }
}
