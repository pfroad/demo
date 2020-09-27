package com.pfroad.demo;

import com.pfroad.demo.user.entity.User;

import java.util.Arrays;

public class TestJVM {
    public static int staticVar;
    public int instanceVar;
    private static int arr[][];

    static {
        staticVar = 2;
    }

    public static void main(String[] args) {
        int x = 32768; // ldc
        TestJVM myObj = new TestJVM(); // new
        TestJVM.staticVar = x; // putstatic
        x = TestJVM.staticVar; // getstatic
        myObj.instanceVar = x; // putfield
        x = myObj.instanceVar; // getfield

        arr = new int[2][];
        myObj.printArrayType(arr);
        Object obj = myObj;
        if (obj instanceof TestJVM) { // instanceof
            myObj = (TestJVM) obj; // checkcast
            System.out.println(myObj.instanceVar);
        }
    }

    public void printArrayType(int[][] arr) {
        Class clazz = arr.getClass();
        System.out.println(clazz.getName());
        System.out.println(clazz.getSuperclass());
        System.out.println(clazz.getCanonicalName());

        Class[] interfaces = clazz.getInterfaces();
        if (interfaces != null) {
            Arrays.stream(interfaces).forEach( it ->
                    System.out.println(it.getName())
            );
        }
        System.out.println(clazz.getDeclaredMethods().length);
    }

    public Integer test(Long[] a, Long b, int c) {
        for (int i = 0; i < 100; i++) {
            int x = 32768; // ldc
            TestJVM myObj = new TestJVM(); // new
            myObj.instanceVar = x + i; // putfield
        }

        return 1;
    }
}
