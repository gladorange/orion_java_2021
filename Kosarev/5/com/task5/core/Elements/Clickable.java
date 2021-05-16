package com.task5.core.Elements;


public interface Clickable {
    ClickCallback getClickCallback();

    default void click() {
        getClickCallback().onClick();
    }
}
