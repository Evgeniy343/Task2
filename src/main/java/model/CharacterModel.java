package model;

import java.util.List;

public class CharacterModel implements SpeechModel {
    private char sign;

    CharacterModel() {
    }

    CharacterModel(char sign) {
        this.sign = sign;
    }

    @Override
    public void print() {
        System.out.print(sign);
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
