package com.rxjavatutorial.operator.transforming;

import com.rxjavatutorial.utils.RxUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 22/04/20, 10:39 PM.
 */
public class FlatMapOperator {

    // Transmit the item, After applying function to modify it BUT it returns observale

    public static final Logger LOGGER = LoggerFactory.getLogger(FlatMapOperator.class);

    public static void main(String... args) {

        Observable.fromIterable(RxUtils.postiveNumbers(10)).flatMap(new Function<Integer, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Integer integer) throws Throwable {

                return  Observable.just(integer*3);
            }
        }).subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                LOGGER.info(" onSubscribe "+d);

            }

            @Override
            public void onNext(@NonNull Object o) {
                LOGGER.info(" onNext "+o);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                LOGGER.info(" onError "+e);
            }

            @Override
            public void onComplete() {
                LOGGER.info(" onComplete ");

            }
        });
    }
}
