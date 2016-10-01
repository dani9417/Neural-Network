package nn;

import java.lang.reflect.Array;
import java.util.ArrayList;


class InputParser {
    ArrayList<String> inputString;
    NeuralNetwork neuralNetwork;

    InputParser(ArrayList<String> inputString) {
        this.inputString = inputString;

        neuralNetwork = new NeuralNetwork(stringToIntegerArray(inputString.get(0)));
        neuralNetwork.setWeights(weightList());
        neuralNetwork.initWeightAndBias();


    }



    int[] stringToIntegerArray(String input) {
        String[] strings = input.split(",");
        int[] integers = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            integers[i] = Integer.parseInt(strings[i]);
        }

        return integers;

    }

    float[] stringToFloatArray(String input) {
        String[] strings = input.split(",");
        float[] floats = new float[strings.length];

        for (int i = 0; i < strings.length; i++) {
            floats[i] = Float.parseFloat(strings[i]);
        }

        return floats;
    }

    ArrayList<float[]> weightList() {
        ArrayList<float[]> weights = new ArrayList<>();

        for (int i = 1; i <= neuralNetwork.getWeightRowCount(); i++) {
            weights.add(stringToFloatArray(inputString.get(i)));
        }
        return weights;
    }
}
