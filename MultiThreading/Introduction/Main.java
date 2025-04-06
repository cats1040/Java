// package MultiThreading.Introduction;
/*
    This code is based on a tutorial by Coding with John
    YouTube Link: https://www.youtube.com/watch?v=r_MbozD32eo
*/

// package MultiThreaded.Introduction;

// public class Main {
//     public static void main(String[] args) {
//         MultiThreading myThing = new MultiThreading(1);

//         MultiThreading myThing2 = new MultiThreading(2);

//         myThing.start();
//         /*
//          * creates a new thread and starts running run method
//          */

//         myThing2.start();
//     }
// }

// Implementing Runnable

public class Main {
    public static void main(String[] args) {
        MultiThreadingThing myThing = new MultiThreadingThing(1);
        Thread thread1 = new Thread(myThing);
        MultiThreadingThing myThing2 = new MultiThreadingThing(2);
        Thread thread2 = new Thread(myThing2);

        try {
            thread1.join();
            // Waits for this thread to die.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // thread1.start();
        /*
         * creates a new thread and starts running run method
         */

        thread2.start();
    }
}