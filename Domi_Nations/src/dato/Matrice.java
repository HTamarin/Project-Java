package dato;


public class Matrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		matrix();
	}

	public static void matrix() {
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
		affichePlateau(plateau);
	}

	public static void affichePlateau(String[][] plateau) {
		for (int i = 0; i < plateau.length; i++) {
			System.out.print("[");
			for (int j = 0; j < plateau.length; j++) {

				System.out.print(plateau[i][j] + " ");
			}
			System.out.println("]");
		}

	}
	//public static 
}