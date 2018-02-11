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
	 * @param firstPlayerHand 1人目の出した手
	 * @param secondPlayerHand 2人目の出した手
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
			System.out.println(getWinnerMessage("1人目"));
		} else if (winner == secondPlayerHand) {
			System.out.println(getWinnerMessage("2人目"));
		}
		System.out.println("");
	}

	/**
	 * じゃんけん勝者の結果表示を組み立てる
	 * @param winner じゃんけんの勝者
	 * @return じゃんけん勝者の結果
	 */
	private static String getWinnerMessage(String winner) {
		return winner + "の勝ちです。";
	}

	/**
	 * プレイヤーが出した手を表示する
	 * @param firstPlayerHand 1人目の出した手
	 * @param secondPlayerHand 2人目の出した手
	 * @return 1人目と2人目の手の出し方
	 */
	private static String getPlayerHand(Hand firstPlayerHand, Hand secondPlayerHand) {
		return "1人目の手は" + String.format("%s", firstPlayerHand.getHand())
				+ " ：  2人目の手は" + String.format("%s", secondPlayerHand.getHand());
	}

}
