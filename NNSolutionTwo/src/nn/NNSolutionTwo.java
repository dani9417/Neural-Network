package nn;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class NNSolutionTwo {
    public static void main(String[] args) throws IOException {
        ArrayList<float[]> outPutValues = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputArchitecture = br.readLine();


        NeuralNetwork nn = new NeuralNetwork(inputArchitecture);

        int inputWeightCount = nn.getInputCount();


        WeightMatrix weightMatrix = new WeightMatrix(stringToIntegerArray(inputArchitecture));

        for(int i = 0; i < inputWeightCount; i++) {
            weightMatrix.setWeights(stringToFloatArray(br.readLine()));
        }
        nn.setWeightMatrix(weightMatrix);

        //weightMatrix.listWeights();

        int inputValueCount = Integer.parseInt(br.readLine());

        for(int i = 0; i < inputValueCount; i++) {
            float[] inputValues = stringToFloatArray(br.readLine());
            outPutValues.add(nn.calculateOutput(inputValues));
        }


        //nn.output();
    }

    private static int[] stringToIntegerArray(String inputArchitecture) {
        String[] strings = inputArchitecture.split(",");
        int[] integers = new int[strings.length];
        for(int i = 0; i < strings.length; i++)
            integers[i] = Integer.parseInt(strings[i]);

        return integers;
    }

    private static float[] stringToFloatArray(String inputStringWeights) {
        String[] strings = inputStringWeights.split(",");
        float[] floats = new float[strings.length];
        for(int i = 0; i < strings.length; i++)
            floats[i] = Float.parseFloat(strings[i]);

        return floats;
    }
}
