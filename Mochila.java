package lab4;

public class Mochila {
    
    public static int maxBeneficio(int []W, int [][]B, int n, int M) {
        int i = n;
        int k = M;
        while (i > 0 && k > 0) {
            if (B[i][k] != B[i - 1][k]) {
                k = k - W[i - 1];
            } else {
                i--;
            }
        }
        return B[n][M];
    }

     
    public static boolean[] Object(int []W, int [][]B, int n, int M){
        boolean X[] = new boolean [n];
        int i =n; int k = M;
        while(i>0 && k>0){
            if(B[i][k] != B[i-1][k]){
                X[i-1] = true;  //item esta en la mochila
                k = k - W[i-1];
            }
            else
                X[i-1] = false;
            i--;
        }
        return X;         
    }
    
    public static void main(String[] args) {
        int capacidad = 8;
        int[] pesos = {1,3,4,5,7};
        int[] beneficios = {2,5,10,14,15};

//        int[] pesos = {1,5,3,4};
//        int[] beneficios = {15,10,9,5};

        int n = pesos.length;
        
        int[][] dp = new int[n + 1][capacidad + 1];
        
        // Llenar la matriz dp
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= capacidad; k++) {
                if (i == 0 || k == 0)
                    dp[i][k] = 0;
                else if (pesos[i - 1] <= k)
                    dp[i][k] = Math.max(beneficios[i - 1] + dp[i - 1][k - pesos[i - 1]], dp[i - 1][k]);
                else
                    dp[i][k] = dp[i - 1][k];
            }
        }
        
        // Prueba de maxBeneficio
        int maxBeneficio = maxBeneficio(pesos, dp, n, capacidad);
        System.out.println("El maximo beneficio posible es: " + maxBeneficio);
        
        // Prueba de Object
        boolean[] elementosSeleccionados = Object(pesos, dp, n, capacidad);
        System.out.println("Elementos seleccionados en la mochila:");
        for (int i = 0; i < n; i++) {
            if (elementosSeleccionados[i]) {
                System.out.println("Item " + (i + 1));
            }
        }
    }
}
