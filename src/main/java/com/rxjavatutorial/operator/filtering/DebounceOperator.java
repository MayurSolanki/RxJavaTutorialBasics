package com.rxjavatutorial.operator.filtering;

import com.rxjavatutorial.utils.RxUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 22/04/20, 10:39 PM.
 */
public class DebounceOperator {

    // Transmit the item, After applying function to modify it in sqquence


    public static final Logger LOGGER = LoggerFactory.getLogger(DebounceOperator.class);
    private static List<Character> characterList = new ArrayList<>();

    public static void main(String... args) {

        Random random = new Random();



        
        Observable.interval(2,TimeUnit.SECONDS).map(new Function<Long, List<Character>>() {
            @Override
            public List<Character> apply(Long aLong) throws Throwable {

                characterList.add(((char)(random.nextInt(26)+'a')));

                return characterList;
            }
        }).doOnEach(new Consumer<Notification<List<Character>>>() {
            @Override
            public void accept(Notification<List<Character>> listNotification) throws Throwable {
                LOGGER.info(" current value {}",listNotification);
            }
        }).debounce(2, TimeUnit.SECONDS).subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                LOGGER.info(" onSubscribe "+d);

            }

            @Override
            public void onNext(@NonNull Object o) {
                LOGGER.info(" onNext "+o);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                LOGGER.info(" onError "+e);
            }

            @Override
            public void onComplete() {
                LOGGER.info(" onComplete ");

            }
        });

        RxUtils.sleep(10000);

    }

}
