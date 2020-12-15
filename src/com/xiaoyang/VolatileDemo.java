package com.xiaoyang;

public class VolatileDemo {
    private static volatile int num = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    num++;
                }
            }).start();
        }
        System.out.println(num);
    }

    private class Demo2 {
        private volatile int low;
        private volatile int high;

        public int getLow() {
            return low;
        }

        public int getHigh() {
            return high;
        }

        public void setLow(int low) {
            if (low > high)
                throw new IllegalArgumentException();
            this.low = low;
        }

        public void setHigh(int high) {
            if (high < low)
                throw new IllegalArgumentException();
            this.high = high;
        }
    }
}
