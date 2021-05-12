package com.task4.core;


/**
 * Instance of class implementing SceneViewable can be rendered on Scene
 */
public interface SceneViewable {
    /**
     * @return String with length == 2 -- view class on Scene
     */
    default String toSceneView() {
        return "????";
    }
}
