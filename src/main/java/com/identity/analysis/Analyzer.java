package com.identity.analysis;

import com.identity.analysis.impl.fullTextAnalyse.*;
import com.identity.analysis.impl.partOfSpeechAnalyse.*;
import com.identity.analysis.impl.punctuationAnalyse.*;
import com.identity.entity.Author;
import com.identity.entity.measures.Measure;
import com.identity.entity.measures.MeasureEnum;
import com.identity.utils.Vocabulary;

import java.util.*;

/**
 * Created by Anna on 04.04.2017.
 */
public class Analyzer {
    private Map<MeasureEnum, Double[]> results = new HashMap<>();

    private Set<FullTextAnalyzer> fullTextAnalyzers = new HashSet<>();
    private Set<FractionOfPMTextAnalyzer> fractionOfPMTextAnalyzers = new HashSet<>();
    private Set<FractionOfPOSTextAnalyzer> fractionOfPOSTextAnalyzers = new HashSet<>();


    public Analyzer(){
        fullTextAnalyzers.add(new SentenceLengthTextAnalyzer());
        fullTextAnalyzers.add(new VocabularyAmountTextAnalyzer());

        // maybe it would be better if fractionOfPM be count as fullText; both do not need any preprocessing
        fractionOfPMTextAnalyzers.add(new FractionOfColonTextAnalyzer());
        fractionOfPMTextAnalyzers.add(new FractionOfExclamationMarkTextAnalyzer());
        fractionOfPMTextAnalyzers.add(new FractionOfQuestionMarkTextAnalyzer());
        fractionOfPMTextAnalyzers.add(new FractionOfSemicolonTextAnalyzer());
        fractionOfPMTextAnalyzers.add(new FractionOfCommaTextAnalyzer());
        fractionOfPMTextAnalyzers.add(new FractionOfDashTextAnalyzer());

        fractionOfPOSTextAnalyzers.add(new FractionOfAdjectiveTextAnalyzer());
        fractionOfPOSTextAnalyzers.add(new FractionOfNounTextAnalyzer());
    }

    public Author analyseAuthor(List<String> texts, List<MeasureEnum> measureList) {
        Map<MeasureEnum, Measure> measures = new HashMap<>();

        for(FullTextAnalyzer analyzer : fullTextAnalyzers){
            Measure m = analyzer.getMeasure(texts);
            if(measureList.contains(m.getType()))
                measures.put(m.getType(), m);
        }

        for(FractionOfPMTextAnalyzer analyzer : fractionOfPMTextAnalyzers) {
            Measure m = analyzer.getMeasure(texts);
            if(measureList.contains(m.getType()))
                measures.put(m.getType(), m);
        }

        //List<String> PoS = texts.stream().map(Vocabulary::POSText).collect(Collectors.toList());
        List<String> PoS = new ArrayList<>();
        for(String text : texts) {
            PoS.add(Vocabulary.POSTextSentences(text));
        }
        for(FractionOfPOSTextAnalyzer analyzer : fractionOfPOSTextAnalyzers){
            Measure m = analyzer.getMeasure(PoS);
            if(measureList.contains(m.getType()))
                measures.put(m.getType(), m);
        }

        return new Author(measures);
    }
}
