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
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Predicate;

public class ObservableUsingCreate {

    public static final Logger LOGGER = LoggerFactory.getLogger(ObservableUsingCreate.class);

    public static void main(String... args) {

         final List<Shape> shapeList = RxUtils.shapes(5);

        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> observableEmitter) throws Exception {

                try {

                    for (int i = 0; i < shapeList.size() ; i++) {

                        observableEmitter.onNext(shapeList.get(i));

                    }

                }catch (Throwable e){
                    observableEmitter.onError(e);

                }

                observableEmitter.onComplete();

            }
        }).subscribe(new DemoObserver());

    }
}
