package com.epam.jwd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextCompoundPartModel implements SpeechModel {

    private final List<SpeechModel> components;

    TextCompoundPartModel() {
        this.components = new ArrayList<>();
    }

    TextCompoundPartModel(List<SpeechModel> components) {
        this.components = components;
    }

    @Override
    public void print() {
        for (SpeechModel component : components) {
            component.print();
        }
    }

    @Override
    public void add(SpeechModel component) {
        components.add(component);
    }

    @Override
    public void remove(SpeechModel component) {
        components.remove(component);
    }

    @Override
    public List<SpeechModel> getComponents() {
        return components;
    }

    @Override
    public Integer speechLength() {
        Integer sentenceLength = 0;
        for (SpeechModel component : components) {
            sentenceLength += component.speechLength();
        }
        return sentenceLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextCompoundPartModel that = (TextCompoundPartModel) o;
        return Objects.equals(components, that.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }

    @Override
    public String toString() {
        return "TextCompoundPartModel{" +
                "components=" + components +
                '}';
    }
}
