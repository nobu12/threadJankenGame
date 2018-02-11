package game;

public class Janken {
	public enum Hand {
		GUU("グー"), CHOKI("チョキ"), PAA("パー");

		private final String hand;

		private Hand(String hand) {
			this.hand = hand;
		}

		public String getHand() {
			return hand;
		}
	}

	/**
	 * じゃんけんの結果を表示する
	 *
	 * @param firstPlayerHand
	 *            1人目の出した手
	 * @param secondPlayerHand
	 *            2人目の出した手
	 */
	public static void getGameResult(Hand firstPlayerHand, Hand secondPlayerHand) {
		// じゃんけんの勝者を1人目と仮置きする
		Hand winner = firstPlayerHand;

		if (firstPlayerHand == Hand.GUU && secondPlayerHand == Hand.PAA) {
			winner = secondPlayerHand;
		} else if (firstPlayerHand == Hand.CHOKI && secondPlayerHand == Hand.GUU) {
			winner = secondPlayerHand;
		} else if (firstPlayerHand == Hand.PAA && secondPlayerHand == Hand.CHOKI) {
			winner = secondPlayerHand;
		}

		System.out.println(getPlayerHand(firstPlayerHand, secondPlayerHand));
		if (firstPlayerHand == secondPlayerHand) {
			System.out.println("あいこです。");
		} else if (winner == firstPlayerHand) {
			System.out.println("1人目の勝ちです。");
		} else if (winner == secondPlayerHand) {
			System.out.println("2人目の勝ちです。");
		}
		System.out.println("");
	}

	/**
	 * ランダムにじゃんけんの手を取得する
	 * @return じゃんけんの手
	 */
	public static Hand getHand() {
		double random = Math.random() * 10;
		if (6.6 < random) {
			return Hand.GUU;
		} else if (3.3 < random) {
			return Hand.CHOKI;
		}
		return Hand.PAA;
	}

	/**
	 * プレイヤーが出した手を表示する
	 *
	 * @param firstPlayerHand
	 *            1人目の出した手
	 * @param secondPlayerHand
	 *            2人目の出した手
	 * @return 1人目と2人目の手の出し方
	 */
	private static String getPlayerHand(Hand firstPlayerHand, Hand secondPlayerHand) {
		return "1人目の手は" + String.format("%s", firstPlayerHand.getHand()) + " ：  2人目の手は"
				+ String.format("%s", secondPlayerHand.getHand());
	}

}
