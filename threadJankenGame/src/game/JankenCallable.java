package game;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class JankenCallable implements Callable<Janken.Hand> {

	public static int playerNumber = 1;
	public final static Object lock = new Object();

	@Override
	public Janken.Hand call() throws Exception {
		TimeUnit.SECONDS.sleep(1);

		synchronized (lock) {
			playerNumber++;

			if (playerNumber % 2 == 0) {
				System.out.println("1人目の名前 ： " + Thread.currentThread().getName());
			} else {
				System.out.println("2人目の名前 ： " + Thread.currentThread().getName());
			}
		}

		double random = (int) (Math.random() * 10);
		if (6 < random) {
			return Janken.Hand.GUU;
		} else if (3 < random) {
			return Janken.Hand.CHOKI;
		}
		return Janken.Hand.PAA;
	}
}
