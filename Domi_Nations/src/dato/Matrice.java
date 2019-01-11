package dato;

import java.util.*;

import javax.swing.JOptionPane;

public class Matrice {
	static int maxxj1 = 4;
	static int minxj1 = 4;
	static int maxyj1 = 4;
	static int minyj1 = 4;
	static int maxxj2 = 4;
	static int minxj2 = 4;
	static int maxyj2 = 4;
	static int minyj2 = 4;
	static int maxxj3 = 4;
	static int minxj3 = 4;
	static int maxyj3 = 4;
	static int minyj3 = 4;
	static int maxxj4 = 4;
	static int minxj4 = 4;
	static int maxyj4 = 4;
	static int minyj4 = 4;

	public static String[][] matrix() {
		String[][] plateau = new String[9][9];

		for (int i = 0; i < plateau.length; i++) {

			for (int j = 0; j < plateau.length; j++) {
				if (i == 4 && j == 4) {
					plateau[i][j] = "chateau";
				} else {
					plateau[i][j] = null;
				}
			}
		}
		return plateau;

	}

	public static void affichePlateau(String[][] plateau) {
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau.length; j++) {

				System.out.print(plateau[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static Map<String, String[][]> ajouterDominoPlateau(ArrayList<String> tourDomino, Map<String, String[][]> plateau) {
		String joueur = tourDomino.get(0);
		String domino = tourDomino.get(1);
		ArrayList<Integer> caseDispo = new ArrayList<Integer>();
		String[][] plateauJoueur = plateau.get(joueur);
		affichePlateau(plateauJoueur);
		int maxx = 0;
		int minx = 0;
		int maxy = 0;
		int miny = 0;
		int antmaxx=0;
		int antminx=0;
		int antmaxy=0;
		int antminy=0;
		if (joueur.equals("joueur1")) {
			maxx = maxxj1;
			minx = minxj1;
			maxy = maxyj1;
			miny = minyj1;
		}
		if (joueur.equals("joueur2")) {
			maxx = maxxj2;
			minx = minxj2;
			maxy = maxyj2;
			miny = minyj2;
		}
		if (joueur.equals("joueur3")) {
			maxx = maxxj3;
			minx = minxj3;
			maxy = maxyj3;
			miny = minyj3;
		}
		if (joueur.equals("joueur4")) {
			maxx = maxxj4;
			minx = minxj4;
			maxy = maxyj4;
			miny = minyj4;
		}
		System.out.println("xmax= " + maxx + " xmin= " + minx + " ymax= " + maxy + " ymin= " + miny);
		for (int i = 0; i < plateauJoueur[0].length; i++) {
			for (int j = 0; j < plateauJoueur[0].length; j++) {

				if (plateauJoueur[i][j] != null) {
					if (i > 0 && j > 0 && i < 9 && j < 9) {
						if (plateauJoueur[i + 1][j] == null) {
							if ((maxx - minx) < 4 && (maxy - miny) < 4) {
								caseDispo.add(i + 1);
								caseDispo.add(j);
							}
							if ((maxx - minx) == 4 || (maxy - miny) == 4) {
								if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
								if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
								if (((i+1 <= maxx && i+1 >= minx) && (j <= maxy && j >= miny))) {
									caseDispo.add(i+1);
									caseDispo.add(j);
								}
								if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
								if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
							}
						}
						if (plateauJoueur[i - 1][j] == null) {
							if ((maxx - minx) < 4 && (maxy - miny) < 4) {
								caseDispo.add(i - 1);
								caseDispo.add(j);
							}
							if ((maxx - minx) == 4 || (maxy - miny) == 4) {
								if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
								if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
								if (((i-1 <= maxx && -1 >= minx) && (j <= maxy && j >= miny))) {
									caseDispo.add(i-1);
									caseDispo.add(j);
								}
								if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
								if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
							}
						}
						if (plateauJoueur[i][j + 1] == null) {
							if ((maxx - minx) < 4 && (maxy - miny) < 4) {
								caseDispo.add(i);
								caseDispo.add(j+1);
							}
							if ((maxx - minx) == 4 || (maxy - miny) == 4) {
								if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
								if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
								if (((i <= maxx && i >= minx) && (j+1 <= maxy && j+1 >= miny))) {
									caseDispo.add(i);
									caseDispo.add(j+1);
								}
								if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
								if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
							}
						}
						if (plateauJoueur[i][j - 1] == null) {
							if ((maxx - minx) < 4 && (maxy - miny) < 4) {
								caseDispo.add(i);
								caseDispo.add(j-1);
							}
							if ((maxx - minx) == 4 || (maxy - miny) == 4) {
								if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
								if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
								if (((i <= maxx && i >= minx) && (j-1 <= maxy && j-1 >= miny))) {
									caseDispo.add(i);
									caseDispo.add(j-1);
								}
								if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
								if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
							}
						}
					}
					if (i == 0) {
						if (plateauJoueur[i + 1][j] == null) {
							if ((maxx - minx) < 4 && (maxy - miny) < 4) {
								caseDispo.add(i + 1);
								caseDispo.add(j);
							}
							if ((maxx - minx) == 4 || (maxy - miny) == 4) {
								if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
								if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
								if (((i+1 <= maxx && i+1 >= minx) && (j <= maxy && j >= miny))) {
									caseDispo.add(i+1);
									caseDispo.add(j);
								}
								if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
								if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
							}
						}
						if (plateauJoueur[i][j + 1] == null) {
							if ((maxx - minx) < 4 && (maxy - miny) < 4) {
								caseDispo.add(i);
								caseDispo.add(j+1);
							}
							if ((maxx - minx) == 4 || (maxy - miny) == 4) {
								if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
								if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
								if (((i <= maxx && i >= minx) && (j+1 <= maxy && j+1 >= miny))) {
									caseDispo.add(i);
									caseDispo.add(j+1);
								}
								if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
								if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
							}
						}
						if (plateauJoueur[i][j - 1] == null) {
							if ((maxx - minx) < 4 && (maxy - miny) < 4) {
								caseDispo.add(i);
								caseDispo.add(j-1);
							}
							if ((maxx - minx) == 4 || (maxy - miny) == 4) {
								if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
								if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
								if (((i <= maxx && i >= minx) && (j-1 <= maxy && j-1 >= miny))) {
									caseDispo.add(i);
									caseDispo.add(j-1);
								}
								if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
								if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
							}
						}
					}
					if (i == 9) {
						if (plateauJoueur[i - 1][j] == null) {
							if ((maxx - minx) < 4 && (maxy - miny) < 4) {
								caseDispo.add(i - 1);
								caseDispo.add(j);
							}
							if ((maxx - minx) == 4 || (maxy - miny) == 4) {
								if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
								if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
								if (((i-1 <= maxx && i-1 >= minx) && (j <= maxy && j >= miny))) {
									caseDispo.add(i-1);
									caseDispo.add(j);
								}
								if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
								if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
							}
						}
						if (plateauJoueur[i][j + 1] == null) {
							if ((maxx - minx) < 4 && (maxy - miny) < 4) {
								caseDispo.add(i);
								caseDispo.add(j+1);
							}
							if ((maxx - minx) == 4 || (maxy - miny) == 4) {
								if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
								if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
								if (((i <= maxx && i >= minx) && (j+1 <= maxy && j+1 >= miny))) {
									caseDispo.add(i);
									caseDispo.add(j+1);
								}
								if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
								if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
							}
						}
						if (plateauJoueur[i][j - 1] == null) {
							if ((maxx - minx) < 4 && (maxy - miny) < 4) {
								caseDispo.add(i);
								caseDispo.add(j-1);
							}
							if ((maxx - minx) == 4 || (maxy - miny) == 4) {
								if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
								if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
								if (((i <= maxx && i >= minx) && (j-1 <= maxy && j-1 >= miny))) {
									caseDispo.add(i);
									caseDispo.add(j-1);
								}
								if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
								if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
								
							}
						}
					}
					if (j == 0) {
						if (plateauJoueur[i + 1][j] == null) {
							if ((maxx - minx) < 4 && (maxy - miny) < 4) {
								caseDispo.add(i + 1);
								caseDispo.add(j);
							}
							if ((maxx - minx) == 4 || (maxy - miny) == 4) {
								if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
								if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
								if (((i+1 <= maxx && i+1 >= minx) && (j <= maxy && j >= miny))) {
									caseDispo.add(i+1);
									caseDispo.add(j);
								}
								if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
								if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
							}
						}
						if (plateauJoueur[i - 1][j] == null) {
							if ((maxx - minx) < 4 && (maxy - miny) < 4) {
								caseDispo.add(i - 1);
								caseDispo.add(j);
							}
							if ((maxx - minx) == 4 || (maxy - miny) == 4) {
								if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
								if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
								if (((i-1 <= maxx && i-1 >= minx) && (j <= maxy && j >= miny))) {
									caseDispo.add(i-1);
									caseDispo.add(j);
								}
								if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
								if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
							}
						}
						if (plateauJoueur[i][j + 1] == null) {
							if ((maxx - minx) < 4 && (maxy - miny) < 4) {
								caseDispo.add(i);
								caseDispo.add(j+1);
							}
							if ((maxx - minx) == 4 || (maxy - miny) == 4) {
								if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
								if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
								if (((i <= maxx && i >= minx) && (j+1 <= maxy && j+1 >= miny))) {
									caseDispo.add(i);
									caseDispo.add(j+1);
								}
								if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
								if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
							}
						}
					}
					if (j == 9) {
						if (plateauJoueur[i + 1][j] == null) {
							if ((maxx - minx) < 4 && (maxy - miny) < 4) {
								caseDispo.add(i + 1);
								caseDispo.add(j);
							}
							if ((maxx - minx) == 4 || (maxy - miny) == 4) {
								if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
								if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
								if (((i+1 <= maxx && i+1 >= minx) && (j <= maxy && j >= miny))) {
									caseDispo.add(i+1);
									caseDispo.add(j);
								}
								if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
								if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
							}
						}
						if (plateauJoueur[i - 1][j] == null) {
							if ((maxx - minx) < 4 && (maxy - miny) < 4) {
								caseDispo.add(i - 1);
								caseDispo.add(j);
							}
							if ((maxx - minx) == 4 || (maxy - miny) == 4) {
								if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
								if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
								if (((i-1 <= maxx && i-1 >= minx) && (j <= maxy && j >= miny))) {
									caseDispo.add(i-1);
									caseDispo.add(j);
								}
								if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
								if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
							}
						}
						if (plateauJoueur[i][j - 1] == null) {
							if ((maxx - minx) < 4 && (maxy - miny) < 4) {
								caseDispo.add(i);
								caseDispo.add(j-1);
							}
							if ((maxx - minx) == 4 || (maxy - miny) == 4) {
								if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
								if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
								if (((i <= maxx && i >= minx) && (j-1 <= maxy && j-1 >= miny))) {
									caseDispo.add(i);
									caseDispo.add(j-1);
								}
								if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
								if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
							}
						}
					}

				}
			}
		}
		if (caseDispo.size()!=0) {
		String[] answers = { "Droite", "Gauche" };

		ArrayList<String> Answer = new ArrayList<>();
		for (int j = 0; j < answers.length; j++) {
			Answer.add(answers[j]);
		}

		String answer = (String) JOptionPane.showInputDialog(null, "Quelle partie du domino voulez-vous poser ?",
				"Choix", JOptionPane.QUESTION_MESSAGE, null, answers, null);
		if (Turn.isNullOrEmpty(answer)) {
			System.exit(0);
		}
		String partieDomino1 = null;
		String partieDomino2 = null;
		if (answer.equals("Gauche")) {
			partieDomino1 = domino + "g";
			partieDomino2 = domino + "d";
		}
		if (answer.equals("Droite")) {
			partieDomino1 = domino + "d";
			partieDomino2 = domino + "g";
		}
		System.out.println("Les emplacements disponibles sont : ");
		int k = 1;
		for (int i = 0; i < caseDispo.size(); i = i + 2) {
			System.out.println("Emplacement " + String.valueOf(k) + " = " + "x:" + String.valueOf(caseDispo.get(i))
					+ " y:" + String.valueOf(caseDispo.get(i + 1)));
			k++;
		}
		String[] casestring = new String[caseDispo.size() / 2];
		Map<String, Integer> mapemplacement = new HashMap<String, Integer>();
		for (int j = 0; j < caseDispo.size() / 2; j++) {
			casestring[j] = String.valueOf(j + 1);
			mapemplacement.put(String.valueOf(j + 1), j + 1);
		}
		String emplacement = (String) JOptionPane.showInputDialog(null, "Quel emplacement choisissez vous ?", "Choix",
				JOptionPane.QUESTION_MESSAGE, null, casestring, null);
		if (Turn.isNullOrEmpty(emplacement)) {
			System.exit(0);
		}
		ArrayList<int[]> listeduo = new ArrayList<int[]>();
		Map<String, ArrayList<Integer>> mapcouple = new TreeMap<String, ArrayList<Integer>>();
		int debut = 0;
		for (int po = 0; po < 100; po = po + 2) {
			ArrayList<Integer> tableauduo = new ArrayList<Integer>();
			tableauduo.add(po);
			tableauduo.add(po + 1);
			mapcouple.put(String.valueOf(debut), tableauduo);
			debut++;

		}
		String l = String.valueOf(mapemplacement.get(emplacement) - 1);
		ArrayList<Integer> place = mapcouple.get(l);
		System.out.println(listeduo);
		System.out.println("l=" + l);
		System.out.println("emp=" + emplacement);

		plateauJoueur[caseDispo.get(place.get(0))][caseDispo.get(place.get(1))] = partieDomino1;

		//////////////////////////////////////////////////////

		ArrayList<Integer> case2Dispo = new ArrayList<Integer>();
		System.out.println("waypoint5");
		int i = caseDispo.get(place.get(0));
		int j = caseDispo.get(place.get(1));
		if (i > maxx) {
			maxx = i;
		}
		if (i < minx) {
			minx = i;
		}
		if (j > maxy) {
			maxy = j;
		}
		if (j < miny) {
			miny = j;
		}
		System.out.println("x= " + i + " y= " + j);
		if (i > 0 && j > 0 && i < 9 && j < 9) {
			if (plateauJoueur[i + 1][j] == null) {
				if ((maxx - minx) < 4 && (maxy - miny) < 4) {
					case2Dispo.add(i + 1);
					case2Dispo.add(j);
				}
				if ((maxx - minx) == 4 || (maxy - miny) == 4) {
					if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
					if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
					if (((i+1 <= maxx && i+1 >= minx) && (j <= maxy && j >= miny))) {
						case2Dispo.add(i+1);
						case2Dispo.add(j);
					}
					if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
					if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
				}
			}
			if (plateauJoueur[i - 1][j] == null) {
				if ((maxx - minx) < 4 && (maxy - miny) < 4) {
					case2Dispo.add(i - 1);
					case2Dispo.add(j);
				}
				if ((maxx - minx) == 4 || (maxy - miny) == 4) {
					if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
					if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
					if (((i-1 <= maxx && i-1 >= minx) && (j <= maxy && j >= miny))) {
						case2Dispo.add(i-1);
						case2Dispo.add(j);
					}
					if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
					if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
				}
			}
			if (plateauJoueur[i][j + 1] == null) {
				if ((maxx - minx) < 4 && (maxy - miny) < 4) {
					case2Dispo.add(i);
					case2Dispo.add(j+1);
				}
				if ((maxx - minx) == 4 || (maxy - miny) == 4) {
					if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
					if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
					if (((i <= maxx && i >= minx) && (j+1 <= maxy && j+1 >= miny))) {
						case2Dispo.add(i);
						case2Dispo.add(j+1);
					}
					if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
					if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
				}
			}
			if (plateauJoueur[i][j - 1] == null) {
				if ((maxx - minx) < 4 && (maxy - miny) < 4) {
					case2Dispo.add(i);
					case2Dispo.add(j-1);
				}
				if ((maxx - minx) == 4 || (maxy - miny) == 4) {
					if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
					if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
					if (((i <= maxx && i >= minx) && (j-1 <= maxy && j-1 >= miny))) {
						case2Dispo.add(i);
						case2Dispo.add(j-1);
					}
					if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
					if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
				}
			}
		}
		if (i == 0) {
			if (plateauJoueur[i + 1][j] == null) {
				if ((maxx - minx) < 4 && (maxy - miny) < 4) {
					case2Dispo.add(i + 1);
					case2Dispo.add(j);
				}
				if ((maxx - minx) == 4 || (maxy - miny) == 4) {
					if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
					if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
					if (((i+1 <= maxx && i+1 >= minx) && (j <= maxy && j >= miny))) {
						case2Dispo.add(i+1);
						case2Dispo.add(j);
					}
					if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
					if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
				}
			}
			if (plateauJoueur[i][j + 1] == null) {
				if ((maxx - minx) < 4 && (maxy - miny) < 4) {
					case2Dispo.add(i);
					case2Dispo.add(j+1);
				}
				if ((maxx - minx) == 4 || (maxy - miny) == 4) {
					if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
					if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
					if (((i <= maxx && i >= minx) && (j+1 <= maxy && j+1 >= miny))) {
						case2Dispo.add(i);
						case2Dispo.add(j+1);
					}
					if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
					if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
				}
			}
			if (plateauJoueur[i][j - 1] == null) {
				if ((maxx - minx) < 4 && (maxy - miny) < 4) {
					case2Dispo.add(i);
					case2Dispo.add(j-1);
				}
				if ((maxx - minx) == 4 || (maxy - miny) == 4) {
					if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
					if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
					if (((i <= maxx && i >= minx) && (j-1 <= maxy && j-1 >= miny))) {
						case2Dispo.add(i);
						case2Dispo.add(j-1);
					}
					if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
					if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
				}
			}
		}
		if (i == 9) {
			if (plateauJoueur[i - 1][j] == null) {
				if ((maxx - minx) < 4 && (maxy - miny) < 4) {
					case2Dispo.add(i - 1);
					case2Dispo.add(j);
				}
				if ((maxx - minx) == 4 || (maxy - miny) == 4) {
					if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
					if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
					if (((i-1 <= maxx && i-1 >= minx) && (j <= maxy && j >= miny))) {
						case2Dispo.add(i-1);
						case2Dispo.add(j);
					}
					if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
					if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
				}
			}
			if (plateauJoueur[i][j + 1] == null) {
				if ((maxx - minx) < 4 && (maxy - miny) < 4) {
					case2Dispo.add(i);
					case2Dispo.add(j+1);
				}
				if ((maxx - minx) == 4 || (maxy - miny) == 4) {
					if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
					if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
					if (((i <= maxx && i >= minx) && (j+1 <= maxy && j+1 >= miny))) {
						case2Dispo.add(i);
						case2Dispo.add(j+1);
					}
					if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
					if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
				}
			}
			if (plateauJoueur[i][j - 1] == null) {
				if ((maxx - minx) < 4 && (maxy - miny) < 4) {
					case2Dispo.add(i);
					case2Dispo.add(j-1);
				}
				if ((maxx - minx) == 4 || (maxy - miny) == 4) {
					if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
					if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
					if (((i <= maxx && i >= minx) && (j-1 <= maxy && j-1 >= miny))) {
						case2Dispo.add(i);
						case2Dispo.add(j-1);
					}
					if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
					if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
				}
			}
		}
		if (j == 0) {
			if (plateauJoueur[i + 1][j] == null) {
				if ((maxx - minx) < 4 && (maxy - miny) < 4) {
					case2Dispo.add(i + 1);
					case2Dispo.add(j);
				}
				if ((maxx - minx) == 4 || (maxy - miny) == 4) {
					if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
					if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
					if (((i+1 <= maxx && i+1 >= minx) && (j <= maxy && j >= miny))) {
						case2Dispo.add(i+1);
						case2Dispo.add(j);
					}
					if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
					if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
				}
			}
			if (plateauJoueur[i - 1][j] == null) {
				if ((maxx - minx) < 4 && (maxy - miny) < 4) {
					case2Dispo.add(i - 1);
					case2Dispo.add(j);
				}
				if ((maxx - minx) == 4 || (maxy - miny) == 4) {
					if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
					if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
					if (((i-1 <= maxx && i-1 >= minx) && (j <= maxy && j >= miny))) {
						case2Dispo.add(i-1);
						case2Dispo.add(j);
					}
					if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
					if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
				}
			}
			if (plateauJoueur[i][j + 1] == null) {
				if ((maxx - minx) < 4 && (maxy - miny) < 4) {
					case2Dispo.add(i);
					case2Dispo.add(j+1);
				}
				if ((maxx - minx) == 4 || (maxy - miny) == 4) {
					if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
					if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
					if (((i <= maxx && i >= minx) && (j+1 <= maxy && j+1 >= miny))) {
						case2Dispo.add(i);
						case2Dispo.add(j+1);
					}
					if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
					if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
				}
			}
		}
		if (j == 9) {
			if (plateauJoueur[i + 1][j] == null) {
				if ((maxx - minx) < 4 && (maxy - miny) < 4) {
					case2Dispo.add(i + 1);
					case2Dispo.add(j);
				}
				if ((maxx - minx) == 4 || (maxy - miny) == 4) {
					if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
					if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
					if (((i+1 <= maxx && i+1 >= minx) && (j <= maxy && j >= miny))) {
						case2Dispo.add(i+1);
						case2Dispo.add(j);
					}
					if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
					if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
				}
			}
			if (plateauJoueur[i - 1][j] == null) {
				if ((maxx - minx) < 4 && (maxy - miny) < 4) {
					case2Dispo.add(i - 1);
					case2Dispo.add(j);
				}
				if ((maxx - minx) == 4 || (maxy - miny) == 4) {
					if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
					if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
					if (((i-1 <= maxx && i-1 >= minx) && (j <= maxy && j >= miny))) {
						case2Dispo.add(i-1);
						case2Dispo.add(j);
					}
					if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
					if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
				}
			}
			if (plateauJoueur[i][j - 1] == null) {
				if ((maxx - minx) < 4 && (maxy - miny) < 4) {
					case2Dispo.add(i);
					case2Dispo.add(j-1);
				}
				if ((maxx - minx) == 4 || (maxy - miny) == 4) {
					if ((maxx - minx) != 4) {antmaxx=maxx;antminx=minx;maxx=9;minx=0;}
					if ((maxy - miny) != 4) {antmaxy=maxy;antminy=miny;maxy=9;miny=0;}
					if (((i <= maxx && i >= minx) && (j-1 <= maxy && j-1 >= miny))) {
						case2Dispo.add(i);
						case2Dispo.add(j-1);
					}
					if ((maxx - minx) != 4) {maxx=antmaxx;minx=antminx;}
					if ((maxy - miny) != 4) {maxy=antmaxy;miny=antminy;}
				}
			}
		}
		if (case2Dispo.size()!=0) {
		System.out.println("Les emplacements disponibles sont : ");
		int k1 = 1;

		for (int i1 = 0; i1 < case2Dispo.size(); i1 = i1 + 2) {
			System.out.println("Emplacement " + String.valueOf(k1) + " = " + "x:" + String.valueOf(case2Dispo.get(i1))
					+ " y:" + String.valueOf(case2Dispo.get(i1 + 1)));
			k1++;
		}
		String[] casestring1 = new String[case2Dispo.size() / 2];
		Map<String, Integer> mapemplacement1 = new HashMap<String, Integer>();
		for (int j1 = 0; j1 < case2Dispo.size() / 2; j1++) {
			casestring1[j1] = String.valueOf(j1 + 1);
			mapemplacement1.put(String.valueOf(j1 + 1), j1 + 1);
		}
		String emplacement1 = (String) JOptionPane.showInputDialog(null, "Quel emplacement choisissez vous ?", "Choix",
				JOptionPane.QUESTION_MESSAGE, null, casestring1, null);
		if (Turn.isNullOrEmpty(emplacement1)) {
			System.exit(0);
		}
		ArrayList<int[]> listeduo1 = new ArrayList<int[]>();
		Map<String, ArrayList<Integer>> mapcouple1 = new TreeMap<String, ArrayList<Integer>>();
		int debut1 = 0;
		for (int po = 0; po < 100; po = po + 2) {
			ArrayList<Integer> tableauduo = new ArrayList<Integer>();
			tableauduo.add(po);
			tableauduo.add(po + 1);
			mapcouple1.put(String.valueOf(debut1), tableauduo);
			debut1++;

		}
		String l1 = String.valueOf(mapemplacement1.get(emplacement1) - 1);
		ArrayList<Integer> place1 = mapcouple1.get(l1);
		System.out.println(listeduo1);
		System.out.println("l=" + l1);
		System.out.println("emp=" + emplacement1);
		int x = case2Dispo.get(place1.get(0));
		int y = case2Dispo.get(place1.get(1));
		if (x > maxx) {
			maxx = x;
		}
		if (x < minx) {
			minx = x;
		}
		if (y > maxy) {
			maxy = y;
		}
		if (y < miny) {
			miny = y;
		}
		plateauJoueur[case2Dispo.get(place1.get(0))][case2Dispo.get(place1.get(1))] = partieDomino2;
		affichePlateau(plateauJoueur);
		System.out.println("xmax= " + maxx + " xmin= " + minx + " ymax= " + maxy + " ymin= " + miny);
		if (joueur.equals("joueur1")) {
			maxxj1 = maxx;
			minxj1 = minx;
			maxyj1 = maxy;
			minyj1 = miny;
		}
		if (joueur.equals("joueur2")) {
			maxxj2 = maxx;
			minxj2 = minx;
			maxyj2 = maxy;
			minyj2 = miny;
		}
		if (joueur.equals("joueur3")) {
			maxxj3 = maxx;
			minxj3 = minx;
			maxyj3 = maxy;
			minyj3 = miny;
		}
		if (joueur.equals("joueur4")) {
			maxxj4 = maxx;
			minxj4 = minx;
			maxyj4 = maxy;
			minyj4 = miny;
		}
		}
	}
		plateau.put(joueur,plateauJoueur);
		return plateau;
	}

}
