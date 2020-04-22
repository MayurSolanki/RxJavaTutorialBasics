package com.rxjavatutorial.operator.transforming;

import com.rxjavatutorial.utils.RxUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.BiFunction;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 22/04/20, 10:39 PM.
 */
public class ScanOperator {

    // Transmit the item, After applying function to modify it in sqquence


    public static final Logger LOGGER = LoggerFactory.getLogger(ScanOperator.class);

    public static void main(String... args) {

        Observable.fromIterable(RxUtils.postiveNumbers(10)).scan(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer1, Integer integer2) throws Throwable {

                return integer1+integer2;
            }
        }).subscribe(new Observer<Integer>() {
          @Override
            public void onSubscribe(@NonNull Disposable d) {
                LOGGER.info(" onSubscribe "+d);

            }

            @Override
            public void onNext(@NonNull Integer o) {
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
