import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class oli{
    private static int scoretemporaire = 0;
    private static HashMap<Integer, Integer> tableaucoordonnex = new HashMap<Integer, Integer>();
    private static HashMap<Integer Integer> tableaucoordonney = new HashMap<Integer, Integer>();
    static String [][] plateaujoueur ={{null ,null, null, null, null, null, null, null, null},
            {null ,null, null, null, null, null, null, null, null},
            {null ,"46d", "35d" ,"47d", "9g", "36d", null, null, null},
            {null ,"46g" ,"35g" ,"47g", "9d", "36g", null, null, null},
            {null ,"5d" ,"11d" ,"37d" ,"chateau", null, null,null, null},
            {null ,"5g","11g", "37g" ,"8d" ,null ,null ,null ,null},
            {null ,null ,null ,null ,"8g" ,null ,null ,null, null},
            {null ,null, null, null, null, null, null, null, null},
            {null ,null, null, null, null, null, null, null, null}};

    public static int calculScore( String joueur  String [][] plateaujoueur //Plateau censé être celui du joueur) {
        ArrayList<String> nomdomaine = new ArrayList<>();
        nomdomaine.add("Champs");
        nomdomaine.add("Foret");
        nomdomaine.add("Mer");
        nomdomaine.add("Prairie");
        nomdomaine.add("Mine");
        nomdomaine.add("Montagne");
        String domainedomino=null;
        String domaine = null;
        int nbCouronnes;
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
            System.out.println("tableauX = " + tableaucoordonnex);
            System.out.println("tableauY = " + tableaucoordonney);

            while (tableauX.size() != 0) {
                nbCouronnes = 0;
                scoretemp = 0;
                int change = (int) tableaucoordonnex.keySet().toArray()[0];
                System.out.println("lol = " +lol);
                calculScore2(change, tableaucoordonnex.get(lol), tableaucoordonney.get(lol), plateaujoueur);
                nbCouronnes = Domino.domino.get(0);
                score = score + scoretemporaire;
                scorefinal = score * nbCouronnes;
            }
        }

        return (scorefinal);
    }


    public static void calculScorerecursif(int indice, int x, int y, /*classe du plateau ? */ plateaujoueur) {

        nbCouronnes += domino.spliDomaine(plateau[x][y]); //on veut récupérer le nombre de couronnes selon notre x et notre y;
        tableaucoordonnex.remove(indice);
        tableaucoordonney.remove(indice);
        scoretemporaire++;

        for (int key = 0; key < 81; key++) {
            if (tableaucoordonnex.containsKey(key)) {


                int xtemp = tableaucoordonnex.get(cle);
                int ytemp = tableaucoordonney.get(cle);

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
