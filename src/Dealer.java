
public class Dealer {

	private String name;
	private int cardA = (int)(Math.random()*13 + 1);
	private int cardB = (int)(Math.random()*13 + 1);
	private int addCard = 0;

	Dealer(String name){
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

	public void game_1() {
		this.addCard = this.cardA + this.cardB;
	}

	public void game_2() {
		this.addCard += cardB;
	}
}
