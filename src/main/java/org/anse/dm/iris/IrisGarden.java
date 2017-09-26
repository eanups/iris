package org.anse.dm.iris;


public class IrisGarden {
    private static final short REC_SIZE = 150;
    private static final String FILE = "iris.data";


    private String garden[][];
    // private double doubleGarden [][] = new double[REC_SIZE][];

    private double[] sepalLengthArr = new double[REC_SIZE];
    private double[] sepalWidthArr = new double[REC_SIZE];
    private double[] petalLengthArr = new double[REC_SIZE];
    private double[] petalWidthArr = new double[REC_SIZE];

    private String[] classLabelArr = new String[REC_SIZE];

    private CSVReader csvReader;


    public double[] getSepalLengthArr() {
        return sepalLengthArr;
    }

    public double[] getSepalWidthArr() {
        return sepalWidthArr;
    }

    public double[] getPetalLengthArr() {
        return petalLengthArr;
    }

    public double[] getPetalWidthArr() {
        return petalWidthArr;
    }

    public String[] getClassLabelArr() {
        return classLabelArr;
    }

    public IrisGarden() {
        this(FILE, REC_SIZE);
    }

    public IrisGarden(String file, int size) {
        csvReader = new CSVReader();
        garden = csvReader.readCSV(file, size);

        for (int i=0; i < size; i++) {

            sepalLengthArr[i] = Double.parseDouble(garden[i][0]);
            sepalWidthArr[i] = Double.parseDouble(garden[i][1]);
            petalLengthArr[i] = Double.parseDouble(garden[i][2]);
            petalWidthArr[i] = Double.parseDouble(garden[i][3]);
            classLabelArr[i] = garden[i][4];

        }
    }

    public String[][] getGarden() {
        return garden;
    }

    /**
     * Sets the Iris Garden
     * @param garden
     */
    public void setGarden(String[][] garden) {
        this.garden = garden;
    }


    public void setGarden(double[] sepalLengthArr, double[] sepalWidthArr, double[] petalLengthArr,
                          double[] petalWidthArr) {
        this.sepalLengthArr = sepalLengthArr;
        this.sepalWidthArr = sepalWidthArr;
        this.petalLengthArr = petalLengthArr;
        this.petalWidthArr = petalWidthArr;

        for (int i=0; i<REC_SIZE; i++) {
            garden[i][0] = Double.toString(sepalLengthArr[i]);
            garden[i][1] = Double.toString(sepalWidthArr[i]);
            garden[i][2] = Double.toString(petalLengthArr[i]);
            garden[i][3] = Double.toString(petalWidthArr[i]);

        }
    }


    /**
     * Displays Iris Garden Data
     */
    public void displayIrisGarden () {
        System.out.println("=================================================");
        System.out.println("        IRIS GARDEN      ");
        System.out.println("=================================================");


        for (int i=0; i<REC_SIZE; i++) {
            System.out.println(i+1 + ": " + garden[i][0] + " | " + garden[i][1] + " | " + garden[i][2]
                    + " | " + garden[i][3] + "\tClass: " + garden[i][4]) ;

        }

        System.out.println("\n=================================================\n");


    }


}
