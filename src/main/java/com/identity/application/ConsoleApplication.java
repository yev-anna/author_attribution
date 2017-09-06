package com.identity.application;

import com.identity.analysis.Analyzer;
import com.identity.entity.Author;
import com.identity.entity.measures.MeasureEnum;
import com.identity.utils.File;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Анна on 07.05.2017.
 */
public class ConsoleApplication implements Application {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void runDialog() {
        System.out.println("Hello! Choose what you want to do" + "\n" +
                "1 - add new author to database" +"\n" +
                "2 - analyze text for author");
        int answer = scanner.nextInt();

        List<String> texts = new ArrayList<>();

        System.out.println("Enter url of texts (enter 'stop' if you want to stop)");
        String url = "";
        while ((url = scanner.next()).equals("stop")) {
            texts.add(File.readFromFile(url, StandardCharsets.UTF_8));
        }

        List<MeasureEnum> measureEnum = new ArrayList<>();

        Author author = (new Analyzer()).analyseAuthor(texts, measureEnum);

        if(answer == 1) {
            addAuthor(author);
        }
        else if(answer == 2){
            analyzeText(author, measureEnum);
        }
    }

    @Override
    public void addAuthor(Author newAuthor) {
        // add to database
        System.out.println("new author added");
    }

    @Override
    public void analyzeText(Author unknownAuthor, List<MeasureEnum> measures) {
        List<Author> probable = new ArrayList<>();
        System.out.println("The most probable author - " + probable.get(0));
        System.out.println("The same characteristics also have: "+ "\n");
        for (int i = 0; i < 5; i++) {
            System.out.println(probable.get(i));
        }
    }
}
