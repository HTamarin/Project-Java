import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class oli{
    private static int scoretemp = 0;
    private static HashMap<Integer, Integer> tableauX = new HashMap<Integer, Integer>();
    private static HashMap<Integer, Integer> tableauY = new HashMap<Integer, Integer>();
    static String [][] plateaujoueur ={{null ,null, null, null, null, null, null, null, null},
            {null ,null, null, null, null, null, null, null, null},
            {null ,"46d", "35d" ,"47d", "9g", "36d", null, null, null},
            {null ,"46g" ,"35g" ,"47g", "9d", "36g", null, null, null},
            {null ,"5d" ,"11d" ,"37d" ,"chateau", null, null,null, null},
            {null ,"5g","11g", "37g" ,"8d" ,null ,null ,null ,null},
            {null ,null ,null ,null ,"8g" ,null ,null ,null, null},
            {null ,null, null, null, null, null, null, null, null},
            {null ,null, null, null, null, null, null, null, null}};

    public static int calculScore() {
        ArrayList<String> nomdomaine = new ArrayList<>();
        nomdomaine.add("Champs");
        nomdomaine.add("Foret");
        nomdomaine.add("Mer");
        nomdomaine.add("Prairie");
        nomdomaine.add("Mine");
        nomdomaine.add("Montagne");
        String domainedomino=null;
        String domaine = null;
        int[] temp = new int[2];
        int score = 0;
        int nbCouronnes = 0;
        int scorefinal = 0;
        int f;

        for (int d = 0; d < 6; d++) {
            f = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    String domino = plateaujoueur[i][j];
                    if(domino!=null && !domino.equals("chateau")) {
                        domainedomino = Domino.splitDomaine(domino);
                        domaine=nomdomaine.get(d);
                        if (domainedomino.equals(domaine)) {
                            tableauX.put(f, i);
                            tableauY.put(f, j);
                            f++;
                            System.out.println("f= "+f);
                        }
                    }
                }
            }
            System.out.println("tableauX = " + tableauX);
            System.out.println("tableauY = " + tableauY);

            while (tableauX.size() != 0) {
                scoretemp = 0;
                int lol = (Integer) tableauX.keySet().toArray()[0];
                System.out.println("lol = " +lol);
                calculScore2(lol, tableauX.get(lol), tableauY.get(lol));
                nbCouronnes = Domino.domino.get(0);
                score = score + scoretemp;
                scorefinal = score * nbCouronnes;
            }
        }

        return (scorefinal);
    }


    public static void calculScore2(int indice, int x, int y) {
        tableauX.remove(indice);
        tableauY.remove(indice);
        scoretemp++;
        for (int cle = 0; cle < 81; cle++) {
            if (tableauX.containsKey(cle)) {


                int xTemporaire = tableauX.get(cle);
                int yTemporaire = tableauY.get(cle);

                if ((xTemporaire == x + 1 && yTemporaire == y) ||
                        (xTemporaire == x - 1 && yTemporaire == y) ||
                        (xTemporaire == x && yTemporaire == y - 1) ||
                        (xTemporaire == x && yTemporaire == y + 1)) {

                    calculScore2(cle, xTemporaire, yTemporaire);
                }
            }
        }

    }
}
