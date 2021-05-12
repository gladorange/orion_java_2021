package com.task4.core;


/**
 * Instance of class implementing SceneViewable can be rendered on Scene
 *
 * UPD: идея была такая: я думал, что отрисовываться могут не только Char-ы, но и что-нибудь другое
 *      (я не внимательно прочитал описание д\з и подумал, что спелл Стена огня должна "ставиться"
 *      на четные клетки сцены и персонаж, оказавшийся на этой клетке (не обязательно в тот ход, когда
 *      был скастован спелл) должен получить урон -> соотв эту стену тоже нужно как-то отрисовывать)
 *      Наверное зря все это... (TODO: избавиться от интерфейса)
 */
public interface SceneViewable {
    /**
     * @return String with length == 2 -- view class on Scene
     */
    default String toSceneView() {
        return "????";
    }
}
