package com.rxjavatutorial.observables;



import com.rxjavatutorial.observers.DemoObserver;

import io.reactivex.rxjava3.core.Observable;

public class ObservableUsingJust {


    public static void main(String[] arg) {

        Observable.just("a","b","c","d","e","f","j").subscribe(new DemoObserver());

    }
}
