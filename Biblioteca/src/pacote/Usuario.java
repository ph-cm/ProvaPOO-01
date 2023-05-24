package pacote;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nome;
	private int idade;
	private List<Livro> livroEmprestado;
	
	public Usuario(String nome , int idade ) {
		this.nome = nome;
		this.idade = idade;
		this.livroEmprestado = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}
	public int getIdade() {
		return idade;
	}
	public List<Livro> getLivroEmprestado() {
		return livroEmprestado;
	}
	 public void emprestarLivro(Livro livro) {
	        livroEmprestado.add(livro);
	    }
	
	public void exibirLivrosEmprestados() {
        if (livroEmprestado.isEmpty()) {
            System.out.println("Você não possui livros emprestados.\n");
            return;
        }
        for (Livro livro : livroEmprestado) {
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Número de páginas: " + livro.getNumeroDePagina());
            System.out.println();
        }
    }
}
