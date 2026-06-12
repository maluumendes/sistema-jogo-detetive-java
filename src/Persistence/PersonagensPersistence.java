package Persistence;

import Model.Investigador;
import Model.Suspeito;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonagensPersistence {

    private static final String ARQUIVO_INVESTIGADORES = "investigadores.txt";
    private static final String ARQUIVO_SUSPEITOS = "suspeitos.txt";

    public static void salvarInvestigadores(List<Investigador> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_INVESTIGADORES))) {
            for (Investigador inv : lista) {
                bw.write(inv.getId() + ";" +
                        inv.getNome() + ";" +
                        inv.getCargo() + ";" +
                        inv.getDepartamento() + ";" +
                        inv.getLimiteCasosSimultaneos() + ";" +
                        inv.getCasosAtivosAtuais() + ";" +
                        inv.getMetodoInvestigacao() + ";" +
                        inv.getItemDeInvestigacaoFavorito());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo de investigadores: " + e.getMessage());
        }
    }

    public static void salvarSuspeitos(List<Suspeito> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_SUSPEITOS))) {
            for (Suspeito susp : lista) {
                bw.write(susp.getId() + ";" +
                        susp.getNome() + ";" +
                        susp.getOcupacao() + ";" +
                        susp.getIdade() + ";" +
                        susp.getAlibi() + ";" +
                        susp.getRelacaoComVitima() + ";" +
                        susp.isPossuiAntecedentes());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo de suspeitos: " + e.getMessage());
        }
    }

    public static List<Investigador> carregarInvestigadores() {
        List<Investigador> lista = new ArrayList<>();
        File arquivo = new File(ARQUIVO_INVESTIGADORES);

        if (!arquivo.exists()) {
            return lista;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                String[] dados = linha.split(";");

                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String cargo = dados[2];
                String departamento = dados[3];
                int limite = Integer.parseInt(dados[4]);
                int atuais = Integer.parseInt(dados[5]);
                String metodo = dados[6];
                String item = dados[7];

                Investigador inv = new Investigador(id, nome, cargo, departamento);
                inv.setLimiteCasosSimultaneos(limite);
                inv.setCasosAtivosAtuais(atuais);
                inv.setMetodoInvestigacao(metodo);
                inv.setItemDeInvestigacaoFavorito(item);

                lista.add(inv);
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar o arquivo de investigadores: " + e.getMessage());
        }
        return lista;
    }

    public static List<Suspeito> carregarSuspeitos() {
        List<Suspeito> lista = new ArrayList<>();
        File arquivo = new File(ARQUIVO_SUSPEITOS);

        if (!arquivo.exists()) {
            return lista;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                String[] dados = linha.split(";");

                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String ocupacao = dados[2];
                int idade = Integer.parseInt(dados[3]);
                String alibi = dados[4];
                String relacao = dados[5];
                boolean antecedentes = Boolean.parseBoolean(dados[6]);

                Suspeito susp = new Suspeito(id, nome, ocupacao, idade, alibi, relacao, antecedentes);
                lista.add(susp);
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar o arquivo de suspeitos: " + e.getMessage());
        }
        return lista;
    }
}
