package com.task4.core;

import com.task4.core.Char.Char;

import java.util.Arrays;
import java.util.Objects;
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

    public String sceneView() {
        String nullView = "____";
        String sceneStr = "[ ";
        sceneStr += Arrays.stream(fields)
                .map(c -> c == null ? nullView : c.toSceneView())
                .collect(Collectors.joining(" "));
        sceneStr += " ]";
        return sceneStr;
    }

    public int nextFreePos() {
        return IntStream.range(0, SCENE_LENGTH)
                .filter(i -> fields[i] == null)
                .findFirst()
                .orElse(-1);
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
}
