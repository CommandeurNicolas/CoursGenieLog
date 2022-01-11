package exercice2;

import datamocklib.Person;
import datamocklib.TxtHelper;
import exercice2.models.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class MainExercice2 implements Exo2 {

    /* EXO 2
     * Recupérez depuis le serveur la liste des gens qui sont nés à Chambéry.
     * La récupération de Data se fait dans l'ordre :
     *  - Récupération de data sur le server grâce à TxtHelper.getDataFromTxt("server.txt");
     *  - Vider la base de données locale grâce à la fonction TxtHelper.clearDataLocal();
     *  - Insérer les données dans la database locale grâce à la fonction TxtHelper.insertDataInTxt(line, "local.txt")
     *  - Afficher les données locale grace à TxtHelper.getDataFromTxt("local.txt")
     */
    @Override
    public void displayPersonFromChambery() {
        List<String> pStringList = TxtHelper.getDataFromTxt("persons.txt");
        List<List<String>> pSplitList = new ArrayList<>();
        for (int i = 0; i < pStringList.size(); i++) {
            pSplitList.set(i, new ArrayList<>(Arrays.asList(pStringList.get(i).split(","))));
        }

        for (List<String> person : pSplitList) {
            if (person.get(5) != null && person.get(5) == "Chambery") System.out.println(person.toString());
        }
    }

    /*
     * Recupérez depuis le serveur la liste des gens qui ont plus de 25 ans.
     * La récupération de Data se fait comme dans la question précedente
     * Tips : Vous avez dans la class Person la fonction getAge();
     */
    @Override
    public void displayBoomers() {
        List<String> pStringList = TxtHelper.getDataFromTxt("persons.txt");
        List<List<String>> pSplitList = new ArrayList<>();
        for (int i = 0; i < pStringList.size(); i++) {
            pSplitList.set(i, new ArrayList<>(Arrays.asList(pStringList.get(i).split(","))));
        }

        for (List<String> person : pSplitList) {
            if (person.get(5) != null && person.get(5) == "Chambery") System.out.println(person.toString());
        }
    }

    /*
     * Recupérez depuis le serveur la liste des gens de sexe féminin.
     * La récupération de Data se fait comme dans la question précedente
     */
    @Override
    public void displayFemales() {
        List<String> pStringList = TxtHelper.getDataFromTxt("persons.txt");
        List<List<String>> pSplitList = new ArrayList<>();

        for (int i = 0; i < pStringList.size(); i++) {
            pSplitList.set(i, new ArrayList<>(Arrays.asList(pStringList.get(i).split(","))));
        }

        for (List<String> person : pSplitList) {
            Calendar cal1 = new GregorianCalendar();
            Calendar cal2 = new GregorianCalendar();

            Date date1, date2;
            try {
                date1 = new SimpleDateFormat("MM-dd-yyyy").parse(person.get(2));
                date2 = new SimpleDateFormat("MM-dd-yyyy").parse(LocalDateTime.now().toString());
                cal1.setTime(date1);
                cal2.setTime(date2);

                if(cal1.get(Calendar.DAY_OF_YEAR) - cal2.get(Calendar.DAY_OF_YEAR) > 25)
                {
                    System.out.println(person.toString());
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    /*
     * Recupérez depuis le serveur la liste des femmes de plus de 25 ans.
     * La récupération de Data se fait comme dans la question précedente
     */
    @Override
    public void displayFemaleBoomers() {

    }

    public static void main(String[] args) {
        Exo2 exo2 = new MainExercice2();
        exo2.displayBoomers();
    }
}
