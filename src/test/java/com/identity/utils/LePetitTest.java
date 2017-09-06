package com.identity.utils;

import com.identity.analysis.Analyzer;
import com.identity.analysis.TextAnalyzer;
import com.identity.analysis.impl.functionalWordsAnalyse.FunctionWordTheTextAnalyzer;
import com.identity.analysis.impl.punctuationAnalyse.FractionOfBracketsTextAnalyzer;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

/**
 * Created by Анна on 25.04.2017.
 */
public class LePetitTest {

    @Test
    public void test() throws Exception {
        String text = "Beginning with spasmodic words, he went on to speak more and more\n" +
                "fluently, more and more passionately, feeling her leaning towards him,\n" +
                "listening with wonder like a child, with gratitude like a woman. She\n" +
                "interrupted him gravely now and then.\n" +
                "\n" +
                "\"But it was foolish to stand outside and look at the windows. Suppose\n" +
                "William hadn’t seen you. Would you have gone to bed?\"\n" +
                "\n" +
                "He capped her reproof with wonderment that a woman of her age could have\n" +
                "stood in Kingsway looking at the traffic until she forgot.\n" +
                "\n" +
                "“But it was then I first knew I loved you!” she exclaimed.";

        String filePath = "data\\library\\Charles_Dickens_David_Copperfield.txt";
        long timeStart = System.currentTimeMillis();
        String fileText = File.readFromFile(filePath, StandardCharsets.UTF_8);
        long timeEnd = System.currentTimeMillis();
        System.out.println(timeEnd - timeStart);
    }
}