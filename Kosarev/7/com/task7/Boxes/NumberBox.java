package com.task7.Boxes;

public class NumberBox<N extends Number> extends Box<N> {

    public NumberBox(N number) {
        super(number);
    }

    public static <N extends Number> NumberBox<N> of(N number) {
        // Вроде и хочется переиспользовать для этого Box.of(),
        // но возвращаемый тип будет Box и придется кастовать -- не гуд
        return new NumberBox<>(number);
    }

    public NumberBox<?> add(Box<? extends Number> arg) {
        // беру doubleValue, т.к. любой численный тип можно безболезненно кастануть к Double (где-то была схема)
        // TODO: подумать
        // Я уверен, что вместо "?" следует параметризоваться от N или от типа из arg,
        // но тогда происходит compile error - cannot cast Double to N
        // пока не слишком изящно сделал =/
        if (get().doubleValue() + arg.get().doubleValue() == (long)(get().doubleValue() + arg.get().doubleValue()))
            return NumberBox.of( (get().longValue() + arg.get().longValue()) );
        return NumberBox.of( (get().doubleValue() + arg.get().doubleValue()) );
    }

    public NumberBox<?> mul(Box<? extends Number> arg) {
        return NumberBox.of( (get().doubleValue() * arg.get().doubleValue()) );
    }

    public static void run() {
        Box<Integer> firstBox = Box.of(2);
        Box<Long> secondBox = Box.of(2L);
        NumberBox<Integer> thirdBox = NumberBox.of(2);
        System.out.printf("%s \"firstBox\", containing %s (%s)%n", firstBox.getClass(), firstBox.get().toString(), firstBox.get().getClass());
        System.out.printf("%s \"secondBox\", containing %s (%s)%n", secondBox.getClass(), secondBox.get().toString(), secondBox.get().getClass());
        System.out.printf("%s \"thirdBox\", containing %s (%s)%n", thirdBox.getClass(), thirdBox.get().toString(), thirdBox.get().getClass());
        System.out.println();
        var res = thirdBox.add(secondBox).mul(firstBox);
        System.out.println("(thirdBox + secondBox) * firstBox");
        System.out.printf("%s \"res\", containing %s (%s)%n", res.getClass(), res.get().toString(), res.get().getClass());
        System.out.println();
        res = res.add(Box.of(1.5));
        System.out.println("1.5 + (thirdBox + secondBox) * firstBox");
        System.out.printf("%s \"res\", containing %s (%s)%n", res.getClass(), res.get().toString(), res.get().getClass());
        System.out.println();
        res = res.mul(NumberBox.of(7.5F));
        System.out.println("7.5F * (1.5 + (thirdBox + secondBox) * firstBox)");
        System.out.printf("%s \"res\", containing %s (%s)%n", res.getClass(), res.get().toString(), res.get().getClass());
        System.out.println();
        res = res.add(Box.of(-20));
        System.out.println("7.5F * (1.5 + (thirdBox + secondBox) * firstBox) + (-20)");
        System.out.printf("%s \"res\", containing %s (%s)%n", res.getClass(), res.get().toString(), res.get().getClass());
        System.out.println();
        var box = res.add(Box.of(0.75));
        System.out.println("7.5F * (1.5 + (thirdBox + secondBox) * firstBox) + (-20) + 0.75");
        System.out.printf("%s \"box\", containing %s (%s)%n", box.getClass(), box.get().toString(), box.get().getClass());
    }
}
