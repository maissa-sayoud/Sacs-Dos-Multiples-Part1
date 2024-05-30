import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


public class Fenetre1_ChoisirAlgorithme extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	//les bouttons sont des varibales GLOBALES ! (action listener!)
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	
	JRadioButton DFS_button = new JRadioButton();
    JRadioButton BFS_button = new JRadioButton();
    JRadioButton A_button = new JRadioButton();
    
	
	public static int Numero_Algo = 0;
	
	Fenetre1_ChoisirAlgorithme()
	{
		
		super();
		
		// JFrame = une interface graphique pour y ajouter des composants
		
		//JFrame frame = new JFrame(); //creation de l'interface (depuis le main seuelement)
		
		//ajoueter une label :
		
		//-------------------- Label 1 -------------------------
		
		JLabel label1 = new JLabel();
		
		label1.setText("CHOIX DE L'ALGORITHME");
		label1.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
		label1.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
		label1.setForeground(new Color(0x800080));
		label1.setFont(new Font("MV BOLI",Font.BOLD ,20));
		
		// Définir la position et la taille de label1
        label1.setBounds(100, 10, 600, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
		
        
        
        //-------------------- Label 2 -------------------------
		
      	JLabel label2 = new JLabel();
      		
      	label2.setText("Veuillez choisir l'algorithme à utiliser :");
      	label2.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
      	label2.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
      	label2.setForeground(new Color(0xffffff));
      	label2.setFont(new Font("Inter",Font.BOLD ,16));
      		
      	// Définir la position et la taille de label1
        label2.setBounds(50, 100, 400, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
      		
              
              
        // -------------------- Label 3 -------------------------
		
      	JLabel label3 = new JLabel();
      		
      	label3.setText("Veuillez patienter lors du traitement...");
      	label3.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
      	label3.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
      	label3.setForeground(new Color(0xffffff));
      	label3.setFont(new Font("Inter",Font.BOLD ,16));
      		
      	// Définir la position et la taille de label1
        label3.setBounds(100, 250, 400, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
      		
              
              

        
        
        // -------------------- Boutton de Validation 1 -------------------------
        
        //implementer as une variable globale
        //JButton button1 = new JButton(); 
        
        button1.setBounds(300,400,100,40);
        //button1.addActionListener(this); //on va remplacer this par lambda expression
		button1.setEnabled(false); // desactiver le boutton une fois cliquer dessus

        // LAMBDA EXPRESISON de Boutton 1:
        button1.addActionListener
        ( 
        	e -> 
        	{
    			System.out.println("Algo bien choisi !"); 
    			
    			button1.setEnabled(false); // desactiver le boutton une fois cliquer dessus
    			//labelX.setVisible(true); //si on veut faire apparaitre du texte apres le click
    			
    			
    			int nsac = Fenetre0_LesSacsADos.Nombre_SacsADos;
    			int [] capacite = Fenetre0_LesSacsADos.poidsDesSacs;
    			
    				
    			//LANCEMENT du TRAITEMENT & REDIRECTION VERS LA 2EME PAGE (correspondante a l'algorithme choisi):
    			if (Numero_Algo == 1)
    			{
    				//lancer DFS
       				LancerTraitementDFS.TraitementDFS(nsac, Fenetre0_LesSacsADos.nobj, capacite, Fenetre0_LesSacsADos.objet);
    				
    				//redirection :
        			Fenetre2_ConfigurerParametresAlgorithme page21 = new Fenetre2_ConfigurerParametresAlgorithme();

    			}
    			else
    			{
    				if (Numero_Algo == 2)
    				{
    					//lancer BFS
           				LancerTraitementBFS.TraitementBFS(nsac, Fenetre0_LesSacsADos.nobj, capacite, Fenetre0_LesSacsADos.objet);
           				
        				//redirection :
            			Fenetre2_AfficherResultat_BFS page22 = new Fenetre2_AfficherResultat_BFS();

    				}
    				else
    				{
    					if (Numero_Algo == 3)
    					{
    						//lancer DFS
    	       				LancerTraitementAetoile.TraitementAetoile(nsac, Fenetre0_LesSacsADos.nobj, capacite, Fenetre0_LesSacsADos.objet);
    	    				
    	    				//redirection :
    	       				Fenetre2_AfficherResultat_Aetoile page23 = new Fenetre2_AfficherResultat_Aetoile();

    					}
    				}
    			}
    			
    		}
        );
        
        button1.setText("Valider");
        button1.setFocusable(rootPaneCheckingEnabled);
        button1.setFont(new Font("Comic Sans",Font.BOLD ,16));
        button1.setForeground(new Color (0xffffff)); //clr du texte
        button1.setBackground(new Color(0x803A93));  //clr du boutton
        button1.setBorder(BorderFactory.createEtchedBorder()); //effet 3D du boutton
        // le boutton est grisé jusqu'à ce que choix de l'algorithme soit fait !
        //button1.setEnabled(false);
        
        
        
// -------------------- Boutton d'Annulation 2 -------------------------
        
        
        
        button2.setBounds(500,400,100,40);
        //button1.addActionListener(this); //on va remplacer this par lambda expression
        
        // LAMBDA EXPRESISON de Boutton 1:
        button2.addActionListener
        ( 
        	e -> 
        	{
        		System.exit(0);
    			
    		}
        );
        
        button2.setText("Quitter");
        button2.setFocusable(rootPaneCheckingEnabled);
        button2.setFont(new Font("Comic Sans",Font.BOLD ,16));
        button2.setForeground(new Color (0xffffff)); //clr du texte
        button2.setBackground(new Color(0xff0000));  //clr du boutton
        button2.setBorder(BorderFactory.createEtchedBorder()); //effet 3D du boutton
        // le boutton est grisé jusqu'à ce que choix de l'algorithme soit fait !
        //button2.setEnabled(false);
        

        
        //-------------------- Frame -------------------------
        
        this.setLayout(null); //libel fixe or not !

		this.setTitle("Choix Algorithme"); //1ere interface est pour choisir l'algorithme !
		
		//frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // hide pour cacher, mais le programme ne se termine pas
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit = sortit et quitter !
		
		
		// Utilisation du BorderLayout pour positionner la Label au centre
		/*this.setLayout(new BorderLayout());
        this.add(label1, BorderLayout.CENTER);*/
        
		//frame.setResizable(false); 	//l'interface est non redimmensionnable !
		
		this.setSize(800,600); 	// REDIMENSIONNER l'interface ! 
		this.setVisible(true);   	// redre l'interface visible !
		
		//ajouter une icone à l'interface :
		ImageIcon img = new ImageIcon("logo.jpg"); 	// creer une image
		this.setIconImage(img.getImage());			// et l'xappliquer !
		
		//changer les couleurs de l'interface :
		this.getContentPane().setBackground(new Color(0,0,0)); //(background)

		
		
		
		
		// -------------------- Boutton RADIO 1 -------------------------

        // 3 bouttons radio : DFS - BFS - A etoile
        
        /*Declaration en format global :
         * 
         * JRadioButton DFS_button = new JRadioButton();
        JRadioButton BFS_button = new JRadioButton();
        JRadioButton A_button = new JRadioButton();
        */
		
		DFS_button.setBounds(50, 200, 100, 40);
        DFS_button.setText("DFS");
        DFS_button.addActionListener(this);
        DFS_button.setFont(new Font("Comic Sans",Font.BOLD ,16));
        DFS_button.setForeground(new Color (0xffffff)); //clr du texte
        DFS_button.setBackground(new Color(0,0,0)); //(background)
		
        
        BFS_button.setBounds(200, 200, 100, 40);
        BFS_button.setText("BFS");
        BFS_button.addActionListener(this);
        BFS_button.setFont(new Font("Comic Sans",Font.BOLD ,16));
        BFS_button.setForeground(new Color (0xffffff)); //clr du texte
        BFS_button.setBackground(new Color(0,0,0)); //(background)
		
        
        A_button.setBounds(350, 200, 100, 40);
        A_button.setText("A etoile");
        A_button.addActionListener(this);
        A_button.setFont(new Font("Comic Sans",Font.BOLD ,16));
        A_button.setForeground(new Color (0xffffff)); //clr du texte
        A_button.setBackground(new Color(0,0,0)); //(background)
		
        
        
		// pour choisir une seul algorithme a la fois :
        ButtonGroup group = new ButtonGroup();
        
        group.add(DFS_button);
        group.add(BFS_button);
        group.add(A_button);
		
		
		
		
		//-------------------- **** -------------------------
		
		
		this.add(label1);
		this.add(label2);
		this.add(label3);
		
		this.add(DFS_button);
		this.add(BFS_button);
		this.add(A_button);
		
		this.add(button1);
		this.add(button2);

		
	
		
		
	}

	
	
	// -------------------  validation button 1 ActionListener--------------------------------------------------
	/* remplacer par la "LAMBDA EXPRESSION" dans la partie boutton1 :
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		if(e.getSource()==button1)
		{
			System.out.println("Algo bien choisi !"); 
			
			button1.setEnabled(false); // desactiver le boutton une fois cliquer dessus
			//labelX.setVisible(true); //si on veut faire apparaitre du texte apres le click
		}
		
	}*/
	
	
	
	
	
	// -------------------  RADIO button 1 ActionListener--------------------------------------------------
	
	@Override
	public void actionPerformed (ActionEvent e)
	{
		 if (e.getSource() == DFS_button) 
		 {
	         Numero_Algo = 1;
			 button1.setEnabled(true);
	     }
		 else
		 {
			 if (e.getSource() == BFS_button)
			 {
				 Numero_Algo = 2;
				 button1.setEnabled(true);
				 
			 }
			 else 
			 {
				if (e.getSource() == A_button)
				{
					Numero_Algo = 3;
					button1.setEnabled(true);
					
				}
			 }
		 }
	}
	
	
	
	
}
