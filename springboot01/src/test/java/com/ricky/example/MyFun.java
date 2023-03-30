package com.ricky.example;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author ricky
 * @create 2023-03-29 20:13
 */
@FunctionalInterface
public interface MyFun {
	public T getValue(T num);
}
