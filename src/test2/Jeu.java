package test2;

import java.util.Random;
import java.util.Scanner;

public class Jeu {

	private Grille grille;
	private Croix x;
	private Obstacle o1;
	private Obstacle o2;
	private Pion p;
	private Scanner input = new Scanner(System.in);
	private Random rand = new Random();
	
	public Jeu()
	{
		initialiseJeu();
		menuDeplacement();
	}
	
	public void initialiseJeu()
	{
		grille = new Grille(4,4);
		x = new Croix(2,2);
		grille.set(2, 2, x);
		
		
		
		//debut du placement des obstacles
		int i =0;
		int ligne=0;
		int colonne=0;
		while (i<2)
		{
			ligne = rand.nextInt(grille.getLigne());
			colonne = rand.nextInt(grille.getColonne());
			
			if (i==0)
			{
				if (grille.vide(ligne, colonne))
				{
					o1 = new Obstacle(ligne, colonne);
					grille.set(ligne, colonne, o1);
					i++;
				}
				
			}
			else if(i==1)
			{
				if (grille.vide(ligne, colonne))
				{
					o2 = new Obstacle(ligne, colonne);
					grille.set(ligne,  colonne, o2);
					i++;
				}
				
			}
		}//////fin du placement des obstacles
		//Placement pion
		while (!grille.vide(ligne, colonne))
		{
			ligne = rand.nextInt(grille.getLigne());
			colonne = rand.nextInt(grille.getColonne());
		}
		
		p = new Pion(ligne, colonne);
		grille.set(ligne, colonne, p);
		//Fin placement du pion
	}
	
	public void menuDeplacement()
	{
		grille.afficher();
		int choix=-1;
		boolean fin=false;
		do
		{
			do
			{
				System.out.println("0 - Haut\n1 - Bas\n2 - Gauche\n3 - Droite\n4 - Stop\n");
				choix = input.nextInt();
				if (choix<0 || choix>4)
					System.out.println("Mauvaise saisie");
				
			}while (choix!=2 && choix!=4 && choix!=8 && choix!=6);
			
			switch (choix) {
				case 8:
					x.deplacer(0, grille);
					break;
				case 2:
					x.deplacer(1, grille);		
					break;
				case 4:
					x.deplacer(2, grille);
					break;
				case 6:
					x.deplacer(3, grille);
					break;
				case 0:
					
					break;
				default:
					break;
			}
			
			
			grille.afficher();
			if (p.getColonne()==x.getColonne() && p.getLigne()==x.getLigne())
			{
				fin = true;
			}
			int direction = 0;
			if (fin==false)
			{
				//deplacement Pion
				
				if (p.deplacementPossible(0, grille) || p.deplacementPossible(1, grille) || p.deplacementPossible(2, grille) || p.deplacementPossible(4, grille))
				{
					boolean deplacer = false;
					while(deplacer==false)
					{
						direction = rand.nextInt(4);
						if (p.deplacer(direction, grille))
						{
							deplacer = true;
						}
					}
				}
				
			}
			grille.afficher();
			System.out.println(direction);
			
		}while(choix!=0);
		
	}
	
}
