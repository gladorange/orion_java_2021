package com.orion.java.lesson2;

public class MagicNumberTask extends ArrayTask {

    public MagicNumberTask(String taskName, int arraySize){
        super(taskName, arraySize);
    }

    void generateWorkspace(int arrayFrom, int arrayTo){

        for(int i = 0; i < this.array.length; i++){
            this.array[i] = this.rand.nextInt(arrayTo - arrayFrom + 1) + arrayFrom;
        }
    }

    void getResult(){
        for (int item: this.array) {
            if(isMagicNumber(item)){
                System.out.println(item + " is magic number");
            }
        }
    }

    //TODO на stream anyMatch
    private boolean isMagicNumber(int number){
        return (number / 10) == (number % 10);
    }

}
