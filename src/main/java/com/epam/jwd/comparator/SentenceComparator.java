package com.epam.jwd.comparator;

import com.epam.jwd.model.SpeechModel;
import com.epam.jwd.model.TextCompoundPartModel;
import com.epam.jwd.model.WordModel;

import java.util.*;

public class SentenceComparator implements Comparator<SpeechModel> {

    @Override
    public int compare(SpeechModel o1, SpeechModel o2) {
        List<Integer> wordsLength1 = new ArrayList<>();
        List<Integer> wordsLength2 = new ArrayList<>();
        pushWordsLength(o1, wordsLength1);
        pushWordsLength(o2, wordsLength2);
        Optional<Integer> max1 = wordsLength1.stream().max(Integer::compare);
        Optional<Integer> max2 = wordsLength2.stream().max(Integer::compare);
        if(max1.isPresent() && max2.isPresent()) {
            System.out.println(max1);
            System.out.println(max2);
            return max1.get() - max2.get();
        }
        return 0;
    }

    private void pushWordsLength(SpeechModel o, List<Integer> wordsLength1) {
        for (SpeechModel component : o.getComponents()) {
            if(component.getClass().equals(WordModel.class)){
                wordsLength1.add(component.speechLength());
            }
        }
    }
}
