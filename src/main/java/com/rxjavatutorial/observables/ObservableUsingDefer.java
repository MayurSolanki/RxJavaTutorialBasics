package com.rxjavatutorial.observables;



import com.rxjavatutorial.model.Shape;
import com.rxjavatutorial.observers.DemoObserver;
import com.rxjavatutorial.utils.RxUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromSupplier;

public class ObservableUsingDefer {

    // This observable only be created when it subscribe, and Created every time when subscribe

    private static final Logger LOGGER = LoggerFactory.getLogger(ObservableUsingDefer.class);

    public static void main(String... args) {

         final List<Integer> shapeList = RxUtils.postiveNumbers(5);



        Observable<Integer>  observableUsingDefer =  Observable.defer(() ->{
            return Observable.fromIterable(RxUtils.postiveNumbers(5));
        });

        observableUsingDefer.subscribe(new DemoObserver());
        observableUsingDefer.subscribe(new DemoObserver());


//        observableUsingDefer.subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull Integer integer) {
//                LOGGER.info("onNext -> {}",integer);
//
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });

    }
}
