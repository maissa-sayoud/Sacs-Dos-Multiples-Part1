//import java.util.ArrayList;
import java.util.LinkedList;
//import java.util.List;
import java.util.Queue;

//Le but étant de maximiser la valeur totale 
// les contraintes : on depase pas capacite de sac a dos
//                   l'objet on  le mat dans un seul sac




public class LancerTraitementBFS 
{
	
	public static double executionTimeInSeconds_BFS;
	
	public static int VALEURMAXIMALEBFS;
	
	public static int NOEUDSBFS;
	
    public static int[] poid_actualeBFS;
    
    public static int [][] matriceBFS;
    
    //public static List<Integer> AfficherListeBFS = new ArrayList<>();
 
	public static void TraitementBFS(int nsac, int nobj, int [] capacite, int [][] objet)
	{

		     
		     Queue<Noeud> ouvert = new LinkedList<>();
			   
		     Queue<Noeud> ferme = new LinkedList<>();
			 
	         
	         
		     	
		     long startTime = System.currentTimeMillis(); // -- temps
		     
		     
		     int profondeur = nobj;  // pour verifier si etas finale 
		     
		     
		     Noeud s_i = new Noeud(new int[nsac][nobj], new int[nsac], 0, 0);  // le noeud initiale  profondeur =0
		     int nbrnoeud=1;
		     Noeud  best_solusion= s_i; // des sac a dos vide +
		     
		     
		     ouvert.add(s_i);
		     
		               
		     
		     while (!ouvert.isEmpty()) 
		     {
		    	 Noeud s =ouvert.poll();
		         
		    	 ferme.offer(s);
		                
		    	 // verifier si l'etat finale
		                
		    	 if((s.getP())==profondeur) 
		    	 {
		       
		    		 if(s.getVtotale()>best_solusion.getVtotale())
		    		 {
		            
		    			 Noeud t = best_solusion;
		            	
		    			 best_solusion=s;
		            	
		    			 s=t;
		            	
		    		 }
		            	
		    	 }
		    	 else 
		    	 {
		    		 // si ce n'est pas l'eta finale on cree les seccesseur 
		         
		    		 fonction_bfs fonc = new fonction_bfs();
		            
		    		 //System.out.println("cree des seccsessur");
		             
		    		 nbrnoeud=	 fonction_bfs.seccesseur(s, objet, ouvert, capacite, nsac,nbrnoeud);
		    	 }
		         
		     } 
		     
		     long endTime = System.currentTimeMillis();
		     
		     long executionTime = endTime - startTime;
		               
		     matriceBFS = best_solusion.getMatrice();
		     
		     poid_actualeBFS=best_solusion.getTp();
		     
		     System.out.println("La meilleure solution est : ");
		     
		     for (int i = 0; i < matriceBFS.length; i++) 
		     {
		                   
		    	 for (int j = 0; j < matriceBFS[i].length; j++) 
		         {
		    		 System.out.print(matriceBFS[i][j] + " ");
		         }
		                   
		    	 System.out.println();
		     }
		     ////////////////////////////////
		     
		     
             System.out.println("solution finale : ");
             
             for (int i = 0; i < matriceBFS.length; i++) 
             {
            	 
          	   System.out.printf("sac %d : ", (i+1));
          	   
          	   System.out.printf("[");
                 
          	   for (int j = 0; j < matriceBFS[i].length; j++) 
                 {
              	
          		   if(matriceBFS[i][j]==1) 
              	   {
              		  
              		   System.out.printf(" objet%d ",(j+1));
              		   //AfficherListeBFS.add(j+1);
              		  
              		   
              	   }
                 }
          	   
                 System.out.printf("]");
                 System.out.println();
                 System.out.println();
                 
                 poid_actualeBFS = best_solusion.getTp();
                 System.out.printf(" le poids actuel %d vs La capacité %d ",poid_actualeBFS[i] ,capacite[i]);
                 System.out.println();
                 System.out.println();
                 System.out.println();
             }
		     
		     //////////////////////////////////
		     
		     
             VALEURMAXIMALEBFS= best_solusion.getVtotale();
		     
		     System.out.println("La valeur maximale est :"+VALEURMAXIMALEBFS);  
		     System.out.println();
		     
		     NOEUDSBFS = nbrnoeud;
		     System.out.println("Nombre de noeud exploite  " + NOEUDSBFS );
		     System.out.println();
		     
		     executionTimeInSeconds_BFS = executionTime / 1000.0; // Convert to seconds

		  
		     System.out.println("Execution time: " + executionTimeInSeconds_BFS + " seconds");
		 
		 
	}
	
}