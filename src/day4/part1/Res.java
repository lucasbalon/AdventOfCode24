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
                if (tab[y][x] == 'X') {
                    res += find(tab, x, y);
                }
            }
            System.out.println();
        }

        System.out.println(res);
    }

    public static int find(char[][] tab, int startX, int startY) {
        int[][] directions = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0},
                {1, 1},
                {1, -1},
                {-1, 1},
                {-1, -1}
        };

        int count = 0;
        int rows = tab.length;
        int cols = tab[0].length;
        String xmas = "XMAS";


        for (int[] dir : directions) {
            boolean match = true;
            for (int k = 0; k < 4; k++) {
                int newX = startX + k * dir[1];
                int newY = startY + k * dir[0];
                if (newX < 0 || newX >= cols || newY < 0 || newY >= rows || tab[newY][newX] != xmas.charAt(k)) {
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
