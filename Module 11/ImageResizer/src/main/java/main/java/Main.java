package main.java;
import java.io.File;

public class Main
{
    public static void main(String[] args)
    {
        String srcFolder = "D:/images";
        String dstFolder = "D:/imageResizer";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();
        int part = files.length/Runtime.getRuntime().availableProcessors();
        File[] files1 = new File[part];
        System.arraycopy(files, part * 0, files1, 0, files1.length);
        ImageResizer resizer1 = new ImageResizer(files1, dstFolder, start);
        new Thread(resizer1).start();

        File[] files2 = new File[part];
        System.arraycopy(files, part * 1, files2, 0, files2.length);
        ImageResizer resizer2 = new ImageResizer(files2, dstFolder, start);
        new Thread(resizer2).start();

        File[] files3 = new File[part];
        System.arraycopy(files, part * 2 , files3, 0, files3.length);
        ImageResizer resizer3 = new ImageResizer(files3, dstFolder, start);
        new Thread(resizer3).start();

        File[] files4 = new File[part];
        System.arraycopy(files, part * 3, files4, 0, files4.length);
        ImageResizer resizer4 = new ImageResizer(files4, dstFolder, start);
        new Thread(resizer4).start();

        File[] files5 = new File[part];
        System.arraycopy(files, part * 4, files5, 0, files5.length);
        ImageResizer resizer5 = new ImageResizer(files5, dstFolder, start);
        new Thread(resizer5).start();

        File[] files6 = new File[part];
        System.arraycopy(files, part * 5, files6, 0, files6.length);
        ImageResizer resizer6 = new ImageResizer(files6, dstFolder, start);
        new Thread(resizer6).start();

        File[] files7 = new File[part];
        System.arraycopy(files, part * 6, files7, 0, files7.length);
        ImageResizer resizer7 = new ImageResizer(files7, dstFolder, start);
        new Thread(resizer7).start();

        File[] files8 = new File[part];
        System.arraycopy(files, part * 7, files8, 0, files8.length);
        ImageResizer resizer8 = new ImageResizer(files8, dstFolder, start);
        new Thread(resizer8).start();

        File[] files9 = new File[part];
        System.arraycopy(files, part * 8, files9, 0, files9.length);
        ImageResizer resizer9 = new ImageResizer(files9, dstFolder, start);
        new Thread(resizer9).start();

        File[] files10 = new File[part];
        System.arraycopy(files, part * 9, files10, 0, files10.length);
        ImageResizer resizer10 = new ImageResizer(files10, dstFolder, start);
        new Thread(resizer10).start();

        File[] files11 = new File[part];
        System.arraycopy(files, part * 10, files11, 0, files11.length);
        ImageResizer resizer11 = new ImageResizer(files11, dstFolder, start);
        new Thread(resizer11).start();

        File[] files12 = new File[part];
        System.arraycopy(files, part * 11, files12, 0, files12.length);
        ImageResizer resizer12 = new ImageResizer(files12, dstFolder, start);
        new Thread(resizer12).start();
    }
}
