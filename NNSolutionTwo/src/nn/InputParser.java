package nn;

import java.util.ArrayList;


class InputParser {
    private ArrayList<String> inputString;
    private NeuralNetwork neuralNetwork;
    private int inputCount;
    private ArrayList<float[]> inputs;
    private ArrayList<WeightMatrix> outputs;

    InputParser(ArrayList<String> inputString) throws Exception {
        this.inputString = inputString;


        neuralNetwork = new NeuralNetwork(stringToIntegerArray(inputString.get(0)));
        neuralNetwork.setWeights(weightList());
        neuralNetwork.initWeightAndBiasValues();

        //neuralNetwork.listWeightAndBiasMatrices();

        this.inputCount = Integer.parseInt(inputString.get(neuralNetwork.getWeightRowCount() + 1));

        this.inputs = new ArrayList<>(inputCount);
        this.outputs = new ArrayList<>(inputCount);

        convertInputStrings(neuralNetwork.getWeightRowCount() + 2);

        for (int i = 0; i < inputs.size(); i++) {
            outputs.add(neuralNetwork.calculateOutput(2, new WeightMatrix(2, inputs.get(i))));
        }

        printOutput();




    }

    private void printOutput() {
        System.out.println(inputCount);

        for (WeightMatrix o : outputs)
            System.out.println(o.toString());
    }

    private void convertInputStrings(int startingIndex) {
        for (int i = startingIndex; i < inputString.size(); i++) {
            inputs.add(stringToFloatArray(inputString.get(i)));
        }
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
