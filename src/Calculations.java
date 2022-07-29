
public class Calculations {
	
	private final int NUM_DICE = 5;
	protected double prob_four = 1.0/NUM_DICE;
	protected double prob_six = 1.0/NUM_DICE;
	protected double prob_eight = 1.0/NUM_DICE;
	protected double prob_twelve = 1.0/NUM_DICE;
	protected double prob_twenty = 1.0/NUM_DICE;
	private final int SIDES_FOUR = 4;
	private final int SIDES_SIX = 6;
	private final int SIDES_EIGHT = 8;
	private final int SIDES_TWELVE = 12;
	private final int SIDES_TWENTY = 20;
	private double sum = prob_four/SIDES_FOUR + prob_six/SIDES_SIX + prob_eight/SIDES_EIGHT + prob_twelve/SIDES_TWELVE + prob_twenty/SIDES_TWENTY;
	
	int roll;
	
//----------------------------------------------------------------------------------------------------------------------------
	
	public void calculateProbability(int roll) {
		//four
		if(roll <= SIDES_FOUR) {
			sum = prob_four/SIDES_FOUR + prob_six/SIDES_SIX + prob_eight/SIDES_EIGHT + prob_twelve/SIDES_TWELVE + prob_twenty/SIDES_TWENTY;
			prob_four = (prob_four/SIDES_FOUR)/sum;
			prob_six = (prob_six/SIDES_SIX)/sum;
			prob_eight = (prob_eight/SIDES_EIGHT)/sum;
			prob_twelve = (prob_twelve/SIDES_TWELVE)/sum;
			prob_twenty = (prob_twenty/SIDES_TWENTY)/sum;
		}
		//six
		if(roll > SIDES_FOUR && roll <= SIDES_SIX) {
			prob_four = 0;
			sum = prob_six/SIDES_SIX + prob_eight/SIDES_EIGHT + prob_twelve/SIDES_TWELVE + prob_twenty/SIDES_TWENTY;
			prob_six = (prob_six/SIDES_SIX)/sum;
			prob_eight = (prob_eight/SIDES_EIGHT)/sum;
			prob_twelve = (prob_twelve/SIDES_TWELVE)/sum;
			prob_twenty = (prob_twenty/SIDES_TWENTY)/sum;
		}
		if(roll > SIDES_SIX && roll <= SIDES_EIGHT) {
			prob_four = 0;
			prob_six = 0;
			sum = prob_eight/SIDES_EIGHT + prob_twelve/SIDES_TWELVE + prob_twenty/SIDES_TWENTY;
			prob_eight = (prob_eight/SIDES_EIGHT)/sum;
			prob_twelve = (prob_twelve/SIDES_TWELVE)/sum;
			prob_twenty = (prob_twenty/SIDES_TWENTY)/sum;
		}
		if(roll > SIDES_EIGHT && roll <= SIDES_TWELVE) {
			prob_four = 0;
			prob_six = 0;
			prob_eight = 0;
			sum = prob_twelve/SIDES_TWELVE + prob_twenty/SIDES_TWENTY;
			prob_twelve = (prob_twelve/SIDES_TWELVE)/sum;
			prob_twenty = (prob_twenty/SIDES_TWENTY)/sum;
		}
		if(roll > SIDES_TWELVE && roll <= SIDES_TWENTY) {
			prob_four = 0;
			prob_six = 0;
			prob_eight = 0;
			prob_twelve = 0;
			sum = prob_twenty/SIDES_TWENTY;
			prob_twenty = (prob_twenty/SIDES_TWENTY)/sum;
		}
		/*
		System.out.println("Prob four: " + 100*prob_four);
		System.out.println("Prob six: " + 100*prob_six);
		System.out.println("Prob eight: " + 100*prob_eight);
		System.out.println("Prob twelve: " + 100*prob_twelve);
		System.out.println("Prob twenty: " + 100*prob_twenty);
		System.out.println("Prob total: " + 100*(prob_four + prob_six + prob_eight + prob_twelve + prob_twenty));
		*/
	}
}
