package org.anse.dm.iris;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * CSV File Reader
 */
public class CSVReader {

    private static final String DELIM = ",";

    /**
     *
     * @param filename
     * @return
     */
    private File getResourceFile(String filename) {
        File file = null ;
        ClassLoader loader = getClass().getClassLoader();
        URL res = loader.getResource(filename);
        if (res!=null) {
            file = new File(res.getFile());
        }
        return file;
    }


    /**
     * Reads a CSV file of size 'N' and returns a two dimensional data set
     * @param filename CSV file to be read
     * @param size number of records
     * @return 2D String Array
     */
    public String[][] readCSV(String filename, int size) {
        String line;
        CSVReader reader = new CSVReader();
        String[][] dataSet = new String[size][];


        try(BufferedReader br = new BufferedReader(new FileReader(reader.getResourceFile(filename)))) {
            int count = 0;

            while ((line = br.readLine()) != null && line.trim().length() > 0) {
                String[] record = line.split(DELIM);
                dataSet[count] = record;
                count += 1;

            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return dataSet.clone();
    }


}
