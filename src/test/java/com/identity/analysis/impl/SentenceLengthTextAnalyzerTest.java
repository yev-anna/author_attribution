package com.identity.analysis.impl;

import com.identity.analysis.impl.fullTextAnalyse.SentenceLengthTextAnalyzer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Assert;

import java.io.*;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by Anna on 20.04.2017.
 */
@RunWith(Parameterized.class)
public class SentenceLengthTextAnalyzerTest {
    private final String text;
    private final Double expectedRes;

    private static final SentenceLengthTextAnalyzer analyzer = new SentenceLengthTextAnalyzer();

    private final static double EPS = 0.01;
    //private static Properties properties = new Properties();
    //private final boolean is;

    public SentenceLengthTextAnalyzerTest(/*String text,*/ String filePath, Charset cs, Double expectedRes){
        this.text = readFromFile(filePath, cs);
        this.expectedRes = expectedRes;
        // this.text = text;
        //this.is = is;
    }

    private String readFromFile(String filePath, Charset cs) {
        String text = "";

        try (BufferedReader bf = new BufferedReader(
                new InputStreamReader(new FileInputStream(new File(filePath)), cs));) {

            String line;
            while ((line=bf.readLine()) != null)
                text +="\n"+line;
            //System.out.println(text);
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
        ClassLoader classLoader = SentenceLengthTextAnalyzerTest.class.getClassLoader();
        Properties properties = new Properties();

        try (InputStream in = classLoader.getResourceAsStream("unitTest/analyzerFiles")) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object[][] tests = {
                {properties.getProperty("text1"), StandardCharsets.UTF_8, new Double(properties.getProperty("avg.words.number1"))},
                {properties.getProperty("text2"), StandardCharsets.UTF_8, new Double(properties.getProperty("avg.words.number2"))}
                };

        return Arrays.asList(tests);
    }

    @Test
    public void testAnalyse() throws Exception {
        /*System.out.println(text);
        System.out.println(expectedRes); */
        Assert.assertEquals(analyzer.analyse(text),expectedRes, EPS);
    }
}