/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosnumericos_desafio2_jacobi;

/**
 *
 * @author hp
 */
public class MetodosNumericos_desafio2_jacobi {

    public static void main(String[] args) {
        double[][] A = {
            {52, 30, 18},
            {20, 50, 30},
            {25, 20, 55}
        };
        double[] b = {4800, 5810, 5690};
        double[] x = {0, 0, 0};
        int maxIteraciones = 100; // Número máximo de iteraciones
        double tolerancia = 1e-5; // Tolerancia para el criterio de convergencia
        jacobi(A, b, x, maxIteraciones, tolerancia);
    }

    public static void jacobi(double[][] A, double[] b, double[] x, int maxIteraciones, double tolerancia) {
        int n = b.length;
        double[] xNuevo = new double[n];
        double error;

        for (int iteracion = 0; iteracion < maxIteraciones; iteracion++) {
            for (int i = 0; i < n; i++) {
                double suma = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        suma += A[i][j] * x[j];
                    }
                }
                xNuevo[i] = (b[i] - suma) / A[i][i];
            }

            error = 0;
            for (int i = 0; i < n; i++) {
                error += Math.abs(xNuevo[i] - x[i]);
            }
            if (error < tolerancia) {
                break;
            }
            System.arraycopy(xNuevo, 0, x, 0, n);
            System.out.println("Iteración " + (iteracion + 1));
            for (int i = 0; i < n; i++) {
                System.out.printf("x%d = %.5f ", (i + 1), x[i]);
            }
            System.out.println("\nError: " + error + "\n");
        }

        System.out.println("Solución final:");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.5f ", (i + 1), x[i]);
        }
        System.out.println();
    }
    
}
