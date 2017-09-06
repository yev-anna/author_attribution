package com.identity.entity.measures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anna on 04.04.2017.
 */
public enum MeasureEnum implements Comparable<MeasureEnum>{
    SENTENCE_LENGTH(1), WORD_LENGTH(1), VOCABULARY_AMOUNT(1),

    FRACTION_NOUN(1), FRACTION_VERB(1), FRACTION_ADJECTIVE(1), FRACTION_ADVERB(1), FRACTION_NUMERAL(1), FRACTION_INT(1),
    FRACTION_PREP(1), FRACTION_PRONOUN(1), FRACTION_CONJ(1), FRACTION_VBE(1), FRACTION_ARTICLE (1),

    FRACTION_COMMA(1), FRACTION_DASH(1), FRACTION_SEMICOLON(1), FRACTION_COLON(1), FRACTION_QUESTION(1),
    FRACTION_EXCLAMATION(1), FRACTION_BRACKETS(1),

    FUNCTION_THE(1), FUNCTION_A(1),

    FUNCTION_OF(1), FUNCTION_IN(1), FUNCTION_TO(1), FUNCTION_FOR(1), FUNCTION_WITH(1), FUNCTION_ON(1), FUNCTION_AT(1),
    FUNCTION_FROM(1), FUNCTION_BY(1);

    private double weight;
    MeasureEnum(double weight) {
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }

    public static List<MeasureEnum> getStrongList(){
        List<MeasureEnum> m = new ArrayList<>();

        m.add(SENTENCE_LENGTH);
        m.add(VOCABULARY_AMOUNT);
        m.add(FRACTION_COMMA);
        m.add(FRACTION_SEMICOLON);
        m.add(FUNCTION_THE);

        return m;
    }

    public static List<MeasureEnum> getMoreList(){
        List<MeasureEnum> m = new ArrayList<>();

        m.add(FRACTION_COLON);
        m.add(FUNCTION_TO);
        m.add(FUNCTION_FOR);
        m.add(FUNCTION_BY);
        m.add(FRACTION_ARTICLE);

        return m;
    }

    public static List<MeasureEnum> getMiddleList(){
        List<MeasureEnum> m = new ArrayList<>();

        m.add(WORD_LENGTH);
        m.add(FRACTION_EXCLAMATION);
        m.add(FRACTION_QUESTION);
        m.add(FRACTION_BRACKETS);
        m.add(FUNCTION_OF);
        m.add(FUNCTION_ON);
        m.add(FUNCTION_AT);
        m.add(FRACTION_PREP);
        m.add(FRACTION_ADVERB);

        return m;
    }

    public static List<MeasureEnum> getLessList(){
        List<MeasureEnum> m = new ArrayList<>();

        m.add(FUNCTION_A);
        m.add(FUNCTION_WITH);
        m.add(FUNCTION_FROM);
        m.add(FRACTION_CONJ);
        m.add(FRACTION_PRONOUN);
        m.add(FRACTION_VBE);

        return m;
    }

    public static List<MeasureEnum> getLowList(){
        List<MeasureEnum> m = new ArrayList<>();

        m.add(FUNCTION_IN);
        m.add(FRACTION_ADJECTIVE);
        m.add(FRACTION_INT);
        m.add(FRACTION_NUMERAL);
        m.add(FRACTION_VERB);

        return m;
    }



}
