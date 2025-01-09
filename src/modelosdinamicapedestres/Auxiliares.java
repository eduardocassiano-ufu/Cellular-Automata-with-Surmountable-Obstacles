package modelosdinamicapedestres;

public class Auxiliares {
    public static void copiaReticuladoSemPedestres(int[][] origem, int[][] destino, int l, int c) {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                if (origem[i][j] == 1){
                    destino[i][j] = 0; 
                } else {
                    destino[i][j] = origem[i][j];
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void mostraReticulado(double[][] reticulado, int l, int c) {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(reticulado[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void mostraReticuladoPedestres(int[][] reticulado, int l, int c) {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                if (reticulado[i][j] == 0){
                  System.out.print(" ");  
                } else {
                  System.out.print(reticulado[i][j]); 
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void mostraReticuladoPedestresFilme(int[][] reticulado, int l, int c, int p, String[] pessoasLinux, int[][] posicaoPessoas) {
    	int p3 = 0;
    
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
            	
                if (reticulado[i][j] == 0) {
                        System.out.print("⬛");
       		}
                else if(reticulado[i][j] == 2){
                	System.out.print("⬜");
                } 
                else if(reticulado[i][j] == 3){
                	System.out.print("🟫");
                }
                else if(reticulado[i][j] == 1){
                	
                	for(int p4 = 0; p4 < p; p4++){
                		if(posicaoPessoas[p4][0] == i && posicaoPessoas[p4][1] == j){
                			p3 = p4;
                			break;
                		}
                	}
                	
                       	if(posicaoPessoas[p3][0] != -1 && posicaoPessoas[p3][1] != -1 && posicaoPessoas[p3][3] % 11 == 0){
                	     System.out.print(pessoasLinux[0]);
                	} 
                	if (posicaoPessoas[p3][0] != -1 && posicaoPessoas[p3][1] != -1 && posicaoPessoas[p3][3] % 11 == 1) {
                	     System.out.print(pessoasLinux[1]);
                	}
                	if(posicaoPessoas[p3][0] != -1 && posicaoPessoas[p3][1] != -1 && posicaoPessoas[p3][3] % 11 == 2){
                	     System.out.print(pessoasLinux[2]);
                	} 
                	if (posicaoPessoas[p3][0] != -1 && posicaoPessoas[p3][1] != -1 && posicaoPessoas[p3][3] % 11 == 3) {
                	     System.out.print(pessoasLinux[3]);
                	}
                	if(posicaoPessoas[p3][0] != -1 && posicaoPessoas[p3][1] != -1 && posicaoPessoas[p3][3] % 11 == 4){
                	     System.out.print(pessoasLinux[4]);
                	} 
                	if (posicaoPessoas[p3][0] != -1 && posicaoPessoas[p3][1] != -1 && posicaoPessoas[p3][3] % 11 == 5) {
                	     System.out.print(pessoasLinux[5]);
                	} 
                	if(posicaoPessoas[p3][0] != -1 && posicaoPessoas[p3][1] != -1 && posicaoPessoas[p3][3] % 11 == 6){
                	     System.out.print(pessoasLinux[6]);
                	} 
                	if (posicaoPessoas[p3][0] != -1 && posicaoPessoas[p3][1] != -1 && posicaoPessoas[p3][3] % 11 == 7) {
                	     System.out.print(pessoasLinux[7]);
                	}
                	if(posicaoPessoas[p3][0] != -1 && posicaoPessoas[p3][1] != -1 && posicaoPessoas[p3][3] % 11 == 8){
                	     System.out.print(pessoasLinux[8]);
                	} 
                	if (posicaoPessoas[p3][0] != -1 && posicaoPessoas[p3][1] != -1 && posicaoPessoas[p3][3] % 11 == 9) {
                	     System.out.print(pessoasLinux[9]);
                	}
                	if(posicaoPessoas[p3][0] != -1 && posicaoPessoas[p3][1] != -1 && posicaoPessoas[p3][3] % 11 == 10){
                	     System.out.print(pessoasLinux[10]);
                	} 
                	if (posicaoPessoas[p3][0] != -1 && posicaoPessoas[p3][1] != -1 && posicaoPessoas[p3][3] % 11 == 11) {
                	     System.out.print(pessoasLinux[11]);
                	}
                	p3++;
                }
            }
            System.out.println();
        }
        System.out.println();
    } 
     
   public static int xy_unifica(int x, int y, int c){
        int z = 0;

        z = x * c;
        z += y + 1;

        return z; // z eh a celula q o pedestre quer movimentar
    }

    public static int xy_separa(int z, int c){
        int x, y = 0;
        
        if (z % c == 0) {
            x = (z / c) - 1;
            y = c - 1;
        } else {
            x = z / c;
            y = (z % c) - 1;
        }
        return x;
    }
    
    public static int xy_separa2(int z, int c){
        int x, y = 0;
        
        if (z % c == 0) {
            x = (z / c) - 1;
            y = c - 1;
        } else {
            x = z / c;
            y = (z % c) - 1;
        }
        return y;
    }
}
