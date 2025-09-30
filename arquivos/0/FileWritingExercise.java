import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileWritingExercise {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileWriter fileWriter = null;
        BufferedWriter writer = null;
        String linha = "";
        String SAIR = "SAIR";

        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine().trim();


        try {
            fileWriter = new FileWriter(fileName);
            writer = new BufferedWriter(fileWriter);
            do{
                System.out.println("Caso queira sair, digite SAIR.");
                System.out.println("Ou digite uma nova linha: ");
                linha = scanner.nextLine();
                writer.write(linha);
                writer.newLine();

            } while(!linha.equalsIgnoreCase(SAIR));
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.close();
        scanner.close();
    }
}
