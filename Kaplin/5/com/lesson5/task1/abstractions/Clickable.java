package com.lesson5.task1.abstractions;

import com.lesson5.task1.exceptions.ReadOnlyException;

public interface Clickable {
    void click() throws ReadOnlyException;
}
