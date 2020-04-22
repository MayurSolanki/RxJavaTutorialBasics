package com.rxjavatutorial.observables;

import com.rxjavatutorial.observers.DemoObserver;
import com.rxjavatutorial.utils.RxUtils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 20/04/20, 11:18 PM.
 */
public class ObservableWithBackpressure {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObservableWithBackpressure.class);
     // Subscriber is able to handle the data as same rate as observable emits the data

    public static void main(String... args) {

        Flowable<Integer> flowableNumbers =    Flowable.fromIterable(RxUtils.postiveNumbers(1000000)).repeat().observeOn(Schedulers.newThread()).subscribeOn(Schedulers.newThread())
                .doOnNext( integer -> LOGGER.info(" emitting integer ->{}", integer) );

        flowableNumbers.subscribe(new Subscriber<Integer>() {
            private Subscription subscription;
            private AtomicInteger counter = new AtomicInteger(0);

            @Override
            public void onSubscribe(Subscription s) {
                LOGGER.info(" onSubscribe ->{}", s);

                this.subscription = s;

                subscription.request(5);
            }

            @Override
            public void onNext(Integer integer) {
                LOGGER.info(" onNext ->{}", integer);
                RxUtils.sleep(100L);
                if(counter.incrementAndGet()%5 == 0){
                    subscription.request(5);
                }
            }

            @Override
            public void onError(Throwable t) {
                LOGGER.info(" onError ->{}", t);
            }

            @Override
            public void onComplete() {
                LOGGER.info(" onComplete");
            }

        });

        RxUtils.sleep(1000000);

    }
}
