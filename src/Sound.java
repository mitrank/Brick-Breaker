import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	
	Clip clip;
	public void setFile(String soundFileName)
	{
		try 
		{
			File file = new File(soundFileName);
			AudioInputStream sound = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(sound);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	public void play()
	{
		clip.setFramePosition(0);
		clip.start(); 
	}
	
}
