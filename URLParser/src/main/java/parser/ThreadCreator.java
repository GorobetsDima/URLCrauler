package parser;

import java.util.Set;

/**
 * Created by Dmitriy Gorobets.
 */

public class ThreadCreator {

    public static void startThreads (){


        public static void startThreads (String threadName){


            Thread t = new Thread(new GetDeeperUrlConnect(), String.format("%s :" + threadName, "Thread"));
            t.start();

            try {
                t.join(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("All threads are dead, exiting main thread");
       }

    }
}








