package com.rxjavatutorial.observables;

import com.rxjavatutorial.observers.DemoObserver;
import com.rxjavatutorial.utils.RxUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 20/04/20, 10:39 PM.
 */
public class ObservableUsingRepeat {

    // Four Types of Observable usong From
    // 1. fromIterable
    // 2. fromArray
    // 3. fromCallable
    // 4. fromPublisher


    public static void main(String... args) {

        Observable<Integer> observable =  Observable.fromIterable(RxUtils.postiveNumbers(10));

        observable.repeat(3).subscribe(new DemoObserver());


        RxUtils.sleep(20000);

    }
}
