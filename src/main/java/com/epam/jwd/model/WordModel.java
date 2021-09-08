package com.epam.jwd.model;

import java.util.List;
import java.util.Objects;

public class WordModel implements SpeechModel {
    private final String wrd;

    WordModel(String wrd) {
        this.wrd = wrd;
    }

    @Override
    public void print() {
        System.out.print(wrd);
    }

    @Override
    public void add(SpeechModel component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(SpeechModel component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<SpeechModel> getComponents() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer speechLength() {
        return wrd.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordModel wordModel = (WordModel) o;
        return Objects.equals(wrd, wordModel.wrd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wrd);
    }

    @Override
    public String toString() {
        return "WordModel{" +
                "wrd='" + wrd + '\'' +
                '}';
    }
}
