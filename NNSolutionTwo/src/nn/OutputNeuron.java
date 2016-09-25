package nn;


import java.util.Random;

class OutputNeuron extends BaseNeuron {

	OutputNeuron(int prevLevelNeuronCount) {
		weights = new double[prevLevelNeuronCount];

		InitWeights();
	}
	
	private void InitWeights() {
		for (int i = 0; i < weights.length - 1; i++) {
			weights[i] = (new Random()).nextGaussian() * 0.1;
		}
		
		weights[weights.length - 1] = 0;
		
	}

	@Override
	public String listWeights() {
		String weightReturn = "";
		
		for (int i = 0; i < weights.length - 1; i++) {
			weightReturn += weights[i] + ", ";
		}
		weightReturn += weights[weights.length - 1];
		
		return weightReturn;
	}

	@Override
	public float activationFunction(float input) {
		value = input;
		return value;
	}

	@Override
	public float feedForward(float[] inputs, float[] weights) {
		float outputValue = 0;
		for (int i = 0; i < inputs.length; i++) {
			outputValue += inputs[i] * weights[i];
		}

		return outputValue;
	}

}
