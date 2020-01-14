package com.example.newworkspace;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import static android.content.ContentValues.TAG;

public class Byte {
    public static void main(String[] args) {
        int [ ][ ]  arr={{22,15,32,20,18},{12,21,25,19,33},{14,58,34,24,66},};
        printArr1(arr);
    }
    //方法1
    public static void printArr1(int[][] arr) {
        for(int x=0; x<arr.length; x++) {
            for(int y=0; y<arr[x].length; y++) {
                System.out.print(arr[x][y]+" ");
            }
            System.out.println();
        }
    }
    //        写入
    FileOutputStream fileOutputStream;

    {
        try {
            fileOutputStream = new FileOutputStream("D://a.txt");
            fileOutputStream.write("123".getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            Log.e(TAG, "onCreate: 结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //读取
    File f = new File("D://a.txt");
    long length = f.length();
    FileInputStream fileInputStream;

    {
        try {
            fileInputStream = new FileInputStream(f);
            int l = 0;
            StringBuffer str = new StringBuffer();
            byte[] by = new byte[Integer.parseInt(length+"")];
            while ((l = fileInputStream.read(by))!= -1){
                String s = new String(by, 0, l);
                str.append(s);
            }
            String s = str.toString();
            System.out.println(s);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
