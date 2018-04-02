package Lesson2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class ReportMaker {
    public static void makeReportPDF(String str) throws IOException{
        PrintWriter pw = new PrintWriter("Z:/1.txt");
        pw.println();
        pw.close();
    }
}
