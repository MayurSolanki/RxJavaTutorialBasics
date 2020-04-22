package com.rxjavatutorial.operator.filtering;

import com.rxjavatutorial.model.Shape;
import com.rxjavatutorial.observers.DemoObserver;
import com.rxjavatutorial.utils.RxUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Predicate;

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 22/04/20, 10:39 PM.
 */
public class FilterOperator {

    // Transmit the item, After applying function to modify it in sqquence


    public static final Logger LOGGER = LoggerFactory.getLogger(FilterOperator.class);

    public static void main(String... args) {

       List<Shape> list =  RxUtils.shapes(10);

        for (Shape shape: list) {
            LOGGER.info(" shape color "+shape.getColor());
        }

       Observable.fromIterable(list).filter(new Predicate<Shape>() {
           @Override
           public boolean test(Shape shape) throws Throwable {
               return shape.getColor().equalsIgnoreCase("blue");
           }
       }).subscribe(new DemoObserver());
    }

}
