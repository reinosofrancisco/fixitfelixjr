package game;

public class Difficulty {
	
	
	//de aca pa adentro, la dificultad va de 0 a n
	//de aca pa afuera de 1 a 10
	
	private int lvl;
	private double mult=1.1;
	private static Difficulty INSTANCE;
	
	
	
	
	private Difficulty() {
		this(1);
	}
	
	
	private Difficulty(int l) {
		setDifficulty(l-1);
	}
	
	
	public static Difficulty getInstance() {
		if (INSTANCE== null) {
			INSTANCE=new Difficulty();
		}
		return INSTANCE;
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
	
	public void lvlUp() {
		lvl++;
		mult*=1.1;
	}
	
}