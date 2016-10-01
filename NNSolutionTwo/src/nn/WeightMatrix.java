package nn;


public class WeightMatrix {
    private float[][] weights;
    private int actRow;
    private int width, height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float[][] getWeights() {
        return weights;
    }

    WeightMatrix(int x, int y) {
        weights = new float[y][x];
        actRow = 0;
        width = x;
        height = y;
    }

    void setWeights(float[] weightRow) {
        weights[actRow++] = weightRow;
    }

    float activationFunction(float input) {
        return input > 0 ? input : 0;
    }

    float[] activatonFunction(float[] input) {
        float[] newInput = new float[input.length];

        for (int i = 0; i < input.length; i++) {
            newInput[i] = input[i] > 0 ? input[i] : 0;
        }
        return newInput;
    }

    WeightMatrix matrixAddition(WeightMatrix left, WeightMatrix right) {
        int w = left.width;
        int h = left.height;
        WeightMatrix newWeightMatrix = new WeightMatrix(w, h);

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                newWeightMatrix.weights[y][x] = left.weights[y][x] + right.weights[y][x];
            }
        }
        return newWeightMatrix;
    }

    float dotProduct(WeightMatrix left, WeightMatrix right) throws Exception {
        if(left.width > 1 && left.height > 1 || right.width > 1 && right.height > 1)
            throw new Exception("Dot product error");

        float sum = 0;
        for (int i = 0; i < left.height; i++) {
            sum += left.weights[i][0] * right.weights[i][0];
        }
        return sum;
    }

}


