package nn;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NNSolutionTwo {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        InputParser inputParser;

        ArrayList<String> inputString = new ArrayList();
        String nextString;

        while((nextString = br.readLine()) != null && nextString.length() != 0) {
            inputString.add(nextString);
        }

        inputParser = new    InputParser(inputString);



    }
}
