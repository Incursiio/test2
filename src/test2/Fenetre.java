package test2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Fenetre extends JFrame{
	private Random rand = new Random();
	static int direction;
	private Croix croix;
	private Grille grille;
	private JButton caseGrille = new JButton();
	private JPanel container;
	
	public Fenetre(String titre)
	{
		super(titre);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.initialise();
		this.setBounds(0, 0, 800, 600);
		this.setVisible(true);
		}
	
	
	
	public void initialise()
	{
		this.grille = new Grille(5,5);
		croix = new Croix(2,2);
		
		Obstacle o1;
		Obstacle o2;
		Pion p;
		grille.set(2, 2, croix);
		//debut du placement des obstacles
		int a =0;
		int ligne=0;
		int colonne=0;
		while (a<2)
		{
			ligne = rand.nextInt(grille.getLigne());
			colonne = rand.nextInt(grille.getColonne());
			
			if (a==0)
			{
				if (grille.vide(ligne, colonne))
				{
					o1 = new Obstacle(ligne, colonne);
					grille.set(ligne, colonne, o1);
					a++;
				}
					
			}
			else if(a==1)
			{
				if (grille.vide(ligne, colonne))
				{
					o2 = new Obstacle(ligne, colonne);
					grille.set(ligne,  colonne, o2);
					a++;
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
		
		
		getContentPane().setLayout(new BorderLayout());
		container = new Panel(grille);
		getContentPane().add(container, BorderLayout.CENTER);
		getContentPane().add(this.getPanelSud(), BorderLayout.SOUTH);
	}
	
//	private JPanel getPanelCentre()
//	{
//		String contenuCase = (" ");
//		container = new JPanel();
//		container.setLayout(new GridLayout(grille.getLigne(), grille.getColonne()));
//		for(int i=0; i<grille.getLigne(); i++)
//		{
//			for (int j=0; j<grille.getColonne(); j++)
//			{
//				if (grille.vide(i,j))
//					contenuCase = " ";
//				else
//					contenuCase = "" + grille.getGrille()[i][j];
//				
//				JButton caseGrille = new JButton(contenuCase);
//				container.add(caseGrille);
//			}
//		}
//		
//		return container;
//	}
	
	
	private JPanel getPanelSud()
	{
		JPanel bouton = new JPanel();
		bouton.setLayout(new GridLayout(3, 3));
		JButton haut = new JButton("haut");
		JButton bas = new JButton("bas");
		JButton gauche = new JButton("gauche");
		JButton droite = new JButton("droite");
		JButton vide1 = new JButton();
		JButton vide2 = new JButton();
		JButton vide3 = new JButton();
		JButton vide4 = new JButton();
		JButton vide5 = new JButton();
		vide1.setEnabled(false);
		vide2.setEnabled(false);
		vide3.setEnabled(false);
		vide4.setEnabled(false);
		vide5.setEnabled(false);
		bouton.add(vide1);
		bouton.add(haut);
		bouton.add(vide2);
		bouton.add(gauche);
		bouton.add(vide3);
		bouton.add(droite);
		bouton.add(vide4);
		bouton.add(bas);
		bouton.add(vide5);
		
		
		haut.addActionListener(new ButtonListenerH());
		bas.addActionListener(new ButtonListenerB());
		gauche.addActionListener(new ButtonListenerG());
		droite.addActionListener(new ButtonListenerD());
		
		return bouton;
	}
	
	public class ButtonListenerH implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			direction =0;
			croix.deplacer(direction, grille);
			System.out.println(croix.getColonne());
			System.out.println(croix.getLigne());
			
			container.removeAll();
			container.repaint();
			
			//getContentPane().removeAll();
			//container.revalidate();
			//getContentPane().validate();
			//container.repaint();
		}
	}
	
	public class ButtonListenerB implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			direction = 1;
			croix.deplacer(direction, grille);
			System.out.println(croix.getColonne());
			System.out.println(croix.getLigne());
			
			container.validate();
			container.repaint();
		}
	}
	
	public class ButtonListenerG implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			direction = 2;
			croix.deplacer(direction, grille);
			System.out.println(croix.getColonne());
			System.out.println(croix.getLigne());
			
			container.validate();
			container.repaint();
		}
	}
	
	public class ButtonListenerD implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			direction = 3;
			croix.deplacer(direction, grille);
			System.out.println(croix.getColonne());
			System.out.println(croix.getLigne());
			
			container.validate();
			container.repaint();
		}
	}
}
