package com.rxjavatutorial.operator.combine;

import com.rxjavatutorial.model.Shape;
import com.rxjavatutorial.observers.DemoObserver;
import com.rxjavatutorial.utils.RxUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.BiFunction;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 22/04/20, 10:39 PM.
 */
public class MergeOperator {

    // Transmit the item, After applying function to modify it in sqquence


    public static final Logger LOGGER = LoggerFactory.getLogger(MergeOperator.class);

    public static void main(String... args) {

        Observable shapes =   Observable.just(RxUtils.shapes(10));
        Observable integer =  Observable.fromIterable(RxUtils.postiveNumbers(10));

        Observable.merge(shapes, integer, new ObservableSource<Object>() {
            @Override
            public void subscribe(@NonNull Observer<? super Object> observer) {

                observer.onNext(observer);

            }
        }).subscribe(new DemoObserver());

//        Observable.merge(shapes, integer).subscribe(new DemoObserver());




    }

}
