package ej02;

public class URL extends Post{

	private String url;

	public URL(String titulo, String autor, String url) {
		super(titulo, autor);
		this.url=url;
	}

	public String getUrl() {
		return url;
	}

	@Override
	public String toString() {
		return "URL: " + url + super.toString();
	}

}
