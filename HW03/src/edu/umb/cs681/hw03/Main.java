package edu.umb.cs681.hw03;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        CovidPVI pvi = new CovidPVI();
        List<List<String>> matrix = pvi.PVI();
        ArrayList<Double> massPvi = new ArrayList<>();
        for(int i = 1; i < matrix.size(); i++){
            if(matrix.get(i).get(3).contains("Massachusetts")) {
                String pviString = matrix.get(i).get(0);
                double pviValue = Double.parseDouble(pviString.substring(1, pviString.length() - 1));
                massPvi.add(pviValue);
            }
        }

        double averagePvi = massPvi.stream().reduce(new double[2], (result, pviAvg) ->{
            double average = ((result[0] * result[1]) + pviAvg)/(result[0]+1);
            result[0]++;
            result[1] = average;
            return result;},(finalResult, intermediateResult) -> finalResult)[1];
        System.out.println("Average PVI values of Massachusetts counties: " + averagePvi);

        double variancePvi = massPvi.stream().reduce(new double[1], (result, varianceP) ->{
            double variance = (varianceP - averagePvi)*(varianceP - averagePvi);
            result[0] += variance;
            return result;
        }, (finalResult, intermediateResult) -> finalResult)[0];

        System.out.println("Standard Deviation of Massachusetts counties: " + Math.sqrt(variancePvi/massPvi.size()));
    }

}