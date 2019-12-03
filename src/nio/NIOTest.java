package nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author maitentai
 * @version 1.0
 * @date 2019-09-16 14:38
 */
public class NIOTest {
    public static void main(String[] args) {
        File file = new File("/Users/gaorui/Desktop/a2.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileInputStream = new FileInputStream("/Users/gaorui/Desktop/a1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileChannel readchannel = fileInputStream.getChannel();
        FileChannel writechannel = fileOutputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true){
            buffer.clear();
            try {
                if (readchannel.read(buffer) == -1){
                    break;
                }
                buffer.flip();
                writechannel.write(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
