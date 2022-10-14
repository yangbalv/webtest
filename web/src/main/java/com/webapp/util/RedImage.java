package com.webapp.util;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class RedImage {
    public static void main(String args[]) throws IOException {
        BufferedImage img = null;
        File f = null;

        try {
            f = new File("web/src/main/resources/aaa.jpg");
            img = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int width = img.getWidth();
        int height = img.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);

                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;

                p = (a << 24) | (r << 16) | (0 << 8) | 0;

                img.setRGB(x, y, p);
            }
        }
        try {
            f = new File("web/src/main/resources/ddd.jpg");
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
} 