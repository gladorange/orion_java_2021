package com.task5.core.Elements.Templates;


import com.task5.core.Exceptions.UIReadOnlyException;

public interface Clickable {
    ClickCallback getClickCallback();

    default void click() throws UIReadOnlyException {
        getClickCallback().onClick();
    }
}
