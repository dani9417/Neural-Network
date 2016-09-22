package nn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NNSolutionOne {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String inputString = br.readLine();
		
		NeuralNetwork nn = new NeuralNetwork(inputString);
		
		nn.output();

		
		

	}

}
