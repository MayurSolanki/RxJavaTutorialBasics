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
import io.reactivex.rxjava3.functions.Predicate;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 22/04/20, 10:39 PM.
 */
public class SkipUntilOperator {

    //  Observer subscribe immediately but receive data after delay time while in debounce Observable emits after defined amount of Time


    public static final Logger LOGGER = LoggerFactory.getLogger(SkipUntilOperator.class);

    public static void main(String... args) {

        Observable observableFirst = Observable.timer(5, TimeUnit.SECONDS);
        Observable observableSecond = Observable.timer(2, TimeUnit.SECONDS);

        observableFirst.skipUntil(observableSecond).subscribe(new DemoObserver());



        RxUtils.sleep(50000);



    }

}
