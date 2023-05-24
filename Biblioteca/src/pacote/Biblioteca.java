package pacote;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
	
	private List<Livro> livroDisponivel;
	private List<Usuario> usuarios;
	public Scanner sc = new Scanner(System.in);
	public Biblioteca() {
		this.livroDisponivel = new ArrayList<>();
		this.usuarios = new ArrayList<>();
	}

	public List<Livro> getLivroDisponivel() {
		return livroDisponivel;
	}

	public List<Usuario> getUsuario(){
		return usuarios;
	}
	
	
	public void adicionarLivro(Livro livro) {
		livroDisponivel.add(livro);
	}
	
	public void adicionarUsuario(Usuario usuario) {
		
		usuarios.add(usuario);
		/*System.out.println("Usuario Adicionado" );
		System.out.println("Nome: " + usuario.getNome());
		System.out.println("Idade: " + usuario.getIdade());
		System.out.println();*/
		
	}
	
	//EMPRESTAR
	public void emprestarLivro(Usuario usuario,Livro livro) {
		if(livroDisponivel.size() > 3) {
			System.out.println("O usuário atingiu o limite de empréstimo");
			return;
		}
		
		if(!livroDisponivel.contains(livro)) {
			System.out.println("O livro" + livro.getTitulo() + " não esta disponível na biblioteca");
			return;
		}
		
		if(usuario.getLivroEmprestado().contains(livro)) {
			System.out.println("O usuario possui o livro: " + livro.getTitulo());
			return;
		}
		usuario.getLivroEmprestado().add(livro);
		livroDisponivel.remove(livro);
		System.out.println("Livro : " + livro.getTitulo() + " emprestado para " + usuario.getNome());
	}
	
	//DEVOLVER
	public void devolverLivro(Usuario usuario , Livro livro) {
		if(usuario.getLivroEmprestado().remove(livro)) {
			System.out.println("O livro: " + livro.getTitulo() + " foi devolvido");
		}
		else {
			System.out.println("O usuario " + usuario.getNome() + " não possui o livro");
		}
	}
	
	//VERIFICAR SE TEM(TRUE/FALSE)
	public boolean verificarDisponibilidadeLivro(Livro livro) {
		return livroDisponivel.contains(livro);
	}
	//MOSTRAR TODOS DISPONIVEIS
	public void exibirTodosLivrosDisponiveis() {
		if(livroDisponivel.isEmpty()) {
			System.out.println("Não há livros disponíveis");
		}else {
			System.out.println("Livros disponíveis:");
			for(Livro l : livroDisponivel) {
				System.out.println("Titulo: " + l.getTitulo());
			}
		}
	}
	//VER QUEM TEM LIVRO
	public void verificarUsuarioComLivro() {
		List<Usuario> usuarioComLivro = new ArrayList<>();
		
		for(Usuario usuario : usuarios) {
			if(!usuario.getLivroEmprestado().isEmpty()) {
				usuarioComLivro.add(usuario);
			}
		
			if(usuario.getLivroEmprestado().isEmpty()) {
				System.out.println("Não há usuarios com livro");
			}
		}
			System.out.println("Usuarios que pegaram livros emprestados:");
			for(Usuario usuario : usuarios) {
				System.out.println("Nome: " + usuario.getNome() + " , Idade: " + usuario.getIdade());
			}
		}
	public Livro buscarLivroDisponivelPorTitulo(String titulo) {
        for (Livro livro : livroDisponivel) {
            if (livro.equals(livroDisponivel) && livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }
        return null;
    }
}
