package game;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class JankenCallable implements Callable<Janken.Hand> {

	@Override
	public Janken.Hand call() throws Exception {
		TimeUnit.SECONDS.sleep(1);
		double random = (int) (Math.random() * 10);
		if (6 < random) {
			return Janken.Hand.GUU;
		} else if (3 < random) {
			return Janken.Hand.CHOKI;
		}
		return Janken.Hand.PAA;
	}
}
