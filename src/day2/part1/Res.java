package day2.part1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Res {
    public static void main(String[] args) throws FileNotFoundException {
        //open file
        FileReader fr = new FileReader("src/day2/data.txt");
        Scanner scan = new Scanner(fr);
        String line;
        ArrayList<int[]> numbers = new ArrayList<>();


        int res = 0;

        //read lines
        while (scan.hasNextLine()) {
            line = scan.nextLine();
            numbers.add(StringArrToIntArr(line.split("\\s+")));
        }

        for (int[] el: numbers) {
            if (Verify(el))
                res++;
        }
        System.out.println(res);
        //close file
        scan.close();
    }

    public static boolean Verify(int[] el) {
        boolean increasing;
        increasing = el[0] < el[1];
        for (int i = 0; i < el.length-1; i++) {
            if ((increasing && el[i] > el[i+1]) || (!increasing && el[i] < el[i+1])) {
                return false;
            }
            if ((increasing && (el[i] < el[i+1] && el[i+1] <= el[i] + 3)) || (!increasing && (el[i] < el[i+1] && el[i] >= el[i+1] + 3))) { //problème ici surement, attention data de test
                return false;
            }
        }
        return true;
    }

    public static int[] StringArrToIntArr(String[] s) {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }
}
