
public abstract class Person {
	protected String name;
	protected int cardA = (int)(Math.random()*13 + 1);
	protected int cardB = (int)(Math.random()*13 + 1);
	protected int addCard = 0;

	Person(String name){
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	public int getCardA() {
		return this.cardA;
	}
	public int getCardB() {
		return this.cardB;
	}
	public int getAddCard() {
		return this.addCard;
	}

	public void setCardB(int cardB) {
		this.cardB = cardB;
	}

	abstract public void game_1();
	abstract public void game_2();

	public void score2() {
		switch(this.cardB) {
		case 11:
		case 12:
		case 13:
			this.addCard += 10;
		default:
			this.addCard += this.cardB;
		}
	}
}
