package test;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		A a = new A();

		System.out.println(a.getCount());
		a.setCount(13);
		System.out.println(a.getCount());

		System.out.println(Arrays.asList(A.class.getDeclaredFields()));
		System.out.println(Arrays.asList(A.class.getDeclaredMethods()));

	}

}
