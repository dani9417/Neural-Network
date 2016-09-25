package nn;

class InputNeuron extends BaseNeuron {


	InputNeuron() {
		value = 0;
	}

	InputNeuron(float input) {
		value = input;
	}
	
	@Override
	public String listWeights() {
		return "";
		
	}

	@Override
	public float activationFunction(float input) {
		return value;
	}

	@Override
	public float feedForward(float[] inputs, float[] weights) {
		return value;
	}


}
