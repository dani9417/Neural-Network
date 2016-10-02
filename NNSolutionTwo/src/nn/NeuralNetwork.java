package nn;

import java.util.ArrayList;
import java.util.Arrays;

class NeuralNetwork {
	private int[] architecture;
	private ArrayList<float[]> weights;
	private ArrayList<WeightMatrix> weightMatrices;
	private ArrayList<WeightMatrix> biasVertices;

	NeuralNetwork(int[] architecture) {
		this.architecture = architecture;
		weightMatrices = new ArrayList<>(this.architecture.length - 1);
		biasVertices = new ArrayList<>(this.architecture.length - 1);


	}

	void initWeightAndBiasValues() {
		int actRow = 0;
		int index = 1;
		for(int i = 1; i < architecture.length; i++) {
			WeightMatrix weightMatrix = new WeightMatrix(architecture[i-1],architecture[i]);
			WeightMatrix biasVertex = new WeightMatrix(1,architecture[i]);

			for (int j = 0; j < architecture[i]; j++) {
				float[] row = weights.get(actRow++);
				weightMatrix.setWeights(Arrays.copyOfRange(row,0,architecture[i - 1]));
				biasVertex.setWeights(new float[] {row[row.length-1]});
			}
			weightMatrices.add(weightMatrix);
			biasVertices.add(biasVertex);
		}

	}

	int[] getArchitecture() {
		return architecture;
	}

	int getWeightRowCount() {
		int sum = 0;
		for (int i = 1; i < architecture.length ; i++) {
			sum += architecture[i];
		}
		return sum;
	}



	void setWeights(ArrayList<float[]> weights) {
		this.weights = weights;
	}

	void listWeightAndBiasMatrices() throws Exception {
		for (WeightMatrix wm : weightMatrices)
			System.out.println(wm.toString());

		for(WeightMatrix vm : biasVertices)
			System.out.println(vm.toString());


	}

	WeightMatrix calculateOutput(int depth, WeightMatrix input) throws Exception {
		WeightMatrix bias = biasVertices.get(depth - 1);
		WeightMatrix weight = weightMatrices.get(depth - 1);

		if(depth == 1) {
			return bias.matrixAddition(weight.matrixProduct(input));
		}
		else {
			return bias.matrixAddition(weight.matrixProduct(calculateOutput(depth-1, input).activatonFunction()));

		}


	}
}
