package com.nahoy.minion.binding;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public abstract class RxPresenter<View> {
    protected CompositeSubscription compositeSubscription = new CompositeSubscription();
    protected View view;

    public void initialize(View view) {
        this.view = view;
    }

    public void destroy() {
        view = null;
        compositeSubscription.clear();
    }

    protected void manage(Subscription subscription) {
        compositeSubscription.add(subscription);
    }
}
