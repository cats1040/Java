// package MultiThreading.Introduction;
/*
    This code is based on a tutorial by Coding with John
    YouTube Link: https://www.youtube.com/watch?v=r_MbozD32eo
*/

// package MultiThreaded.Introduction;

// public class MultiThreading extends Thread {
//     private int threadNumber;

//     MultiThreading(int threadNumber) {
//         this.threadNumber = threadNumber;
//     }

//     @Override
//     public void run() {
//         for (int i = 0; i < 5; i++) {
//             System.out.println(i + " from thread " + this.threadNumber);
//             try {
//                 Thread.sleep(1000); // 1s
//             } catch (Exception e) {

//             }
//         }
//     }
// }

// By implementing Runnable
// Only advantage is that we can extend a class, and implement any number of interfaces

public class MultiThreadingThing implements Runnable {
    private int threadNumber;

    MultiThreadingThing(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " from thread " + this.threadNumber);
            try {
                Thread.sleep(1000); // 1s
            } catch (Exception e) {

            }
        }
    }
}