package data;

public class Terrain {

	public static Case[][] terrain = new Case[5][5];
	
	public Case getCase(int indiceLigne, int indiceColonne) {
		return terrain[indiceLigne][indiceColonne];
	}
		
	public void placedDominoHorizontal(int indiceLigne, int indiceColonne){
			
		getCase(indiceLigne, indiceColonne).setFree();
		getCase(indiceLigne+1, indiceColonne).setFree();
		
	}
	public void placedDominoVertical(int indiceLigne, int indiceColonne){
	
		getCase(indiceLigne, indiceColonne).setFree();
		getCase(indiceLigne, indiceColonne+1).setFree();
	}

	
	
		
	
	
}
