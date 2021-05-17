package com.task5;

import com.task5.core.Elements.Button;
import com.task5.core.Elements.CheckBox;
import com.task5.core.Elements.Templates.Clickable;
import com.task5.core.Elements.Templates.UIElement;
import com.task5.core.Elements.TextField;
import com.task5.core.Exceptions.UIElementOverlapException;
import com.task5.core.Exceptions.UIInvalidSizeException;
import com.task5.core.Exceptions.UIReadOnlyException;
import com.task5.core.UIScene;

import java.io.IOException;
import java.util.Random;

public class Main {
    private static final int UISCENE_WIDTH                    = 100;
    private static final int UISCENE_HEIGHT                   = 100;
    private static final int ADD_ELEMENT_BUTTON_WIDTH         = 20;
    private static final int ADD_ELEMENT_BUTTON_HEIGHT        = 3;
    private static final int NEXT_XY_TEXT_FIELD_WIDTH         = 14;
    private static final int NEXT_XY_TEXT_FIELD_HEIGHT        = 3;

    private static final int ELEMENT_MIN_WIDTH  = 8;
    private static final int ELEMENT_MAX_WIDTH  = 64;
    private static final int ELEMENT_MIN_HEIGHT = 5;
    private static final int ELEMENT_MAX_HEIGHT = 24;

    public static UIElement getRandomElement(int x, int y, int width, int height, boolean isDisabled) throws UIInvalidSizeException {
        Random random = new Random();
        boolean chboxStateOn = random.nextBoolean();
        int elementPick = random.nextInt(3);
        UIElement randomElement;
        switch (elementPick) {
            case 0 -> randomElement = new Button(x, y, width, height, String.format("Кнопка в <%d; %d>", x, y), isDisabled,
                    () -> System.out.printf("Нажата кнопка в <%d; %d> с названием \"%s\"\n", x, y, String.format("Кнопка в <%d; %d>", x, y)));
            case 1 -> {
                randomElement = new CheckBox(x, y, width, height, String.format("Галка в <%d; %d>", x, y), isDisabled, chboxStateOn);
                ((Clickable) randomElement).setClickCallback(() -> System.out.println(
                        randomElement.getTypeName() + " \"" + randomElement.getName() + "\" теперь " +
                                (randomElement.isDisabled() ? "ВЫКЛ" : "ВКЛ")));
            }
            case 2 -> randomElement = new TextField(x, y, width, height, String.format("ТекстПоле в <%d; %d>", x, y), isDisabled,
                    "Содержимое текстового поля\nТекст текст текст");
            default -> throw new IllegalStateException("Unexpected value in switch" + elementPick);
        }
        System.out.printf("Создаю случайный %s (x: %d; y: %d; w: %d; h: %d; %s)%n",
                randomElement.getTypeName(), randomElement.getX(), randomElement.getY(), randomElement.getWidth(), randomElement.getHeight(), randomElement.isDisabled() ? "disabled" : "enabled");
        return randomElement;
    }

    public static void main(String[] args) throws UIInvalidSizeException, UIElementOverlapException {
        Random random = new Random();

        UIScene testScene = new UIScene(UISCENE_WIDTH, UISCENE_HEIGHT);
        UIElement addNewElementButton = new Button(1, 1,
                ADD_ELEMENT_BUTTON_WIDTH, ADD_ELEMENT_BUTTON_HEIGHT, "Добавить элемент");
        UIElement nextXTextfield = new TextField(1, addNewElementButton.getY() + addNewElementButton.getHeight(),
                NEXT_XY_TEXT_FIELD_WIDTH, NEXT_XY_TEXT_FIELD_HEIGHT, "След. Х", "");
        UIElement nextYTextfield = new TextField(1, nextXTextfield.getY() + nextXTextfield.getHeight(),
                NEXT_XY_TEXT_FIELD_WIDTH, NEXT_XY_TEXT_FIELD_HEIGHT, "След. Y", "");
        UIElement nextWidthTextfield = new TextField(1, nextYTextfield.getY() + nextYTextfield.getHeight(),
                NEXT_XY_TEXT_FIELD_WIDTH, NEXT_XY_TEXT_FIELD_HEIGHT, "След. Ширина", "");
        UIElement nextHeightTextfield = new TextField(1, nextWidthTextfield.getY() + nextWidthTextfield.getHeight(),
                NEXT_XY_TEXT_FIELD_WIDTH, NEXT_XY_TEXT_FIELD_HEIGHT, "След. Высота", "");
        CheckBox nextIsDisabled = new CheckBox(1, nextHeightTextfield.getY() + nextHeightTextfield.getHeight(),
                NEXT_XY_TEXT_FIELD_WIDTH, NEXT_XY_TEXT_FIELD_HEIGHT, "След. выкл", false, false);
        ((Clickable) nextIsDisabled).setClickCallback( () -> System.out.println(
                nextIsDisabled.getTypeName() +
                " \"" + nextIsDisabled.getName() + "\" теперь " +
                (nextIsDisabled.isDisabled() ? "ВЫКЛ" : "ВКЛ") ));

        testScene.addElement(addNewElementButton);
        testScene.addElement(nextXTextfield);
        testScene.addElement(nextYTextfield);
        testScene.addElement(nextWidthTextfield);
        testScene.addElement(nextHeightTextfield);
        testScene.addElement(nextIsDisabled);

        for (int i = 0; i < 10; i++) {
            int nextX = random.nextInt(UISCENE_WIDTH);
            int nextY = random.nextInt(UISCENE_HEIGHT);
            int nextWidth = random.nextInt(ELEMENT_MAX_WIDTH - ELEMENT_MIN_WIDTH) + ELEMENT_MIN_WIDTH;
            int nextHeight = random.nextInt(ELEMENT_MAX_HEIGHT - ELEMENT_MIN_HEIGHT) + ELEMENT_MIN_HEIGHT;
            boolean isDisabled = random.nextBoolean();
            ((Button)addNewElementButton).setClickCallback( () -> {
                UIElement randElement;
                try {
                    randElement = getRandomElement(nextX, nextY, nextWidth, nextHeight, isDisabled);
                    testScene.addElement(randElement);
                } catch (UIInvalidSizeException | UIElementOverlapException e) {
                    e.printStackTrace();
                }

            } );
            ((TextField) nextXTextfield).setContent("" + nextX);
            ((TextField) nextYTextfield).setContent("" + nextY);
            ((TextField) nextWidthTextfield).setContent("" + nextWidth);
            ((TextField) nextHeightTextfield).setContent("" + nextHeight);
            nextIsDisabled.setStateOn(isDisabled);

            /*
          // Раскомментировать, для последовательного добавления элементов и ре-рендера сцены
            testScene.render();
            System.out.println("Нажмите ВВОД, чтобы добавить следующий элемент");
            System.in.read();
             */

            try {
                ((Clickable) addNewElementButton).click();
            } catch (UIReadOnlyException e) {
                System.out.println(addNewElementButton.toString() + " выключен и нельзя кликнуть его");
            }
        }
        testScene.render();

        System.out.println("Список элементов:");
        testScene.getElements().forEach(e -> System.out.println("  - " + e.toString()));
        System.out.println("\nПрокликивание доступных элементов: ");
        testScene.getElements().stream()
                .filter(e -> e instanceof Clickable)
                .filter(e -> !e.isDisabled())
                .forEach(e -> {
                    System.out.println(" - " + e.getTypeName() + " " + e.getName() + ":");
                    try {
                        ((Clickable) e).click();
                    } catch (UIReadOnlyException uiReadOnlyException) {
                        uiReadOnlyException.printStackTrace();
                    }
                });
        System.out.println("\nВывод содержимого TextField-ов");
        testScene.getElements().stream()
                .filter(e -> e instanceof TextField)
                .forEach(e -> {
                    System.out.println(" - " + e.getTypeName() + " " + e.getName() + ":");
                    System.out.println(((TextField) e).getContent());
                });
    }
}
