package day2.part2;

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
            if (Verify(el)) {
                res++;
            }  else {
                boolean safe = false;
                for (int i = 0; i < el.length; i++) {
                    int[] modifiedArray = removeElement(el, i);
                    if (Verify(modifiedArray)) {
                        safe = true;
                        break;
                    }
                }
                if (safe) {
                    res++;
                }
            }
        }
        System.out.println(res);
        //close file
        scan.close();
    }

    public static boolean Verify(int[] el) {
        return day2.part1.Res.Verify(el);
    }

    public static int[] removeElement(int[] array, int indexToRemove) {
        int[] newArray = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != indexToRemove) {
                newArray[j++] = array[i];
            }
        }
        return newArray;
    }

    public static int[] StringArrToIntArr(String[] s) {
        return day2.part1.Res.StringArrToIntArr(s);
    }
}
