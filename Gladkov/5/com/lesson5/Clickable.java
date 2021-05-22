package com.lesson5;

import com.lesson5.exceptions.ReadOnlyException;

public interface Clickable {
    void click() throws ReadOnlyException;
}
