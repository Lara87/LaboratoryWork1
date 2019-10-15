package com.company;

import java.io.*;

public class Main {

    public static char[] vowels = new char[]{'а', 'е', 'и', 'о', 'ё', 'ы', 'у', 'э', 'ю', 'я'};

    public static void main(String[] args) throws IOException  {
        try {
            System.out.println("Лабораторная работа №1.\nВыполнила студентка ЗИНРб-41 Черникова Любовь.\nНайти, каких букв, гласных или согласных, больше в каждом предложении текста.\n");
            FileInputStream fstream = new FileInputStream("C:\\Qt\\QtProjects\\text.txt");
            DataInputStream in = new DataInputStream(fstream);

            String strLine;
            for(BufferedReader br = new BufferedReader(new InputStreamReader(in)); (strLine = br.readLine()) != null; System.out.println("------------------------------------")) {
                System.out.println(strLine);
                String strLineEnd = strLine.replaceAll("[^A-Za-zА-Яа-я]", "");
                int a = strLineEnd.length();
                System.out.println("Всего букв: " + a);
                char[] chArray = strLineEnd.toCharArray();
                int countVowels = 0;

                int notVowels;
                for(notVowels = 0; notVowels < chArray.length; ++notVowels) {
                    for(int j = 0; j < vowels.length; ++j) {
                        if (chArray[notVowels] == vowels[j]) {
                            ++countVowels;
                        }
                    }
                }

                notVowels = a - countVowels;
                System.out.println("Согласных: " + notVowels);
                System.out.println("Гласных: " + countVowels);
                if (notVowels > countVowels) {
                    System.out.println("Согласных больше");
                } else if (notVowels < countVowels) {
                    System.out.println("Гласных больше");
                } else {
                    System.out.println("Количество гласных и согланых равно");
                }
            }

            in.close();
        } catch (Exception var11) {
            System.err.println("Error: " + var11.getMessage());
        }
    }
}
