import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("これからブラックジャックを始めます。");
		System.out.println("※絵札は10点ではなくそれぞれの数字どおりに計算しています。");
		System.out.print("あなたの名前を教えてください：");
		String name = scanner.next();
		Player your = new Player(name);
		Player dealer = new Player("ディーラー");

		System.out.println(your.getName() +"はカードを2枚引きました。");
		System.out.println(your.getName() + "の一枚目のカードは" + your.getCardA() + "、二枚目のカードは" + your.getCardB() + "です。");
		System.out.println(dealer.getName() +"はカードを2枚引きました。");
		System.out.println(dealer.getName() + "の一枚目のカードは" +dealer.getCardA() + "です。" );
		your.game_1();
		dealer.game_1();//あとで消す

		Player.continueMessage();
		int gameContinue = scanner.nextInt();
		your.setGameContinue(gameContinue);

		while (your.getGameContinue() == 1) {
			if(your.getAddCard() <= 21) {
				int cardB = (int)(Math.random()*13 + 1);//カードを引く（二回目以降）
				your.setCardB(cardB);
				your.game_2();
			}
			if(dealer.getAddCard() <= 21) {
				int cardB = (int)(Math.random()*13 + 1);
				dealer.setCardB(cardB);
				System.out.println(dealer.getName() + "が一枚カードを引きました。");
				dealer.game_2();//あとで消す。
			}
			if(your.getAddCard() <= 21) {
				Player.continueMessage();
				gameContinue = scanner.nextInt();
				your.setGameContinue(gameContinue);
			}
		}
		while(dealer.getAddCard() <= 21 && dealer.getAddCard() < 17) {
			if(dealer.getAddCard() <= 21 && dealer.getAddCard() < 17) {
				int cardB = (int)(Math.random()*13 + 1);
				dealer.setCardB(cardB);
				System.out.println(dealer.getName() + "が一枚カードを引きました。");
				dealer.game_2();//あとで消す。
			}
		}
		System.out.println(your.getName() + "は" + your.getAddCard() +"でした。");
		System.out.println(dealer.getName() + "は" + dealer.getAddCard() + "でした。");

		if(your.getAddCard() > 21 && dealer.getAddCard() > 21) {
			System.out.println("二人ともバーストしたので引き分けです。");
		}else if(your.getAddCard() <= 21 && dealer.getAddCard() > 21) {
			System.out.println(dealer.getName() + "はバーストしたので"+ your.getName() + "の勝ちです。");
		}else if(your.getAddCard() > 21 && dealer.getAddCard() <= 21) {
			System.out.println(your.getName() + "はバーストしたので"+ your.getName() + "の負けです。");
		}else if(your.getAddCard() > dealer.getAddCard()){
			System.out.println(your.getName() + "の方が合計が大きいので" + your.getName() + "の勝ちです。");
		}else if(your.getAddCard() < dealer.getAddCard()) {
			System.out.println(dealer.getName() + "の方が合計が大きいので" + your.getName() + "の負けです。");
		}else {
			System.out.println("合計が同じなので引き分けです。");
		}
		Player.gameFinish();
	}
}