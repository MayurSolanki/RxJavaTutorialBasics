package com.rxjavatutorial.operator.transforming;

import com.rxjavatutorial.observables.ObservableUsingCreate;
import com.rxjavatutorial.observers.DemoObserver;
import com.rxjavatutorial.utils.RxUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.core.Observable;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 22/04/20, 10:39 PM.
 */
public class BufferOperator {

    // periodically gather items from an Observable into bundles and emit these bundles rather than emitting the items one at a time
    // Buffer (3)

    public static final Logger LOGGER = LoggerFactory.getLogger(BufferOperator.class);

    public static void main(String... args) {

        Observable.just(RxUtils.shapes(10)).buffer(5).subscribe(new DemoObserver());
    }
}
