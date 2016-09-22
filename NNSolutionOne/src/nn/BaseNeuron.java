package nn;

import java.util.Random;

public abstract class BaseNeuron {
	
	public abstract String listWeights();
	
	protected double[] weights;
	
	protected Random randomG;
		
	public double truncWeight(double d) {
		double whole = Math.floor(Math.abs(d));
		double cut = d - whole;
		
		cut *= 10;
		cut = Math.floor(cut);
		
		return whole + cut / 10;
	}
	
}
