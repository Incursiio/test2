package test2;

public class Croix extends Element{
	
	public Croix(int ligne, int colonne)
	{
		super(ligne, colonne);
	}
	
	public void deplacer(int direction, Grille grille)
	{
		int ligne = this.getLigne();
		int colonne = this.getColonne();
		int x=0;
		int y=0;
		if (direction == 0)
		{
			//if (this.getLigne()>0 && (grille.vide(ligne-1, colonne) || grille.getGrille()[ligne-1][colonne].isPion()))
			if (this.getLigne()>0 && (grille.vide(ligne-1, colonne) || grille.getGrille()[ligne-1][colonne].getClass()==Pion.class))
			{
				x-=1;
			}
			
		}
		else if (direction == 1)
		{
			if (this.getLigne()<grille.getLigne()-1 && (grille.vide(ligne+1, colonne)|| grille.getGrille()[ligne+1][colonne].getClass()==Pion.class))
			{
				x++;
			}
			
		}
		else if (direction == 2)
		{
			if (this.getColonne()>0 && (grille.vide(ligne, colonne-1)|| grille.getGrille()[ligne][colonne-1].getClass()==Pion.class))
			{
				y-=1;
			}
			
		}
		else if (direction == 3)
		{
			if (this.getColonne()<grille.getColonne()-1 && (grille.vide(ligne, colonne+1)|| grille.getGrille()[ligne][colonne+1].getClass()==Pion.class))
			{
				y++;
			}
			
		}
		
		grille.set(ligne, colonne, null);
		this.setLigne(ligne+x);
		this.setColonne(colonne+y);
		grille.set(this.getLigne(), this.getColonne(), this);
	}
	
	public String toString()
	{
		return "X";
	}
	
}
