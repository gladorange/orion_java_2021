package com.orion.lesson8;

public class InstanceReference {




    static class FortyTwoStringManipulator {
        String addNumber(String str) {
            return str + "42";
        }
    }




    static class HelloStringManipulator {
        String addHello(String str) {
            return "Hello, " + str;
        }
    }



    static class AddAnotherStringToEnd {
        final String stringToAdd;

        AddAnotherStringToEnd(String stringToAdd) {
            this.stringToAdd = stringToAdd;
        }

        String addSuffix(String str) {
            return str + stringToAdd;
        }
    }



    interface StringManipulator {
        String transformString(String str);
    }


    public static void main(String[] args) {
        final FortyTwoStringManipulator first = new FortyTwoStringManipulator();
        final HelloStringManipulator second = new HelloStringManipulator();
        final AddAnotherStringToEnd third = new AddAnotherStringToEnd("^^^^^^^^");
        final AddAnotherStringToEnd fourth = new AddAnotherStringToEnd("______");


        StringManipulator[] manipulators = {first::addNumber, second::addHello, third::addSuffix, fourth::addSuffix,
             String::toLowerCase,
                String::toUpperCase
        };


        String str = "Vasya";

        for (StringManipulator manipulator : manipulators) {
            System.out.println(manipulator.transformString(str));
        }


    }

}
