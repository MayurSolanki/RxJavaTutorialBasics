package com.rxjavatutorial.operator.conditional;

import com.rxjavatutorial.observers.DemoObserver;
import com.rxjavatutorial.utils.RxUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Predicate;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 22/04/20, 10:39 PM.
 */
public class AllOperator {

    //  Observer subscribe immediately but receive data after delay time while in debounce Observable emits after defined amount of Time


    public static final Logger LOGGER = LoggerFactory.getLogger(AllOperator.class);

    public static void main(String... args) {

        Observable.fromIterable(RxUtils.postiveNumbers(10)).all(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Throwable {
                return integer < 11;
            }
        }).subscribe(new SingleObserver<Boolean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull Boolean aBoolean) {
                LOGGER.info(" === onSuccess {}",aBoolean);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                LOGGER.info(" === onError ",e);
            }
        });

        RxUtils.sleep(10000);



    }

}
