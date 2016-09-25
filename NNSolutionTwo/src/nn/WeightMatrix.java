package nn;


public class WeightMatrix {
    private int[][] weights;
    int matrixHeightCount;
    int maxMatrixWidth;

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
}
