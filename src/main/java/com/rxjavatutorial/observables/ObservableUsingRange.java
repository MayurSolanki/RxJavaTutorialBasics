package com.rxjavatutorial.observables;

import com.rxjavatutorial.observers.DemoObserver;

import io.reactivex.rxjava3.core.Observable;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 20/04/20, 10:34 PM.
 */
public class ObservableUsingRange {
    //Observable that emits a range of sequential integers

    public static void main(String... args) {
        Observable.range(2,10).subscribe(new DemoObserver());
    }
}
