import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvFileReader {

    public static void main(String[] args) {
        String fileName = "funcionarios.csv";
        FileReader fileReader = null;
        BufferedReader reader = null;
        String linha = "";
        String[] partes = null;

        try {
            fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);
            do {
                linha = reader.readLine();
                if (linha == null) break;
                partes = linha.split(",");
                System.out.println("Funcionário: "+partes[0]);
                System.out.println("Idade: "+partes[1]);
                System.out.println("Departamento: "+partes[2]);
                System.out.println("Salarial: "+partes[3]);
                System.out.println("------------------------");
            } while(linha != null);
            System.out.println("Leitura do arquivo concluída.");
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
