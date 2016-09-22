package nn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NNSolutionOne {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String string_data = br.readLine();
		
		NeuralNetwork nn = new NeuralNetwork(string_data);
		
		nn.output();

		
		

	}

}
