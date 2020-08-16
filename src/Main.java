

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        int posterNumber = 0;
        int score;
        ArrayList<Integer> buildingsHeightsList = new ArrayList<Integer>();
        String fileName = "pla10b";

        //Wczytanie pliku i wpisanie wysokości budynków do listy
        try {
            InputStream inputStream = new FileInputStream("in/" + fileName + ".in");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int buildingsNumber;
            buildingsNumber = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= buildingsNumber; i++) {
                line = br.readLine();
                st = new StringTokenizer(line);
                st.nextToken();
                int w = Integer.parseInt(st.nextToken());
                buildingsHeightsList.add(w);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Obliczenie liczby plakatów
        ArrayList<Integer> postersStack = new ArrayList<>();
        for (int i = 0; i < buildingsHeightsList.size(); i++) {
            while (!postersStack.isEmpty() && postersStack.get(postersStack.size() - 1) > buildingsHeightsList.get(i)) {
                postersStack.remove(postersStack.size() - 1);
            }
            if (postersStack.isEmpty() || postersStack.get(postersStack.size() - 1) < buildingsHeightsList.get(i)) {
                postersStack.add(buildingsHeightsList.get(i));
                posterNumber++;
            }
        }

        System.out.println(posterNumber);

        //Sprawdzenie
        try {
            InputStream inputStream = new FileInputStream("tests_out/" + fileName + ".out");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            score = Integer.parseInt(st.nextToken());
        } catch (IOException e1) {
            throw new RuntimeException(e1);
        }

        boolean check = score == posterNumber;

        System.out.println("Obliczona liczba plakatów = " + posterNumber + " | Wynik poprawny - " + check);
    }
}

