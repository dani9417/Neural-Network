package nn;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NNSolutionTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputArchitecture = br.readLine();

        NeuralNetwork nn = new NeuralNetwork(inputArchitecture);

        int inputCount = nn.getInputCount();
        //System.out.println("inputCount = " + inputCount);

        WeightMatrix weightMatrix = new WeightMatrix(stringToIntegerArray(inputArchitecture));

        for(int i = 0; i < inputCount; i++) {
            weightMatrix.setWeights(stringToIntegerArray(br.readLine()));
        }

        weightMatrix.listWeights();

        if(Integer.parseInt(br.readLine()) != inputCount)
            System.err.println("Hibás a bemenet!");



        nn.output();
    }

    private static int[] stringToIntegerArray(String inputArchitecture) {
        String[] strings = inputArchitecture.split(",");
        int[] integers = new int[strings.length];
        for(int i = 0; i < strings.length; i++)
            integers[i] = Integer.parseInt(strings[i]);

        return integers;
    }
}
