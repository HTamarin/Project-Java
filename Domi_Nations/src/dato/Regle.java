package com.company;

import java.io.File;
import java.util.*;

public class Regle {

    static int i = 0;
    boolean equals;

    /**
     * Ce programme permet , en fonction du nombre de joueurs , de definir les
     * dominos restant
     *
     * @param e
     * @return
     */
    public static Map<String, ArrayList<String>> regleJoueur(int e) {
        Map<String, ArrayList<String>> FullDomino = Domino.domino();
        Map<String, ArrayList<String>> PoolDominos = new HashMap<String, ArrayList<String>>();
        ArrayList<String> fullDom = new ArrayList<String>();
        boolean equals;
        if (e == 2) {

            int MaxDominos = 24; // Nombre total de dominos
            int[] random = new int[MaxDominos];
            while (i != MaxDominos) {
                random[i] = ((int) (Math.random() * 47)) + 1; // Valeure aléatoire entre 1 et 48
                equals = false;
                for (int j = 0; j != i; j++) { // Verification des doublons
                    if (random[j] == random[i]) {
                        equals = true;
                    }
                }
                if (!equals) {
                    i++;
                }
            }

            for (int o = 0; o < random.length; o++) {
                String u = String.valueOf(random[o]); // Change chaque entier en String

                fullDom = FullDomino.get(u); // Renvoit la liste correspondant à l'indice u <String>
                PoolDominos.put(u, fullDom);
                // System.out.println(u);
                // jou.put("Joueur"+String.valueOf(random[o]),c)
            }

        }
        if (e == 3) {
            // même chose que precedement , sauf que MaxDominos = 36
            int MaxDominos = 36;
            int[] random = new int[MaxDominos];
            while (i != MaxDominos) {
                random[i] = ((int) (Math.random() * 47)) + 1;
                equals = false;
                for (int j = 0; j != i; j++) {
                    if (random[j] == random[i]) {
                        equals = true;
                    }
                }
                if (!equals) {
                    i++;
                }
            }

            for (int o = 0; o < random.length; o++) {

                String u = String.valueOf(random[o]);

                fullDom = FullDomino.get(u);
                PoolDominos.put(u, fullDom);
            }

        }

        if (e == 4) {

            PoolDominos = FullDomino;

        }
        System.out.println("Les dominos restants sont : " + PoolDominos);
        return PoolDominos;

    }

    public void calculscore(String joueur  Map<String, String[][]> PlateauJoueur){
        String [][] tableaudomaine =  new String[9][9];
        ArrayList<int[]> cordonees = new ArrayList<>();

        List<String> nomdomaine = new Arrays.asList("Champs","Foret", "Mer", "Prairie", "Mine", "Montagne");
        int[] tableaucordonees = new int[2];


        String [][] plateaujoueur = PlateauJoueur.get(joueur);

        int i=0;

        while(i<nomdomaine.size()){
            ArrayList<int[]> caseutilise = new ArrayList<>();
            int count = 1;
            for (int x= 0; x < 9  ; x++){
                for (int y = 0 ; y < 9; y++){
                    String domaine = Domino.domaine(PlateauJoueur[x][y]);

                    if(domaine.equals(nomdomaine.get(i)) ) {
                        tableaucordonees[0] = x;
                        tableaucordonees[1] = y;
                        tableaudomaine[x][y] = Plateaujoueur[x][y];//Plateau avec dominos du même domaine
                        cordonees.add(tableaucordonees);//Liste composé de couple x,y. De chaque domino.
                    }
                    else{

                        tableaudomaine = null;
                    }
                    boolean condition = true;
                    boolean repete = true;
                    for(int j=0; j<cordonees.size(); j++ ){//Parcours la liste cordonees, (2 par deux)

                        ArrayList<int[]> couple = new ArrayList<>();
                        
                        int[] couple = (cordonees.get(j)); //decoupe la liste en séprarant les couples
                        while(repete){
                        if (condition){
                        int x = couple[0];//On redefini x à x //Problème!!!!!
                        int y = couple[1];//On redefini y à y
                        }

                        couple[0] = x;
                        couple[1] = y;
                        caseutilise.add(couple);

                        ArrayList<int[]> couplereferant = new ArrayList<>();//Liste des couples referant
                        couplereferant.add(new int[]{x-1,y});
                        couplereferant.add(new int[]{x+1,y});
                        couplereferant.add(new int[]{x,y-1});
                        couplereferant.add(new int[]{x,y+1});
                        int valrep = 0;
                        for(int k=0; k<4; k++ ){//Taille de couple referant
                            if(cordonees.contains(couplereferant.get(k))){
                                int xans = couplereferant.get(k)[0];
                                int yans = couplereferant.get(k)[1];
                                count++;
                                couplereferant.remove(couplereferant.get(k));
                                x = xans;
                                y = yans;
                                condition = false;
                            }
                            else{
                                valrep++;
                                if(valrep==3){
                                    repete = false   
                                }
                            }
                        }
                        }

                    }


                    i++;
                }
            }
        }
    }

}

