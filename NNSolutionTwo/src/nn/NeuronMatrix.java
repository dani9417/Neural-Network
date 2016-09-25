package nn;


import java.util.Arrays;

class NeuronMatrix<T> {
    private int rows;
    private int columns;
    private Object neurons[][];

    NeuronMatrix(int[] inputArchitecture) {
        this.columns = inputArchitecture.length;
        Arrays.sort(inputArchitecture);
        this.rows = inputArchitecture[inputArchitecture.length - 1];

        @SuppressWarnings("unchecked")
        T[][] array = (T[][]) new Object[rows][columns];

        neurons = array;


    }

    public BaseNeuron getNeuron(int x, int y) {
        return (BaseNeuron) neurons[x][y];
    }

}
