package nn;

import java.util.Random;

public class HiddenNeuron extends BaseNeuron {

	public HiddenNeuron(int prevLevel) {
		weights = new double[prevLevel];
		
		randomG = new Random();
		
		InitWeights();
	}
	
	private void InitWeights() {
		for (int i = 0; i < weights.length - 1; i++) {
			weights[i] = randomG.nextGaussian()*0.1;
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

}
