package com.xiaoyang;

public class FinalizerDemo {
    private static FinalizerDemo object;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalize running");
        object = this;
    }

    public static void main(String[] args) {
        object = new FinalizerDemo();
        object = null;
        System.gc();
        try {
            Thread.sleep(500);
            if (object != null) {
                System.out.println("Object alive");
            } else {
                System.out.println("Object dead");
            }
            object = null;
            System.gc();
            Thread.sleep(500);
            if (object != null) {
                System.out.println("Object alive");
            } else {
                System.out.println("Object dead");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
