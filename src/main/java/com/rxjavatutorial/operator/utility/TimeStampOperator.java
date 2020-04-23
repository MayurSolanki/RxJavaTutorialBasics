package com.rxjavatutorial.operator.utility;

import com.rxjavatutorial.observers.DemoObserver;
import com.rxjavatutorial.utils.RxUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 22/04/20, 10:39 PM.
 */
public class TimeStampOperator {

    //  Observer subscribe immediately but receive data after delay time while in debounce Observable emits after defined amount of Time


    public static final Logger LOGGER = LoggerFactory.getLogger(TimeStampOperator.class);

    public static void main(String... args) {

        Observable.fromIterable(RxUtils.postiveNumbers(10)).timestamp(TimeUnit.SECONDS).subscribe(new DemoObserver());


//        RxUtils.sleep(10000);



    }

}
