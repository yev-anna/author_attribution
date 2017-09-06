package com.identity.utils;

import org.apache.lucene.morphology.Morphology;
import org.apache.lucene.morphology.WrongCharaterException;
import org.apache.lucene.morphology.english.EnglishMorphology;
import org.apache.lucene.morphology.russian.RussianMorphology;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Анна on 25.04.2017.
 */

public class Vocabulary {
    private Vocabulary(){}

    public static List<String> info(String word/*, Language l*/){
        Morphology morph;
        List<String> info = new ArrayList<>();
        try {
            /*if(l == Language.RU)
                morph = new RussianMorphology();
            else */
            morph = new EnglishMorphology();

            info = morph.getMorphInfo(word);
            //System.out.println(info);
        }
        catch (WrongCharaterException e) {
            return null;
        }
        catch (Exception e) {
            e.printStackTrace();
            //System.out.println("problem " + word);
        }
        return info;
    }

    public static String makeInfinitive(String word/*, Language l*/){
        Morphology morph;
        List<String> normal;
        try {
            /*if(l == Language.RU)
                morph = new RussianMorphology();
            else */
            morph = new EnglishMorphology();

            normal = morph.getNormalForms(word.toLowerCase());
            word = normal.get(0);
        }
        catch (WrongCharaterException e) {
            return word;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return word;
    }


    /**
     * @param infoList
     * @return all probable POS from full infoList
     */
    public static List<String> getAllPartOfSpeech(List<String> infoList){
        List<String> partsOfSpeech = new ArrayList<>();
        if(infoList==null) {
            return null;
        }
        for(String info : infoList){
            String[] infoParts = Text.divideWords(info);
            //System.out.println(Arrays.toString(Text.divideWords(info)));
            partsOfSpeech.add(infoParts[1]);
        }
        return partsOfSpeech;
    }

    public static PartOfSpeech getPartOfSpeech(String word){
        List<String> allPartOfSpeech = getAllPartOfSpeech(info(word.toLowerCase()));
        if(allPartOfSpeech == null)
            return PartOfSpeech.UNKNOWN;

        String probable = allPartOfSpeech.get(0);
        return PartOfSpeech.valueOf(probable);
    }

    public static String POSText(String text){
        StringBuilder newText = new StringBuilder();
        String[]words = Text.divideWords(text);
        for(String word : words){
            PartOfSpeech pos = getPartOfSpeech(word.toLowerCase());
            newText.append(pos + " ");
        }
        return new String(newText);
    }

    public static String POSTextSentences(String text) {
        StringBuilder newText = new StringBuilder();
        String[]sentences = Text.divideSentences(text);
        for(String s : sentences) {
            String pos = POSText(s);
            newText.append(pos + ". ");
        }
        return new String(newText);
    }

}
