package dato;

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

            int maxDominos = 24; // Nombre total de dominos
            int[] random = new int[maxDominos];
            while (i != maxDominos) {
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
            int maxDominos = 36;
            int[] random = new int[maxDominos];
            while (i != maxDominos) {
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
       // System.out.println("Les dominos restants sont : " + PoolDominos);
        return PoolDominos;

    }

    public static int calculscore(String joueur,  Map<String, String[][]> plateaux){
        String [][] tableaudomaine =  new String[9][9];
        ArrayList<int[]> cordonees = new ArrayList<>();
        int score = 0;
        List<String> nomdomaine = Arrays.asList("Champs","Foret", "Mer", "Prairie", "Mine", "Montagne");
        int[] tableaucordonees = new int[2];


        String [][] plateaujoueur = plateaux.get(joueur);

        int i=0;

        while(i<nomdomaine.size()){
            int count = 1;
            for (int x= 0; x < 9  ; x++){
                for (int y = 0 ; y < 9; y++){
                    String domaine = Domino.splitDomaine(plateaujoueur[x][y]);    
                    if(domaine.equals(nomdomaine.get(i)) ) {
                        tableaucordonees[0] = x;
                        tableaucordonees[1] = y;
                        tableaudomaine[x][y] = plateaujoueur[x][y];//Plateau avec dominos du même domaine
                        cordonees.add(tableaucordonees);//Liste composé de couple x,y. De chaque domino.
                    }
                    else{
                        tableaudomaine = null;
                    }
                }
            }
                    boolean condition = true;
                    int x=0;
                    int y=0;
                    for(int j=0; j<cordonees.size(); j++ ){//Parcours la liste cordonees, (2 par deux)
                        int couronne=0;
                        boolean repete = true;
                        ArrayList<int[]> couple = new ArrayList<>();
                        
                        int[] couple1 = (cordonees.get(j)); //decoupe la liste en séprarant les couples
                        while(repete){
                        if (condition){
                         x = couple1[0];//On redefini x à x //Problème!!!!!
                         y = couple1[1];//On redefini y à y
                        }                           
                        int couronnecase = Domino.splitCouronne(plateaujoueur[x][y]);
                        couronne=couronne+couronnecase;
                        ArrayList<int[]> couplereferant = new ArrayList<>();//Liste des couples referant
                        couplereferant.add(new int[]{x-1,y});
                        couplereferant.add(new int[]{x+1,y});
                        couplereferant.add(new int[]{x,y-1});
                        couplereferant.add(new int[]{x,y+1});
                        
                        int valrep = 0;
                        for(int k=0; k<4; k++ ){//Taille de couple referant
                            if(cordonees.contains(couplereferant.get(k))){
                                x = couplereferant.get(k)[0];
                                y = couplereferant.get(k)[1];
                                count++;
                                cordonees.remove(couplereferant.get(k));
                                condition = false;
                                
                            }
                            else{
                                valrep++;
                                if(valrep==3){
                                    score=score+couronne*count;
                                    repete = false;
                                    condition = true;
                                    couronne = 0;
                                    count=1;
                                }
                            }
                        }
                        }

                    }
                    i++;
                }
            
        return score;
    }
    public static boolean contains(ArrayList<int[]> cordonees,int[] pos){
    	boolean condition=false;
    	for (int i = 0 ;i<cordonees.size();i++) {
    		if(egal(cordonees.get(i),pos)) {
    			condition=true;
    			}
    		}
		return condition;

    	
    }
    public static boolean egal(int[] tabe1, int[] tabe2){
        int ind=0;
        boolean rep=false;
         
        do{
            if(tabe1[ind]==tabe2[ind]){
                rep=true;
                ind+=1;
            }else{
                rep=false;
            }
        }while(tabe1[ind]==tabe2[ind] && ind<1);
        return rep;
    }
}


