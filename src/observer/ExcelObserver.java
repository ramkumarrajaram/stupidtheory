package observer;

public class ExcelObserver implements FileObserver {
    @Override
    public void notifyJob() {
        System.out.println("I am going to create an .xls file");
    }
}
