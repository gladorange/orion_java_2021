package com.orion.java.paramgetter;

import com.orion.java.main.Main;
import gnu.getopt.Getopt;
import read.usemsg.Usemsg;

/**
 * Класс считывания параметров с командной строки.
 */
public class CommandLineParametersGetter implements ParametersGetter {
    /**
     * Метод получения параметров с консоли.
     * @param integerValues Массив, куда записываются считанные значения чисел.
     * @param args Аргументы, переданные в командную строку.
     */
    public void getParameters(Integer[] integerValues,String[] args){
        int c = -1;
        String arg=new String("");
        Getopt g = new Getopt("testProg", args, "-:d:h;");
        g.setOpterr(false); // We'll do our own error handling

        Integer integerValuesSize = integerValues.length;
        int countNumbers=0;

        while ((c = g.getopt()) != -1)
            switch (c)
            {
                case 'd':
                    arg = g.getOptarg();

                    try {
                        // если доходит до сюда - число
                        integerValues[countNumbers] = Integer.parseInt(arg);
                        countNumbers++;
                        if (integerValuesSize.equals(countNumbers)){
                            return;
                        }
                    } catch (NumberFormatException e) {
                        // если доходит сюда - не число
                        System.out.println("Warning:The parameter |"+arg+"| of |d| isn't  digest.");
                    }
                    break;

                case 'h':
                    String inputFileName = Main.class.getResource("Usemsg.txt").toString().substring(5);
                    Usemsg.show(inputFileName);
                    System.exit(0);
                case ':':
                    System.out.println("Warning: You need an argument for option " +
                            (char)g.getOptopt());
                    break;

                case '?':
                    System.out.println("The option |" + (char)g.getOptopt() +
                            "| isn't valid");
                    break;

                default:
                    System.out.println("getopt() returned " + c);
                    break;
            }
        for (int i = g.getOptind(); i < args.length ; i++)
            System.out.println("Non option args element: " + args[i] + "\n");
        if(!integerValuesSize.equals(countNumbers)){
            System.out.println("Error:Command line doesn't have enough parameters.Exit ... ");
            System.exit(0);
        }
    }

}
