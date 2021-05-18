package com.task4.core;

import com.task4.core.Char.Template.Char;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Scene {
    private static final int SCENE_LENGTH = 10;
    private Char[] fields = new Char[SCENE_LENGTH];

    public void process() {
        Arrays.stream(fields)
                .filter(Objects::nonNull)
                .forEach(Char::checkIfDead);
    }

    public Char findCharByName(String charName) {
        return Arrays.stream(getChars())
                .filter(c -> c.getName().equals(charName))
                .findFirst()
                .orElse(null);
    }

    public String sceneView() {
        String nullView = "____";
        String sceneStr = "[ ";
        sceneStr += Arrays.stream(fields)
                .map(c -> c == null ? nullView : c.toSceneView())
                .collect(Collectors.joining(" "));
        sceneStr += " ]";
        return sceneStr;
    }

    public int nextRandomFreePos() {
        Random random = new Random();
        int randomPos = random.nextInt(SCENE_LENGTH);
        while (fields[randomPos] != null)
            randomPos = random.nextInt(SCENE_LENGTH);
        return randomPos;
    }

    public void set(Char c, int pos) {
        fields[pos] = c;
    }

    public void del(int pos) {
        fields[pos] = null;
    }

    public void del(Char c) {
        del(c.getScenePos());
    }

    public Char[] getFields() {
        return fields;
    }

    public Char[] getChars() {
        return Arrays.stream(fields).filter(Objects::nonNull).toArray(Char[]::new);
    }
}
