package nn;




class NeuronMatrix<T> {
    private int rows;
    private int columns;
    private Object neurons[][];
    private  int[] architecture;

    NeuronMatrix(int[] inputArchitecture) {
        this.architecture = inputArchitecture;
        this.columns = inputArchitecture.length;
        this.rows = maxNumberOfNeurons(inputArchitecture);

        @SuppressWarnings("unchecked")
        T[][] array = (T[][]) new Object[rows][columns];

        neurons = array;

        initMatrix();
    }

    private void initMatrix() {
        for (int i = 0; i < architecture.length; i++) {
            for (int j = 0; j < architecture[i]; j++) {
                // TODO: 2016.09.25. add new Neuron
            }
        }
    }

    private int maxNumberOfNeurons(int[] inputArchitecture) {
        int maxValue = 0;
        for (int i = 0; i < inputArchitecture.length - 1; i++) {
            if(inputArchitecture[i + 1] > inputArchitecture[i])
                maxValue = inputArchitecture[i + 1];
        }
        return maxValue;
    }

    public BaseNeuron getNeuron(int x, int y) {
        return (BaseNeuron) neurons[x][y];
    }

    public void setInputNeuron(float[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            neurons[i][0] = new InputNeuron(inputs[i]);
        }
    }

}
