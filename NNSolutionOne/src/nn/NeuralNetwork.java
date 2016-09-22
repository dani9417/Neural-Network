package nn;

import java.util.ArrayList;
import java.util.Arrays;

public class NeuralNetwork {

	private ArrayList<InputNeuron> inputs;
	private ArrayList<ArrayList<HiddenNeuron>> hiddens;
	private ArrayList<OutputNeuron> outputs;
	
	private String[] inputData;
	private String inputString;
	
	private int numberOfLayers;
	private int[] layerData;
	
	public NeuralNetwork(String stringData) {
		inputs = new ArrayList<InputNeuron>();
		hiddens = new ArrayList<ArrayList<HiddenNeuron>>();
		outputs = new ArrayList<OutputNeuron>();
		
		numberOfLayers = stringData.split(",").length;
		layerData = new int[numberOfLayers];
		inputString = stringData;
		
		inputData = stringData.split(",");
		
		for(int i = 0; i < numberOfLayers; i++) {
			layerData[i] = Integer.parseInt(inputData[i]);
		}
			
		InitInputLayer();
		InitHiddenLayer();
		InitOutputLayer();
		
		
	}

	private void InitHiddenLayer() {
		ArrayList<HiddenNeuron> hdn;
		for(int i = 1; i < numberOfLayers - 1; i++) {
			hdn = new ArrayList<HiddenNeuron>();
					
			for(int j = 0; j < layerData[i]; j++) {
				hdn.add(new HiddenNeuron(layerData[i - 1] + 1));
			}
			hiddens.add(hdn);
		}
		
	}

	private void InitOutputLayer() {
		for(int i = 0; i < layerData[layerData.length-1]; i++) {
			outputs.add(new OutputNeuron(layerData[layerData.length - 2] + 1));
		}
		
	}

	private void InitInputLayer() {
		for(int i = 0; i < layerData[0]; i++) {
			inputs.add(new InputNeuron());
		}
		
	}

	public void output() {
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
