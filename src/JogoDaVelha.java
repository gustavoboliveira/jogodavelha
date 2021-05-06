
public class JogoDaVelha {

	private char [][] tabuleiro;

	public JogoDaVelha(int n) {
		this.tabuleiro =  new char[n][n];
	}
	
	public boolean realizaJogada(int i, int j, char jogada) {
		if(tabuleiro[i][j] == 'x' || tabuleiro[i][j] == 'o') {
			return false;
		} else {
			tabuleiro[i][j] = jogada;
			return true;
		}
		
	}
	
	public boolean verificaGanhador() {
		
		int c = 0;
		int dX1 = 0;
		int dO1 = 0;
		int dX2 = 0;
		int dO2 = 0;
		int lX = 0;
		int lO = 0;
		int cX = 0;
		int cO = 0;
		
		for(int l = 0; l < tabuleiro.length; l++) {
			
			c = 0;
			lX = 0;
			lO = 0;
			cX = 0;
			cO = 0;
			
			if(tabuleiro[l][l] == 'x') {
				dX1++;
			}
			if(tabuleiro[l][l] == 'o') {
				dO1++;
			}
			if(tabuleiro[l][((tabuleiro.length - 1) - l)] == 'x') {
				dX2++;
			}
			if(tabuleiro[l][((tabuleiro.length - 1) - l)] == 'o') {
				dO2++;
			}
			while(c < tabuleiro.length) {
				if(tabuleiro[l][c] == 'x') {
					lX++;
				}
				if(tabuleiro[l][c] == 'o') {
					lO++;
				}
				if(tabuleiro[c][l] == 'x') {
					cX++;
				}
				if(tabuleiro[c][l] == 'o') {
					cO++;
				}
				if(lX == tabuleiro.length || lO == tabuleiro.length || cX == tabuleiro.length || cO == tabuleiro.length) {
					return true;
				}
				c++;
			}
		}
		if(dX1 == tabuleiro.length || dO1 == tabuleiro.length || dX2 == tabuleiro.length || dO2 == tabuleiro.length) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		
		String tab = "";
		for(int a = 0; a < tabuleiro.length; a++) {
			for(int b = 0; b < tabuleiro.length; b++) {
				if(b == (tabuleiro.length - 1)) {
					tab += tabuleiro[a][b] + "\n";
				} 
				else {
					tab += tabuleiro[a][b] +  " | ";
				}
			}
		}
		return tab;
	}
}
