import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Bem-vindo ao Jogo da Velha!!\n");
		System.out.printf("Digite o nome do jogador 1: ");
		String n1 = sc.nextLine();
		System.out.printf("Digite o nome do jogador 2: ");
		String n2 = sc.nextLine();
		
		Jogador j1 = new Jogador(n1);
		Jogador j2 = new Jogador(n2);
		
		int end = 0;
		while (end == 0) {
		
			System.out.printf("\nDigite o tamanho do tabuleiro: ");
			int n = sc.nextInt();
			System.out.println();
		

			JogoDaVelha jdv = new JogoDaVelha(n);
		
			System.out.println("Vamos come�ar!!!\n"+ j1.getNome() +", voc� � 'x'.\n" + j2.getNome() +", voc� � 'o'.\nVoc�s devem digitar n�meros de 1 � " + n + "\n");
			char jogada = 'o';
			int count = 0;
			String nome = j2.getNome();
			while(count < (n*n)) {
				if(nome == j2.getNome()) {
					nome = j1.getNome();
				}
				else {
					nome = j2.getNome();
				}
				System.out.println(nome + ", vamos l�!");
				
				System.out.printf("Digite a linha que quer inserir: ");
				int linha = sc.nextInt() - 1;
				System.out.printf("Digite a coluna que quer inserir: ");
				int coluna = sc.nextInt() - 1;
				System.out.println();
				if (jogada == 'o') {
					jogada = 'x';
				}
				else {
					jogada = 'o';
				} 
				boolean jogOK = jdv.realizaJogada(linha, coluna, jogada);
				while(jogOK == false) {
					System.out.println("Ops, parece que essa posi��o j� est� sendo usada!!\nVamos tentar novamente...\n");
					System.out.printf("Digite a linha que quer inserir: ");
					linha = sc.nextInt() - 1;
					System.out.printf("Digite a coluna que quer inserir: ");
					coluna = sc.nextInt() - 1;
					System.out.println();
					boolean novaTent =  jdv.realizaJogada(linha, coluna, jogada);
					if(novaTent == true) {
						jogOK = true;
					}
				}
				if(jdv.verificaGanhador() == true) {
					if(jogada == 'x') {
						System.out.println(j1.getNome() + ", voc� ganhou! Parab�ns!!!!\n");
						j1.setPontos();
						count = n*n;
					}
					else {
						System.out.println(j2.getNome() + ", voc� ganhou! Parab�ns!!!!\n");
						j2.setPontos();
						count = n*n;
					}
				}
				System.out.println(jdv.toString() + "\n");
				count++;
			}
			sc.nextLine();
			System.out.println("Continuar jogando?");
			System.out.printf("Digite 'Sim' ou 'N�o': ");
			String seg = sc.nextLine();
			if(seg.equalsIgnoreCase("sim")) {
				end = 0;
			}
			else {
				end = 1;
			}
		}
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println();
		if(j1.getPontos() > j2.getPontos()) {
			System.out.println("E o vencedor �..........");
			System.out.println(j1.toString());
			System.out.println("Muito bom! Parab�ns");
		}
		else if(j1.getPontos() < j2.getPontos()) {
			System.out.println("E o vencedor �..........");
			System.out.println(j2.toString());
			System.out.println("Muito bom! Parab�ns");
		}
		else {
			System.out.println("Tivemos um empate, ambos mandaram muito bem!!!");
		}
		
		sc.close();
	}

}
