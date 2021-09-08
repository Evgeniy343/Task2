package com.epam.jwd.sort;

import com.epam.jwd.comparator.ParagraphComparator;
import com.epam.jwd.comparator.SentenceComparator;
import com.epam.jwd.model.SpeechModel;
import com.epam.jwd.model.TextCompoundPartModel;

import java.util.ArrayList;
import java.util.List;

public class SpeechSort implements Sort{
    public SpeechSort() {
    }

    @Override
    public List<SpeechModel> sortParagraphs(List<SpeechModel> components, ParagraphComparator comparator) {
        List<SpeechModel> sortedParagraphs = new ArrayList<>();
        pushSortedSpeeches(components, sortedParagraphs);
        sortedParagraphs.sort(comparator);
        return sortedParagraphs;
    }

    @Override
    public List<SpeechModel> sortSentences(List<SpeechModel> components, SentenceComparator comparator) {
        List<SpeechModel> sortedSentences = new ArrayList<>();
        pushSortedSpeeches(components, sortedSentences);
        sortedSentences.sort(comparator);
        return sortedSentences;
    }

    private void pushSortedSpeeches(List<SpeechModel> components, List<SpeechModel> sortedSpeeches) {
        for (SpeechModel component : components) {
            if (component.getClass().equals(TextCompoundPartModel.class)) {
                sortedSpeeches.add(component);
            }
        }
    }
}
