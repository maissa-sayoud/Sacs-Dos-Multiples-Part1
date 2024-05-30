import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class fonction_A 

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
	
	public static boolean etat_finale( NoeudA s,int profondeur)
	{
		if(s.getP()==profondeur) 
		{
			return true;
		}
		else 
		{
			return false;
		}
		
	}
	
	public static int H_fct(int poit_totale,int[]tp) 
	{
		// le cout reste : etat ectual --> but :le point totale disponible dans les n sac a dos ( a minimise )
		int somme=0;
		
		for (int element : tp) 
		{
			somme += element;
	    }
		
		int rest=poit_totale-somme;
		
		return  rest;
	}
	
	public static int G_fct(int g) 
	{
		// le cout : eta initiale --> etat actuale : dans chaque niveau +1 
		return g+1;
	}
	
	public static int F_fct(int g,int h) 
	{
		
		return g+h;
	}
	
	
	public static int seccesseur(NoeudA s,int[][]objet,  List<NoeudA> ouvert  ,int[]capacite, int nsac, int poit_totale,int nbrnoeud) 
	{
		
	     	int obj_tr= s.getP();  // obj 
		    int[][]solution=s.getMatrice();
		
		    for(int i=0; i<nsac;i++) 
		    {   
		    	// sac 
		    	// System.out.println(" sac num "+i);
		    	int[][] copiedMatrice = cloneMatrice(solution);
		    	int[] copiedTp = Arrays.copyOf(s.getTp(), s.getTp().length);//s.getTp(),
		    	int copiedvtotale=s.getVtotale();
		    	int copiedp=s.getP();
		    	int copiedg=s.getG();
		    	int nbnoeud; 
		    	NoeudA enfant= new NoeudA(copiedMatrice, copiedTp, copiedvtotale, copiedp,copiedg,0,0);
		    	
		    	nbrnoeud++;
		    	int[] tp=enfant.getTp();
		    	
		    	int d =objet[obj_tr][0]+tp[i];  // pour verifier si on peut ajoute l 'objet eu sac i ou no
		    	
		    	if(d<=capacite[i]) 
		    	{
		    	
		    		enfant.getMatrice()[i][obj_tr] = 1;
		    		
		    		// change le point actuale de sac a dos 
		    		
		    		enfant.getTp()[i] = d;
		    		
		    		int x=obj_tr;
		    		
		    		enfant.setP(x+1);
		    		
		    		int nouvelle_v=enfant.getVtotale()+objet[obj_tr][1];
		    		enfant.setVtotale( nouvelle_v );
		    			
		    		int g=G_fct(enfant.getG());
		    		int h=H_fct(poit_totale, enfant.getTp());
		    		int f = F_fct(g,h);
		    		
		    		enfant.setG(g);
		    		enfant.setH(h);
		    		enfant.setf(f);
		    		
		    		System.out.printf(" secesseur ou  ajoute un objet f: %d, g=%d, h=%d" , enfant.getF(), enfant.getG(), enfant.getH());
		    		
		    		
		    		System.out.println();
		    		ouvert.add(enfant);
		    		Collections.sort(ouvert, Comparator.comparingDouble(c -> c.getF()));

		    	}
		    	else 
		    	{
				
		    		enfant.setP(obj_tr + 1); 
		    		
		    		int g=G_fct(enfant.getG());
		    		int h=H_fct(poit_totale, enfant.getTp());
		    		int f = F_fct(g,h);		
		    		
		    		enfant.setG(g);
		    		enfant.setH(h);
		    		enfant.setf(f);
		    		
		    		System.out.printf(" secesseur mais rien n'est ajoute f: %d, g=%d, h=%d" , enfant.getF(), enfant.getG(), enfant.getH());
		    		

		    		System.out.println();
		    		ouvert.add(enfant);
		    		Collections.sort(ouvert, Comparator.comparingDouble(c -> c.getF()));



				
		    	}
			
		   }
		    return nbrnoeud++;
	}
}