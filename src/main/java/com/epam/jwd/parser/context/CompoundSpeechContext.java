package com.epam.jwd.parser.context;

import com.epam.jwd.model.SpeechModel;
import com.epam.jwd.model.SpeechTypeModel;

import java.util.List;

public class CompoundSpeechContext {
    private final SpeechTypeModel type;
    private final List<SpeechModel> components;
    private final SimpleSpeechContext simpleContext;

    public CompoundSpeechContext(SpeechTypeModel type, List<SpeechModel> components, SimpleSpeechContext simpleContext) {
        this.type = type;
        this.components = components;
        this.simpleContext = simpleContext;
    }

    public List<SpeechModel> getComponents() {
        return components;
    }

    public SpeechTypeModel getType() {
        return type;
    }

    public SimpleSpeechContext getSimpleContext() {
        return simpleContext;
    }
}
