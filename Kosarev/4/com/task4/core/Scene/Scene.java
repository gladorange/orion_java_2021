package com.task4.core.Scene;

import com.task4.core.SceneViewable;
import java.util.Arrays;


public class Scene {
    private int sceneSize;
    private Field[] fields;

    public Scene(int sceneSize) {
        this.sceneSize = sceneSize;
        if (!isSceneSizeValid())
            throw new IllegalArgumentException("sceneSize must be greater than 1 (got sceneSize = " + sceneSize + ")");
        fields = new Field[sceneSize];
        Arrays.fill(fields, new Field());
    }

    public void add(SceneViewable sceneViewable, int fieldId) {
        fields[fieldId] = new Field(sceneViewable);
    }

    public void del(int fieldId) {
        fields[fieldId] = new Field();
    }

    private boolean isSceneSizeValid() {
        return sceneSize > 1;
    }

    @Override
    public String toString() {
        String scene_str = "[ ";
        for (Field field: fields) {
            scene_str += field.getContaining().toSceneView() + " ";
        }
        scene_str += "]";
        return scene_str;
    }

}
