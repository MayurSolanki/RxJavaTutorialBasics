package com.rxjavatutorial.operator.filtering;

import com.rxjavatutorial.utils.RxUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 22/04/20, 10:39 PM.
 */
public class IgnoreElementsOperator {

    // Transmit the item, After applying function to modify it in sqquence


    public static final Logger LOGGER = LoggerFactory.getLogger(IgnoreElementsOperator.class);

    public static void main(String... args) {

        Observable.fromIterable(RxUtils.postiveNumbers(10)).ignoreElements().subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });


    }

}
