package game;

public enum Difficulty {
	ONE(1.1),
	TWO(Math.pow(1.1,2.0)),
	TREE(Math.pow(1.1,3.0)),
	FOUR(Math.pow(1.1,4.0)),
	FIVE(Math.pow(1.1,5.0)),
	SIX(Math.pow(1.1,6.0)),
	SEVEN(Math.pow(1.1,7.0)),
	EIGHT(Math.pow(1.1,8.0)),
	NINE(Math.pow(1.1,9.0)),
	TEN(Math.pow(1.1,10.0));
	
	double multiplier;
	Difficulty(double f) {
		multiplier=f;
	}
	public double getDifficulty() {
		return multiplier;
	}
	
}