package com.rxjavatutorial.operator.combine;

import com.rxjavatutorial.observers.DemoObserver;
import com.rxjavatutorial.utils.RxUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 22/04/20, 10:39 PM.
 */
public class CombineLatestOperator {

    // Transmit the item, After applying function to modify it in sqquence


    public static final Logger LOGGER = LoggerFactory.getLogger(CombineLatestOperator.class);
    private static List<Character> characterList = new ArrayList<>();

    public static void main(String... args) {

        Observable observable1 = Observable.interval(1, TimeUnit.SECONDS);
        Observable observable2 = Observable.interval(2, TimeUnit.SECONDS);

        Observable.combineLatest(observable1, observable2, new BiFunction<Object, Object, Object>() {
            @Override
            public Object apply(Object o1, Object o2) throws Throwable {


                LOGGER.info(" Combine Latest o1 "+o1.toString() +" o2  " +o2.toString());

                return  o1.toString() +" "+ o2.toString();
            }
        }).subscribe(new DemoObserver());


        RxUtils.sleep(10000);

    }

}
