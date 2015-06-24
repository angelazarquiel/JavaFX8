package ej02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Blog {

	private ArrayList<Post> posts;

	public Blog() {
		this.posts = new ArrayList<Post>();
	}

	public Post getPost(int i) {
		return posts.get(i);
	}

	public void addPosts(Post post) {
		this.posts.add(post);
	}

	public List<Post> getOrderedPosts() {
		
		ArrayList<Post> ordered=new ArrayList<Post>(this.posts);
		/*
		ordered.sort(new Comparator<Post>(){
			   @Override
			   public int compare(final Post lhs,Post rhs) {
				  if (lhs.getPopularidad()>rhs.getPopularidad())
					  return -1;
				  else if (lhs.getPopularidad()<rhs.getPopularidad())
					  return 1;
				  else 
					 return 0;
			     }
			 });
		*/
		ordered.clear();
		for(Post p:this.posts){
			int i;
			for(i=0;i<ordered.size() && ordered.get(i).getPopularidad()>p.getPopularidad();i++);
			ordered.add(i,p);
		}
		return ordered;
	}
	
	public List<Post> buscarPostsAutor(String Autor) {
		ArrayList<Post> postsAutor=new ArrayList<Post>();
		
		for(Post p:this.posts)
		  if (p.getAutor().equals(Autor))
		  	postsAutor.add(p);
		
		return postsAutor;
	}
	
	public List<Post> buscarPostsPalabras(List<String> palabras) {
		ArrayList<Post> postsPalabras=new ArrayList<Post>();
		
		for(Post p:this.posts)
			for(String s:palabras)
		  		if (p.getTitulo().indexOf(s)>=0) {
		  			postsPalabras.add(p);
		  			continue;
		  		}
		
		return postsPalabras;
	}
	
	public static void main(String[] args) {
		Blog b=new Blog();
		Post p;
		
		b.addPosts(new Post("uno","uno"));
		p=new Post("dos","dos");
		p.aumentarPopularidad(20);
		b.addPosts(p);
		p=new Post("tres","tres");
		p.aumentarPopularidad(40);
		b.addPosts(p);
		
		System.out.println(b.getOrderedPosts());
	}
	
}
