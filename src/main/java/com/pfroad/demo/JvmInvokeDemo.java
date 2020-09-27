package com.pfroad.demo;

public class JvmInvokeDemo implements Runnable {
    public static void main(String[] args) {
        new JvmInvokeDemo().test();
    }

    public void test() {
        JvmInvokeDemo.staticMethod(); // invokestatic
        JvmInvokeDemo demo = new JvmInvokeDemo(); // invokespecial
        demo.instanceMethod(); // invokespecial
        super.equals(null); // invokespecial
        this.run(); // invokevirtual
        ((Runnable) demo).run(); // invokeinterface
    }

    public static void staticMethod() {
//        System.out.println("This is static method!");
    }
    private void instanceMethod() {
//        System.out.println("This is instance method!");
    }
    @Override public void run() {
//        System.out.println("Running!");
    }
}
