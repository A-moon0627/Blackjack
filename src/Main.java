import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Player your = new Player("あなた");
		Player dealer = new Player("ディーラー");

		System.out.println("カードを2枚引きました。");
		System.out.println(your.getName() + "の一枚目のカードは" + your.getCardA() + "、二枚目のカードは" + your.getCardB() + "です。");
		System.out.println(dealer.getName() + "の一枚目のカードは" +dealer.getCardA() + "です。" );
		your.game_1();
		dealer.game_1();//あとで消す
		Scanner scanner = new Scanner(System.in);
		Player.continueMessage();
		int gameContinue = scanner.nextInt();
		your.setGameContinue(gameContinue);
		while (your.getGameContinue() == 1) {
			if(your.getAddCard() <= 21) {
				int cardB = (int)(Math.random()*13 + 1);//カードを引く（二回目以降）
				your.setCardB(cardB);
				your.game_2();
			}else {}
		}
		System.out.println(your.getName() + "は" + your.getAddCard() +"でした。");
		System.out.println(dealer.getName() + "は" + dealer.getAddCard() + "でした。");
		Player.gameFinish();
	/*
		//Player.dealer(addCard);
		*/
	}
}