package Task8;

import java.util.List;

public class StringBoxUtils <T> extends Box <T>
{
    public StringBoxUtils(T element)
    {
        super(element);
    }

    public static StringBoxUtils<String> join(List<Box<? extends CharSequence>> boxes)
    {
        StringBuilder str = new StringBuilder();
        for (var box : boxes)
        {
            str.append(box.getElement());
        }
        return new StringBoxUtils<>(str.toString());
    }

    public static void copyNonEmptyStringBoxToList(Box<? extends CharSequence> boxWithStr, List<? super String> sequenceList)
    {
        String str = boxWithStr.getElement().toString().trim();
        if (!str.isEmpty())
        {
            sequenceList.add(str);
        }
    }
}
