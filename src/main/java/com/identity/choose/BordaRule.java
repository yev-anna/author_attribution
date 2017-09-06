package com.identity.choose;

import com.identity.entity.Author;
import com.identity.entity.measures.Measure;
import com.identity.entity.measures.MeasureEnum;

import java.util.*;


/**
 * Created by Анна on 09.05.2017.
 */
public class BordaRule {
    private final Author author;
    private final Distance distance;
    private final List<Author> candidates;

    public BordaRule(Author author, List<Author> candidates) {
        this.author = author;
        this.candidates = candidates;
        this.distance = new Distance(this.author);
    }

    Map<Author, Double> distanceForMeasure(MeasureEnum m){
        Map<Author, Double> dist = new HashMap<>();
        for(Author a : candidates){
            dist.put(a, distance.getDistance(a, m));
        }
        return dist;
    }

    Map<Author, Integer> getPoints(MeasureEnum m){
        Map<Author, Integer> points = new HashMap<>();
        Map<Author, Double> distance = distanceForMeasure(m);

        List<Double> dist = new ArrayList<>();
        int n = candidates.size();

        for(Map.Entry<Author, Double> e : distance.entrySet()) {
            dist.add(e.getValue());
        }
        Collections.sort(dist);
        for(Map.Entry<Author, Double> e : distance.entrySet()) {
            int place = n - dist.indexOf(e.getValue());
            points.put(e.getKey(), place);
        }
        return points;
    }

    Map<Author, HashMap<MeasureEnum, Integer>> fillTable(List<MeasureEnum> measures){
        Map<Author, HashMap<MeasureEnum, Integer>> table = new HashMap<>();
        for(Author a : candidates){
            table.put(a, new HashMap<>());
        }

        for(MeasureEnum m : measures) {
            Map<Author, Integer> column = getPoints(m);
            for (Author a : column.keySet()) {
                HashMap<MeasureEnum, Integer> row = table.get(a);
                    row.put(m, column.get(a));
                table.put(a, row);
            }
        }

        return table;
    }

    Map<Author, Double> vote(List<MeasureEnum> measures){
        Map<Author, HashMap<MeasureEnum, Integer>> table = fillTable(measures);
        Map<Author, Double> results = new HashMap<>();

        for(Author a : candidates){
            HashMap<MeasureEnum, Integer> row = table.get(a);
            double res = 0.0;
            for (MeasureEnum m : row.keySet()) {
                res += row.get(m)*m.getWeight();
            }
            results.put(a, res);
        }
        return results;
    }

    public List<Author> getMostProbable(List<MeasureEnum> measures){
        return sort(vote(measures));
    }

    List<Author> sort(Map<Author, Double> voted) {

        //System.out.println(voted);

        List<Double> voteRes = new ArrayList<>();
        for(Map.Entry<Author, Double> e : voted.entrySet()){
            voteRes.add(e.getValue());
        }
        Collections.sort(voteRes);

        //System.out.println(voteRes);

        int n = candidates.size();
        Map<Author, Integer> points = new HashMap<>();

        //voted = [London=4, Austen=9, Dickens=5]
        // votedRes = [4, 5, 9]
        //size = 3;
        //place = 3-votedRes.indexOf(4)=3-0=3 - > London = 3
        //place = 3-votedRes.indexOf(9)=3-2=1 - > Austen = 1
        //place = 3-votedRed.indexOf(5)=3-1=2 -> Dickens = 2
        for(Map.Entry<Author, Double> e : voted.entrySet()) {
            int place = n - voteRes.indexOf(e.getValue())-1;
            points.put(e.getKey(), place);
        }

        //System.out.println(points);

        //points = [London=3, Austen=1, Dickens=2]

        //List<Author> mostProbable = new ArrayList<>(candidates.size());
        Author[]mostProbable = new Author[candidates.size()];
        for(Map.Entry<Author, Integer> e : points.entrySet()) {
            //System.out.println("place = " + e.getValue() + " author = " + e.getKey());
            //mostProbable.add(e.getValue(), e.getKey());
            mostProbable[e.getValue()] = e.getKey();
        }

        return Arrays.asList(mostProbable);
    }

}
