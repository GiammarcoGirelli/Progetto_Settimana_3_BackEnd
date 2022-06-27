import PacchettoStudenti.Studente;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(Main.class);
        //File file = new File("/Users/giammarcogirelli/Documents/Java/Progetto_Settimana_3/FileProvaTxt.rtf");


        Studente studente1 = new Studente("Marco", "Cannizzari", 'M', generaMap());
        Studente studente2 = new Studente("Filippo", "Giardini", 'M', generaMap());
        Studente studente3 = new Studente("Giuseppe", "Giardini", 'M', generaMap());
        Studente studente4 = new Studente("Martina", "Giulietti", 'F', generaMap());
        Studente studente5 = new Studente("Giulia", "Federici", 'F', generaMap());
        Studente studente6 = new Studente("Rinaldo", "Filippucci", 'M', generaMap());
        Studente studente7 = new Studente("Francesco", "Prioreschi", 'M', generaMap());
        Studente studente8 = new Studente("Ludovica", "Nanni", 'F', generaMap());
        Studente studente9 = new Studente("Luigi", "Portonacci", 'M', generaMap());
        Studente studente10 = new Studente("Simone", "Longobardo", 'M', generaMap());

        List<Studente> listaStudenti1 = new ArrayList<>();
        listaStudenti1.add(studente1);
        listaStudenti1.add(studente2);
        listaStudenti1.add(studente3);
        listaStudenti1.add(studente4);
        listaStudenti1.add(studente5);



        List<Studente> listaStudenti2 = new ArrayList<>();
        listaStudenti2.add(studente6);
        listaStudenti2.add(studente7);
        listaStudenti2.add(studente8);
        listaStudenti2.add(studente9);
        listaStudenti2.add(studente10);

        Scuola scuola1 = new Scuola(listaStudenti1);

        Scuola scuola2 = new Scuola(listaStudenti2);


        //System.out.println(scuola1.getStudenteMigliore());
        //System.out.println(studente1.promosso());
        //System.out.println("Media voti matematica" + " " + round(studente1.mediaVotoMateria("Matematica"), 2) + "\nVoto migliore" + " " + studente1.votoMiglioreMateria("Matematica"));


        logger.info("Studente migliore scuola " + scuola1.getStudenteMigliore());
        logger.info("Media voti matematica " + round(studente1.mediaVotoMateria("Matematica"), 2) + "\n");



        Thread thread1 = new Thread(scuola1);
        Thread thread2 = new Thread(scuola2);

        thread1.start();
        thread2.start();

        //try {
        //    FileUtils.writeStringToFile(file, "Lista studenti" + listaStudenti1 + listaStudenti2, "UTF-8");
        //} catch (IOException e) {
        //    throw new RuntimeException(e);
        //}

    }

    public static HashMap<String, List<Double>> generaMap(){
        HashMap<String, List<Double>> mappaGenerata = new HashMap<>();
        mappaGenerata.put("Geografia", generaListaVoti());
        mappaGenerata.put("Storia", generaListaVoti());
        mappaGenerata.put("Matematica", generaListaVoti());
        mappaGenerata.put("Filosofia", generaListaVoti());
        return mappaGenerata;
    }

    public static List<Double> generaListaVoti(){
        Random random = new Random();
        List<Double> listaGenerataRandom = new ArrayList<>();
        listaGenerataRandom.add(round(random.nextDouble(4, 10),2));
        listaGenerataRandom.add(round(random.nextDouble(4, 10),2));
        listaGenerataRandom.add(round(random.nextDouble(4, 10),2));
        listaGenerataRandom.add(round(random.nextDouble(4, 10),2));
        return listaGenerataRandom;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
