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
                if (tab[x][y] == 'X') {
                    if (find(tab, x, y)) {
                        res++;
                    }
                }
            }
            System.out.println();
        }

        System.out.println(res);
    }

    public static boolean find(char[][] tab, int startX, int startY) {
        int[][] directions = {
                {0, 1},   // Droite
                {0, -1},  // Gauche
                {1, 0},   // Bas
                {-1, 0},  // Haut
                {1, 1},   // Diagonale droite-bas
                {1, -1},  // Diagonale gauche-bas
                {-1, 1},  // Diagonale droite-haut
                {-1, -1}  // Diagonale gauche-haut
        };

        int rows = tab.length;
        int cols = tab[0].length;

        int len = word.length();

        for (int[] dir : directions) {
            boolean match = true;
            for (int k = 0; k < len; k++) {
                int newX = startX + k * dir[1];
                int newY = startY + k * dir[0];

                // Vérification des limites
                if (newX < 0 || newX >= cols || newY < 0 || newY >= rows || tab[newY][newX] != word.charAt(k)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }
}
