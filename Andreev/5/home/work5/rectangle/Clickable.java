package home.work5.rectangle;

import home.work5.exceptions.ElementsOverlapException;
import home.work5.exceptions.ReadOnlyException;

public interface Clickable {
    void click() throws ReadOnlyException;
}
