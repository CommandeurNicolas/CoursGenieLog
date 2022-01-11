package exercice1;

import datamocklib.Person;
import datamocklib.TxtHelper;

import java.util.ArrayList;
import java.util.List;


public class MainExercice1 {

    // Format du fichier : firstName,lastName,birthDate,gender,cityOfResidence,cityOfBirth
    // Pas de header
    public static List<Person> parse(List<String> data) {
        // A COMPLETER
        ArrayList<Person> pList = new ArrayList<Person>();
        pList.add(new Person(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4), data.get(5)));
        return pList;
    }

    public static void main(String[] args) {
        // EXO 1
        System.out.println(args);
        List<String> data = TxtHelper.getDataFromTxt(args[0]);

        List<Person> pList = parse(data);

        System.out.println(pList);

        /*
         * - Récuperez la liste des personnes sous la forme -> firstName,lastName,birthDate,gender,cityOfResidence,cityOfBirth
         *   grâce à la fonction TxtHelper.getDataFromTxt("persons.txt")
         * - Parser la liste des Personnes grâce à la fonction parse())
         * - Calculer le nombre de personnes nées dans chaque ville avec les données obtenues.
         * Les données contiennent une trentaine de villes, Bonne chance !
        */


    }
}
