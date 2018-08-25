public class Player extends Person {

	private int gameContinue = 0;

	Player(String name){
		super(name);
	}


	public int getGameContinue() {
		return this.gameContinue;
	}
	public void setGameContinue(int gameContinue) {
		this.gameContinue = gameContinue;
	}


	public void game_1() {
		if(spCard()) {
			 massage21();
			 this.addCard = 21;
		}else if(highCard()){
			score1();
			System.out.println(massageHigh1());

		}else {
			score1();
			System.out.println(massageAdd1());
		}
	}

	public void game_2() {
		score2();
		if(this.addCard == 21) {
			System.out.println(cardMessage2());
			this.gameContinue = 2;
		}else if(this.addCard>20){
			System.out.println(massageHigh2());
			this.gameContinue = 2;
		}else {
			System.out.println(massageAdd2());
		}
	}
	public void score1() {
		if(cardA >= 11 && cardB >= 11) {
			this.addCard = 20;
		}else if(cardA >= 11) {
			this.addCard = 10 + this.cardB;
		}else if(cardB >= 11) {
			this.addCard = this.cardA + 10;
		}else {
			this.addCard = this.cardA + this.cardB;
		}
	}


	public boolean spCard() {//ブラックジャックになる組み合わせ
		return (this.cardA == 1 && this.cardB >= 11) || (this.cardA >= 11 && this.cardB == 1) || this.cardA + this.cardB == 21;
	}
	public  boolean highCard() {
		return this.cardA + this.cardB > 20;
	}
	public static void continueMessage() {
		System.out.println("続けてカードを引きますか？");
		System.out.println("1.はい");
		System.out.println("2.いいえ");
	}
	public static void gameFinish() {
		System.out.println("ゲームを終了します。");
	}
 	public String cardMessage() {
		return this.cardA + "と" + this.cardB;
	}

	//一回目の言葉
	public void massage21() {
		System.out.println("合計21なのでブラックジャックになりました。");
	}
	public String massageHigh1() {
		return cardMessage() + "で、合計が21を超えたのでバーストしてしまいました。";
	}
	public String massageAdd1() {
		return cardMessage() + "で、合計が" + this.addCard + "になりました。";
	}

	//二回目以降の言葉
	public String cardMessage2() {
		return "今引いたカードは" + cardB + "で、合計21なので、ブラックジャックになりました。";
	}
	public String massageHigh2() {
		return "今引いたカードは" + cardB +"で、合計が21を超えたのでバーストしてしまいました。";
	}
	public String massageAdd2() {
		return "今引いたカードは" + cardB + "で、合計が" + this.addCard + "になりました。";
	}
}
