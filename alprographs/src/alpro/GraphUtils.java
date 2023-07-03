package alpro;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GraphUtils {

    public static Graph fromFile(String file) throws IOException {
        //TODO: implement method loading graph from adjacency matrix
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(file));
            String Matrix = reader.readLine();
            int i = 0;
            List<String> MatrixRows = new ArrayList<>();
            while (Matrix != null){
                MatrixRows.add(Matrix);
                // System.out.println(Matrix);
                Matrix = reader.readLine();
                i++;

            }
            reader.close();
            Graph graph = new Graph(i);
            System.out.println("Matrix row Size: " + MatrixRows.size());
            System.out.println("Random row: " + MatrixRows.get(2));
            System.out.println("Random row length: " + MatrixRows.get(2).length());
            System.out.println("Random Row char: " + MatrixRows.get(0).charAt(2));
            for (int j = 0; j < MatrixRows.size(); j++) {
                String node = "";
                String s = MatrixRows.get(j);
                for (int k = 0; k < s.length(); k++) {
                    char c = s.charAt(k);
                    String b = Character.toString(c);
                    try {
                        if(b != ",") {
                            if (Integer.parseInt(b) == 0 || Integer.parseInt(b) == 1) {
                                System.out.println(s.charAt(k));
                                node += s.charAt(k);
                            }
                        }
                    }
                    catch (Exception e)
                    {
                    }

                }
            }
            return graph;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }

    }

    //Aufgabe 7 convertToInteger sollte gleich sein aber dsumOfList habe ich ergänzt
    public static List<Integer> convertToInteger(List<String> lines) {
        List<Integer> integers = new ArrayList<>();
        for (String s : lines){
            integers.add(Integer.valueOf(s));
        }

    }
    public static int sumOfList(List<Integer> list){
        int sum = 0;
        for (int i : list)
        {
            sum += i;
        }
        return sum/list.size();
    }

}
