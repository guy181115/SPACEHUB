/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import sun.audio.AudioData;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


public class Music {
    Clip clip;
    AudioData data;
    public void setFile (String s){

        try {
            File file = new File(s);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        }
        catch (Exception e){

        }

    }

    public void play(){
        if (clip==null) System.out.println("not found!!!");
        clip.setFramePosition(0);
        clip.start();

    }
}
