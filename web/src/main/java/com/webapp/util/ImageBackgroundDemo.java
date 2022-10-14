package com.webapp.util;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

public class ImageBackgroundDemo {

    public static void main(String[] args) throws Exception {

//指定的图片路径

        FileInputStream dir = new FileInputStream("web/src/main/resources/aaa.jpg");

//新建一个长度为3的数组，负责保存rgb的值

        int[] rgb = new int[3];

//通过ImageIO.read()方法来返回一个BufferedImage对象，可以对图片像素点进行修改

        BufferedImage bImage = ImageIO.read(dir);

//获取图片的长宽高

        int width = bImage.getWidth();

        int height = bImage.getHeight();

        int minx = bImage.getMinTileX();

        int miny = bImage.getMinTileY();

//遍历图片的所有像素点，并对各个像素点进行判断，是否修改

        for (int i = minx; i < width; i++) {

            for (int j = miny; j < height; j++) {

                int pixel = bImage.getRGB(i, j);

//获取图片的rgb

                rgb[0] = (pixel & 0xff0000) >> 16;

                rgb[1] = (pixel & 0xff00) >> 8;

                rgb[2] = (pixel & 0xff);

//进行判断，如果色素点在指定范围内，则进行下一步修改

                if (rgb[0] < 30 && rgb[0] > 0 && rgb[1] < 255 && rgb[1] > 0 && rgb[2] < 30 && rgb[2] > 0) { //修改像素点，0x007ABB是证件照的蓝色背景色

                    bImage.setRGB(i, j, 0x007ABB);

                }

            }

        }

//输出照片保存在本地

        FileOutputStream ops;

        try {

            ops = new FileOutputStream(new File("web/src/main/resources/ccc.jpg"));

//这里写入的“jpg”是照片的格式，根据照片后缀有所不同

            ImageIO.write(bImage, "jpg", ops);

            ops.flush();

            ops.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }

    }

}
