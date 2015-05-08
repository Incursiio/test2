package test2;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.*;

public class Panel extends JPanel{
	public Panel(Grille grille)
	{
	
		String contenuCase = (" ");
		
		this.setLayout(new GridLayout(grille.getLigne(), grille.getColonne()));
		for(int i=0; i<grille.getLigne(); i++)
		{
			for (int j=0; j<grille.getColonne(); j++)
			{
				if (grille.vide(i,j))
					contenuCase = " ";
				else
					contenuCase = "" + grille.getGrille()[i][j];
				
				JButton caseGrille = new JButton(contenuCase);
				this.add(caseGrille);
			}
		}
		
	}
	
	
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
	}
	
	public void repaint(){
		revalidate();
		super.repaint();
	}
}
