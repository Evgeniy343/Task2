package com.epam.jwd.comparator;

import com.epam.jwd.model.SpeechModel;
import com.epam.jwd.model.TextCompoundPartModel;

import java.util.Comparator;

public class ParagraphComparator implements Comparator<SpeechModel> {
    @Override
    public int compare(SpeechModel o1, SpeechModel o2) {
        return o1.getComponents().size() - o2.getComponents().size();
    }
}
