package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
//        popularityRanking();
        rankingSummary();
    }

    public static void rankingSummary() throws FileNotFoundException {
        System.out.println("Year | \tRank1\tRank2\tRank3\tRank4\tRank5\t| \tRank1\tRank2\tRank3\tRank4\tRank5");
        System.out.println("_________________________________________________________________________________________");
        for(int i=10;i>0;--i){
            String fileName = "babynamesranking" + (2000 + i) + ".txt";
            Scanner in = new Scanner(new File(fileName));
            System.out.print((2000 + i) + " |\t");
            String [] girls = new String[5];
            for(int j=0;j<5;++j){
                String [] line = in.nextLine().split("\t");
                System.out.printf("%.7s\t", line[1]);
                girls[j] = line[3];
            }
            System.out.print("|\t");
            for(int j=0;j<5;++j){
                System.out.printf("%.7s\t", girls[j]);
            }
            System.out.println();
        }
    }

    public static void popularityRanking() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter year: ");
        int y = in.nextInt();
        System.out.print("Enter the gender: ");
        String g = in.next();
        System.out.print("Enter the name: ");
        String n = in.next();

        String fileName = "babynamesranking" + y + ".txt";
        in = new Scanner(new File(fileName));
        int p = 1;
        while(in.hasNextLine()){
            String [] line = in.nextLine().split("\t");
            if((line[1].equals(n) && g.equals("M"))
                    || (line[3].equals(n) && g.equals("F"))){
                System.out.printf("%s is ranked #%d in year %d", n, p, y);
                return;
            }
            ++p;
        }
        System.out.printf("The name %s is not ranked in year %d", n, y);
        in.close();
    }

}
