import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FileReadingExercise {
    public static void main(String[] args) throws IOException {
        String fileName = "exemplo.txt";
        FileReader fileReader = null;
        BufferedReader reader = null;
        String linha = "";

        try {
            fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);
            linha = reader.readLine();
            System.out.println(linha);
            while(linha != null){
                System.out.println(linha);
                linha = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

    }
}