package me;

/**
 *
 * @author nhatt_000
 */
import java.io.*;
import javazoom.jl.player.*;
import javazoom.jl.decoder.JavaLayerException;

public class MP3 {

    private Player player;
    private String filename;

    public MP3(String filename) {
        this.filename = filename;
    }

    public void stop() {
        if (player != null) {
            player.close();
        }
    }

    public void play() {
        try {
            BufferedInputStream bis = new BufferedInputStream(getClass().getResourceAsStream(filename));
//            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filename));
            player = new Player(bis);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    player.play();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        //        MP3 mp3 = new MP3("/JAVESE/Caro/src/me/1.MP3");
//        MP3 mp3 = new MP3("/me/1.MP3");
//        Thread t = new Thread() {
//            public void run() {
//                while (true) {
//                    mp3.play();
//                    try {
//                        sleep(108000);
//                    } catch (InterruptedException ex) {
//                        
//                    }
//                }
//            }
//        };
        //       t.start();
    }
}
