/*
 * 本来は隠しておくべきディーラーの点数をコードの確認用に「ディーラー点数確認用」コメント付きで残している。
 * Main.javaとDealer.javaの2つのファイルにディーラーの点数表記用のコードがあるため、本来はそのコード一列をコメントにして使用する。
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("これからブラックジャックを始めます。");
		System.out.print("あなたの名前を教えてください：");
		String name = scanner.next();
		Player your = new Player(name);
		Dealer dealer = new Dealer("ディーラー");

		System.out.println(your.getName() +"はカードを2枚引きました。");
		System.out.println(your.getName() + "の一枚目のカードは" + your.getCardA() + "、二枚目のカードは" + your.getCardB() + "です。");
		System.out.println(dealer.getName() +"はカードを2枚引きました。");
		System.out.println(dealer.getName() + "の一枚目のカードは" +dealer.getCardA() + "です。" );
		your.game_1();
		dealer.game_1();
		System.out.println(dealer.getCardB()+" , "+dealer.getAddCard());//ディーラー点数確認用
		int gameContinue = 0;
		if(your.getAddCard() < 21) {
			Player.continueMessage();
			gameContinue = scanner.nextInt();
			your.setGameContinue(gameContinue);
		}

		while (your.getGameContinue() == 1 && your.getAddCard() < 21) {
			if(your.getAddCard() < 21) {
				int cardB = (int)(Math.random()*13 + 1);//カードを引く（二回目以降）
				your.setCardB(cardB);
				your.game_2();
			}
			if(dealer.getAddCard() < 21) {
				int cardB = (int)(Math.random()*13 + 1);
				dealer.setCardB(cardB);
				System.out.println(dealer.getName() + "が一枚カードを引きました。");
				dealer.game_2();
				System.out.println(dealer.getCardB()+" , "+dealer.getAddCard());//ディーラー点数確認用
			}
			if(your.getAddCard() < 21) {
				Player.continueMessage();
				gameContinue = scanner.nextInt();
				your.setGameContinue(gameContinue);
			}
		}
		dealer.game_3();
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