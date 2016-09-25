package nn;

abstract class BaseNeuron {
	
	public abstract String listWeights();

	public abstract float activationFunction(float input);

	public abstract float feedForward(float[] inputs, float[] weights);



	
	double[] weights;
	float value;


}
