package com.rxjavatutorial.operator.combine;

import com.rxjavatutorial.observers.DemoObserver;
import com.rxjavatutorial.utils.RxUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.BiFunction;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 22/04/20, 10:39 PM.
 */
public class ZipOperator {

    // Transmit the item, After applying function to modify it in sqquence


    public static final Logger LOGGER = LoggerFactory.getLogger(ZipOperator.class);

    public static void main(String... args) {

        Observable shapes =   Observable.range(11,5);
        Observable integer =  Observable.fromIterable(RxUtils.postiveNumbers(10));


        Observable.zip(shapes, integer, (BiFunction<Object, Object, Object>) (o1, o2) -> {

            LOGGER.info(" ZipOperator Latest o1 "+o1.toString() +" o2  " +o2.toString());

            return  o1.toString() +" "+ o2.toString();

        }).subscribe(new DemoObserver());






    }

}
