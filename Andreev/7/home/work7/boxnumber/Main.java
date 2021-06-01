package home.work7.boxnumber;

public class Main {

    public static void main(String[] args) {
        Box<String> firstBox = new Box<>("2.8");
        Box<Long> secondBox = new Box<>(2L);
        NumberBox third = new NumberBox(2);
        NumberBox result = third.addition(firstBox).multiply(secondBox);
        System.out.println(result.getValue());

        Box<Double> thirdBox = new Box<>(3.4);
        Box<Float> fourthBox = new Box<>(2.3f);
        NumberBox fifth = new NumberBox(3);
        NumberBox secondResult = fifth.addition(thirdBox).multiply(fourthBox);
        System.out.println(secondResult.getValue());
    }
}
