package day1.part1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Res {
    public static void main(String[] args) throws FileNotFoundException {
        //open file
        FileReader fr = new FileReader("src/day1/data.txt");
        Scanner scan = new Scanner(fr);
        String line;
        List<Integer> numbers1 = new ArrayList<>();
        List<Integer> numbers2 = new ArrayList<>();
        int res = 0;

        //read lines
        while (scan.hasNextLine()) {
            //read first line
            line = scan.nextLine();
            numbers1.add(Integer.parseInt(line.substring(0, 5)));
            numbers2.add(Integer.parseInt(line.substring(8, 13)));
        }

        while (!numbers1.isEmpty()) {
            int min1 = numbers1.getFirst();
            int min2 = numbers2.getFirst();
            int index1 = 0, index2 = 0;

            for (int i = 0; i < numbers1.size(); i++) {
                if (numbers1.get(i) < min1) {
                    min1 = numbers1.get(i);
                    index1 = i;
                }
            }
            for (int i = 0; i < numbers2.size(); i++) {
                if (numbers2.get(i) < min2) {
                    min2 = numbers2.get(i);
                    index2 = i;
                }
            }
            res += Math.abs(min1 - min2);

            numbers1.remove(index1);
            numbers2.remove(index2);
        }
        System.out.println(res);

        //close file
        scan.close();
    }
}
