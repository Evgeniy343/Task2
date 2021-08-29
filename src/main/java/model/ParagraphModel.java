package model;

import java.util.ArrayList;
import java.util.List;

public class ParagraphModel implements SpeechModel {

    private List<SentenceModel> components;

    ParagraphModel() {
        components = new ArrayList<>();
    }

    public static SpeechModel of() {
        return new ParagraphModel();
    }

    @Override
    public void print() {
        for (SpeechModel component : components) {
            component.print();
        }
    }

    @Override
    public void add(SpeechModel component) {
        components.add((SentenceModel) component);
    }

    @Override
    public void remove(SpeechModel component) {
        components.remove((SentenceModel) component);
    }
}
