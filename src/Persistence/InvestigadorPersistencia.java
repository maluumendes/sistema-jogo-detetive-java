package Persistence;

import Model.Investigador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class InvestigadorPersistencia {

    private final String arquivo = "investigadores.txt";

    public void salvar(ArrayList<Investigador> investigadores){

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo));

            for(Investigador i : investigadores){
                bw.write(
                        i.getId() + ";" +
                        i.getNome() + ";" +
                        i.getCargo() + ";" +
                        i.getDepartamento()
                );
                bw.newLine();
            }

            bw.close();

        }catch(IOException e){
            System.out.println("Erro ao salvar investigadores.");
        }
    }
}
