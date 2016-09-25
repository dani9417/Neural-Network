package nn;


import java.util.Arrays;

class WeightMatrix {
    private float[][] weights;
    int matrixHeightCount;
    int maxMatrixWidth;
    private int currentRow = 0;

    WeightMatrix(int[] neurons) {
        int matrixHeightCount = matrixHeight(neurons);
        int maxMatrixWidth = matrixWidth(neurons);

        weights = new float[matrixHeightCount][maxMatrixWidth];
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

    public float[][] getWeights() {
        if(weights != null)
            return weights;

        return new float[][] {new float[] {0}};
    }

    void setWeights(float[] weightsRow) {
        weights[currentRow++] = weightsRow;
    }

    public void listWeights() {
        for(float[] row : weights)
            System.out.println(Arrays.toString(row));
    }
}
