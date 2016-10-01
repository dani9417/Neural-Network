package nn;


public class WeightMatrix {
    private float[][] weights;
    private int index;
    private int actRow;

    WeightMatrix(int x, int y) {
        weights = new float[y][x];
        actRow = 0;
    }

    void setWeights(float[] weightRow) {
        weights[actRow++] = weightRow;
    }

}
