package com.rxjavatutorial.observables;

import com.rxjavatutorial.observers.DemoObserver;
import com.rxjavatutorial.utils.RxUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 20/04/20, 10:25 PM.
 */
public class ObservableUsingTimer {
    // Observable that emits a single item after a given delay

    public static final Logger LOGGER = LoggerFactory.getLogger(ObservableUsingCreate.class);

    public static void main(String... args) {
      Observable.timer(5,TimeUnit.SECONDS).subscribe(new DemoObserver());
      RxUtils.sleep(8000);
    }

}
