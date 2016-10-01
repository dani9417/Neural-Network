package nn;

import java.util.ArrayList;
import java.util.Arrays;

class NeuralNetwork {
	private int[] architecture;
	ArrayList<float[]> weights;
	ArrayList<WeightMatrix> weightMatrices;
	ArrayList<WeightMatrix> biasVertices;

	public NeuralNetwork(int[] architecture) {
		this.architecture = architecture;
		weightMatrices = new ArrayList<>(this.architecture.length - 1);
		biasVertices = new ArrayList<>(this.architecture.length - 1);


	}

	void initWeightAndBias() {
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



	public void setWeights(ArrayList<float[]> weights) {
		this.weights = weights;
	}
}
