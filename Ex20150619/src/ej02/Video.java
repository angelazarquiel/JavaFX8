package ej02;

public class Video extends Post {

	private String urlVideo;

	public Video(String titulo, String autor, String urlVideo) {
		super(titulo, autor);
		this.urlVideo=urlVideo;
	}

	public String getUrlVideo() {
		return urlVideo;
	}

	@Override
	public String toString() {
		return "Video: " + urlVideo + super.toString();
	}
	
	

}
