
public class Jogador {
	
	private String nome;
	private int pontos;
	
	public Jogador(String nome) {
		this.nome = nome;
		pontos = 0;
	}
	
	public void setPontos() {
		pontos++;
	}
	
	public int getPontos() {
		return pontos;
	}	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return  getNome() + "!! Com " + getPontos() + " ponto(s).";
	}
}
