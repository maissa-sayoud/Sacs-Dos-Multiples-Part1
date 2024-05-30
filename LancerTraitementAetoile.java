import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LancerTraitementAetoile
{
	
        // Le but étant de maximiser la valeur totale 
	    // les contraintes : on depase pas capacite de sac a dos
	    //                   l'objet on  le met dans un seul sac 
	

	public static double executionTimeInSeconds_Aetoile;
	
	public static int VALEURMAXIMALEAetoile;
	
	public static int NOEUDSAetoile;
	
	public static int[] poid_actualeAetoile;
	
	public static int [][] matriceAetoile;
	
	public static void TraitementAetoile(int nsac, int nobj, int [] capacite, int [][] objet)
 
	 {   //int nbnoeud=0;
	     
	        List<NoeudA> ouvert = new ArrayList<>();
		
		    Queue<NoeudA> ferme = new LinkedList<>();
		 
            		
	        long startTime = System.currentTimeMillis(); // -- TIME !! start 
	        
	        int profondeur = nobj;  // pour verifier si etas finale 
	        
	        
	        
	        //------------------------------------------
	        	int poit_totale=0; 		// poids_total ?!
	        //------------------------------------------
	        
	        	
	        	
	        NoeudA s_i = new NoeudA(new int[nsac][nobj], new int[nsac],0, 0,0,0,0);  // le NoeudA initiale  profondeur =0
	        
	        s_i.setH(poit_totale);
	            	
	        ouvert.add(s_i);
	        boolean etat_finale_trouve=false;
	        int nbrnoeud=1;
	        // NoeudA s=;
	        while (!ouvert.isEmpty()&& !etat_finale_trouve) 
	        {         
	        	NoeudA s=  ouvert.remove(0);
	           	System.out.printf(" le noued a traite  f: %d, g=%d, h=%d" , s.getF(), s.getG(), s.getH());
	            
                
	           	System.out.println();
	            ferme.offer(s);
	                
	            // verifier si l'etat finale
	                
	            if(fonction_A.etat_finale(s,profondeur)) 
	            {
	            	etat_finale_trouve=true; 
	  	         
	            	matriceAetoile =s.getMatrice();
	            	poid_actualeAetoile=s.getTp();
	            	System.out.println("La meilleure est : ");
		               
	            	for (int i = 0; i < matriceAetoile.length; i++) 
	            	{
		                   for (int j = 0; j < matriceAetoile[i].length; j++) 
		                   {
		                       System.out.print(matriceAetoile[i][j] + " ");
		                   }
		                   
		                   System.out.println();
	            	}
	            	/////////////////////////////////////////////
	            	
	            	 System.out.println("solution finale : ");
	                 for (int i = 0; i < matriceAetoile.length; i++) {
	              	   System.out.printf("sac %d : ", (i+1));
	              	   System.out.printf("[");
	                     for (int j = 0; j < matriceAetoile[i].length; j++) {
	                  	   if(matriceAetoile[i][j]==1) {
	                  		  
	                  		   System.out.printf(" objet%d ",(j+1));
	                  		  
	                  		   
	                  	   }
	                     }
	                     System.out.printf("]");
	                     System.out.println();
	                     System.out.println();
	                     System.out.printf(" le poids actuel %d vs La capacité %d ",poid_actualeAetoile[i] ,capacite[i]);
	                     System.out.println();
	                     System.out.println();
	                     System.out.println();
	                 }
	            	
	            	
	            	//////////////////////////////////////////////
	            
	                 VALEURMAXIMALEAetoile =s.getVtotale();
	            	
	            	System.out.println("La valeur maximale est :"+VALEURMAXIMALEAetoile);           
		               
	            		 
	            		 
	            }
	            else 
	            {
	            	// si ce n'est pas l'eta finale on cree les seccesseur
	            	
	             nbrnoeud = fonction_A.seccesseur(s, objet, ouvert, capacite, nsac,poit_totale,nbrnoeud);
	                 Collections.sort(ouvert, Comparator.comparingDouble(c -> c.getF()));
	            }
	            	
	        } 
	        
	        long endTime = System.currentTimeMillis();
	        
	        long executionTime = endTime - startTime;
	               

	        executionTimeInSeconds_Aetoile = executionTime / 1000.0; // Convert to seconds
	        System.out.println();
	        
	        NOEUDSAetoile = nbrnoeud;
	        System.out.println("Nembre de noeud exploite  " + NOEUDSAetoile );
	        System.out.println();
	        System.out.println("Execution time: " + executionTimeInSeconds_Aetoile + " seconds");
	 
	 }

}
