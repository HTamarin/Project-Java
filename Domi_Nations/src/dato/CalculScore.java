package dato;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculScore{
    private static int scoretemporaire = 0;
    private static int couronne = 0;
    private static int nbcouronne = 0;
    private static HashMap<Integer, Integer> tableaucoordonnex = new HashMap<Integer, Integer>();
    private static HashMap<Integer,  Integer> tableaucoordonney = new HashMap<Integer, Integer>();
    static String [][] plateaujoueur ={{null ,null, null, null, null, null, null, null, null},
            {null ,null, null, null, null, null, null, null, null},
            {null ,"46d", "46d" ,"46d", "46d", "46d", null, null, null},
            {null ,"46d" ,"46d" ,"46d", "46d", "38d", null, null, null},
            {null ,"46d" ,"46d" ,"46d" ,"chateau", null, null,null, null},
            {null ,"46d","46d", "46d" ,"46d" ,null ,null ,null ,null},
            {null ,null ,null ,null ,"38d" ,null ,null ,null, null},
            {null ,null, null, null, null, null, null, null, null},
            {null ,null, null, null, null, null, null, null, null}};

    public static int calculScore() { //Plateau censé être celui du joueur) {
        ArrayList<String> nomdomaine = new ArrayList<>();
        nomdomaine.add("Champs");
        nomdomaine.add("Foret");
        nomdomaine.add("Mer");
        nomdomaine.add("Prairie");
        nomdomaine.add("Mine");
        nomdomaine.add("Montagne");
        String domainedomino=null;
        String domaine = null;
        int score = 0;
        int scorefinal = 0;
        int indicepremiertableau;

        for (int d = 0; d < 6; d++) {
            indicepremiertableau = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    String domino = plateaujoueur[i][j];
                    if(domino!=null && !domino.equals("chateau")) {
                        domainedomino = Domino.splitDomaine(domino);
                        domaine=nomdomaine.get(d);
                        if (domainedomino.equals(domaine)) {
                            tableaucoordonnex.put(indicepremiertableau, i);
                            tableaucoordonney.put(indicepremiertableau, j);
                            indicepremiertableau++;
                        }
                    }
                }
            }

            while (tableaucoordonnex.size() != 0) {
                int indice = (Integer) tableaucoordonnex.keySet().toArray()[0];
                int change = (int) tableaucoordonnex.keySet().toArray()[0];
                calculScorerecursif(change, tableaucoordonnex.get(indice), tableaucoordonney.get(indice), plateaujoueur);
                score = score + scoretemporaire*nbcouronne;
                scorefinal = score;
            }
        }

        return (scorefinal);
    }


    public static void calculScorerecursif(int indice, int x, int y, String [][] plateaujoueur) {

        couronne = Domino.splitCouronne(plateaujoueur[x][y]); //on veut récupérer le nombre de couronnes selon notre x et notre y;
        tableaucoordonnex.remove(indice);
        tableaucoordonney.remove(indice);
        nbcouronne=couronne+nbcouronne;
        scoretemporaire++;

        for (int key = 0; key < 81; key++) {
            if (tableaucoordonnex.containsKey(key)) {


                int xtemp = tableaucoordonnex.get(key);
                int ytemp = tableaucoordonney.get(key);

                if ((xtemp == x + 1 && ytemp == y) ||
                        (xtemp == x - 1 && ytemp == y) ||
                        (xtemp == x && ytemp == y - 1) ||
                        (xtemp == x && ytemp == y + 1)) {

                    calculScorerecursif(key, xtemp, ytemp, plateaujoueur);
                }
            }
        }

    }
}