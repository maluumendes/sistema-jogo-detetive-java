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
                    bw.write(inv.getNome() + ";" +
                            inv.getOcupacao() + ";" +
                            inv.getIdade() + ";" +
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
                    bw.write(susp.getNome() + ";" +
                            susp.getOcupacao() + ";" +
                            susp.getIdade() + ";" +
                            susp.getAlibi() + ";" +
                            susp.getRelacaoComVitima() + ";" +
                            susp.getPossuiAntecendentes());
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
                    String[] dados = linha.split(";");

                    String nome = dados[0];
                    String ocupacao = dados[1];
                    int idade = Integer.parseInt(dados[2]);
                    int limite = Integer.parseInt(dados[3]);
                    int atuais = Integer.parseInt(dados[4]);
                    String metodo = dados[5];
                    String item = dados[6];

                    Investigador inv = new Investigador(nome, ocupacao, idade, limite, atuais, metodo, item);
                    inv.setCasosAtivosAtuais(atuais);

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
                    String[] dados = linha.split(";");

                    String nome = dados[0];
                    String ocupacao = dados[1];
                    int idade = Integer.parseInt(dados[2]);
                    String alibi = dados[3];
                    String relacao = dados[4];
                    boolean antecedentes = Boolean.parseBoolean(dados[5]);

                    Suspeito susp = new Suspeito(nome, ocupacao, idade, alibi, relacao, antecedentes);

                    lista.add(susp);
                }
            } catch (Exception e) {
                System.out.println("Erro ao carregar o arquivo de suspeitos: " + e.getMessage());
            }
            return lista;
        }
    }
}
