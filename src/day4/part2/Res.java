package day4.part2;

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
                if (tab[y][x] == 'A') {
                    res += find(tab, x, y);
                }
            }
            System.out.println();
        }

        System.out.println(res);
    }

    public static int find(char[][] tab, int X, int Y) {
        int[][][] patterns = {
                {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}},
                {{-1, -1}, {1, -1}, {-1, 1}, {1, 1}},
                {{1, -1}, {1, 1}, {-1, -1}, {-1, 1}},
                {{-1, 1}, {1, 1}, {-1, -1}, {1, -1}},
        }; // too low ??

        int rows = tab.length;
        int cols = tab[0].length;
        int count = 0;

        for (int[][] pattern : patterns) {
            boolean match = true;
            for (int i = 0; i < pattern.length; i++) {
                int newX = X + pattern[i][1];
                int newY = Y + pattern[i][0];
                char expectedChar = (i < 2) ? 'M' : 'S';

                if (newX < 0 || newX >= cols || newY < 0 || newY >= rows || tab[newY][newX] != expectedChar) {
                    match = false;
                    break;
                }
            }
            if (match) {
                count++;
            }
        }

        return count;
    }
}
