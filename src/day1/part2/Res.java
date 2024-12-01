package day1.part2;

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

        int count;
        for (int j = 0; j < numbers1.size(); j++) {
            count = 0;
            for (int i = 0; i < numbers1.size(); i++) {
                if (numbers1.get(j).equals(numbers2.get(i))) {
                    count++;
                }
            }
            if (count != 0) {
                res += count * numbers1.get(j);
            }
        }
        System.out.println(res);

        //close file
        scan.close();
    }
}
