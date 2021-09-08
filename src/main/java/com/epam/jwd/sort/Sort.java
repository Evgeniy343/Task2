package com.epam.jwd.sort;

import com.epam.jwd.comparator.ParagraphComparator;
import com.epam.jwd.comparator.SentenceComparator;
import com.epam.jwd.model.SpeechModel;

import java.util.List;

public interface Sort {
    List<SpeechModel> sortParagraphs(List<SpeechModel> components, ParagraphComparator comparator);

    List<SpeechModel> sortSentences(List<SpeechModel> components, SentenceComparator comparator);
}
