package kvolkov.java.lectures.designpatterns.structural;

/**
 * This is an example of Adapter structural pattern.
 * 
 * @author Kirill Volkov (vulkovk@gmail.com) https://github.com/vulko
 *
 */
public class AdapterExample {

	public interface MediaPlayer {
		void play(String filename);
	}

	public interface MediaPackage {
		void playFile(String filename);
	}

	public static class MP3 implements MediaPlayer {
		@Override
		public void play(String filename) {
			System.out.println("Playing MP3 File " + filename);
		}
	}

	public static class MP4 implements MediaPackage {
		@Override
		public void playFile(String filename) {
			System.out.println("Playing MP4 File " + filename);
		}
	}

	public static class VLC implements MediaPackage {
		@Override
		public void playFile(String filename) {
			System.out.println("Playing VLC File " + filename);
		}
	}

	public static class FormatAdapter implements MediaPlayer {
		private MediaPackage media;

		public FormatAdapter(MediaPackage m) {
			media = m;
		}

		@Override
		public void play(String filename) {
			System.out.print("Playing through adapter --> ");
			media.playFile(filename);
		}
	}

	public static void execute() {
		MediaPlayer player = new MP3();
		player.play("mp3file.mp3");
		player = new FormatAdapter(new MP4());
		player.play("mp4file.mp4");
		player = new FormatAdapter(new VLC());
		player.play("videofile.avi");
	}

}
