package model;

import java.util.List;

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
}
