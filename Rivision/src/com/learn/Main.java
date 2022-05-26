package com.learn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

//        File file=new File("Table.txt");
//
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String table = "";
//
//        for (int i = 1; i <= 10; i++) {
//            table += i + " * " + 5 + " = " + i * 5 + "\n";
//        }
//Scanner sc=new Scanner(System.in);
//        try {
//            FileWriter fw = new FileWriter("Table.txt");
//            fw.write(table);
//            fw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        File file=new File("Table.txt");
//        Scanner sc=new Scanner(file);
//
//        while(sc.hasNextLine()){
//            String table=sc.nextLine();
//            System.out.println(table);
//        }

        List<String> list = List.of("Prashant", "Bhawna", "Rajat");
        Stream<String> s = list.stream();
        List name=s.filter(e -> e == "Prashant").collect(Collectors.toList());
        System.out.println(name);
    }

}
