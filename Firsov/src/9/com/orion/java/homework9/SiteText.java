package com.orion.java.homework9;

public class SiteText implements Comparable<SiteText>{


    private StringBuffer data;
    private int id;

    public SiteText(StringBuffer stringBuffer, int id) {
        this.data = stringBuffer;
        this.id = id;
    }

    public StringBuffer getData() {
        return data;
    }

    @Override
    public int compareTo(SiteText o) {
        return this.id - o.id;
    }
}
