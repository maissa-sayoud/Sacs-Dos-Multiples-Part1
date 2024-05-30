import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;



//Le but étant de maximiser la valeur totale 
// les contraintes : on depase pas capacite du sac a dos
//                   un objet i ne se trouve que dans un seul sac j 



public class LancerTraitementDFS
{
	
	public static double executionTimeInSeconds_DFS;
	
	public static int VALEURMAXIMALEDFS;
	
	public static int NOEUDSDFS;
	
	public static int[] poid_actualeDFS;
	
	public static int [][] matriceDFS;
	
	public static void TraitementDFS(int nsac, int nobj, int [] capacite, int [][] objet)
	{
		
		Stack<Noeud> ouvert = new Stack<>();   //--
		Queue<Noeud> ferme = new LinkedList<>();//--
		
		
		long startTime = System.currentTimeMillis(); // -- time
		
		int profondeur = nobj;  // -- pour verifier si etas finale 
		Noeud s_i = new Noeud(new int[nsac][nobj], new int[nsac], 0, 0);  // -- le noeud initiale  profondeur =0
		int nbrnoeud=1;
		Noeud  best_solusion= s_i; //-- des sac a dos vide +
    
           
		//-- verifier si la table capacite est bonne : 
        System.out.println("Table de capacite de chaque sac a dos :");
        
        for (int i = 0; i < capacite.length; i++) 
        {
     	    System.out.println(capacite[i] + " ");
       	}
        	
        	
        	
        // -- DEBUT DU TRAITEMENT ! -----------------------------------------------------------------
        	
        ouvert.push(s_i);
           
        while (!ouvert.isEmpty()) {
        	   
        Noeud s = ouvert.pop();
            
        ferme.offer(s);
            
        // verifier si c'est l'etat finale
            
        if((s.getP())==profondeur) 
       	{
        	if(s.getVtotale()>best_solusion.getVtotale())
        	{
        		Noeud t=best_solusion;
        		best_solusion=s;
        		s=t;
        	}
        }
        else 
        {
        	// si ce n'est pas l'eta finale on cree les seccesseurs
        	fonction fonc = new fonction();
        	
       		//System.out.println("cree des seccsessur");
        	nbrnoeud= 	fonction.seccesseur(s, objet, ouvert, capacite, nsac,nbrnoeud);
        }
        	
        } 
        
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
           
        matriceDFS = best_solusion.getMatrice();
        poid_actualeDFS=best_solusion.getTp();
        System.out.println("La meilleure solution est : ");
        
        for (int i = 0; i < matriceDFS.length; i++) 
        {
        
        	for (int j = 0; j < matriceDFS[i].length; j++) 
           	{
           		System.out.print(matriceDFS[i][j] + " ");
           	}
           	
        	System.out.println();
       	}
           
        
        
        ////////////////////////////////////////////
        System.out.println("solution finale : ");
        for (int i = 0; i < matriceDFS.length; i++) 
        {
     	   System.out.printf("sac %d : ", (i+1));
     	   System.out.printf("[");
            for (int j = 0; j < matriceDFS[i].length; j++) 
            {
         	   if(matriceDFS[i][j]==1) 
         	   {
         		  
         		   System.out.printf(" objet%d ",(j+1));
         		  
         		   
         	   }
            }
            System.out.printf("]");
            System.out.println();
            System.out.println();
            System.out.printf(" le poids actuel %d vs La capacité %d ",poid_actualeDFS[i] ,capacite[i]);
            System.out.println();System.out.println();
            System.out.println();
        }
	     
        
        
        ////////////////////////////////////////////
        
        VALEURMAXIMALEDFS = best_solusion.getVtotale();
        
        System.out.println("La valeur maximale est :"+VALEURMAXIMALEDFS);  
        
        
        
        System.out.println();
        
        NOEUDSDFS = nbrnoeud;
        System.out.println("Nombre de noeud exploite  " + NOEUDSDFS );
        System.out.println();
        
        executionTimeInSeconds_DFS = executionTime / 1000.0; // Convert to seconds

        System.out.println("Execution time: " + executionTimeInSeconds_DFS + " seconds");
      
	}
	
}
	
