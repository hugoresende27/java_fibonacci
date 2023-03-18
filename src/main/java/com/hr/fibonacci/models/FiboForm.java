package com.hr.fibonacci.models;

public class FiboForm {

    private int start;
    private int end;

    public FiboForm() {
    }

    @Override
    public String toString() {
        return "Fibo{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public FiboForm(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
