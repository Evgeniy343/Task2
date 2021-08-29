package model;

public class WordModel implements SpeechModel {
    private String wrd;

    public WordModel(String wrd) {
        this.wrd = wrd;
    }

    @Override
    public void print() {
        System.out.println(wrd);
    }

    @Override
    public void add(SpeechModel component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(SpeechModel component) {
        throw new UnsupportedOperationException();
    }
}
