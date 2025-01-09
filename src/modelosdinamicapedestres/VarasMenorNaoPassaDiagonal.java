package modelosdinamicapedestres;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class VarasMenorNaoPassaDiagonal {    
    public static void escolhaProximo(int l, int c, int p, double[][] reticulado, int[][] pessoas, int[][] posicaoPessoas, HashMap<Integer, ArrayList<Integer>> sorteio) {
        int i, p2 = 0, celulaAtual, celulaQueroIr, aux_x, aux_y;
        double parede = 500.0, valorCelulaAtual, valorCelulaQueroIr;
        List<Number> praOndeVou;

        for (i = 0; i < p; i++) {
            if(posicaoPessoas[i][0] != -1 && posicaoPessoas[i][1] != -1){ 
                
                posicaoPessoas[i][2] = Auxiliares.xy_unifica(posicaoPessoas[i][0], posicaoPessoas[i][1], c);
                
                valorCelulaAtual = reticulado[posicaoPessoas[i][0]][posicaoPessoas[i][1]];
                celulaQueroIr = posicaoPessoas[i][2];
                celulaAtual = posicaoPessoas[i][2];
                
                if (tivePanico() == false) {
                    double menorPiso = parede + 1.0;

                    // NORTE
                    if (posicaoPessoas[i][0] - 1 >= 0) {
                        
                        celulaQueroIr = Auxiliares.xy_unifica(posicaoPessoas[i][0] - 1, posicaoPessoas[i][1], c);
                        valorCelulaQueroIr = reticulado[posicaoPessoas[i][0] - 1][posicaoPessoas[i][1]];
                        
                        if (reticulado[posicaoPessoas[i][0] - 1][posicaoPessoas[i][1]] != parede) {
                            praOndeVou = escolheCelula(valorCelulaAtual, valorCelulaQueroIr, celulaAtual, celulaQueroIr);
                            
                            if(!praOndeVou.isEmpty()){
                               celulaAtual = praOndeVou.get(0).intValue();
                               valorCelulaAtual = praOndeVou.get(1).doubleValue(); 
                            }
                        }
                    }

                    // SUL
                    if (posicaoPessoas[i][0] + 1 <= l) {
                        
                        celulaQueroIr = Auxiliares.xy_unifica(posicaoPessoas[i][0] + 1, posicaoPessoas[i][1], c);
                        valorCelulaQueroIr = reticulado[posicaoPessoas[i][0] + 1][posicaoPessoas[i][1]];
                        
                        if (reticulado[posicaoPessoas[i][0] + 1][posicaoPessoas[i][1]] != parede) {
                            praOndeVou = escolheCelula(valorCelulaAtual, valorCelulaQueroIr, celulaAtual, celulaQueroIr);
                            
                            if(!praOndeVou.isEmpty()){
                               celulaAtual = praOndeVou.get(0).intValue();
                               valorCelulaAtual = praOndeVou.get(1).doubleValue(); 
                            }
                        }
                    }

                    // OESTE
                    if (posicaoPessoas[i][1] - 1 >= 0) {
                        
                        celulaQueroIr = Auxiliares.xy_unifica(posicaoPessoas[i][0], posicaoPessoas[i][1] - 1, c);
                        valorCelulaQueroIr = reticulado[posicaoPessoas[i][0]][posicaoPessoas[i][1] - 1];
                        
                        if (reticulado[posicaoPessoas[i][0]][posicaoPessoas[i][1] - 1] != parede) {
                            praOndeVou = escolheCelula(valorCelulaAtual, valorCelulaQueroIr, celulaAtual, celulaQueroIr);
                            
                            if(!praOndeVou.isEmpty()){
                               celulaAtual = praOndeVou.get(0).intValue();
                               valorCelulaAtual = praOndeVou.get(1).doubleValue(); 
                            }
                        }
                    }

                    // LESTE 
                    if (posicaoPessoas[i][1] + 1 <= c) {
                        
                        celulaQueroIr = Auxiliares.xy_unifica(posicaoPessoas[i][0], posicaoPessoas[i][1] + 1, c);
                        valorCelulaQueroIr = reticulado[posicaoPessoas[i][0]][posicaoPessoas[i][1] + 1];
                        
                        if (reticulado[posicaoPessoas[i][0]][posicaoPessoas[i][1] + 1] != parede) {
                            praOndeVou = escolheCelula(valorCelulaAtual, valorCelulaQueroIr, celulaAtual, celulaQueroIr);
                            
                            if(!praOndeVou.isEmpty()){
                               celulaAtual = praOndeVou.get(0).intValue();
                               valorCelulaAtual = praOndeVou.get(1).doubleValue(); 
                            }
                        }
                    }   

                    // NORDESTE 
                    if (posicaoPessoas[i][0] - 1 >= 0 && posicaoPessoas[i][1] + 1 <= c) {
                        
                        celulaQueroIr = Auxiliares.xy_unifica(posicaoPessoas[i][0] - 1, posicaoPessoas[i][1] + 1, c);
                        valorCelulaQueroIr = reticulado[posicaoPessoas[i][0] - 1][posicaoPessoas[i][1] + 1];
                        
                        if (reticulado[posicaoPessoas[i][0] - 1][posicaoPessoas[i][1] + 1] != parede) {
                            
                            if  ((reticulado[posicaoPessoas[i][0] - 1][posicaoPessoas[i][1]] != 500.0) || 
                                (reticulado[posicaoPessoas[i][0]][posicaoPessoas[i][1] + 1] != 500.0)) {
                            
                                praOndeVou = escolheCelula(valorCelulaAtual, valorCelulaQueroIr, celulaAtual, celulaQueroIr);

                                if(!praOndeVou.isEmpty()){
                                   celulaAtual = praOndeVou.get(0).intValue();
                                   valorCelulaAtual = praOndeVou.get(1).doubleValue(); 
                                }
                            }
                        }
                    }

                    // NOROESTE
                    if (posicaoPessoas[i][0] - 1 >= 0 && posicaoPessoas[i][1] - 1 >= 0) {
                        
                        celulaQueroIr = Auxiliares.xy_unifica(posicaoPessoas[i][0] - 1, posicaoPessoas[i][1] - 1, c);
                        valorCelulaQueroIr = reticulado[posicaoPessoas[i][0] - 1][posicaoPessoas[i][1] - 1];
                        
                        if (reticulado[posicaoPessoas[i][0] - 1][posicaoPessoas[i][1] - 1] != parede) {
                            
                            if ((reticulado[posicaoPessoas[i][0] - 1][posicaoPessoas[i][1]] != 500.0) || 
                                    (reticulado[posicaoPessoas[i][0]][posicaoPessoas[i][1] - 1] != 500.0)) {
                            
                                praOndeVou = escolheCelula(valorCelulaAtual, valorCelulaQueroIr, celulaAtual, celulaQueroIr);

                                if(!praOndeVou.isEmpty()){
                                   celulaAtual = praOndeVou.get(0).intValue();
                                   valorCelulaAtual = praOndeVou.get(1).doubleValue(); 
                                }
                            }
                        }
                    }

                    // SUDESTE
                    if (posicaoPessoas[i][0] + 1 <= l && posicaoPessoas[i][1] + 1 <= c) {
                        
                        celulaQueroIr = Auxiliares.xy_unifica(posicaoPessoas[i][0] + 1, posicaoPessoas[i][1] + 1, c);
                        valorCelulaQueroIr = reticulado[posicaoPessoas[i][0] + 1][posicaoPessoas[i][1] + 1];
                        
                        if (reticulado[posicaoPessoas[i][0] + 1][posicaoPessoas[i][1] + 1] != parede) {
                            
                            if ((reticulado[posicaoPessoas[i][0] + 1][posicaoPessoas[i][1]] != 500.0) || 
                                    (reticulado[posicaoPessoas[i][0]][posicaoPessoas[i][1] + 1] != 500.0)) {
                            
                                praOndeVou = escolheCelula(valorCelulaAtual, valorCelulaQueroIr, celulaAtual, celulaQueroIr);

                                if(!praOndeVou.isEmpty()){
                                    celulaAtual = praOndeVou.get(0).intValue();
                                    valorCelulaAtual = praOndeVou.get(1).doubleValue(); 
                                }
                            }
                        }
                    }

                    // SUDOESTE
                    if (posicaoPessoas[i][0] + 1 <= l && posicaoPessoas[i][1] - 1 <= c) {
                        
                        celulaQueroIr = Auxiliares.xy_unifica(posicaoPessoas[i][0] + 1, posicaoPessoas[i][1] - 1, c);
                        valorCelulaQueroIr = reticulado[posicaoPessoas[i][0] + 1][posicaoPessoas[i][1] - 1];
                        
                        if (reticulado[posicaoPessoas[i][0] + 1][posicaoPessoas[i][1] - 1] != parede) {
                            praOndeVou = escolheCelula(valorCelulaAtual, valorCelulaQueroIr, celulaAtual, celulaQueroIr);
                            
                            if(!praOndeVou.isEmpty()){
                                celulaAtual = praOndeVou.get(0).intValue();
                                valorCelulaAtual = praOndeVou.get(1).doubleValue(); 
                            }
                        }
                    }

                    aux_x = Auxiliares.xy_separa(celulaAtual, c);
                    aux_y = Auxiliares.xy_separa2(celulaAtual , c);
                    
                    if (pessoas[aux_x][aux_y] != 1){
                        posicaoPessoas[i][2] = celulaAtual;
                    }
                } 
                
                if(!sorteio.containsKey(posicaoPessoas[i][2])){
                    sorteio.put(posicaoPessoas[i][2], new ArrayList<>());
                    sorteio.get(posicaoPessoas[i][2]).add(i+1);
                }
                else{
                    sorteio.get(posicaoPessoas[i][2]).add(i+1);
                }

                p2++;
            }
        }
    } 
    
    public static void proximoReticulado(int[][] posicaoPessoas, int[][] pessoas, HashMap<Integer, ArrayList<Integer>> sorteio, int p, int c) {                
  
        for(Integer i: sorteio.keySet()){
            if(sorteio.get(i).size() == 1){
                int pes = sorteio.get(i).get(0);

                int x = Auxiliares.xy_separa(posicaoPessoas[pes-1][2], c);
                int y = Auxiliares.xy_separa2(posicaoPessoas[pes-1][2], c);
                
                if(pessoas[x][y] != 1 && pessoas[x][y] != 2){ 
                    if(pessoas[x][y] == 4){
                        boolean resultado = Math.random() < Modelo.taxa_obstaculos;
                        
                        if (resultado == true){
                            pessoas[posicaoPessoas[pes-1][0]][posicaoPessoas[pes-1][1]] = 0; 
                            posicaoPessoas[pes-1][0] = x;
                            posicaoPessoas[pes-1][1] = y;
                            

                            if(pessoas[x][y] != 3){
                                pessoas[x][y] = 1;
                            }
                            else{
                                posicaoPessoas[pes-1][0] = -1;
                                posicaoPessoas[pes-1][1] = -1;
                                Modelo.qtd_pedestres = Modelo.qtd_pedestres - 1;
                            }
                        }                      
                    } else{
                        pessoas[posicaoPessoas[pes-1][0]][posicaoPessoas[pes-1][1]] = 0; 
                        posicaoPessoas[pes-1][0] = x;
                        posicaoPessoas[pes-1][1] = y;

                        if(pessoas[x][y] != 3){
                            pessoas[x][y] = 1;
                        }
                        else{
                            posicaoPessoas[pes-1][0] = -1;
                            posicaoPessoas[pes-1][1] = -1;
                            Modelo.qtd_pedestres = Modelo.qtd_pedestres - 1;
                        }
                    }
                }   
            }  
            if(sorteio.get(i).size() > 1){
                Random rand = new Random();
                int r = rand.nextInt(sorteio.get(i).size());
                
                int pes = sorteio.get(i).get(r);
                
                int x = Auxiliares.xy_separa(posicaoPessoas[pes-1][2], c);
                int y = Auxiliares.xy_separa2(posicaoPessoas[pes-1][2], c);
                
                if(pessoas[x][y] != 1 && pessoas[x][y] != 2){ 
                    if(pessoas[x][y] == 4){
                        boolean resultado = Math.random() < Modelo.taxa_obstaculos; 
                        if (resultado == true){
                            pessoas[posicaoPessoas[pes-1][0]][posicaoPessoas[pes-1][1]] = 0; 
                            posicaoPessoas[pes-1][0] = x;
                            posicaoPessoas[pes-1][1] = y;

                            if(pessoas[x][y] != 3){
                                pessoas[x][y] = 1;
                            }
                            else{
                                posicaoPessoas[pes-1][0] = -1;
                                posicaoPessoas[pes-1][1] = -1;
                                posicaoPessoas[pes-1][2] = -1;
                                Modelo.qtd_pedestres = Modelo.qtd_pedestres - 1;
                            }
                        }                      
                    } else{
                        pessoas[posicaoPessoas[pes-1][0]][posicaoPessoas[pes-1][1]] = 0;
                        posicaoPessoas[pes-1][0] = x;
                        posicaoPessoas[pes-1][1] = y;

                        if(pessoas[x][y] != 3){
                            pessoas[x][y] = 1; 
                        }
                        else{
                            posicaoPessoas[pes-1][0] = -1;
                            posicaoPessoas[pes-1][1] = -1;
                            posicaoPessoas[pes-1][2] = -1;
                            Modelo.qtd_pedestres = Modelo.qtd_pedestres - 1;
                        }
                    }
                }
            }
        }
    }
    
    public static List<Number> escolheCelula(double valorCelulaAtual, double valorCelulaQueroIr, int celulaAtual, int celulaQueroIr){
        List<Number> praOndeVou = new ArrayList<>();
        
        if (valorCelulaQueroIr < valorCelulaAtual){
            praOndeVou.add(celulaQueroIr);
            praOndeVou.add(valorCelulaQueroIr);
        } else if (valorCelulaQueroIr == valorCelulaAtual) {   
            Random random = new Random(); // Modelo.seed
            boolean sorteio = (random.nextInt(2) == 0) ? true : false; 

            if(sorteio){
                praOndeVou.add(celulaQueroIr);
                praOndeVou.add(valorCelulaQueroIr);
            }
        } 
        
        return praOndeVou;
    }
    
    public static boolean tivePanico(){
        boolean sorteio = Math.random() < 0.05;     
        return sorteio;
    }
}
