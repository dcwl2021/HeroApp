package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public class DefectReporter {

    public void reportDefect(String testCase) {

        try {
            FileWriter fw = new FileWriter("DEFECT.md", true);
            fw.write("\n######Failure test : " + testCase + " - [" + new Date() + "]");
            fw.close();
            System.out.println("Defect reported");
        } catch (IOException e) {
            System.out.println("An error occurred when reporting a defect.");
            e.printStackTrace();
        }
    }
}
