

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        ArrayList buildingsHeigtsList = new ArrayList<Integer>();
        try{
            InputStream inputStream = new FileInputStream("in/pla0.in");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int buildingsNumber;
            buildingsNumber = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= buildingsNumber; i++){
                line = br.readLine();
                st = new StringTokenizer(line);
                st.nextToken();
                int w = Integer.parseInt(st.nextToken());
                buildingsHeigtsList.add(w);

            }

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println( calculatePostersNumber(buildingsHeigtsList));

    }

    public static int calculatePostersNumber(ArrayList<Integer> heigts){
        int posterNumber = 0;
        ArrayList<Integer> postersStack = new ArrayList<Integer>();

        for (int i =0; i < heigts.size(); i++){
            while (!postersStack.isEmpty() && postersStack.get(postersStack.size() -1) > heigts.get(i)){
                postersStack.remove(postersStack.size() -1);
            }
            if ( postersStack.isEmpty() || postersStack.get(postersStack.size() -1) < heigts.get(i)){
                postersStack.add(heigts.get(i));
                posterNumber ++;
            }
        }
        return posterNumber;
    }
}
