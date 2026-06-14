package Persistence;

import Model.Caso;
import Util.LoggerSistema;

import java.io.*;
import java.util.ArrayList;

public class CasoPersistencia {

    private final String arquivoTxt = "arquivos/casos.txt";
    private final String arquivoBackup = "arquivos/backup_casos.dat";

    public void salvar(ArrayList<Caso> casos) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoTxt))) {

            for (Caso c : casos) {
                bw.write(c.getId() + ";" + c.getTitulo() + ";" + c.getDescricao() + ";" + c.getLocalCrime() + ";" + c.getDataCrime() + ";" + c.getStatus());

                bw.newLine();
            }

            BackupSerializacao.salvar(arquivoBackup, casos);

            LoggerSistema.registrar("Casos salvos com sucesso.");

        } catch (IOException e) {

            LoggerSistema.registrar("Erro ao salvar casos: " + e.getMessage());
        }
    }

    public ArrayList<Caso> carregar() {

        ArrayList<Caso> casos = new ArrayList<>();

        File arquivo = new File(arquivoTxt);

        if (!arquivo.exists()) {
            return casos;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                Caso caso = new Caso(Integer.parseInt(dados[0]), dados[1], dados[2], dados[3], dados[4], dados[5], new ArrayList<>());

                casos.add(caso);
            }

        } catch (Exception e) {
            LoggerSistema.registrar("Erro ao carregar casos: " + e.getMessage());
        }

        return casos;
    }

    public ArrayList<Caso> carregarBackup() {
        return BackupSerializacao.carregar(arquivoBackup);
    }

    public void excluirArquivos() {

        File arquivoTexto = new File(arquivoTxt);

        if (arquivoTexto.exists()) {
            arquivoTexto.delete();
        }

        File arquivoBackupSerializado = new File(arquivoBackup);

        if (arquivoBackupSerializado.exists()) {
            arquivoBackupSerializado.delete();
        }

        LoggerSistema.registrar("Arquivos de casos removidos.");
    }
}