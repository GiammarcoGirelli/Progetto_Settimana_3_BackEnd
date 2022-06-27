import PacchettoStudenti.Studente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Scuola implements Runnable {

    Logger logger = LoggerFactory.getLogger(Scuola.class);
    private List<Studente> studentiScuola = new ArrayList<>();

    public Scuola(List<Studente> studentiScuola) {
        this.studentiScuola = studentiScuola;
    }

    public List<Studente> getPromossi() {
        List<Studente> promossi = new ArrayList<>();
        for (Studente studentei : studentiScuola) {
            if (studentei.promosso()) {
                promossi.add(studentei);
            }
        }
        return promossi;
    }

    public void getStudenti() {
        System.out.println(studentiScuola);
    }

    public Studente getStudenteMigliore() {
        Double result = 0.0;
        Studente studenteMigliore=null;
        for (Studente studente : studentiScuola) {
            Double mediaTot=0.0;

            for (Map.Entry<String, List<Double>> entry : studente.getVoti().entrySet()) {
                mediaTot += studente.mediaVotoMateria(entry.getKey());
            }
            if (mediaTot > result) {
                result = mediaTot;
                studenteMigliore=studente;
            }
        }
        return studenteMigliore;
    }

    @Override
    public void run() {
        for (Studente studente: studentiScuola){
            logger.info(String.valueOf(studente));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
