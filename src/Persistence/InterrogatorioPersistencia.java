package Persistence;

import Model.Interrogatorio;
import Util.LoggerSistema;

import java.io.*;
import java.util.ArrayList;

public class InterrogatorioPersistencia {

    private final String arquivoTxt = "arquivos/interrogatorios.txt";

    private final String arquivoBackup = "arquivos/backup_interrogatorios.dat";

    public void salvar(ArrayList<Interrogatorio> interrogatorios) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoTxt))) {

            for (Interrogatorio i : interrogatorios) {

                bw.write(i.getId() + ";" + i.getIdCaso() + ";" + i.getIdInvestigador() + ";" + i.getIdSuspeito() + ";" + i.getData() + ";" + i.getDepoimento());
                bw.newLine();
            }

            BackupSerializacao.salvar(arquivoBackup, interrogatorios);

            LoggerSistema.registrar("Interrogatórios salvos.");

        } catch (IOException e) {
            LoggerSistema.registrar("Erro ao salvar interrogatórios: " + e.getMessage());
        }
    }

    public ArrayList<Interrogatorio> carregar() {

        ArrayList<Interrogatorio> interrogatorios = new ArrayList<>();

        File arquivo = new File(arquivoTxt);

        if (!arquivo.exists()) {
            return interrogatorios;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                Interrogatorio interrogatorio = new Interrogatorio(Integer.parseInt(dados[0]), Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), dados[4], dados[5]);

                interrogatorios.add(interrogatorio);
            }

        } catch (Exception e) {
            LoggerSistema.registrar("Erro ao carregar interrogatórios: " + e.getMessage());
        }
        return interrogatorios;
    }

    public ArrayList<Interrogatorio> carregarBackup() {
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