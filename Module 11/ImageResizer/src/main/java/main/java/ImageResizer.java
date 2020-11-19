package main.java;
import com.google.common.io.Files;
import org.imgscalr.Scalr;
import static org.imgscalr.Scalr.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageResizer implements Runnable {
    private File[] files;
    private String dstFolder;
    private long start;
    private static int targetSize = 300;

    public ImageResizer(File[] files, String dstFolder, long start) {
        this.files = files;
        this.dstFolder = dstFolder;
        this.start = start;
    }

    @Override
    public void run() {
        try
        {
            for(File file : files)
            {
                BufferedImage image = ImageIO.read(file);
                if(image == null) {
                    continue;
                }
                BufferedImage newImage = createThumbnail(image, targetSize);
                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, Files.getFileExtension(newFile.getName()), newFile);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }
    public static BufferedImage createThumbnail(BufferedImage img, int targetSize) {
        img = resize(img, Method.ULTRA_QUALITY, targetSize);
        return pad(img, 4);
    }
}
