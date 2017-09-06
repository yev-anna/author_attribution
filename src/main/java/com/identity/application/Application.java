package com.identity.application;

import com.identity.entity.Author;
import com.identity.entity.measures.MeasureEnum;

import java.util.List;

/**
 * Created by Анна on 07.05.2017.
 */
public interface Application {
    void runDialog();

    void addAuthor(Author author);

    void analyzeText(Author unknownAuthor, List<MeasureEnum> measures);
}
