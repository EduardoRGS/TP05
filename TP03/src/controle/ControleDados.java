package controle;

import modelo.*;

public class ControleDados {
	private Dados d = new Dados();
	
	
	public ControleDados() {
		d.GerarDados();
	}
	public Dados getDados() {
		return d;
	}

	public void setDados(Dados d) {
		this.d = d;
	}
	public Livro[] getLivros() {
		return this.d.getLivros();
	}

	public int getQtdLivros() {
		return this.d.getQtdLivros();
	}
	public Usuario[] getUsuarios() {
		return this.d.getUsuarios();
	}
	public int getQtdUsuarios() {
		return this.d.getQtdUsuarios();
	}
	
	public boolean inserirEditarLivro(String[] dadosLivros) {
		Livro l = new Livro(dadosLivros[1], dadosLivros[2]);
		
		d.inserirEditarLivro(l, Integer.parseInt(dadosLivros[0]));
		return true;
		
	}
	
	public boolean removeLivro(int i) {
		int qtdLivros = d.getQtdLivros();
		String livroRemovido = d.getLivros()[i].getNome();
		String aux;
		for(int j = 0; j < 1; j++) {
			aux = d.getLivro()[j].getNome();
			if(livroRemovido.compareTo(aux) == 0)
				return false;
		}
		
		if(i == (d.getQtdLivros() - 1)) {
			d.setQtdLivros(getQtdLivros() - 1);
			d.getLivros()[d.getQtdLivros()] = null;
			return true;
			
		} else {
			int cont = 0;
			while(d.getLivros()[cont].getNome().compareTo(livroRemovido) != 0) {
				cont++;
			}
			for(int j = cont; j < d.getQtdLivros(); j++) {
				d.getLivros()[j] = null;
				d.getLivros()[j] = d.getLivros()[j+1];
			
			}
			d.getLivros()[d.getQtdLivros()] = null;
			d.setQtdLivros(d.getQtdLivros() - 1);
			return true;
		}
	}
	public int pesquisa(String nomeLivro) {
		int posicao = -1;
		
		
		for(int i = 0; i < d.getQtdLivros(); i++) {
			if(d.getLivro()[i].getNome().compareTo(nomeLivro) == 0) 
					return posicao;
					System.out.println(d.getLivros()[i].getNome());
					System.out.println("Livro Pesquisado =  "+nomeLivro);
			
			
		}
		System.out.println("qtd = "+d.getQtdLivros());
		System.out.println("Livro Pesquisado =  "+nomeLivro);
		System.out.println(posicao);
		return posicao;	 
		
	}
	
	public boolean inserirEditarUsuario(String[] dadosUsuario) {
		Usuario u = new Usuario(dadosUsuario[1]);
		
		d.inserirEditarUsuario(u, getQtdUsuarios());
		return true;
	}
	public boolean removeUsuario(int i) {
		int qtdUsuario = d.getQtdUsuarios();
		String userRemovido = d.getUsuarios()[i].getNomeUsuario();
		String aux;
		for(int j = 0; j < 1; j++) {
			aux = d.getUsuarios()[j].getNomeUsuario();
			if(userRemovido.compareTo(aux) == 0)
				return false;
		}
		
		if(i == (d.getQtdUsuarios() - 1)) {
			d.setQtdUsuarios(getQtdUsuarios() - 1);
			d.getUsuarios()[d.getQtdUsuarios()] = null;
			return true;
			
		} else {
			int cont = 0;
			while(d.getUsuarios()[cont].getNomeUsuario().compareTo(userRemovido) != 0) {
				cont++;
			}
			for(int j = cont; j < d.getQtdUsuarios(); j++) {
				d.getUsuarios()[j] = null;
				d.getUsuarios()[j] = d.getUsuarios()[j+1];
			
			}
			d.getUsuarios()[d.getQtdUsuarios()] = null;
			d.setQtdUsuarios(d.getQtdUsuarios() - 1);
			return true;
		}
	}
}
