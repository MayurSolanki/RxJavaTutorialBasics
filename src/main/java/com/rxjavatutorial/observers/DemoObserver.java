package com.rxjavatutorial.observers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 20/04/20, 7:09 PM.
 */
public class DemoObserver implements  Observer {

    public static final Logger LOGGER = LoggerFactory.getLogger(DemoObserver.class);

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        LOGGER.info("onSubscribe");
    }

    @Override
    public void onNext(Object o) {
        LOGGER.info("onNext -> {}",o);
    }

    @Override
    public void onError(@NonNull Throwable throwable) {
        LOGGER.info("onError -> {}",throwable.getMessage());
    }

    @Override
    public void onComplete() {
        LOGGER.info("onComplete");
    }
}
