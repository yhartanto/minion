package com.nahoy.minion.interactor;

import rx.Observable;
import rx.Scheduler;

public class RxInteractor<T> {
    protected final Scheduler backgroundThreadScheduler;
    protected final Scheduler mainThreadScheduler;

    public RxInteractor(Scheduler backgroundThreadScheduler, Scheduler mainThreadScheduler) {
        this.backgroundThreadScheduler = backgroundThreadScheduler;
        this.mainThreadScheduler = mainThreadScheduler;
    }

    protected <T> Observable<T> executeAsync(Observable<T> observable) {
        return observable.subscribeOn(backgroundThreadScheduler)
                .observeOn(mainThreadScheduler);
    }

    protected <T> T executeNow(Observable<T> observable) {
        return observable.toBlocking().single();
    }
}
