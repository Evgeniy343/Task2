package model;

public class CharacterModel implements SpeechModel {
    private char sign;

    public CharacterModel(char sign) {
        this.sign = sign;
    }

    @Override
    public void print() {
        System.out.println(sign);
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
