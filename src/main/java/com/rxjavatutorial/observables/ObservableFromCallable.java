package com.rxjavatutorial.observables;

import com.rxjavatutorial.observers.DemoObserver;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 20/04/20, 10:39 PM.
 */
public class ObservableFromCallable {

    // Four Types of Observable usong From
    // 1. fromIterable
    // 2. fromArray
    // 3. fromCallable
    // 4.fromPublisher

    public static void main(String... args) {

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello";
            }
        };

        Observable.fromCallable(callable).subscribe(new DemoObserver());
    }
}
