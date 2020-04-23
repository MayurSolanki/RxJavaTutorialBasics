package com.rxjavatutorial.operator.utility;

import com.rxjavatutorial.observers.DemoObserver;
import com.rxjavatutorial.utils.RxUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 22/04/20, 10:39 PM.
 */
public class TimeOutOperator {

    //  Observer subscribe immediately but receive data after delay time while in debounce Observable emits after defined amount of Time


    public static final Logger LOGGER = LoggerFactory.getLogger(TimeOutOperator.class);

    public static void main(String... args) {

        Observable.timer(2,TimeUnit.SECONDS).timeout(1,TimeUnit.SECONDS).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Throwable {
                LOGGER.info( " throwable "+throwable.getMessage());
            }
        }).subscribe(new DemoObserver());


//        RxUtils.sleep(10000);



    }

}
