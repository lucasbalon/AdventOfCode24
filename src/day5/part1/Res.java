package day5.part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Res {
    public static void main(String[] args) {
        String fileName = "src/day5/data_test.txt"; // Remplacez par le nom de votre fichier
        ArrayList<int[]> firstSection = new ArrayList<>();
        ArrayList<int[]> secondSection = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isSecondSection = false;

            while ((line = br.readLine()) != null) {
                line = line.trim(); // Supprime les espaces en début/fin de ligne
                if (line.isEmpty()) {
                    isSecondSection = true; // Passe à la deuxième section
                    continue;
                }

                if (!isSecondSection) {
                    // Première section : extraire deux chiffres
                    String[] parts = line.split("\\|");
                    if (parts.length == 2) {
                        int[] pair = {Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
                        firstSection.add(pair);
                    }
                } else {
                    // Deuxième section : extraire tous les nombres
                    String[] numbers = line.split(",");
                    int[] row = new int[numbers.length];
                    for (int i = 0; i < numbers.length; i++) {
                        row[i] = Integer.parseInt(numbers[i].trim());
                    }
                    secondSection.add(row);
                }
            }

            // Convertir les listes en tableaux
            int[][] firstArray = firstSection.toArray(new int[0][0]);
            int[][] secondArray = secondSection.toArray(new int[0][0]);

            // Afficher les résultats
            System.out.println("Première section :");
            for (int[] pair : firstArray) {
                System.out.println(pair[0] + " | " + pair[1]);
            }

            System.out.println("\nDeuxième section :");
            for (int[] row : secondArray) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }

            // Parcourir chaque élément de la deuxième section et chaque paire de la première section
            System.out.println("Traitement des données :");
            for (int[] row : secondArray) {
                for (int num : row) {
                    for (int[] pair : firstArray) {
                        // Exemple d'action : vérifier si le nombre est compris entre les deux valeurs de la paire
                        if (num >= pair[0] && num <= pair[1]) {
                            System.out.println(num + " est compris entre " + pair[0] + " et " + pair[1]);
                        }
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
}
