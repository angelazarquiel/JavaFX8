package ej02;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Post {
	private String titulo;
	private String autor;
	private Date fecha;
	private ArrayList<String> comentarios;
	private int popularidad;
	
	public Post(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
		this.fecha = new Date();
		this.popularidad=0;
		comentarios=new ArrayList<String>();
	}

	public List<String> getComentarios() {
		return comentarios;
	}

	public void añadirComentario(String comentario) {
		this.comentarios.add(comentario);
	}

	public int getPopularidad() {
		return popularidad;
	}

	public void aumentarPopularidad(int incremento) {
		this.popularidad += incremento;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public Date getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		
		StringBuilder res;
		
		res=new StringBuilder(String.format("%d %s\n\t%s-%s\n",
				popularidad, titulo, autor,
				DateFormat.getDateInstance(DateFormat.SHORT).format(fecha)));
		
		if (!comentarios.isEmpty()) res.append("\tComentarios:\n");
		for(String s:comentarios)
			res.append("\t"+s+"\n");
		
		
		return res.toString();
	}
	
	public static void main(String[] args) {
		Post p=new Post("Hola Post","Angel");
		
		p.añadirComentario("Muy Bién");
		System.out.println(p);
	}
}
