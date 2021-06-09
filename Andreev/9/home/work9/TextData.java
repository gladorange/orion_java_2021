package home.work9;

public class TextData implements Comparable<TextData>{
    private int objNumber;
    private StringBuffer data;

    public TextData(StringBuffer stringBuffer, int objNumber) {
        this.data = stringBuffer;
        this.objNumber = objNumber;
    }

    public StringBuffer getData() {
        return data;
    }

    public int getObjNumber() {
        return objNumber;
    }

    @Override
    public int compareTo(TextData o) {
        return this.objNumber - o.getObjNumber();
    }
}
