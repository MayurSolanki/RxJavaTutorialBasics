package com.rxjavatutorial.observables;

import com.rxjavatutorial.observers.DemoObserver;
import com.rxjavatutorial.utils.RxUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 20/04/20, 10:15 PM.
 */
public class ObservableUsingInterval {

    // Observable that emits a sequence of integers spaced by a particular time interval


    public static final Logger LOGGER = LoggerFactory.getLogger(ObservableUsingCreate.class);

    public static void main(String... args) {
        Observable.interval( 2, TimeUnit.SECONDS).subscribe(new DemoObserver());
        RxUtils.sleep(2000);
    }
}
