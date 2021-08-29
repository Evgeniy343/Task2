package model;

import java.util.ArrayList;
import java.util.List;

public class TextModel implements SpeechModel {

    private List<SpeechModel> components;

    TextModel() {
        components = new ArrayList<>();
    }

    public static SpeechModel of(){
        return new TextModel();
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
}
