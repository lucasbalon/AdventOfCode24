package day4.part1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Res {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src/day4/data.txt");
        Scanner scan = new Scanner(fr);
        String line;
        char[][] tab = new char[140][140];
        int res = 0;
        int i = 0;
        int j;
        while (scan.hasNextLine()) {
            j=0;
            line = scan.nextLine();
            for (char c : line.toCharArray()) {
                tab[i][j++] = c;
            }
            i++;
        }

        for (int y = 0; y < tab.length; ++y) {
            for (int x = 0; x < tab[y].length; ++x) {
                System.out.print(tab[y][x]);
            }
            System.out.println();
        }

        System.out.println(res);
    }
}
