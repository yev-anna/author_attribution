package com.identity.analysis.impl;

import com.identity.analysis.impl.fullTextAnalyse.VocabularyAmountTextAnalyzer;
import com.identity.utils.Language;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by Anna on 22.04.2017.
 */
@RunWith(Parameterized.class)
public class VocabularyAmountTextAnalyzerTest {
    private final String text;
    private final Double expectedRes;

    private static final VocabularyAmountTextAnalyzer analyzer = new VocabularyAmountTextAnalyzer();

    private final static double EPS = 0.01;

    public VocabularyAmountTextAnalyzerTest(String filePath, Charset cs, Double expectedRes){
        this.text = readFromFile(filePath, cs);
        this.expectedRes = expectedRes;
    }

    private String readFromFile(String filePath, Charset cs) {
        String text = "";

        try (BufferedReader bf = new BufferedReader(
                new InputStreamReader(new FileInputStream(new File(filePath)), cs));) {

            String line;
            while ((line=bf.readLine()) != null)
                text +="\n"+line;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> fillParameters (){
        ClassLoader classLoader = VocabularyAmountTextAnalyzerTest.class.getClassLoader();
        Properties properties = new Properties();

        try (InputStream in = classLoader.getResourceAsStream("unitTest/analyzerFiles")) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object[][] tests = {
                {properties.getProperty("text1"), StandardCharsets.UTF_8, new Double(properties.getProperty("voc.amount1"))},
                {properties.getProperty("text2"), StandardCharsets.UTF_8, new Double(properties.getProperty("voc.amount2"))}
        };

        return Arrays.asList(tests);
    }

    @Test
    public void testAnalyse() throws Exception {

        Assert.assertEquals(analyzer.analyse(text), expectedRes, EPS);
    }
}