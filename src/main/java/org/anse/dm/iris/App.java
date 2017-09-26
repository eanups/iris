package org.anse.dm.iris;

public class App {

    public static void main(String[] args) {

        IrisGarden garden = new IrisGarden();

        garden.displayIrisGarden();

        double[] slArr = Utils.normalize(garden.getSepalLengthArr());
        double[] swArr = Utils.normalize(garden.getSepalWidthArr());
        double[] plArr = Utils.normalize(garden.getPetalLengthArr());
        double[] pwArr = Utils.normalize(garden.getPetalWidthArr());

        garden.setGarden(slArr, swArr, plArr, pwArr);

        garden.displayIrisGarden();


        int dimension = 4;
        // Read Training Data
        int train_size = 90;
        IrisGarden trainIGarden = new IrisGarden("train.csv",train_size);
        double[][] trainGarden = Utils.strToDouble2D(trainIGarden.getGarden(), dimension, train_size);


        // Read Test Data
        int test_size = 60;
        IrisGarden testIGarden = new IrisGarden("test.csv", test_size);
        double[][] testGarden = Utils.strToDouble2D(testIGarden.getGarden(), dimension, test_size);

        String[] trainLabels = trainIGarden.getClassLabelArr();
        String[] testLabels = testIGarden.getClassLabelArr();


        int correct = 0;
        int index = 0;
        double[] point1 = new double[dimension];
        double[] point2 = new double[dimension];

        double[] newIndex = new double[test_size];

        for (int i=0; i<test_size; i++) {
            double minDistance = 1000.0;

            for (int j=0; j<train_size; j++) {
                for (int k=0; k<dimension; k++) {
                    point1[k] = testGarden[i][k];
                    point2[k] = trainGarden[j][k];

                }
                double dist = Utils.dist(point1, point2, dimension);
                if (dist < minDistance) {
                    index = j;
                    minDistance = dist;
                    newIndex[i] = j;
                }

            }
            if (trainLabels[index].equals(testLabels[i])) {
                correct += 1 ;
            } else {
                System.out.println(" Unmatched Data Point index: " + i);
            }
        }

        double accuracy = (double)correct / test_size * 100;

        System.out.println(" *** The accuracy of the Nearest Neighbor algo for IRIS data: " + accuracy);

    }
}
