package observer;

import java.util.ArrayList;
import java.util.List;

public class FileJob {

    public static void main(String args[]) {
        List<FileObserver> listOfObserversToBeNotified = new ArrayList();

        listOfObserversToBeNotified.add(new ExcelObserver());

        notifyObservers(listOfObserversToBeNotified);
    }

    private static void notifyObservers(List<FileObserver> listOfObserversToBeNotified) {

        for (FileObserver observer: listOfObserversToBeNotified) {
            observer.notifyJob();
        }
    }
}
