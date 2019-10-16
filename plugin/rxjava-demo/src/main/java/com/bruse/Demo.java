package com.bruse;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Demo {

    public static void main(String[] args) throws Exception {
        // m1();
        // m2();
        // m3();
        m4();
    }

    static void m1() {
        Flowable.just("Hello world").subscribe(System.out::println);
    }

    static void m2() {
        Observable.create(emitter -> {
            while (!emitter.isDisposed()) {
                long time = System.currentTimeMillis();
                emitter.onNext(time);
                if (time % 2 != 0) {
                    emitter.onError(new IllegalStateException("Odd millisecond!"));
                    break;
                }
            }
        }).subscribe(System.out::println, Throwable::printStackTrace);
    }

    static void m3() throws InterruptedException {
        Flowable.fromCallable(() -> {
            Thread.sleep(1000); //  imitate expensive computation
            return "Done";
        })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(System.out::println, Throwable::printStackTrace);

        // <--- wait for the flow to finish
        Thread.sleep(2000);
    }

    static void m4() {
        Flowable.just("Hello world!").map(s -> {
            System.out.println(s);
            return "Why ";
        }).map(s -> {
            System.out.print(s);
            return "the ";
        }).map(s -> {
            System.out.print(s);
            return "fuck";
        }).subscribe(s -> {
            System.out.print(s);
            System.out.println("?");
        }, Throwable::printStackTrace);
    }
}
