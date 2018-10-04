import java.util.Scanner;

public class ValseCaracts {

    View view;

    Scanner input = new Scanner(System.in);
    private int NB_MESURES = 8;
    private int PAUSE = 250;
    static protected String type;
    private boolean mute;
    private String nomMesure;
    static int [] diceMenuet1 = new int [8];
    static int [] diceMenuet2 = new int [8];
    static int [] diceTriolet1 = new int [8];
    static int [] diceTriolet2 = new int [8];
    static int tabEntry1[] = new int[8];
    static int tabEntry2[] = new int[8];
	static int tabEntry3[] = new int[8];
	static int tabEntry4[] = new int[8];
    static int tabEntryPost1[] = new int[8];
    static int tabEntryPost2[] = new int[8];
    static int tabEntryPost3[] = new int[8];
    static int tabEntryPost4[] = new int[8];
    int swi = 0 ;

	/**
	 * Constructeur vide.
	 */
    public ValseCaracts(){}

	/**
	 * Constructeur.
	 * @param type est le type de valse que l'on souhaite jouer (menuet, triolet, les deux).
	 * @param mute permet de lancer le programme avec son ou sans.
	 * @param view fenêtre attribuée à la valse courante.
	 */
    public ValseCaracts(String type, boolean mute, View view) {
        this.type = type;
        this.mute = mute;
        this.view = view;
    }

    		/*User Part*/

    /**
	 * Regroupe et appelle les differentes méthodes nécessaire selon le type de valse. Cette methode nécessite l'entrée de valeurs par l'utilisateur
	 */
    public void playStdin() {
    	if (this.type.equals("Menuet") || this.type.equals("menuet")) {
                this.playStdinMenuet();
        } else if (this.type.equals("Triolet") || this.type.equals("triolet")) {
            this.playStdinTriolet();
        } else {
            if (this.type.equals("Menuet+Triolet") || this.type.equals("menuet+triolet")) {
                this.playStdinMenuetTriolet();
            }
            else if (this.type.equals("Triolet+Menuet") || this.type.equals("triolet+menuet")) {
                this.playStdinTrioletMenuet();
            }else{
                System.out.println("invalid type. Please consult help.txt");
            }
        }
      
    }

	/**
	 * Joue un 2x8 mesures de menuet, choisies par l'utilisateur et selon les tableaux proposés.
	 */
    public void playStdinMenuet() {
        System.out.println("Entrez les 16 valeurs de dès (Menuet) : ");
        for (int i = 0; i < 8; i++) {
            do {
                tabEntry1[i] = input.nextInt();
                if (tabEntry1[i] < 2 || tabEntry1[i] > 12) {
                    System.out.println("Error : Please enter a value in range [2,11]");
                }
            } while (tabEntry1[i] < 2 || tabEntry1[i] > 12);
            swi = 0;
            tabEntryPost1[i] = tabEntry1[i]-2;
            view.progressionMenuet(i, tabEntryPost1, swi, View.COLOR_TO_BE_PLAYED);
        }
        for (int i = 0; i < 8; i++) {
            do {
                tabEntry2[i] = input.nextInt();
                if (tabEntry2[i] < 2 || tabEntry2[i] > 12) {
                    System.out.println("Error : Please enter a value in range [2,11]");
                }
            } while (tabEntry2[i] < 2 || tabEntry2[i] > 12);
            swi = 1;
            tabEntryPost2[i] = tabEntry2[i]-2;
            view.progressionMenuet(i, tabEntryPost2, swi, View.COLOR_TO_BE_PLAYED);
        }
        
        for(int b = 0 ; b < Valse.nbBoucleArg; b++){
            System.out.println("\n\n\n1ere partie du Menuet\n");
            for (int i = 0; i < 8; i++) {
                swi = 0;
                if(this.mute == false){
	               	StdAudio.play(TabMesure.tabMenuet1[i][tabEntryPost1[i]]);
	            }
	            nomMesure = TabMesure.tabMenuet1[i][tabEntryPost1[i]];
	            nomMesure = nomMesure.substring(0, nomMesure.length() - 4);
	            System.out.println("\t" + nomMesure);
                view.progressionMenuet(i, tabEntryPost1, swi, View.COLOR_PLAYED);
				view.tracePartitionMenuet(i, tabEntryPost1, swi);
                try {
                    Thread.sleep(PAUSE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                view.progressionMenuet(i, tabEntryPost1, swi, View.COLOR_TO_BE_PLAYED);
            }
            System.out.println("\n\n\n2eme partie du Menuet\n");
            for (int i = 0; i < 8; i++) {
                swi = 1;
                if(this.mute == false){
	               	StdAudio.play(TabMesure.tabMenuet2[i][tabEntryPost2[i]]);
	            }
	            nomMesure = TabMesure.tabMenuet2[i][tabEntryPost2[i]];
	            nomMesure = nomMesure.substring(0, nomMesure.length() - 4);
	            System.out.println("\t" + nomMesure);
                view.progressionMenuet(i, tabEntryPost2, swi, View.COLOR_PLAYED);
				view.tracePartitionMenuet(i, tabEntryPost2, swi);
                try {
                    Thread.sleep(PAUSE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                view.progressionMenuet(i, tabEntryPost2, swi, View.COLOR_TO_BE_PLAYED);
            }
        }
    }

	/**
	 * Joue un 2x8 mesures de triolet, choisies par l'utilisateur et selon les tableaux proposés.
	 */
	public void playStdinTriolet() {
	    System.out.println("Entrez les 16 valeurs de dès (Triolet) : ");
	    for (int i = 0; i < 8; i++) {
	        do {
	            tabEntry3[i] = input.nextInt();
	            if (tabEntry3[i] < 1 || tabEntry3[i] > 6) {
	                System.out.println("Error : Please enter a value in range [1,6]");
	            }
	        } while (tabEntry3[i] < 1 || tabEntry3[i] > 6);
	        swi = 0;
	        tabEntryPost3[i] = tabEntry3[i]-1;
	        view.progressionTriolet(i, tabEntryPost3, swi, View.COLOR_TO_BE_PLAYED);
	    }
	    for (int i = 0; i < 8; i++) {
	        do {
	            tabEntry4[i] = input.nextInt();
	            if (tabEntry4[i] < 1 || tabEntry4[i] > 6) {
	                System.out.println("Error : Please enter a value in range [1,6]");
	            }
	        } while (tabEntry4[i] < 1 || tabEntry4[i] > 6);
	        swi = 1;
	        tabEntryPost4[i] = tabEntry4[i]-1;
	        view.progressionTriolet(i, tabEntryPost4, swi, View.COLOR_TO_BE_PLAYED);
	    }
	        
	    for(int b = 0 ; b < Valse.nbBoucleArg; b++){
		    System.out.println("\n\n\n1ere partie du Triolet\n");
		    for (int i = 0; i < 8; i++) {
		        swi = 0;
		        if(this.mute == false){
		    	 	StdAudio.play(TabMesure.tabTriolet1[i][tabEntryPost3[i]]);
				}
				nomMesure = TabMesure.tabTriolet1[i][tabEntryPost3[i]];
				nomMesure = nomMesure.substring(0, nomMesure.length() - 4);
				System.out.println("\t" + nomMesure);
		        view.progressionTriolet(i, tabEntryPost3, swi, View.COLOR_PLAYED);
				view.tracePartitionTriolet(i, tabEntryPost3, swi);
		        try {
		            Thread.sleep(PAUSE);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        view.progressionTriolet(i, tabEntryPost3, swi, View.COLOR_TO_BE_PLAYED);
		    }
		    System.out.println("\n\n\n2eme partie du Triolet\n");
		    for (int i = 0; i < 8; i++) {
		        swi = 1;
		        if(this.mute == false){
		       		StdAudio.play(TabMesure.tabTriolet2[i][tabEntryPost4[i]]);
				}
				nomMesure = TabMesure.tabTriolet2[i][tabEntryPost4[i]];
				nomMesure = nomMesure.substring(0, nomMesure.length() - 4);
				System.out.println("\t" + nomMesure);
		        view.progressionTriolet(i, tabEntryPost4, swi, View.COLOR_PLAYED);	                
				view.tracePartitionTriolet(i, tabEntryPost4, swi);
		        try {
		            Thread.sleep(PAUSE);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        view.progressionTriolet(i, tabEntryPost4, swi, View.COLOR_TO_BE_PLAYED);
	        }
	    }
	}
	/**
	 * Joue un 2x8 mesures de menuet puis 2x8 mesures de triolet, choisies par l'utilisateur et selon les tableaux proposés.
	 */
	public void playStdinMenuetTriolet(){
		System.out.println("Entrez les 16 valeurs de dès (Menuet) : ");
        for (int i = 0; i < 8; i++) {
            do {
                tabEntry1[i] = input.nextInt();
                if (tabEntry1[i] < 2 || tabEntry1[i] > 12) {
                    System.out.println("Error : Please enter a value in range [2,11]");
                }
            } while (tabEntry1[i] < 2 || tabEntry1[i] > 12);
            swi = 0;
            tabEntryPost1[i] = tabEntry1[i]-2;
            view.progressionMenuet(i, tabEntryPost1, swi, View.COLOR_TO_BE_PLAYED);
        }
        for (int i = 0; i < 8; i++) {
            do {
                tabEntry2[i] = input.nextInt();
                if (tabEntry2[i] < 2 || tabEntry2[i] > 12) {
                    System.out.println("Error : Please enter a value in range [2,11]");
                }
            } while (tabEntry2[i] < 2 || tabEntry2[i] > 12);
            swi = 1;
            tabEntryPost2[i] = tabEntry2[i]-2;
            view.progressionMenuet(i, tabEntryPost2, swi, View.COLOR_TO_BE_PLAYED);
        }
     	System.out.println("Entrez les 16 valeurs de dès (Triolet) : ");
	    for (int i = 0; i < 8; i++) {
	        do {
	            tabEntry3[i] = input.nextInt();
	            if (tabEntry3[i] < 1 || tabEntry3[i] > 6) {
	                System.out.println("Error : Please enter a value in range [1,6]");
	            }
	        } while (tabEntry3[i] < 1 || tabEntry3[i] > 6);
	        swi = 0;
	        tabEntryPost3[i] = tabEntry3[i]-1;
	        view.progressionTriolet(i, tabEntryPost3, swi, View.COLOR_TO_BE_PLAYED);
	    }
	    for(int b = 0 ; b < Valse.nbBoucleArg; b++){
		    for (int i = 0; i < 8; i++) {
		        do {
		            tabEntry4[i] = input.nextInt();
		            if (tabEntry4[i] < 1 || tabEntry4[i] > 6) {
		                System.out.println("Error : Please enter a value in range [1,6]");
		            }
		        } while (tabEntry4[i] < 1 || tabEntry4[i] > 6);
		        swi = 1;
		        tabEntryPost4[i] = tabEntry4[i]-1;
		        view.progressionTriolet(i, tabEntryPost4, swi, View.COLOR_TO_BE_PLAYED);
		    }
	     	System.out.println("\n\n\n1ere partie du Menuet\n");
	        for (int i = 0; i < 8; i++) {
	            swi = 0; 
	            if(this.mute == false){
		           	StdAudio.play(TabMesure.tabMenuet1[i][tabEntryPost1[i]]);
		        }
		        nomMesure = TabMesure.tabMenuet1[i][tabEntryPost1[i]];
		        nomMesure = nomMesure.substring(0, nomMesure.length() - 4);
		        System.out.println("\t" + nomMesure);
	            view.progressionMenuet(i, tabEntryPost1, swi, View.COLOR_PLAYED);
				view.tracePartitionMenuet(i, tabEntryPost1, swi);
	            try {
	                Thread.sleep(PAUSE);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            view.progressionMenuet(i, tabEntryPost1, swi, View.COLOR_TO_BE_PLAYED);
	        }
	        System.out.println("\n\n\n2eme partie du Menuet\n");
	        for (int i = 0; i < 8; i++) {
	            swi = 1;
	            if(this.mute == false){
		           	StdAudio.play(TabMesure.tabMenuet2[i][tabEntryPost2[i]]);
		        }
		        nomMesure = TabMesure.tabMenuet2[i][tabEntryPost2[i]];
		        nomMesure = nomMesure.substring(0, nomMesure.length() - 4);
		        System.out.println("\t" + nomMesure);
	            view.progressionMenuet(i, tabEntryPost2, swi, View.COLOR_PLAYED);
				view.tracePartitionMenuet(i, tabEntryPost2, swi);
	            try {
	                Thread.sleep(PAUSE);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            view.progressionMenuet(i, tabEntryPost2, swi, View.COLOR_TO_BE_PLAYED);
	        }
	        System.out.println("\n\n\n1ere partie du Triolet\n");
		    for (int i = 0; i < 8; i++) {
		        swi = 0;
		        if(this.mute == false){
		       	StdAudio.play(TabMesure.tabTriolet1[i][tabEntryPost3[i]]);
			}
			nomMesure = TabMesure.tabTriolet1[i][tabEntryPost3[i]];
			nomMesure = nomMesure.substring(0, nomMesure.length() - 4);
			System.out.println("\t" + nomMesure);
		    view.progressionTriolet(i, tabEntryPost3, swi, View.COLOR_PLAYED);
			view.tracePartitionTriolet(i, tabEntryPost3, swi);
		    try {
		        Thread.sleep(PAUSE);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        view.progressionTriolet(i, tabEntryPost3, swi, View.COLOR_TO_BE_PLAYED);
	        }
	        System.out.println("\n\n\n2eme partie du Triolet\n");
	        for (int i = 0; i < 8; i++) {
		        swi = 1;
		        if(this.mute == false){
		        	StdAudio.play(TabMesure.tabTriolet2[i][tabEntryPost4[i]]);
				}
				nomMesure = TabMesure.tabTriolet2[i][tabEntryPost4[i]];
				nomMesure = nomMesure.substring(0, nomMesure.length() - 4);
				System.out.println("\t" + nomMesure);
		        view.progressionTriolet(i, tabEntryPost4, swi, View.COLOR_PLAYED);	                
				view.tracePartitionTriolet(i, tabEntryPost4, swi);
		        try {
		            Thread.sleep(PAUSE);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        view.progressionTriolet(i, tabEntryPost4, swi, View.COLOR_TO_BE_PLAYED);
		    }
		}
	}

	/**
	 * Joue un 2x8 mesures de triolet puis 2x8 mesures de menuet, choisies par l'utilisateur et selon les tableaux proposés.
	 */
	public void playStdinTrioletMenuet(){
		System.out.println("Entrez les 16 valeurs de dès (Triolet) : ");
	    for (int i = 0; i < 8; i++) {
	        do {
	            tabEntry3[i] = input.nextInt();
	            if (tabEntry3[i] < 1 || tabEntry3[i] > 6) {
	                System.out.println("Error : Please enter a value in range [1,6]");
	            }
	        } while (tabEntry3[i] < 1 || tabEntry3[i] > 6);
	        swi = 0;
	        tabEntryPost3[i] = tabEntry3[i]-1;
	        view.progressionTriolet(i, tabEntryPost3, swi, View.COLOR_TO_BE_PLAYED);
	    }
	    for (int i = 0; i < 8; i++) {
	        do {
	            tabEntry4[i] = input.nextInt();
	            if (tabEntry4[i] < 1 || tabEntry4[i] > 6) {
	                System.out.println("Error : Please enter a value in range [1,6]");
	            }
	        } while (tabEntry4[i] < 1 || tabEntry4[i] > 6);
	        swi = 1;
	        tabEntryPost4[i] = tabEntry4[i]-1;
	        view.progressionTriolet(i, tabEntryPost4, swi, View.COLOR_TO_BE_PLAYED);
	    }
	    System.out.println("Entrez les 16 valeurs de dès (Menuet) : ");
        for (int i = 0; i < 8; i++) {
            do {
                tabEntry1[i] = input.nextInt();
                if (tabEntry1[i] < 2 || tabEntry1[i] > 12) {
                    System.out.println("Error : Please enter a value in range [2,11]");
                }
            } while (tabEntry1[i] < 2 || tabEntry1[i] > 12);
            swi = 0;
            tabEntryPost1[i] = tabEntry1[i]-2;
            view.progressionMenuet(i, tabEntryPost1, swi, View.COLOR_TO_BE_PLAYED);
        }
        for (int i = 0; i < 8; i++) {
            do {
                tabEntry2[i] = input.nextInt();
                if (tabEntry2[i] < 2 || tabEntry2[i] > 12) {
                    System.out.println("Error : Please enter a value in range [2,11]");
                }
            } while (tabEntry2[i] < 2 || tabEntry2[i] > 12);
            swi = 1;
            tabEntryPost2[i] = tabEntry2[i]-2;
            view.progressionMenuet(i, tabEntryPost2, swi, View.COLOR_TO_BE_PLAYED);
        }
        for(int b = 0 ; b < Valse.nbBoucleArg; b++){
		    System.out.println("\n\n\n1ere partie du Triolet\n");
		    for (int i = 0; i < 8; i++) {
		        swi = 0;
		        if(this.mute == false){
		    	 	StdAudio.play(TabMesure.tabTriolet1[i][tabEntryPost3[i]]);
				}
				nomMesure = TabMesure.tabTriolet1[i][tabEntryPost3[i]];
				nomMesure = nomMesure.substring(0, nomMesure.length() - 4);
				System.out.println("\t" + nomMesure);
		        view.progressionTriolet(i, tabEntryPost3, swi, View.COLOR_PLAYED);
				view.tracePartitionTriolet(i, tabEntryPost3, swi);
		        try {
		            Thread.sleep(PAUSE);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        view.progressionTriolet(i, tabEntryPost3, swi, View.COLOR_TO_BE_PLAYED);
		    }
		    System.out.println("\n\n\n2eme partie du Triolet\n");
		    for (int i = 0; i < 8; i++) {
		        swi = 1;
		        if(this.mute == false){
		       		StdAudio.play(TabMesure.tabTriolet2[i][tabEntryPost4[i]]);
				}
				nomMesure = TabMesure.tabTriolet2[i][tabEntryPost4[i]];
				nomMesure = nomMesure.substring(0, nomMesure.length() - 4);
				System.out.println("\t" + nomMesure);
		        view.progressionTriolet(i, tabEntryPost4, swi, View.COLOR_PLAYED);	                
				view.tracePartitionTriolet(i, tabEntryPost4, swi);
		        try {
		            Thread.sleep(PAUSE);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        view.progressionTriolet(i, tabEntryPost4, swi, View.COLOR_TO_BE_PLAYED);
	        }

	        System.out.println("\n\n\n1ere partie du Menuet\n");
            for (int i = 0; i < 8; i++) {
                swi = 0; 
                if(this.mute == false){
	               	StdAudio.play(TabMesure.tabMenuet1[i][tabEntryPost1[i]]);
	            }
	            nomMesure = TabMesure.tabMenuet1[i][tabEntryPost1[i]];
	            nomMesure = nomMesure.substring(0, nomMesure.length() - 4);
	            System.out.println("\t" + nomMesure);
                view.progressionMenuet(i, tabEntryPost1, swi, View.COLOR_PLAYED);
				view.tracePartitionMenuet(i, tabEntryPost1, swi);
                try {
                    Thread.sleep(PAUSE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                view.progressionMenuet(i, tabEntryPost1, swi, View.COLOR_TO_BE_PLAYED);
            }
            System.out.println("\n\n\n2eme partie du Menuet\n");
            for (int i = 0; i < 8; i++) {
                swi = 1;
                if(this.mute == false){
	               	StdAudio.play(TabMesure.tabMenuet2[i][tabEntryPost2[i]]);
	            }
	            nomMesure = TabMesure.tabMenuet2[i][tabEntryPost2[i]];
	            nomMesure = nomMesure.substring(0, nomMesure.length() - 4);
	            System.out.println("\t" + nomMesure);
                view.progressionMenuet(i, tabEntryPost2, swi, View.COLOR_PLAYED);
				view.tracePartitionMenuet(i, tabEntryPost2, swi);
                try {
                    Thread.sleep(PAUSE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                view.progressionMenuet(i, tabEntryPost2, swi, View.COLOR_TO_BE_PLAYED);
            }
        }
	}

	    	/*Random Part*/

	/**
	 * Regroupe et appelle les differentes méthodes nécessaire selon le type de valse. Cette methode ne nécessite pas l'entrée de valeurs par l'utilisateur.(Random)
	 * Cette méthode gère aussi l'ordre d'appelle des méthode selon si on veut jouer 2 menuets + 2 triolets ou l'inverse.
	 */
	public void playRand() {
	    if (this.type.equals("Menuet") || this.type.equals("menuet")) {
	            this.randMenuet();
	    } else if (this.type.equals("Triolet") || this.type.equals("triolet")) {
	        this.randTriolet();
	    } else {
	        if (this.type.equals("Menuet+Triolet") || this.type.equals("menuet+triolet")) {
	            this.randMenuet();
	            this.randTriolet();
	        }
	        else if (this.type.equals("Triolet+Menuet") || this.type.equals("triolet+menuet")) {
	            this.randTriolet();
	            this.randMenuet();
	        }else{
	            System.out.println("invalid type. Please consult help.txt");
	        }
	    }
	}

	/**
	 * Joue un 2x8 mesures de menuet, aléatoirement et selon les tableaux proposés.
	 */
	public void randMenuet() {
	    System.out.println("\n\n1ère Partie de la valse (Menuet) : ");
	    for (int i = 0; i < NB_MESURES; i++) { //progression menuet1
	        diceMenuet1[i] = randomize(11);
	        swi = 0;
	        view.progressionMenuet(i, diceMenuet1, swi, View.COLOR_TO_BE_PLAYED);
	    }
	    for (int i = 0; i < NB_MESURES; i++) { //progression menuet2
	        diceMenuet2[i] = randomize(11);
	        swi = 1;
	        view.progressionMenuet(i, diceMenuet2, swi, View.COLOR_TO_BE_PLAYED);
	    }
	        for (int i = 0; i < NB_MESURES; i++) {
	            if(this.mute == false){
	                StdAudio.play(TabMesure.tabMenuet1[i][diceMenuet1[i]]);
	            }
	            nomMesure = TabMesure.tabMenuet1[i][diceMenuet1[i]];
	            nomMesure = nomMesure.substring(0, nomMesure.length() - 4);
	            System.out.print(nomMesure + " ");
	            swi = 0;
	            view.progressionMenuet(i, diceMenuet1, swi, View.COLOR_PLAYED);
	  			view.tracePartitionMenuet(i, diceMenuet1, swi);
	            try {
	                Thread.sleep(PAUSE);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	                view.progressionMenuet(i, diceMenuet1, swi, View.COLOR_TO_BE_PLAYED);
	        }
	        System.out.println("\n\n2ème Partie de la valse (Menuet):");
	        for (int i = 0; i < NB_MESURES; i++) {
	            if(this.mute == false){
	                StdAudio.play(TabMesure.tabMenuet2[i][diceMenuet2[i]]);
	            }
	            nomMesure = TabMesure.tabMenuet2[i][diceMenuet2[i]];
	            nomMesure = nomMesure.substring(0, nomMesure.length() - 4);
	            System.out.print(nomMesure + " ");
	            swi = 1;
	            view.progressionMenuet(i, diceMenuet2, swi, View.COLOR_PLAYED);
	            view.tracePartitionMenuet(i, diceMenuet2, swi);
	            try {
	                Thread.sleep(PAUSE);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            view.progressionMenuet(i, diceMenuet2, swi, View.COLOR_TO_BE_PLAYED);
	      }
	}

	/**
	 * Joue un 2x8 mesures de triolet, aléatoirement et selon les tableaux proposés.
	 */
	public void randTriolet() {
	    System.out.println("\n\n1ère Partie de la valse (Triolet):");
	    for (int i = 0; i < NB_MESURES; i++) {
	        diceTriolet1[i] = randomize(6);
	        swi = 0;
	        view.progressionTriolet(i, diceTriolet1, swi, View.COLOR_TO_BE_PLAYED);
	    }
	    for (int i = 0; i < NB_MESURES; i++) {
	        diceTriolet2[i] = randomize(6);
	        swi = 1;
	        view.progressionTriolet(i, diceTriolet2, swi, View.COLOR_TO_BE_PLAYED);
	    }
	    for (int i = 0; i < NB_MESURES; i++) {
	        if(this.mute == false){
	            StdAudio.play(TabMesure.tabTriolet1[i][diceTriolet1[i]]);
	        }
	        nomMesure = TabMesure.tabTriolet1[i][diceTriolet1[i]];
	        nomMesure = nomMesure.substring(0, nomMesure.length() - 4);
	        System.out.print(nomMesure + " ");
	        swi = 0;
	        view.progressionTriolet(i, diceTriolet1, swi, View.COLOR_PLAYED);
			view.tracePartitionTriolet(i, diceTriolet1, swi);
	        try {
	            Thread.sleep(PAUSE);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        view.progressionTriolet(i, diceTriolet1, swi, View.COLOR_TO_BE_PLAYED);
	    }
	    System.out.println("\n\n2ème Partie de la valse (Triolet):");
	    for (int i = 0; i < NB_MESURES; i++) {
	        if(this.mute == false){
	            StdAudio.play(TabMesure.tabTriolet2[i][diceTriolet2[i]]);
	        }
	        nomMesure = TabMesure.tabTriolet2[i][diceTriolet2[i]];
	        nomMesure = nomMesure.substring(0, nomMesure.length() - 4);
	        System.out.print(nomMesure + " ");
	        swi = 1;
	        view.progressionTriolet(i, diceTriolet2, swi, View.COLOR_PLAYED);
			view.tracePartitionTriolet(i, diceTriolet2, swi);
	        try {
	            Thread.sleep(PAUSE);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        view.progressionTriolet(i, diceTriolet2, swi, View.COLOR_TO_BE_PLAYED);
	    }
	}

	    	/*Others*/

	/**
	 * Attribue une valeur aléatoire entre 0 et nb à la variable rand.
	 * @param nb est le nombre que l'on veut mélanger.
	 * @return rand est le nombre obtenue
	 */
	public int randomize(int nb) {
	        int rand = (int) (Math.random() * nb);
	        return rand;
	}

	/**
	 * Retourne l'état de l'objet valse créé
	 */
	public void etat() {
		System.out.println("\n\nEtat de la Valse : ");
		System.out.println("Type : " + this.type);
		System.out.println("Mute : " + this.mute);
		System.out.println("\n");
	}
}