package com.rxjavatutorial.observables;

import com.rxjavatutorial.observers.DemoObserver;
import com.rxjavatutorial.utils.RxUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 20/04/20, 10:52 PM.
 */
public class ObservableWithoutBackpressure {
    // subscriber rate of consume is same as observable emits data

    private static final Logger LOGGER = LoggerFactory.getLogger(ObservableWithoutBackpressure.class);


    public static void main(String... args) {

     Observable<Integer> numbers =    Observable.fromIterable(RxUtils.postiveNumbers(100000)).repeat().observeOn(Schedulers.newThread()).subscribeOn(Schedulers.newThread());

     numbers.subscribe(new DemoObserver());

     RxUtils.sleep(10000);
    }

}
