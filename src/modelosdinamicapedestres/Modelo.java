package modelosdinamicapedestres;

import java.util.ArrayList;
import java.util.HashMap;

public class Modelo {
    static int qtd_pedestres; 
    static double taxa_obstaculos;
    static int seed;
    
    public static void main(String[] args) throws InterruptedException {
        String arq = "mapa-vazio-25-pedestres.txt"; // arquivo contendo o mapa da simulação e parametros
        
        Simulacao S = null;
        S = LeituraArquivo.ler(arq);
        
        int l = S.l; // quantidade de linhas
        int c = S.c; // quantidades de colunas 
        int p = S.p, p2 = 0; // quantidade de pedestres
        int s = S.s; // quantidade de saidas;
        int o = S.o; // quantidade de objetos transponiveis;
        
        qtd_pedestres = S.p; // quantidade de pedestres que ainda estão dentro da sala
        int qtd_passos = 0; // quantos passos de tempo levaram para todos os pedestres sairem
        
        double n = S.n; // distancia entre celulas
        double lambda = S.lambda; // taxa da diagonal
        taxa_obstaculos = S.transponiveis; // taxa de objetos transponiveis
        
        boolean rodarMapas = true; // True ira mostrar a simulacao, enquanto False so contara passos
        boolean ligaObstaculos = true;
        //seed = 2;
       
        for(int i = 0; i < s; i++){
            PisoSemDiagonais.calculoField(S.reticulado, S.posicaoSaidas[i][0], S.posicaoSaidas[i][1], l, c, n, lambda);
        } 
        Auxiliares.mostraReticulado(S.reticulado, l, c);
        
        int[][] semPedestres = new int[l][c];
        Auxiliares.copiaReticuladoSemPedestres(S.pessoas, semPedestres, l, c); 
        
        // Hashmap para sortear em caso de dois pedestres desejarem ir para a mesma celula
        HashMap<Integer, ArrayList<Integer>> sorteio = new HashMap<>();
        
        // Vetor com emojis para a funcao mostraReticuladoPedestresFilme
        String[] pessoasLinux = {"🧔", "👩", "👶", "🧒", "👧", "👦", "🧑", "👨", "🧓", "👴", "👵"};
        
        if(rodarMapas){
            System.out.println("Simulacao no passo = "+qtd_passos);
            System.out.println();
            Auxiliares.mostraReticuladoPedestres(S.pessoas, l, c); 
            // Auxiliares.mostraReticuladoPedestresFilme(S.pessoas, l, c, p, pessoasLinux, S.posicaoPessoas);
            
            while(qtd_pedestres > 0){
                sorteio.clear();
                
                Thread.currentThread().sleep(1000);  
                
                // Para o linux
                System.out.print("\033[H\033[2J");  
	        System.out.flush(); 
                
                // VarasOriginal, VarasEscolheMenorPiso, VarasNaoPassaDiagonal,VarasOriginalNaoPassaDiagonal
                VarasOriginal.escolhaProximo(l, c, p, S.reticulado, S.pessoas, S.posicaoPessoas, sorteio);                
                
                VarasOriginal.proximoReticulado(S.posicaoPessoas, S.pessoas, sorteio, p, c);
                
                if(ligaObstaculos){
                    for (int i = 0; i < o; i++) {
                        if (S.pessoas[S.posicaoObjetos[i][0]][S.posicaoObjetos[i][1]] == 0) {
                            S.pessoas[S.posicaoObjetos[i][0]][S.posicaoObjetos[i][1]] = 4; 
                        }  
                    }
                } 
      
                System.out.println("Simulacao no passo = "+(qtd_passos+1));
                System.out.println();
                Auxiliares.mostraReticuladoPedestres(S.pessoas, l, c);
                System.out.println("Quantidade pedestres = "+qtd_pedestres);
                System.out.println();
           
                qtd_passos = qtd_passos + 1;
            }         
        }else{
            while(qtd_pedestres > 0){
                sorteio.clear();
               
                VarasOriginal.escolhaProximo(l, c, p, S.reticulado, S.pessoas, S.posicaoPessoas, sorteio);
            
                VarasOriginal.proximoReticulado(S.posicaoPessoas, S.pessoas, sorteio, p, c);
                
                if(ligaObstaculos){
                    for (int i = 0; i < o; i++) {
                        if (S.pessoas[S.posicaoObjetos[i][0]][S.posicaoObjetos[i][1]] == 0) {
                            S.pessoas[S.posicaoObjetos[i][0]][S.posicaoObjetos[i][1]] = 4; 
                        }
                    }
                }

                qtd_passos = qtd_passos + 1;     
            }
        }
        
        System.out.println("A simulacao finalizou em "+qtd_passos+" passos.");
    }
}   