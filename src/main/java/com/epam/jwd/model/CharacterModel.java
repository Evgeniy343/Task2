package com.epam.jwd.model;

import java.util.List;
import java.util.Objects;

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

    @Override
    public Integer speechLength() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterModel that = (CharacterModel) o;
        return sign == that.sign;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sign);
    }

    @Override
    public String toString() {
        return "CharacterModel{" +
                "sign=" + sign +
                '}';
    }
}
