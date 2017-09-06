package com.identity.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Created by Анна on 29.04.2017.
 */
@RunWith(Parameterized.class)
public class TextTest {
    private final String text;
    private final String[]sentences;
    private final String[]words;

    public TextTest(String text, String[] sentences, String[] words) {
        this.text = com.identity.utils.File.readFromFile(text, StandardCharsets.UTF_8);
        this.sentences = sentences;
        this.words = words;
    }


    @Parameterized.Parameters
    public static Iterable<Object[]> fillParameters (){
        ClassLoader classLoader = TextTest.class.getClassLoader();
        Properties properties = new Properties();

        try (InputStream in = classLoader.getResourceAsStream("unitTest/utils")) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object[][] tests = {
                {properties.getProperty("text1"), properties.getProperty("sentences1"), properties.getProperty("words1")},
                {properties.getProperty("text2"), properties.getProperty("sentences2"), properties.getProperty("words2")}
        };

        return Arrays.asList(tests);
    }

    @Test
    public void testDivideWords(){

    }

}