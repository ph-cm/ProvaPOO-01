package pacote;

import java.util.List;
import java.util.Scanner;

public class Principal {

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opc = -1;
		Biblioteca biblioteca = new Biblioteca();
		Usuario usuarios = null;
		
		
		
		do {
			System.out.println("------MENU------");
			System.out.println("1)Pagina do Usuario");
			System.out.println("2)Pagina da biblioteca");
			System.out.println("0)Voltar");
			opc = sc.nextInt();
			
			switch(opc) {
			case 1: 
				mostrarPagUsuario(biblioteca , sc , usuarios);
				break;
			case 2: 
				mostrarPagBiblioteca(biblioteca ,  sc );
			}
		}while(opc != 0);
	}
	public static void mostrarPagUsuario(Biblioteca biblioteca , Scanner sc , Usuario usuario) {
		int aux = -1;
		String nome;
		
		System.out.println("Digite o nome do usuario: ");
		nome = sc.next();
		
		Usuario usuario1 = encontrarUsuario(biblioteca , nome);
		
		if (usuario1 == null ) {
			System.out.println("Nao foi encontrado usuario com esse nome");
		}
		do {
			System.out.println("--PAGINA DO USUARIO--");
			System.out.println("1)-Fazer Emprestimo");
			System.out.println("2)-Fazer Devolução");
			System.out.println("3)-Verificar Livros Disponíveis");
			System.out.println("4)-Exibir Seus Livros Emprestados");
			System.out.println("0)-voltar para o menu");
			aux = sc.nextInt();
			
			switch(aux) {
			case 1: 
				
				fazerEmprestimo(biblioteca , sc , usuario1);
				
				break;
			case 2 : 
				
				fazerDevolucao(biblioteca , sc , usuario1);
				
				break;
			case 3: 
				biblioteca.exibirTodosLivrosDisponiveis();
				break;
			case 4: 
				usuario1.exibirLivrosEmprestados();
				break;
			case 0 : 
				System.out.println("Voltando. . .");
				break;
				default :
				System.out.println("Opcão inválida");
				break;
			}
		}while(aux != 0 );
	}
	
	
	public  static void fazerEmprestimo(Biblioteca biblioteca , Scanner sc , Usuario usuario) {
		String titulo;
		
		if(usuario.getLivroEmprestado().size() >= 3) {
			System.out.println("Cota de livros emprestados atingida");
			return;
		}
		System.out.println("Título: ");
		titulo = sc.next();
		
		Livro livro = encontrarLivro(biblioteca , titulo);
		if(livro == null) {
			System.out.println("Livro não disponível");
		}
		biblioteca.emprestarLivro(usuario , livro);
		biblioteca.getLivroDisponivel().remove(livro);
		System.out.println("Livro: " + livro.getTitulo() + " emprestado para " + usuario.getNome());
		
	}
	
	public static void fazerDevolucao(Biblioteca biblioteca , Scanner sc , Usuario usuario) {
		String titulo;
		
		System.out.println("Título: ");
		titulo = sc.next();
		
		Livro livro = encontrarLivroDevolucao(usuario , titulo);
		
		biblioteca.devolverLivro(usuario, livro);
		biblioteca.getLivroDisponivel().add(livro);
		System.out.println("Livro: " + livro.getTitulo() + " devolvido por " + usuario.getNome());
		
	}
	public static Livro encontrarLivroDevolucao(Usuario usuario , String titulo) {
		 List<Livro> livrosEmprestados = usuario.getLivroEmprestado();
	        
	        for (Livro livro : livrosEmprestados) {
	            if (livro.getTitulo().equals(titulo)) {
	                return livro;
	            }
	        }
	        return null;
	    
	}
	
	public static Livro encontrarLivro(Biblioteca biblioteca , String titulo){
		List<Livro> livroDisponivel = biblioteca.getLivroDisponivel();
		
		for(Livro livro : livroDisponivel) {
			if(livro.getTitulo().equals(titulo)) {
				return livro;
			}
		}
		return null;
	}
	
	public static Usuario encontrarUsuario(Biblioteca biblioteca , String nome) {
		List<Usuario> usuario = biblioteca.getUsuario();
		
		for(Usuario usuarios : usuario) {
			if(usuarios.getNome().equals(nome)) {
				return usuarios;
			}
		}
		return null;
	}
	
	
	
	
	
	public static void mostrarPagBiblioteca(Biblioteca biblioteca , Scanner sc ) {
		int aux = -1;

		do {
			System.out.println("--MENU DA BIBLIOTECA--");
			System.out.println("1)-Adicionar livro");
			System.out.println("2)-Inserir Usuário");
			System.out.println("3)-Verificar usuarios com livros emprestados");
			System.out.println("4)-Verificar acervo de livros");
			System.out.println("0)-Voltar");
			aux = sc.nextInt();
			
			switch(aux) {
			
			case 1:
				adicionarLivro(biblioteca , sc);
				break;
			
			case 2: 
				inserirUsuario(biblioteca , sc);
				break;
			case 3 : 
				
				biblioteca.verificarUsuarioComLivro();
				break;
				
			case 4: 
				biblioteca.exibirTodosLivrosDisponiveis();
				break;
			
			case 0: 
				System.out.println("Voltando . . .");
				break;
				default:
					System.out.println("Opção inválida");
					break;
			}
		}while(aux != 0 );
	}
	
	
	public static void adicionarLivro(Biblioteca biblioteca , Scanner sc) {
		String titulo , autor ; 
		int numDePaginas;
		
		System.out.println("Título: ");
		titulo = sc.next();
		System.out.println("Autor: ");
		autor = sc.next();
		System.out.println("Número de Páginas: ");
		numDePaginas = sc.nextInt();
		
		Livro livro = new Livro(titulo , autor , numDePaginas);
		
		biblioteca.adicionarLivro(livro);
		System.out.println("Livro Adicionado");
	}
	
	
	public static Usuario inserirUsuario(Biblioteca biblioteca , Scanner sc ) {
		String nome ;
		int idade;
		
		System.out.println("Nome: ");
		nome = sc.next();
		System.out.println("Idade: ");
		idade = sc.nextInt();
		
		Usuario usuario = new Usuario(nome , idade);
		
		biblioteca.adicionarUsuario(usuario);
		System.out.println("Usuario adicionado");
		
		return usuario;
		
	}
	
		
	
}
