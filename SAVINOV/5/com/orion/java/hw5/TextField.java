package com.orion.java.hw5;

import java.util.Random;

class TextField extends Rectangle implements Clickable {
    private boolean textIsEntered;
    private String text;

    public TextField(int x, int y, int weight, int height, String caption, boolean isActive, String text) {
        super(x, y, weight, height, caption, isActive);
        this.text = text;
        getRandomString(10);
        checkTextIsEntered();
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    private void checkTextIsEntered() {
        if (!isEmpty(this.text)) {
            this.textIsEntered = true;
        } else {
            this.textIsEntered = false;
        }
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    private void getRandomString(int len) {
        StringBuilder result = new StringBuilder(len);
        if (isEmpty(this.text)) {
            final String chars = "abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            for (int i = 0; i < len; i++) {
                result.append(chars.charAt(new Random().nextInt(chars.length())));
            }
            this.text = result.toString();
        }
    }


    @Override
    public void click() {
        //делать кликабельным не обязательно
    }
}