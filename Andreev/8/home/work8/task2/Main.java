package home.work8.task2;

public class Main {

    public static void main(String[] args) {

        Calculator calc = new Calculator();
        calc.addOperation("mult", (a,b) -> a*b);
        calc.addOperation("div", (a,b) -> a/b);
        calc.addOperation("add", Double::sum);
        calc.addOperation("sub", (a,b) -> a-b);
        calc.addOperation("expon", Math::pow);
        calc.addOperation("ext", (a,b) -> Math.exp(Math.log(a)/b));
        calc.calculate("mult",2.,3.);
        calc.calculate("div",6.,3.);
        calc.calculate("add",2.,3.);
        calc.calculate("sub",6.,3.);
        calc.calculate("expon",2.,3.);
        calc.calculate("ext",2.,3.);
    }
}
