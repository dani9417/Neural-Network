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
        T[][] array = (T[][]) new BaseNeuron[rows][columns];

        neurons = array;

        initMatrix();
    }

    private void initMatrix() {
        for (int i = 1; i < architecture.length; i++) {
            for (int j = 0; j < architecture[i]; j++) {
                if(i < architecture.length)
                    neurons[i][j] = new HiddenNeuron();
                else
                    neurons[i][j] = new OutputNeuron();

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


    public int getRow() {
        return rows;
    }

    int getRowLength(int y) {
        return neurons[y].length;
    }

    public void setNeuronValue(int x, int y) {
        BaseNeuron bn = (BaseNeuron) neurons[x][y];
        bn.setValue(sum(x,y));
        neurons[x][y] = bn;
    }

    private float sum(int x, int y) {
        int s = 0;
        for (int i = 0; i < neurons[y].length; i++) {

        }
        return 0;
    }
}
