package Persistence;

import Model.Caso;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CasoPersistencia {

    private final String arquivo = "casos.txt";

    public void salvar(ArrayList<Caso> casos){

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo));

            for (Caso c : casos) {
                bw.write(c.getId() + ";" + c.getTitulo() + ";" + c.getDescricao() + ";" + c.getLocalCrime() + ";" + c.getDataCrime() + ";" + c.getStatus() );
                bw.newLine();
            }
            bw.close();
        } catch (IOException e){
            System.out.println("Erro ao salvar arquivo.");
        }
    }

}
