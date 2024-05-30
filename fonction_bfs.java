import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
//import main.Noeud;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class fonction_bfs 
{
	public static int[][] cloneMatrice(int[][] matrice) 
	{
	
		int[][] clone = new int[matrice.length][];
	    
		for (int i = 0; i < matrice.length; i++) 
		{
	    
			clone[i] = matrice[i].clone();
	    }
	    
		return clone;
	}
	
	public static int seccesseur(Noeud s,int[][]objet, Queue<Noeud> ouvert,int[]capacite,int nsac,int nbrnoeud) 
	{
		int obj_tr= s.getP();  // obj 
		int[][]solution=s.getMatrice();
		for(int i=0; i<nsac;i++) 
		{   // sac 
			// System.out.println(" sac num "+i);
			int[][] copiedMatrice = cloneMatrice(solution);
			int[] copiedTp = Arrays.copyOf(s.getTp(), s.getTp().length);//s.getTp(),
			int copiedvtotale=s.getVtotale();
			int copiedp=s.getP();
	       
			// Noeud enfant = new Noeud(nouvelleMatrice(solution), Arrays.copyOf(s.getTp(), s.getTp().length),
                  //  s.getVtotale(), s.getP());
			Noeud enfant= new Noeud(copiedMatrice,copiedTp, copiedvtotale,copiedp);
			nbrnoeud++;
		  	int[] tp=enfant.getTp();
			int d =objet[obj_tr][0]+tp[i];  // pour verifier si on peut ajoute l 'objet eu sac i ou no
			int j=i;
			// 	System.out.println("Verifier si on ajoute dans le sac " + j + ", l'objet: " + obj_tr);

			if(d<=capacite[i]) 
			{
				enfant.getMatrice()[i][obj_tr] = 1;
				
				// change le point actuale de sac a dos 
				enfant.getTp()[i] = d;
				enfant.setP(obj_tr+1);
				
				int nouvelle_v=enfant.getVtotale()+objet[obj_tr][1];
				enfant.setVtotale( nouvelle_v );
				ouvert.add(enfant);
				
			}
			else 
			{
				enfant.setP(obj_tr + 1); 
				ouvert.add(enfant);
				
				
			}
			
		}
		return nbrnoeud++;
	}
}