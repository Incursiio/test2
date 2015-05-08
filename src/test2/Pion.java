package test2;

public class Pion extends Element{
	public Pion (int ligne, int colonne)
	{
		super(ligne, colonne);
	}
	
	public boolean deplacementPossible(int direction, Grille grille)
	{
		int ligne = this.getLigne();
		int colonne = this.getColonne();
		
		if (direction == 0)
		{
			if (this.getLigne()>0 && grille.vide(ligne-1, colonne))
			{
				return true;
			}
			
		}
		else if (direction == 1)
		{
			if (this.getLigne()<grille.getLigne()-1 && grille.vide(ligne+1, colonne))
			{
				return true;
			}
			
		}
		else if (direction == 2)
		{
			if (this.getColonne()>0 && grille.vide(ligne, colonne-1))
			{
				return true;
			}
			
		}
		else if (direction == 3)
		{
			if (this.getColonne()<grille.getColonne()-1 && grille.vide(ligne, colonne+1))
			{
				return true;
			}
		}
		return false;
	
	}
	
	public boolean deplacer(int direction, Grille grille)
	{
		int ligne = this.getLigne();
		int colonne = this.getColonne();
		
		if (direction == 0)
		{
			if (this.getLigne()>0 && grille.vide(ligne-1, colonne))
			{
				this.setLigne(ligne-1);
				this.setColonne(colonne);
				grille.set(ligne, colonne, null);
				grille.set(this.getLigne(), this.getColonne(), this);
				return true;
			}
			
		}
		else if (direction == 1)
		{
			if (this.getLigne()<grille.getLigne()-1 && grille.vide(ligne+1, colonne))
			{
				this.setLigne(ligne+1);
				this.setColonne(colonne);
				grille.set(ligne, colonne, null);
				grille.set(this.getLigne(), this.getColonne(), this);
				return true;
			}
			
		}
		else if (direction == 2)
		{
			if (this.getColonne()>0 && grille.vide(ligne, colonne-1))
			{
				this.setLigne(ligne);
				this.setColonne(colonne-1);
				grille.set(ligne, colonne, null);
				grille.set(this.getLigne(), this.getColonne(), this);
				return true;
			}
			
		}
		else if (direction == 3)
		{
			if (this.getColonne()<grille.getColonne()-1 && grille.vide(ligne, colonne+1))
			{
				this.setLigne(ligne);
				this.setColonne(colonne+1);
				grille.set(ligne, colonne, null);
				grille.set(this.getLigne(), this.getColonne(), this);
				return true;
			}
		}
		return false;
	}

	public String toString()
	{
		return "P";
	}
}
