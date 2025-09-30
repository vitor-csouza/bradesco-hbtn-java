import java.util.Scanner;


public class ArrayExercicio {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tamanhoArray = 10;
        int[] numeros = new int[tamanhoArray];
        int soma = 0;
        int maiorNumero = Integer.MIN_VALUE;


        System.out.println("Digite 10 números inteiros:");
        for(int i=0;i<numeros.length;i++){
            System.out.printf("Digite o número %d: %n", (i+1));
            numeros[i] = scanner.nextInt();
            soma += numeros[i];

            if (numeros[i] > maiorNumero){
                maiorNumero = numeros[i];
            }
        }


        System.out.println("\n\nConteúdo do array:");
        for(int i=0;i<numeros.length;i++){
            System.out.printf("%d ", numeros[i]);
        }
        System.out.println("\nSoma de todos os números: "+ soma);
        System.out.println("Maior número no array: "+ maiorNumero);

        scanner.close();
    }
}