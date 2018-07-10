package com.test.threadpool;

class InnerStaticSingleton {

    private InnerStaticSingleton() {
        System.out.println("InnerStaticSingleton");
    }

    public static class Holder {
        private static InnerStaticSingleton singleton = new InnerStaticSingleton();

        public static void hehe() {
            System.out.println("hehe");
        }
    }

    public static InnerStaticSingleton getInstance() {
        return Holder.singleton;
    }

    public static void hehe() {
        System.out.println("hehe");
    }
}
