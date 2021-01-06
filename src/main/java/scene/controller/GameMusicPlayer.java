package scene.controller;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * The GameMusicPlayer plays music when a game starts and stop music when a game stops.
 * 
 * @author Zewei Zhou
 *
 */
public class GameMusicPlayer {
	
	/**
	 * The media player.
	 */
	private MediaPlayer mediaPlayer;
	
	/**
	 * The file path of the music.
	 */
	private String musicFile;

	/**
	 * Sets up media player with default music file.
	 */
	public GameMusicPlayer() {
		setMusicFile("src/main/resources/Frogger Main Song Theme (loop).mp3");
		Media sound = new Media(new File(musicFile).toURI().toString());
		this.mediaPlayer = new MediaPlayer(sound);
		this.mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	}
	
	/**
	 * Sets media player with specific music file.
	 * 
	 * @param musicFile music file address
	 */
	public GameMusicPlayer(String musicFile) {
		setMusicFile(musicFile);
		Media sound = new Media(new File(musicFile).toURI().toString());
		this.mediaPlayer = new MediaPlayer(sound);
		this.mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	}
	
	/**
	 * Gets music file address.
	 * 
	 * @return music file address
	 */
	public String getMusicFile() {
		return musicFile;
	}

	/**
	 * Sets music file.
	 * 
	 * @param musicFile address of the music file
	 */
	public void setMusicFile(String musicFile) {
		this.musicFile = musicFile;
	}
	
	/**
	 * Plays the background music.
	 */
	public void playMusic() {
	    mediaPlayer.play();
	}
	
	/**
	 * Stops the background music.
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}
	
	/**
	 * Acts (doing nothing) in every frame
	 * 
	 * @param now the current time
	 */
	public void act(long now) {
		
	}
}
