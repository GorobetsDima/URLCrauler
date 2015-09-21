package parser;

import java.util.Set;

/**
 * Created by Дарья on 17.09.2015.
 */

public class ThreadCreator {
    public static void main(String[] args) {
        ThreadCreator.startThreads();
    }

    public static void startThreads (){

            Thread t = new Thread(new GetDeeperUrlConnect(), "t");
            t.start();

            try {
                t.join(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("All threads are dead, exiting main thread");



//        public static void startThreads (String threadName){
//
//
//            Thread t = new Thread(new GetDeeperUrlConnect(), String.format("%s :" + threadName, "Thread"));
//            t.start();
//
//            try {
//                t.join(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("All threads are dead, exiting main thread");
//        }

    }
}








