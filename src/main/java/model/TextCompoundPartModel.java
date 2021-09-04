package model;

import java.util.ArrayList;
import java.util.List;

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
}
