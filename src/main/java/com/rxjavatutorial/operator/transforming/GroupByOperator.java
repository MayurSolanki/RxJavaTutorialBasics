package com.rxjavatutorial.operator.transforming;

import com.rxjavatutorial.model.Shape;
import com.rxjavatutorial.observers.DemoObserver;
import com.rxjavatutorial.utils.RxUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observables.GroupedObservable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 22/04/20, 10:39 PM.
 */
public class GroupByOperator {

    // Make group based on criteria


    public static final Logger LOGGER = LoggerFactory.getLogger(GroupByOperator.class);

    public static void main(String... args) {

        Observable.fromIterable(RxUtils.shapes(50)).groupBy(new Function<Shape, Object>() {
            @Override
            public Object apply(Shape shape) throws Throwable {

                return shape.getShape();
            }
        }).observeOn(Schedulers.newThread())
                .subscribe(new Observer<GroupedObservable<Object, Shape>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull GroupedObservable<Object, Shape> objectShapeGroupedObservable) {

                        LOGGER.info(" Key {}",objectShapeGroupedObservable.getKey());

                        objectShapeGroupedObservable.subscribe(new DemoObserver());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        RxUtils.sleep(10000);
    }
}
