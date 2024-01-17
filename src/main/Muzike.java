package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Muzike {
	
	Clip clip;
	
	URL muzikeURL[] = new URL[30];
	
	public Muzike() {

		muzikeURL[0] = getClass().getResource("/muzike/MbledhThesaret.wav");
		muzikeURL[1] = getClass().getResource("/muzike/MuzikeBackgroundi.wav");
		muzikeURL[2] = getClass().getResource("/muzike/MuzikeEndPage.wav");
		
	}
	
	public void setFile(int i) {
		
		try {
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(muzikeURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			
		} catch(Exception e) {
			
		}
	}
	public void play() {
		
		clip.start();
	}
	public void loop() {
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	public void stop() {
		
		clip.stop();
	}

}
