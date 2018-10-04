/**
 Project realised by FLIEDNER Florent and ROBIN Erwan as "Les pêcheurs du dimanche"
 Group A2.
 Project started on 25/11/2017.
 Finished on 22/12/2017.
 Merry Christmas & Happy new year, Enjoy !
**/

/*
    REPONSES AUX QUESTIONS:

    (la formule utilisée se trouve dans le pdf ReadMe)

    Menuets: 	n = 8;  p = 8 * 11 = 88;
    Nombre de combinaisons possible:

    88! / 8!(88 − 8)!
    = 88×87×86×85×84×83×82×81 / 8×7×6×5×4×3×2
    = 2591645234048640 / 40320
    = 64276915527

    Menuets + Trio: 	n = 16;  p = 8 * 11 + 8 * 6 = 136;
    Nombre de combinaisons possible:

    136! / 16!(136 − 16)!
    = 136×135×134×133×132×131×130×129×128×127×126×125×124×123×122×121 / 16×15×14×13×12×11×10×9×8×7×6×5×4×3×2
    = 5469827772398615431168153190400000 / 20922789888000
    = 261429178502421685800

    Question subsidiaire:

    M82 ; T45 ; M82 ; T45 ;
*/

public class Valse {
// Pour les E/S d'évaluation. NE PAS MODIFIER.
// final static Scanner input = new Scanner(System.in);

    static int nbBoucleArg = 1;

    public static void main(String[] args) {

        String whichType = "menuet+triolet";
        boolean muted = false;
        int nbArgs=4;
        boolean isRand = true;

        View view = new View();
        ValseCaracts valse1 = new ValseCaracts("menuet+triolet", false, view);
        view.createWidget(valse1);
        valse1.playRand();

        /*nbArgs = args.length;
        for (int i = 0; i < nbArgs; i++) {
            if (args[i].equals("menuet") || args[i].equals("Menuet")) {
                whichType = "menuet";
            }else {
                if (args[i].equals("trio") || args[i].equals("Trio") || args[i].equals("triolet") || args[i].equals("Triolet")) {
                    whichType = "triolet";
                }else {
                    if (args[i].equals("menuet+trio") || args[i].equals("Menuet+Trio") || args[i].equals("menuet+triolet") || args[i].equals("Menuet+Triolet")) {
                        whichType = "menuet+triolet";
                    }else {
                        if (args[i].equals("trio+menuet") || args[i].equals("Trio+Menuet") || args[i].equals("triolet+menuet") || args[i].equals("Triolet+Menuet")) {
                            whichType = "triolet+menuet";
                        }else {
                            if (args[i].equals("playback") || args[i].equals("playback")) {
                                muted = false;
                           }else {
                                if (args[i].equals("noplayback") || args[i].equals("Noplayback")) {
                                    muted = true;
                                }else {
                                    if (args[i].equals("rand") || args[i].equals("Rand")) {
                                        isRand = true;
                                    }else {
                                        if (args[i].equals("stdin") || args[i].equals("Stdin")) {
                                            isRand = false;
                                        }else {
                                            if (args[i].equals("help") || args[i].equals("Help")) {
                                                printHelp();
                                            }else {
                                                if (args[i].matches("^-?\\d+$")) {
                                                    nbBoucleArg = Integer.parseInt(args[i]);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }*/

        /*ValseCaracts valse1 = new ValseCaracts(whichType, muted, view);*/

        if (!isRand){
            view.createWidget(valse1);
            valse1.playStdin();
        }else{        
            for(int b = 0; b < nbBoucleArg; b++){
                view.createWidget(valse1);                
                valse1.playRand();
            }
        }
    }

    /**
     * Affiche l'aide.
     */
    public static void printHelp(){
        System.out.println("\n\n|!| ========================- HELP -========================|!|\n\n");

        System.out.println("Argument: Voici la liste des argument possible, L'ORDRE N'A PAS D'IMPORTANCE :\n");
        System.out.println("\t- 'Rand' ou 'rand'      : jouera la composition aléatoirement");
        System.out.println("\t- 'Stdin' ou 'stdin'    : jouera la composition celon les entrés dans la console");
        System.out.println("\t- 'Menuet' ou 'menuet'                                      : jouera la composition en menuet");
        System.out.println("\t- 'Trio' ou 'trio' ou 'triolet' ou 'Triolet'                : jouera la composition en triolet");
        System.out.println("\t- 'Menuet+Trio' ou 'menuet+trio' ou 'Menuet+Triolet' ou 'menuet+triolet': jouera la composition en menuet puis en triolet");
        System.out.println("\t- 'Trio+Menuet' ou 'trio+menuet' ou 'Triolet+Menuet' ou 'triolet+menuet': jouera la composition en triolet puis en menuet");
        System.out.println("\t- 'playback' ou 'Playback'      : active le son");
        System.out.println("\t- 'noplayback' ou 'Noplayback'  : desactive le son");
        System.out.println("\t-  Un entier naturel determinera le nombre de répétition de la composition");
        System.out.println("\t- 'help' ou 'Help': affichera l'aide\n\n");


        System.out.println("A défaut d'être renseigné, l'argument prendra la valeur suivante:\n");
        System.out.println("\t- Mode:     'rand'");
        System.out.println("\t- Type:     'menuet+trio'");
        System.out.println("\t- Son:      'playback'");
        System.out.println("\t- Repetition: '1'");
        
        System.out.println("\n\n|!| ========================- HELP -========================|!|\n\n");
    }
}

    //  VERSION POUR IDEA.
    /*
        View view = new View();
        ValseCaracts valse1 = new ValseCaracts("menuet+triolet", false, view);
        view.createWidget(valse1);
        valse1.playStdin();
    */