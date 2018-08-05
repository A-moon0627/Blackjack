
public class Dealer {

	private String name;
	private int cardA = (int)(Math.random()*13 + 1);
	private int cardB = (int)(Math.random()*13 + 1);
	private int addCard = 0;
	private int gameContinue2 = 1;

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
	public int getGameContinue2() {
		return this.gameContinue2;
	}

	public void setCardB(int cardB) {
		this.cardB = cardB;
	}
	public void setGameContinue2(int gameContinue2) {
		this.gameContinue2 = gameContinue2;
	}

	public void game_1() {
		this.addCard = this.cardA + this.cardB;
	}

	public void game_2() {
		score();
		if(this.addCard == 21) {
			this.gameContinue2 = 2;
		}else if(this.addCard>20){
			this.gameContinue2 = 2;
		}else {
		
		}
	}
	public void score() {
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
