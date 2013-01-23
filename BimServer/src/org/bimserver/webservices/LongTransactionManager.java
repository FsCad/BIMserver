package org.bimserver.webservices;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class LongTransactionManager {
	private final AtomicLong counter = new AtomicLong();
	private final Map<Long, LongTransaction> runningTransactions = new HashMap<Long, LongTransaction>();
	
	public synchronized LongTransaction newLongTransaction(Long poid) {
		LongTransaction longTransaction = new LongTransaction(poid, counter.incrementAndGet());
		runningTransactions.put(longTransaction.getTid(), longTransaction);
		return longTransaction;
	}

	public LongTransaction get(Long tid) {
		return runningTransactions.get(tid);
	}

	public void remove(long tid) {
		runningTransactions.remove(tid);
	}
}
