package com.rxjavatutorial.operator.conditional;

import com.rxjavatutorial.observers.DemoObserver;
import com.rxjavatutorial.utils.RxUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Predicate;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 22/04/20, 10:39 PM.
 */
public class TakeWhileOperator {

    //  Observer subscribe immediately but receive data after delay time while in debounce Observable emits after defined amount of Time


    public static final Logger LOGGER = LoggerFactory.getLogger(TakeWhileOperator.class);

    public static void main(String... args) {



          Observable.fromIterable(RxUtils.postiveNumbers(10)).skipWhile(new Predicate<Integer>() {
              @Override
              public boolean test(Integer integer) throws Throwable {
                  return integer > 6;
              }
          }).subscribe(new DemoObserver());



        RxUtils.sleep(50000);



    }

}
