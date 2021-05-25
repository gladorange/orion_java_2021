package home.work7.boxnumber;

public class NumberBox<T extends Number> {
    private T value;

    public NumberBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public NumberBox<Number> multiply(Box anotherBox) {

        CalcHelper calcHelper = new CalcHelper();

        calcHelper.calc(value, anotherBox);

        return new NumberBox<>((calcHelper.thisValueF + calcHelper.thisValueL) * (calcHelper.anotherValueF + calcHelper.anotherValueL));
    }


    public NumberBox<Number> addition(Box anotherBox) {

        CalcHelper calcHelper = new CalcHelper();

        calcHelper.calc(value, anotherBox);

        return new NumberBox<>((calcHelper.thisValueF + calcHelper.thisValueL) + (calcHelper.anotherValueF + calcHelper.anotherValueL));

    }

    static class CalcHelper {
        float thisValueF = 0;
        float anotherValueF = 0;
        long thisValueL = 0;
        long anotherValueL = 0;

        public void calc(Number value, Box<Object> anotherBox) {

            thisValueF = getFloat(value);
            thisValueL = getLong(value);
            anotherValueF = getFloat((Number) anotherBox.getValue());
            anotherValueL = getLong((Number) anotherBox.getValue());

        }

        private Long getLong(Number number) {

            if (number.getClass().getSimpleName().equals("Integer") | number.getClass().getSimpleName().equals("Long")
                    | number.getClass().getSimpleName().equals("Short") | number.getClass().getSimpleName().equals("Byte")) {
                return number.longValue();
            }
            return 0L;
        }

        private Float getFloat(Number number){
            if (number.getClass().getSimpleName().equals("Float") | number.getClass().getSimpleName().equals("Double")) {
                return number.floatValue();
            }
            return 0f;
        }

    }
}
