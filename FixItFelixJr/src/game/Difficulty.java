package game;

public class Difficulty {
	
	
	//de aca pa adentro, la dificultad va de 0 a n
	//de aca pa afuera de 1 a 10
	
	int lvl;

	double mult=1.1;
	
	public Difficulty() {
		setDifficulty(0);
	}
	
	public Difficulty(int l) {
		setDifficulty(l-1);
	}
	public void setDifficulty(int l) {
		lvl=l;
		mult=Math.pow(mult,lvl);
	}
	
	public double getDifficulty() {
		return mult;
	}

	
	public int getLvl() {
		return lvl+1;
	}
	
	public void setLvl(int lvl) {
		this.lvl = lvl-1;
	}
	
	//yeah this used to be an enumerator
//	ONE(1.1),
//	TWO(Math.pow(1.1,2.0)),
//	TREE(Math.pow(1.1,3.0)),
//	FOUR(Math.pow(1.1,4.0)),
//	FIVE(Math.pow(1.1,5.0)),
//	SIX(Math.pow(1.1,6.0)),
//	SEVEN(Math.pow(1.1,7.0)),
//	EIGHT(Math.pow(1.1,8.0)),
//	NINE(Math.pow(1.1,9.0)),
//	TEN(Math.pow(1.1,10.0));
//	
//	double multiplier;
//	Difficulty(double f) {
//		multiplier=f;
//	}
	
}