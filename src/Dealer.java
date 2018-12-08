public class Dealer extends Person {

	private int gameContinue2 = 1;

	Dealer(String name){
		super(name);
	}


	public int getGameContinue2() {
		return this.gameContinue2;
	}

	public void setGameContinue2(int gameContinue2) {
		this.gameContinue2 = gameContinue2;
	}

	public void game_1() {
		this.addCard = this.cardA + this.cardB;
	}

	public void game_2() {
		score2();
		if(this.addCard == 21) {
			this.gameContinue2 = 2;
		}else if(this.addCard>20){
			this.gameContinue2 = 2;
		}else {

		}
	}
	public void game_3() {
		while(this.addCard < 21 && this.gameContinue2 == 1) {
			if(this.addCard < 17) {
				int cardB = (int)(Math.random()*13 + 1);
				this.cardB = cardB;
				System.out.println(this.name + "が一枚カードを引きました。");
				game_2();
				//System.out.println("ディーラー二枚目：" + this.cardB +" ,ディーラー合計："+ this.addCard);//ディーラー点数確認用
			}else if(this.addCard == 17){
				int gameContinue2 =(int)(Math.random()*2 + 1);
				this.gameContinue2 =gameContinue2;
				if(this.gameContinue2 == 1) {
					int cardB = (int)(Math.random()*13 + 1);
					this.cardB = cardB;
					System.out.println(this.name + "が一枚カードを引きました。");
					game_2();
					//System.out.println("ディーラー二枚目：" + this.cardB+" ,ディーラー合計： "+ this.addCard);//ディーラー点数確認用
				}
			}else{
				int cardB = (int)(Math.random()*13 + 1);
				this.cardB = cardB;
				System.out.println(this.name + "が一枚カードを引きました。");
				game_2();
				//System.out.println("ディーラー二枚目：" + this.cardB +" , ディーラー合計："+ this.addCard);//ディーラー点数確認用
				int gameContinue2 =(int)(Math.random()*2 + 1);
				this.gameContinue2 = gameContinue2;
			}
		}
	}

}
