package com.company;

import java.io.*;

public class Main {

    public static char[] vowels = new char[]{'�', '�', '�', '�', '�', '�', '�', '�', '�', '�'};

    public static void main(String[] args) throws IOException  {
        try {
            System.out.println("������������ ������ �1.\n��������� ��������� �����-41 ��������� ������.\n�����, ����� ����, ������� ��� ���������, ������ � ������ ����������� ������.\n");
            FileInputStream fstream = new FileInputStream("C:\\Qt\\QtProjects\\text.txt");
            DataInputStream in = new DataInputStream(fstream);

            String strLine;
            for(BufferedReader br = new BufferedReader(new InputStreamReader(in)); (strLine = br.readLine()) != null; System.out.println("------------------------------------")) {
                System.out.println(strLine);
                String strLineEnd = strLine.replaceAll("[^A-Za-z�-��-�]", "");
                int a = strLineEnd.length();
                System.out.println("����� ����: " + a);
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
                System.out.println("���������: " + notVowels);
                System.out.println("�������: " + countVowels);
                if (notVowels > countVowels) {
                    System.out.println("��������� ������");
                } else if (notVowels < countVowels) {
                    System.out.println("������� ������");
                } else {
                    System.out.println("���������� ������� � �������� �����");
                }
            }

            in.close();
        } catch (Exception var11) {
            System.err.println("Error: " + var11.getMessage());
        }
    }
}
