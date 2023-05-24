package pacote;

public class Livro {
	private String titulo;
	private String autor;
	private int numeroDePagina;
	
	
	
	public Livro(String titulo , String autor , int numeroDePagina) {
		this.titulo = titulo;
		this.autor = autor;
		this.numeroDePagina = numeroDePagina;
	}


	public String getTitulo() {
		return titulo;
	}


	public String getAutor() {
		return autor;
	}


	public int getNumeroDePagina() {
		return numeroDePagina;
	}

	
}
