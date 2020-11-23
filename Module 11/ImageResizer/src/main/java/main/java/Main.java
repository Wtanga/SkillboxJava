package main.java;
import java.io.File;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws InterruptedException {
        String srcFolder = "D:/images";
        String dstFolder = "D:/imageResizer";
        ArrayList<Thread> threadList = new ArrayList<>();
        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();
        int amountOfThreads = Runtime.getRuntime().availableProcessors();
        int part = files.length/amountOfThreads;
        File[] files1 = new File[part];
        for(int i = 0; i < amountOfThreads;i++){
            System.arraycopy(files, part * i, files1, 0, files1.length);
            ImageResizer resizer = new ImageResizer(files1, dstFolder, start);
            Thread t = new Thread(resizer);
            threadList.add(t);
            t.start();
        }
        for(Thread t : threadList){
            t.join();
        }
    }
}
