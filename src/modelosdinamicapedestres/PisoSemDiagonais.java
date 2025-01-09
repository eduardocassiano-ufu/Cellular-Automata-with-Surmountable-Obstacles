package modelosdinamicapedestres;

public class PisoSemDiagonais {
    public static void calculoField(double[][] reticulado, int pos_i, int pos_j, int l, int c, double n, double lambda) {        
        calculoFieldSaiCima(reticulado, pos_i, pos_j, l, c, n, lambda);
        calculoFieldSaiBaixo(reticulado, pos_i, pos_j, l, c, n, lambda); 
        calculoFieldSaiEsq(reticulado, pos_i, pos_j, l, c, n, lambda);
        calculoFieldSaiDir(reticulado, pos_i, pos_j, l, c, n, lambda); 
        calculoFieldSaiMeio(reticulado, pos_i, pos_j, l, c, n, lambda); 
    }
    
    public static void calculoFieldSaiEsq(double[][] reticulado, int pos_i, int pos_j, int l, int c, double n, double lambda) {
        int cima = pos_i - 1;
        int baixo = pos_i + 1;
        
        andarLinhaEsq(reticulado, pos_i, pos_j, l, c, n, lambda);
        
        for(int i = cima; i >= 0; i--){
            andarLinhaEsq(reticulado, i, pos_j, l, c, n, lambda);
        }   
        
        for(int i = baixo; i < l; i++){
            andarLinhaEsq(reticulado, i, pos_j, l, c, n, lambda);
        }
    }
    
    public static void calculoFieldSaiDir(double[][] reticulado, int pos_i, int pos_j, int l, int c, double n, double lambda) {
        int cima = pos_i - 1;
        int baixo = pos_i + 1;
        
        andarLinhaDir(reticulado, pos_i, pos_j, l, c, n, lambda);
        
        for(int i = cima; i >= 0; i--){
            andarLinhaDir(reticulado, i, pos_j, l, c, n, lambda);
        }   
        
        for(int i = baixo; i < l; i++){
            andarLinhaDir(reticulado, i, pos_j, l, c, n, lambda);
        }
    }
    
    public static void calculoFieldSaiBaixo(double[][] reticulado, int pos_i, int pos_j, int l, int c, double n, double lambda) {
        int esq = pos_j - 1;
        int dir = pos_j + 1;
        
        andarLinhaBaixo(reticulado, pos_i, pos_j, l, c, n, lambda);
        
        for(int j = esq; j >= 0; j--){
            andarLinhaBaixo(reticulado, pos_i, j, l, c, n, lambda);
        }   
        
        for(int j = dir; j < c; j++){
            andarLinhaBaixo(reticulado, pos_i, j, l, c, n, lambda);
        }
    }
    
    public static void calculoFieldSaiCima(double[][] reticulado, int pos_i, int pos_j, int l, int c, double n, double lambda) {
        int esq = pos_j - 1;
        int dir = pos_j + 1;
        
        andarLinhaCima(reticulado, pos_i, pos_j, l, c, n, lambda);
        
        for(int j = esq; j >= 0; j--){
            andarLinhaCima(reticulado, pos_i, j, l, c, n, lambda);
        }   
        
        for(int j = dir; j < c; j++){
            andarLinhaCima(reticulado, pos_i, j, l, c, n, lambda);
        }
    }
    
    public static void calculoFieldSaiMeio(double[][] reticulado, int pos_i, int pos_j, int l, int c, double n, double lambda) {
        int cima = pos_i - 1;
        int baixo = pos_i + 1;
        
        andarLinhaMeio(reticulado, pos_i, pos_j, l, c, n, lambda);
        
        for(int i = cima; i >= 0; i--){
            andarLinhaMeio(reticulado, i, pos_j, l, c, n, lambda);
        }   
        
        for(int i = baixo; i < l; i++){
            andarLinhaMeio(reticulado, i, pos_j, l, c, n, lambda);
        }
    }
    
    public static void andarLinhaEsq(double[][] reticulado, int pos_i, int pos_j, int l, int c, double n, double lambda){
        for(int j = pos_j; j < c; j++){
            norte(reticulado, pos_i, j, l, c, n);
            sul(reticulado, pos_i, j, l, c, n);
            leste(reticulado, pos_i, j, l, c, n);
            oeste(reticulado, pos_i, j, l, c, n);
            nordeste(reticulado, pos_i, j, l, c, lambda);
            noroeste(reticulado, pos_i, j, l, c, lambda);
            sudeste(reticulado, pos_i, j, l, c, lambda);
            sudoeste(reticulado, pos_i, j, l, c, lambda);
        }
    }
    
    public static void andarLinhaDir(double[][] reticulado, int pos_i, int pos_j, int l, int c, double n, double lambda){
        for(int j = pos_j; j >= 0; j--){
            norte(reticulado, pos_i, j, l, c, n);
            sul(reticulado, pos_i, j, l, c, n);
            leste(reticulado, pos_i, j, l, c, n);
            oeste(reticulado, pos_i, j, l, c, n);
            nordeste(reticulado, pos_i, j, l, c, lambda);
            noroeste(reticulado, pos_i, j, l, c, lambda);
            sudeste(reticulado, pos_i, j, l, c, lambda);
            sudoeste(reticulado, pos_i, j, l, c, lambda);
        }
    }
    
    public static void andarLinhaBaixo(double[][] reticulado, int pos_i, int pos_j, int l, int c, double n, double lambda){
        for(int i = pos_i; i >= 0; i--){
            norte(reticulado, i, pos_j, l, c, n);
            sul(reticulado, i, pos_j, l, c, n);
            leste(reticulado, i, pos_j, l, c, n);
            oeste(reticulado, i, pos_j, l, c, n);
            nordeste(reticulado, i, pos_j, l, c, lambda);
            noroeste(reticulado, i, pos_j, l, c, lambda);
            sudeste(reticulado, i, pos_j, l, c, lambda);
            sudoeste(reticulado, i, pos_j, l, c, lambda);
        }
    }
    
    public static void andarLinhaCima(double[][] reticulado, int pos_i, int pos_j, int l, int c, double n, double lambda){
        for(int i = pos_i; i < l; i++){
            norte(reticulado, i, pos_j, l, c, n);
            sul(reticulado, i, pos_j, l, c, n);
            leste(reticulado, i, pos_j, l, c, n);
            oeste(reticulado, i, pos_j, l, c, n);
            nordeste(reticulado, i, pos_j, l, c, lambda);
            noroeste(reticulado, i, pos_j, l, c, lambda);
            sudeste(reticulado, i, pos_j, l, c, lambda);
            sudoeste(reticulado, i, pos_j, l, c, lambda);
        }
    }
    
    public static void andarLinhaMeio(double[][] reticulado, int pos_i, int pos_j, int l, int c, double n, double lambda){
        for(int j = pos_j; j >= 0; j--){
            norte(reticulado, pos_i, j, l, c, n);
            sul(reticulado, pos_i, j, l, c, n);
            leste(reticulado, pos_i, j, l, c, n);
            oeste(reticulado, pos_i, j, l, c, n);
            nordeste(reticulado, pos_i, j, l, c, lambda);
            noroeste(reticulado, pos_i, j, l, c, lambda);
            sudeste(reticulado, pos_i, j, l, c, lambda);
            sudoeste(reticulado, pos_i, j, l, c, lambda);
        }
        
        for(int j = pos_j; j < c; j++){
            norte(reticulado, pos_i, j, l, c, n);
            sul(reticulado, pos_i, j, l, c, n);
            leste(reticulado, pos_i, j, l, c, n);
            oeste(reticulado, pos_i, j, l, c, n);
            nordeste(reticulado, pos_i, j, l, c, lambda);
            noroeste(reticulado, pos_i, j, l, c, lambda);
            sudeste(reticulado, pos_i, j, l, c, lambda);
            sudoeste(reticulado, pos_i, j, l, c, lambda);
        }
    }
    
    // DIRECOES BASICAS
    public static void norte(double[][] reticulado, int i, int j, int l, int c, double n) {
        if(i - 1 >= 0){
            if(reticulado[i-1][j] != 500.00 && reticulado[i-1][j] != 1.0 && ((reticulado[i][j] + n) < reticulado[i-1][j] || reticulado[i-1][j] == 0)){
                reticulado[i-1][j] = reticulado[i][j] + n;
            }
        }
    }
    
    public static void sul(double[][] reticulado, int i, int j, int l, int c, double n) {
        if(i + 1 < l){
            if(reticulado[i+1][j] != 500.00 && reticulado[i+1][j] != 1.0 && ((reticulado[i][j] + n) < reticulado[i+1][j] || reticulado[i+1][j] == 0)){
                reticulado[i+1][j] = reticulado[i][j] + n;
            }
        }
    }
    
    public static void leste(double[][] reticulado, int i, int j, int l, int c, double n) {
        if(j + 1 < c){
            if(reticulado[i][j+1] != 500.00 && reticulado[i][j+1] != 1.0 && ((reticulado[i][j] + n) < reticulado[i][j+1] || reticulado[i][j+1] == 0)){
                reticulado[i][j+1] = reticulado[i][j] + n;
            }
        }
    }
    
    public static void oeste(double[][] reticulado, int i, int j, int l, int c, double n) {
        if(j - 1 > 0){
            if(reticulado[i][j-1] != 500.00 && reticulado[i][j-1] != 1.0 && ((reticulado[i][j] + n) < reticulado[i][j-1] || reticulado[i][j-1] == 0)){
                reticulado[i][j-1] = reticulado[i][j] + n;
            }
        }
    }
    
    public static void nordeste(double[][] reticulado, int i, int j, int l, int c, double lambda) {
        if(i - 1 >= 0 && j + 1 < c && (reticulado[i-1][j] != 500.00 || reticulado[i][j+1] != 500.00)){
            if(reticulado[i-1][j+1] != 500.00 && reticulado[i-1][j+1] != 1.0 && ((reticulado[i][j] + lambda) < reticulado[i-1][j+1] || reticulado[i-1][j+1] == 0)){
                reticulado[i-1][j+1] = reticulado[i][j] + lambda;
            }
        }
    }
    
    public static void noroeste(double[][] reticulado, int i, int j, int l, int c, double lambda) {
        if(i - 1 >= 0 && j - 1 >= 0 && (reticulado[i-1][j] != 500.00 || reticulado[i][j-1] != 500.00)){
            if(reticulado[i-1][j-1] != 500.00 && reticulado[i-1][j-1] != 1.0 && ((reticulado[i][j] + lambda) < reticulado[i-1][j-1] || reticulado[i-1][j-1] == 0)){
                reticulado[i-1][j-1] = reticulado[i][j] + lambda;
            }
        }
    }
    
    public static void sudeste(double[][] reticulado, int i, int j, int l, int c, double lambda) {
        if(i + 1 < l && j + 1 < c && (reticulado[i+1][j] != 500.00 || reticulado[i][j+1] != 500.00)){
            if(reticulado[i+1][j+1] != 500.00 && reticulado[i+1][j+1] != 1.0 && ((reticulado[i][j] + lambda) < reticulado[i+1][j+1] || reticulado[i+1][j+1] == 0)){
                reticulado[i+1][j+1] = reticulado[i][j] + lambda;
            }
        }
    }
    
    public static void sudoeste(double[][] reticulado, int i, int j, int l, int c, double lambda) {
        if(i + 1 < l && j - 1 >= 0 && (reticulado[i+1][j] != 500.00 || reticulado[i][j-1] != 500.00)){
            if(reticulado[i+1][j-1] != 500.00 && reticulado[i+1][j-1] != 1.0 && ((reticulado[i][j] + lambda) < reticulado[i+1][j-1] || reticulado[i+1][j-1] == 0) ){
                reticulado[i+1][j-1] = reticulado[i][j] + lambda;
            }
        }
    }
}
