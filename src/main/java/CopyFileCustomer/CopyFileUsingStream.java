package CopyFileCustomer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyFileUsingStream {
    private void copyFile(File source, File desk) throws IOException {
        FileInputStream is = null;
        FileOutputStream os = null;

        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(desk);
            byte[] buffer = new byte[1024];
            int lenght;
            while ((lenght = is.read(buffer))>0) {
                os.write(buffer,0,lenght);
            }
            System.out.println("Copy thanh cong.");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner scn = new Scanner(System.in);

        System.out.println("Nhap vao file can copy: ");
        String soucrePath = scn.nextLine();
        System.out.println("Nhap vao file ban can copy den: ");
        String deskPath = scn.nextLine();

        File source = new File(soucrePath);
        File desk = new File(deskPath);

        CopyFileUsingStream copy = new CopyFileUsingStream();
        copy.copyFile(source, desk);
//        desk: .\src\main\resources\n.txt
//        sources: .\src\main\resources\m.txt
    }
}
