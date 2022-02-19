package edu.st4rd.otus.core.transactionmanager;

import java.util.function.Supplier;

public interface TransactionAction<T> extends Supplier<T> {
}
