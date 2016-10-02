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

    WeightMatrix(int y, float [] input) {
        weights = new float[y][1];
        actRow = 0;
        width = 1;
        height = y;
        for (int _y = 0; _y < y; _y++) {
            weights[_y][0] = input[_y];
        }

    }

    void setWeights(float[] weightRow) {
        weights[actRow++] = weightRow;
    }

    float activationFunction(float input) {
        return input > 0 ? input : 0;
    }

    WeightMatrix activatonFunction() {
        WeightMatrix newWeightMatrix = new WeightMatrix(this.width, this.height);

        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                newWeightMatrix.weights[y][x] = activationFunction(this.weights[y][x]);
            }
        }

        return newWeightMatrix;
    }

    WeightMatrix matrixAddition(WeightMatrix right) {
        int w = this.width;
        int h = this.height;
        WeightMatrix newWeightMatrix = new WeightMatrix(w, h);

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                newWeightMatrix.weights[y][x] = this.weights[y][x] + right.weights[y][x];
            }
        }
        return newWeightMatrix;
    }

    float dotProduct( WeightMatrix right) throws Exception {
        if(this.width > 1 && this.height > 1 || right.width > 1 && right.height > 1)
            throw new Exception("Dot product error - Wrong matrix format");

        float sum = 0;
        for (int i = 0; i < this.width; i++) {
            sum += this.weights[0][i] * right.weights[i][0];
        }
        return sum;
    }

    WeightMatrix matrixProduct(WeightMatrix right) throws Exception {
        if(this.width != right.height)
            throw new Exception("Matrix sizes are not equal");

        int w = right.width;
        int h = this.height;

        WeightMatrix newWeightMatrix = new WeightMatrix(w,h);

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                for (int k = 0; k < this.width; k++) {
                    newWeightMatrix.weights[y][x] += this.weights[y][k] * right.weights[k][x];
                }
            }
        }
        return newWeightMatrix;

    }

    @Override
    public String toString() {
        String s = "";
        for (int y = 0; y < this.height; y++) {

            for (int x = 0; x < this.width; x++) {
                s += this.weights[y][x] + " ";
            }

        }
        return s;
    }
}


