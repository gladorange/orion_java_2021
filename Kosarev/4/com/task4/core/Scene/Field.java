package com.task4.core.Scene;

import com.task4.core.SceneViewable;


public class Field {
    private SceneViewable containing;

    public Field(SceneViewable containing) {
        this.containing = containing;
    }

    public Field() {
        this.containing = new EmptyField();
    }

    public SceneViewable getContaining() {
        return containing;
    }
}
