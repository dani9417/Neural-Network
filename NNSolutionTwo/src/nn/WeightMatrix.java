package nn;


import java.util.Arrays;

public class WeightMatrix {
    private int[][] weights;
    int matrixHeightCount;
    int maxMatrixWidth;
    int currentRow = 0;

    WeightMatrix(int[] neurons) {
        int matrixHeightCount = matrixHeight(neurons);
        int maxMatrixWidth = matrixWidth(neurons);

        weights = new int[matrixHeightCount][maxMatrixWidth];
    }

    private int matrixWidth(int[] neurons) {
        int maxMatrixWidth = 0;
        for(int i = 0; i < neurons.length - 1; i++) {
            if(neurons[i+1] > neurons[i]) maxMatrixWidth = neurons[i+1];
        }
        return maxMatrixWidth;
    }

    private int matrixHeight(int[] neurons) {
        int neuronCount = 0;
        for(int i = 1; i < neurons.length; i++) {
            neuronCount += neurons[i];
        }
        return neuronCount;
    }

    public int[][] getWeights() {
        if(weights != null)
            return weights;

        return new int[][] {new int[] {0}};
    }

    public void setWeights(int[] weightsRow) {
        weights[currentRow++] = weightsRow;
    }

    public void listWeights() {
        for(int[] row : weights)
            System.out.println(Arrays.toString(row));
    }
}
