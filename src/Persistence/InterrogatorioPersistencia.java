package Persistence;

import Model.Interrogatorio;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InterrogatorioPersistencia {
    private final String FILE_PATH = "interrogatorios.txt";

    public void salvarTodos(List<Interrogatorio> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Interrogatorio i : lista) {
                bw.write(i.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar interrogatórios: " + e.getMessage());
        }
    }

    public List<Interrogatorio> listarTodos() {
        List<Interrogatorio> lista = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                String[] dados = linha.split(";");
                Interrogatorio i = new Interrogatorio(
                    Integer.parseInt(dados[0]),
                    Integer.parseInt(dados[1]),
                    Integer.parseInt(dados[2]),
                    Integer.parseInt(dados[3]),
                    dados[4],
                    dados[5]
                );
                lista.add(i);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo de interrogatórios: " + e.getMessage());
        }
        return lista;
    }
}
