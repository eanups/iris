package org.anse.dm.iris;

import java.util.Arrays;

public class Utils {


    public static double getMax(double[] arr) {
        double[] arr_copy = arr.clone();
        Arrays.sort(arr_copy);
        return arr_copy[arr.length-1];
    }

    public static double getMin(double[] arr) {
        double[] arr_copy = arr.clone();
        Arrays.sort(arr_copy);
        return arr_copy[0];
    }

    public static double getMean(double[] arr) {
        double sum = 0;
        for (int i=0; i<arr.length; i++) {
            sum += arr[i];

        }
        return sum/arr.length;
    }

    public static double[] normalize(double[] attribute) {
        double maxValue = getMax(attribute);
        double minValue = getMin(attribute);

        double[] normAttribute = new double[attribute.length];
        for (int i=0; i<attribute.length; i++) {
            normAttribute[i] = attribute[i] - getMean(attribute) / maxValue - minValue;
        }
        return normAttribute.clone();
    }

    public static double[][] strToDouble2D(String[][] dataSet, int dim, int size) {
        double[][] doubleDataSet = new double[size][dim];
        for (int i=0; i<size; i++) {
            for (int j=0; j<dim; j++) {
                doubleDataSet[i][j] = Double.parseDouble(dataSet[i][j]);
            }
        }
        return doubleDataSet.clone();
    }

    public static double dist(double[] p1, double[] p2, int dim) {
        double sumOfDist = 0;
        for (int d=0; d<dim; d++) {
            sumOfDist += ( Math.pow(p1[d] - p2[d], 2) );
        }
        return Math.sqrt(sumOfDist);

    }

}
