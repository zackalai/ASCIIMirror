package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input the file path:");
        Scanner scanner = new Scanner(System.in);
        String filepath = scanner.nextLine();

        File path = new File(filepath);
        List<String> list = new ArrayList<>();
        String input;
        int stringMaxLength = 0;

        if (path.exists() && path.isFile()) {
            try (Scanner reader = new Scanner(path)) {

                while (reader.hasNext()) {
                    input = reader.nextLine();
                    if (input.length() > stringMaxLength) {
                        stringMaxLength = input.length();
                    }
                    list.add(input);
                }

                String temp = "";

                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < stringMaxLength - list.get(i).length(); j++) {
                        temp += " ";

                    }
                    list.set(i, list.get(i) + temp + " | " + temp + reversedString(list.get(i)));
                    temp = "";
                    System.out.println(list.get(i));
                }

            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("File not found!");
        }
    }

    public static String reversedString(String s) {
        char[] chArray = s.toCharArray();
        for (int i = 0; i < chArray.length; i++) {
            if (chArray[i] == '/') {
                chArray[i] = '\\';
            } else if (chArray[i] == '\\') {
                chArray[i] = '/';
            } else if (chArray[i] == '(') {
                chArray[i] = ')';
            } else if (chArray[i] == ')') {
                chArray[i] = '(';
            } else if (chArray[i] == '[') {
                chArray[i] = ']';
            } else if (chArray[i] == ']') {
                chArray[i] = '[';
            } else if (chArray[i] == '<') {
                chArray[i] = '>';
            } else if (chArray[i] == '>') {
                chArray[i] = '<';
            } else if (chArray[i] == '{') {
                chArray[i] = '}';
            } else if (chArray[i] == '}') {
                chArray[i] = '{';
            }
        }
        s = new String(chArray);
        StringBuilder bd = new StringBuilder(s);
        bd.reverse();
        return bd.toString();
    }
}