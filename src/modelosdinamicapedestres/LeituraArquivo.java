package modelosdinamicapedestres;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class LeituraArquivo {
    
    static int l, c, p, s, o;
    static double[][] reticulado;
    static int[][] pessoas;
    static int[][] posicaoSaidas;
    static int[][] posicaoPessoas;
    static int[][] posicaoObjetos;
    static double n, lambda, panico, transponiveis;  
    
    public static Simulacao ler(String caminhoArquivo){  
        try {
             FileReader lerArquivo = new FileReader(caminhoArquivo);
             BufferedReader arquivo = new BufferedReader(lerArquivo);
             String linha = "";
             int flag = 0;
             
            try {
                // Leitura da quantidade de LINHAS
                linha = arquivo.readLine();
                l = Integer.parseInt(linha);
                
                // Leitura da quantidade de COLUNAS
                linha = arquivo.readLine();
                c = Integer.parseInt(linha);
                
                // Leitura da quantidade de PEDESTRES
                linha = arquivo.readLine();
                p = Integer.parseInt(linha);

                // Leitura da quantidade de SAIDAS
                linha = arquivo.readLine();
                s = Integer.parseInt(linha);
                
                // Leitura da quantidade de OBJETOS
                linha = arquivo.readLine();
                o = Integer.parseInt(linha);
                
                reticulado = new double[l][c];
                pessoas = new int[l][c];
                posicaoSaidas = new int[s][2];
                posicaoPessoas = new int[p][4];
                posicaoObjetos = new int[o][2];
                
                // Leitura do espaço de simulacao
                int k = 0, pedestres = 0, objetos = 0; // contar saidas e pedestres
                
                for(int i = 0; i < l; i++){
                    linha = arquivo.readLine();
                    String[] linhaMatriz = linha.split(" ");
                    int j = 0;
                    
                    for(String aux: linhaMatriz){
                        if(Integer.parseInt(aux) == 0){
                            reticulado[i][j] = Double.parseDouble(aux);
                            pessoas[i][j] = 0;
                        }
                        if(Integer.parseInt(aux) == 1){
                            reticulado[i][j] = 0.0; // PEDESTRES NAO SAO LIDADOS AQUI
                            pessoas[i][j] = 1;  

                            posicaoPessoas[pedestres][0] = i;
                            posicaoPessoas[pedestres][1] = j;
                            posicaoPessoas[pedestres][2] = Auxiliares.xy_unifica(i, j, c);
                            posicaoPessoas[pedestres][3] = pedestres;

                            pedestres++;
                        }
                        if(Integer.parseInt(aux) == 2){
                            reticulado[i][j] = 500.0; // PAREDE E OBSTACULOS INTRANSPONIVEIS
                            pessoas[i][j] = 2;
                        }
                        if(Integer.parseInt(aux) == 3){
                            reticulado[i][j] = 1.0; // SAIDA
                            pessoas[i][j] = 3;
                            
                            posicaoSaidas[k][0] = i; // linha da saida
                            posicaoSaidas[k][1] = j; // coluna da saida
                            k++;
                        }
                        if(Integer.parseInt(aux) == 4){
                            reticulado[i][j] = 0.0; // OBSTACULOS TRANSPONIVEIS
                            pessoas[i][j] = 4;
                            
                            posicaoObjetos[objetos][0] = i;
                            posicaoObjetos[objetos][1] = j;       
                            
                            objetos++;
                        }
                     
                        j++;
                    }
                }
                
                // Leitura do valor de N (dist de cada cel da outra)
                linha = arquivo.readLine();
                n = Double.parseDouble(linha); 
                
                // Leitura do valor de LAMBDA
                linha = arquivo.readLine();
                lambda = Double.parseDouble(linha);
                
                // Leitura do valor de PANICO
                linha = arquivo.readLine();
                panico = Double.parseDouble(linha);
                
                // Leitura do valor de TRANSPONIVEIS
                linha = arquivo.readLine();
                transponiveis = Double.parseDouble(linha);
                
                lerArquivo.close();
                
            } catch (IOException e) {}
            
        }
        catch (FileNotFoundException e) {}
        
        Simulacao S = new Simulacao(l, c, reticulado, pessoas, posicaoSaidas, posicaoPessoas, posicaoObjetos, n, lambda, panico, transponiveis, p, s, o);
        return S;
    }
}  