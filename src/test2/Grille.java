package test2;

public class Grille {
	private Element [][]grille;
	private int ligne;
	private int colonne;
	
	public Grille(int i, int j)
	{
		ligne=i;
		colonne=j;
		grille = new Element[i][j];
	}
	
	public void set(int i, int j, Element e)
	{
		grille[i][j]= e;
	}
	
	public boolean vide(int i, int j)
	{
		if (grille[i][j]==null)
		{
			return true;
		}
		else 
			return false;
			
	}
	
	public void clearScreen()
	{
		for (int i=0; i<10; i++)
		{
			System.out.println();
		}
	}
	
	
	public Element[][] getGrille() {
		return grille;
	}

	public void setGrille(Element[][] grille) {
		this.grille = grille;
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public int getColonne() {
		return colonne;
	}

	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

	public void afficher()
	{
		clearScreen();
		for (int i=0; i<ligne; i++)
		{
			System.out.print("|");
			for (int j=0; j<colonne; j++)
			{
				
				if (vide(i,j))
				{
					System.out.print(" ");
				}
				else
					System.out.print(grille[i][j]);
				
				System.out.print("|");
			}
			System.out.println();
		}
	}
	
	
	
}
