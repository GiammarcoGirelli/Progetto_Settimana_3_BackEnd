package PacchettoStudenti;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Studente {

    private static int id=0;

    private String nome;

    private String cognome;

    private char genere;

    private HashMap<String, List<Double>> voti = new HashMap<>();

    public Studente(String nome, String cognome, char genere, HashMap<String, List<Double>> voti) {
        this.nome = nome;
        this.cognome = cognome;
        this.genere = genere;
        this.voti = voti;
        this.id++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public char getGenere() {
        return genere;
    }

    public void setGenere(char genere) {
        this.genere = genere;
    }

    public HashMap<String, List<Double>> getVoti() {
        return voti;
    }

    public void setVoti(HashMap<String, List<Double>> voti) {
        this.voti = voti;
    }






    public Double mediaVotoMateria(String materia){
        List<Double> mediaVoto = voti.get(materia);
        Double result=0.0;
        for (Double votoi: mediaVoto){
            result+=votoi;
        }
        return result/mediaVoto.size();
    }

    public Double votoMiglioreMateria(String materia){
        List<Double> mediaVoto = voti.get(materia);
        Double result=0.0;
        for (Double votoi: mediaVoto){
            if (votoi > result){
                result = votoi;
            }
        }
        return result;
    }

    public boolean promosso(){
        int contatore=0;
        for(Map.Entry<String,List<Double>> entry:voti.entrySet()){
            if(mediaVotoMateria(entry.getKey())<6){
                contatore++;
            }
        }
        if(contatore>=4){
            return false;
        }
        return true;
    }
    //, promosso()

    @Override
    public String toString() {
        return "Studente " +
                "nome = " + nome +
                ", cognome = '" + cognome + '\'' +
                ", genere=" + genere +
                ", voti=" + voti  + "\n";
    }
}