package com.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Input fileName: ");
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        System.out.print("Output fileName: ");
        String CSV_FILE = in.nextLine();
        in.close();

        FileReader file = new FileReader(fileName);

        CSVWriter writer = new CSVWriter(CSV_FILE);
        writer.writerCSV(file.readFile());
    }
}
