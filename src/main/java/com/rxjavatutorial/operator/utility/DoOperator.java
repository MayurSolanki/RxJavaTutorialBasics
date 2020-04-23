package com.rxjavatutorial.operator.utility;

import com.rxjavatutorial.model.Shape;
import com.rxjavatutorial.observers.DemoObserver;
import com.rxjavatutorial.utils.RxUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 22/04/20, 10:39 PM.
 */
public class DoOperator {

    //  Observer subscribe immediately but receive data after delay time while in debounce Observable emits after defined amount of Time


    public static final Logger LOGGER = LoggerFactory.getLogger(DoOperator.class);

    public static void main(String... args) {

        Observable.fromIterable(RxUtils.shapes(10))
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Throwable {

                        LOGGER.info(" === doOnSubscribe ");

                    }
                }).doOnEach(new Consumer<Notification<Shape>>() {
            @Override
            public void accept(Notification<Shape> shapeNotification) throws Throwable {

//                if(shapeNotification.getValue().getColor().equalsIgnoreCase("red")){
//                    shapeNotification.getValue().setColor("Reddish");
//                }

                LOGGER.info("  === doOnEach "+shapeNotification.getValue());
            }
           }).doOnNext(new Consumer<Shape>() {
            @Override
            public void accept(Shape shape) throws Throwable {
                LOGGER.info(" ===  doOnNext "+shape);
            }
        }).doOnComplete(() -> {
            LOGGER.info(" ===  doOnComplete ");

        }).subscribe(new DemoObserver());


        RxUtils.sleep(10000);

    }

}
