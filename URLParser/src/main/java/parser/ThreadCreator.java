package parser;

import java.util.Set;

/**
 * Created by Дарья on 17.09.2015.
 */

public class ThreadCreator {

    public static void startThreads(Set<String> links) {

        for (int numOfThrads = 0; numOfThrads < links.size(); numOfThrads++) {

            if (links.iterator().hasNext()) {
                Thread t = new Thread(new GetDeeperUrlConnect(), String.format("%s %d :" + links.iterator().next(), "Thread", numOfThrads));
                t.start();

                try {
                    t.join(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("All threads are dead, exiting main thread");
    }

}




