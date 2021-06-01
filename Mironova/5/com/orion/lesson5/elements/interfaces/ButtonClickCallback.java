package com.orion.lesson5.elements.interfaces;

import com.orion.lesson5.exceptions.OutOfRangeException;

import java.lang.reflect.InvocationTargetException;

public interface ButtonClickCallback {

    void onButtonClick() throws OutOfRangeException;

}
