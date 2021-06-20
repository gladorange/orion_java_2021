package com.orion.java.homework5;

import com.orion.java.homework5.exception.ReadOnlyException;

public interface Clickable {
    public void onClick()throws ReadOnlyException;
}
