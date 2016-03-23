package com.dorukkangal.android.mvvm.contact;

/**
 * @author Doruk Kangal
 */
public interface Action<T> {

    void perform(T t);
}
