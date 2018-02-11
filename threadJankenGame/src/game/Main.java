package game;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	// スレッドプール数　2人専用のじゃんけんゲームのため"2"限定となってしまう
	private static final int THREAD_POOL_COUNT = 2;
	// じゃんけんのゲーム回数
	private static final int GAME_COUNT = 3;

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_COUNT);

		// じゃんけんの手をMapに設定する
		Map<Long, Future<Janken.Hand>> map = new HashMap<Long, Future<Janken.Hand>>();
		for (int i = 0; i < GAME_COUNT * 2; i++) {
			Future<Janken.Hand> future = executorService.submit(new JankenCallable());
			// Mapのキーが重複しないようにする
			map.put(Thread.currentThread().getId() + i, future);
		}

		int count = 0;
		Janken.Hand firstPlayerHand = null;
		for (Long future : map.keySet()) {
			count++;

			Janken.Hand currentPlayerHand = null;
			try {
				currentPlayerHand = map.get(future).get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				executorService.shutdown();
			}

			// 1人目と2人目の手が決まったところで結果を表示する
			if (count % THREAD_POOL_COUNT == 0) {
				Janken.getGameResult(firstPlayerHand, currentPlayerHand);
			} else {
				firstPlayerHand = currentPlayerHand;
			}
		}
	}
}