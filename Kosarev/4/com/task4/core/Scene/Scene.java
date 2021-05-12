package com.task4.core.Scene;

import com.task4.core.Chars.Char;
import com.task4.core.SceneViewable;
import java.util.Arrays;
import java.util.Objects;


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

    public void processChars() {
        Arrays.stream(fields)
                .map(Field::getContaining)
                .filter(sv -> sv instanceof Char)
                .map(sv -> (Char) sv)
//                .forEach(aChar -> aChar.checkIfDead());
                .forEach(Char::checkIfDead);
    }

    private boolean isSceneSizeValid() {
        return sceneSize > 1;
    }

    public Field[] getFields() {
        return fields;
    }

    public int getSceneSize() {
        return sceneSize;
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
