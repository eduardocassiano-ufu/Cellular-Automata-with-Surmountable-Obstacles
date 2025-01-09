package modelosdinamicapedestres;

public class Simulacao {
    public int l, c, p, s, o;
    public double[][] reticulado; 
    public int[][] pessoas;
    public int[][] posicaoSaidas;
    public int[][] posicaoPessoas;
    public int[][] posicaoObjetos;
    public double n, lambda, panico, transponiveis;
    
    public Simulacao(int l, int c, double[][] reticulado, int[][] pessoas, int[][] posicaoSaidas, int[][] posicaoPessoas, int[][] posicaoObjetos, double n, double lambda, double panico, double transponiveis, int p, int s, int o){
        this.l = l; // linhas
        this.c = c; // colunas
        this.reticulado = reticulado;
        this.pessoas = pessoas;
        this.posicaoSaidas = posicaoSaidas; // guardar a posicao das saidas
        this.posicaoPessoas = posicaoPessoas;
        this.posicaoObjetos = posicaoObjetos;
        this.n = n; // distancia entre celulas
        this.lambda = lambda;
        this.panico = panico;
        this.transponiveis = transponiveis;
        this.p = p; // pessoas
        this.s = s; // saídas
        this.o = o; // objetos
    }
    
    public void montarSimulacao(){
        System.out.println("Quantidade de linhas: "+l);
        System.out.println("Quantidade de colunas: "+c);
        System.out.println("Quantidade de pedestres: "+p);
        System.out.println("Quantidade de saidas: "+s);
        
        System.out.println();
        
        System.out.println("Ambiente de simulação: ");
        for(int i = 0; i < l; i++){
            for(int j = 0; j < c; j++){
                System.out.print(reticulado[i][j]);
                System.out.print("\t");
            }
             System.out.println();
        }
        
        System.out.println();
        
        System.out.println("Reticulado dos pedestres: ");
        for(int i = 0; i < l; i++){
            for(int j = 0; j < c; j++){
                System.out.print(pessoas[i][j]);
                System.out.print("\t");
            }
             System.out.println();
        }
        
        System.out.println();
        
        System.out.println("Posição das pessoas: ");
        /* 
                       linha    coluna    pos_atual (nº cel)    identificacao
            saida 01    10        4             0                   0 
            saida 02    x         y             1                   1
           
        */
        for(int i = 0; i < p; i++){
            System.out.print(posicaoPessoas[i][0]);
            System.out.print("\t");
            System.out.print(posicaoPessoas[i][1]);
            System.out.print("\t");
            System.out.print(posicaoPessoas[i][2]);
            System.out.print("\t");
            System.out.println(posicaoPessoas[i][3]);
        }
        System.out.println();
        
        System.out.println("Posição das saídas: ");
        /* 
                        linha   coluna
            saida 01     10       0
            saida 02      x       y
        */
        for(int i = 0; i < s; i++){
            System.out.print(posicaoSaidas[i][0]);               
            System.out.print("\t");
            System.out.println(posicaoSaidas[i][1]);
        }
        
        System.out.println("Posição dos objetos: ");
        for(int i = 0; i < o; i++){
            System.out.print(posicaoObjetos[i][0]);               
            System.out.print("\t");
            System.out.println(posicaoObjetos[i][1]);
        }
        
        System.out.println();
        
        System.out.println("Distancia entre celulas: "+n);
        System.out.println("Valor da taxa da diagonal: "+lambda);
        System.out.println("Valor da taxa de pânico: "+panico);
        System.out.println("Valor da taxa de objetos transponíveis: "+transponiveis);
    }
}