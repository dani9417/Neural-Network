package nn;

import java.util.ArrayList;

class NeuralNetwork {

	private ArrayList<InputNeuron> inputs;
	private ArrayList<ArrayList<HiddenNeuron>> hiddens;
	private ArrayList<OutputNeuron> outputs;

	private String inputString;
	
	private int numberOfLayers;
	private int[] neurons;
	
	NeuralNetwork(String inputString) {
		inputs = new ArrayList<>();
		hiddens = new ArrayList<>();
		outputs = new ArrayList<>();
		
		numberOfLayers = inputString.split(",").length;
		neurons = new int[numberOfLayers];
		this.inputString = inputString;

		String[] inputStringArray = inputString.split(",");

		for(int i = 0; i < numberOfLayers; i++) {
			neurons[i] = Integer.parseInt(inputStringArray[i]);
		}
			
		initInputLayer();
		initHiddenLayer();
		initOutputLayer();


	}

	private void initHiddenLayer() {
		ArrayList<HiddenNeuron> hdn;
		for(int i = 1; i < numberOfLayers - 1; i++) {
			hdn = new ArrayList<>();
					
			for(int j = 0; j < neurons[i]; j++) {
				hdn.add(new HiddenNeuron(neurons[i - 1] + 1));
			}
			hiddens.add(hdn);
		}
		
	}

	private void initOutputLayer() {
		for(int i = 0; i < neurons[neurons.length-1]; i++) {
			outputs.add(new OutputNeuron(neurons[neurons.length - 2] + 1));
		}
		
	}

	private void initInputLayer() {
		for(int i = 0; i < neurons[0]; i++) {
			inputs.add(new InputNeuron());
		}
		
	}

	void output() {
		System.out.println(inputString);
		
		for(ArrayList<HiddenNeuron> ah : hiddens) {
			for (HiddenNeuron hid : ah) {
				System.out.println(hid.listWeights());
			}
		}
		
		for(BaseNeuron b : outputs) {
			System.out.println(b.listWeights());
		}
		
	}

	

}
