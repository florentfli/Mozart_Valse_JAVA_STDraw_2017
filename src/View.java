import java.awt.*;
import java.util.*;

public class View {
    
    static Color COLOR_PLAYED = new Color(255, 123, 0);
    static Color COLOR_TO_BE_PLAYED = new Color(165, 68, 7);
    static Color COLOR_CONTOUR = new Color(0, 0, 0);
    static Color COLOR_FONT = new Color(255, 255, 255);
    static Color COLOR_RECTANGLE = new Color(185, 27, 17, 75);
    static Color COLOR_COL_DES = new Color(119, 124, 113, 78);
    double TailleCase = 32;
    double PosXTabLeft = 150;
    double PosXTabRight = 1000;
    double PosYTabBottom = 200;
    double PosYTabTop = 450;
    double POS_X_PART_SCREEN = 800;
    double POS_Y_PART_SCREEN = 385;
    double SCALE_X_IMG_PART = 225;
    double SCALE_Y_IMG_PART = 175;
    int TAILLE_REC_X = 150;
    int TAILLE_REC_Y = 100;
    double epaisseurContourRectangle = 0.005;
    double VAL_X = 86;

    /**
     * FAit appelle aux différentes méthodes de tracage de la valse, selon le type de cette dernière.
     * Fait appelle à la méthode initWidget().
     * @param valse objet crée auquel on veut attribuer la frame.
     */
    public void createWidget(ValseCaracts valse) {
        initWidget();
        if (valse.type.equals("Menuet") || valse.type.equals("menuet")) {
            this.traceMenuet();
        } else if (valse.type.equals("Triolet") || valse.type.equals("triolet")) {
            this.traceTriolet();
        } else {
            if (valse.type.equals("Menuet+Triolet") || valse.type.equals("menuet+triolet")) {
                this.traceMenuet();
                this.traceTriolet();
            }
            else if (valse.type.equals("Triolet+Menuet") || valse.type.equals("triolet+menuet")) {
                this.traceTriolet();
                this.traceMenuet();
            }else{
                System.out.println("invalid traceType. Please consult help.txt");
            }
        }
        StdDraw.show();
    }

    /**
     * Initialise tous les caractèristiques de la frame.
     * Fait appelle aux méthodes traceTitle() et traceAuthors().
     */
    public void initWidget(){
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(1600, 900);
        StdDraw.setXscale(0, 1600);
        StdDraw.setYscale(0, 1000);
        StdDraw.picture(800, 500, "piano.jpg", 1600, 1000);
        StdDraw.setPenRadius(50);
        traceTitle();
        traceAuthors();
        Font font = new Font("Arial", Font.PLAIN, 14);
        StdDraw.setFont(font);
    }

    /**
     * Trace les deux tableaux de menuets
     */
    public void traceMenuet(){
        traceValeurMenuet();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 11; j++) {
                String mesure = TabMesure.tabMenuet1[i][10 - j];
                mesure = mesure.substring(0, mesure.length() - 4);
                StdDraw.setPenColor(COLOR_RECTANGLE);
                StdDraw.filledRectangle(i * 2 * TailleCase + PosXTabLeft, j * TailleCase + PosYTabTop, TailleCase, TailleCase / 2);
                StdDraw.setPenColor(COLOR_CONTOUR);
                StdDraw.setPenRadius(epaisseurContourRectangle);
                StdDraw.rectangle(i * 2 * TailleCase + PosXTabLeft, j * TailleCase + PosYTabTop, TailleCase, TailleCase / 2);
                StdDraw.setPenColor(COLOR_FONT);
                StdDraw.text(i * 2 * TailleCase + PosXTabLeft, j * TailleCase + PosYTabTop, mesure);
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 11; j++) {
                String mesure = TabMesure.tabMenuet2[i][10 - j];
                mesure = mesure.substring(0, mesure.length() - 4);
                StdDraw.setPenColor(COLOR_RECTANGLE);
                StdDraw.filledRectangle(i * 2 * TailleCase + PosXTabRight, j * TailleCase + PosYTabTop, TailleCase, TailleCase / 2);
                StdDraw.setPenColor(COLOR_CONTOUR);
                StdDraw.setPenRadius(epaisseurContourRectangle);
                StdDraw.rectangle(i * 2 * TailleCase + PosXTabRight, j * TailleCase + PosYTabTop, TailleCase, TailleCase / 2);
                StdDraw.setPenColor(COLOR_FONT);
                StdDraw.text(i * 2 * TailleCase + PosXTabRight, j * TailleCase + PosYTabTop, mesure);
            }
        }
    }

    /**
     * Trace les deux tableaux de triolets
     */
    public void traceTriolet(){
        traceValeurTriolet();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                String mesure = TabMesure.tabTriolet1[i][5 - j];
                mesure = mesure.substring(0, mesure.length() - 4);
                StdDraw.setPenColor(COLOR_RECTANGLE);
                StdDraw.filledRectangle(i * 2 * TailleCase + PosXTabLeft, j * TailleCase + PosYTabBottom, TailleCase, TailleCase / 2);
                StdDraw.setPenColor(COLOR_CONTOUR);
                StdDraw.setPenRadius(epaisseurContourRectangle);
                StdDraw.rectangle(i * 2 * TailleCase + PosXTabLeft, j * TailleCase + PosYTabBottom, TailleCase, TailleCase / 2);
                StdDraw.setPenColor(COLOR_FONT);
                StdDraw.text(i * 2 * TailleCase + PosXTabLeft, j * TailleCase + PosYTabBottom, mesure);
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                String mesure = TabMesure.tabTriolet2[i][5 - j];
                mesure = mesure.substring(0, mesure.length() - 4);
                StdDraw.setPenColor(COLOR_RECTANGLE);
                StdDraw.filledRectangle(i * 2 * TailleCase + PosXTabRight, j * TailleCase + PosYTabBottom, TailleCase, TailleCase / 2);
                StdDraw.setPenColor(COLOR_CONTOUR);
                StdDraw.setPenRadius(epaisseurContourRectangle);
                StdDraw.rectangle(i * 2 * TailleCase + PosXTabRight, j * TailleCase + PosYTabBottom, TailleCase, TailleCase / 2);
                StdDraw.setPenColor(COLOR_FONT);
                StdDraw.text(i * 2 * TailleCase + PosXTabRight, j * TailleCase + PosYTabBottom, mesure);
            }
        }
    }

    /**
     * Met en valeurs les cases a jouer des deux tableaux de menuets.
     * @param i est l'indice de la colonne du tableaux de menuet joué.
     * @param tabValue est le tableaux des valeurs à être jouée.
     * @param swi permet de changer la position du tracage de la progression selon la position dans la valse (1er menuet ou 2ème menuet).
     * @param couleur attribue la couleur à la case.
     */
    public void progressionMenuet(int i, int[] tabValue, int swi, Color couleur){
        String mesure;
        switch(swi){
            case 0 :
                //Menuet1
                StdDraw.setPenColor(couleur);
                mesure = TabMesure.tabMenuet1[i][tabValue[i]];
                mesure = mesure.substring(0, mesure.length() - 4);
                StdDraw.filledRectangle(i * 2 * TailleCase + PosXTabLeft, (10 - tabValue[i]) * TailleCase + PosYTabTop, TailleCase, TailleCase / 2);
                StdDraw.setPenColor(COLOR_CONTOUR);
                StdDraw.setPenRadius(epaisseurContourRectangle);
                StdDraw.rectangle(i * 2 * TailleCase + PosXTabLeft, (10 - tabValue[i]) * TailleCase + PosYTabTop, TailleCase, TailleCase / 2);
                StdDraw.setPenColor(COLOR_FONT);
                StdDraw.text(i * 2 * TailleCase + PosXTabLeft, (10 - tabValue[i]) * TailleCase + PosYTabTop, mesure);
                StdDraw.show();
                break;
            case 1 :
                //Menuet2
                StdDraw.setPenColor(couleur);
                mesure = TabMesure.tabMenuet2[i][tabValue[i]];
                mesure = mesure.substring(0, mesure.length() - 4);
                StdDraw.filledRectangle(i * 2 * TailleCase + PosXTabRight, (10 - tabValue[i]) * TailleCase + PosYTabTop, TailleCase, TailleCase / 2);
                StdDraw.setPenColor(COLOR_CONTOUR);
                StdDraw.setPenRadius(epaisseurContourRectangle);
                StdDraw.rectangle(i * 2 * TailleCase + PosXTabRight, (10 - tabValue[i]) * TailleCase + PosYTabTop, TailleCase, TailleCase / 2);
                StdDraw.setPenColor(COLOR_FONT);
                StdDraw.text(i * 2 * TailleCase + PosXTabRight, (10 - tabValue[i]) * TailleCase + PosYTabTop, mesure);
                StdDraw.show();
                break;
        }
    }

    /**
     * Met en valeurs les cases a jouer des deux tableaux de triolets.
     * @param i est l'indice de la colonne du tableaux de triolet joué.
     * @param tabValue est le tableaux des valeurs à être jouée.
     * @param swi permet de changer la position du tracage de la progression selon la position dans la valse (1er triolet ou 2ème triolet).
     * @param couleur attribue la couleur à la case.
     */
    public void progressionTriolet(int i, int[] tabValue, int swi, Color couleur) {
        String mesure;
        switch (swi) {
            case 0:
                //Triolet1
                StdDraw.setPenColor(couleur);
                mesure = TabMesure.tabTriolet1[i][tabValue[i]];
                mesure = mesure.substring(0, mesure.length() - 4);
                StdDraw.filledRectangle(i * 2 * TailleCase + PosXTabLeft, (5 - tabValue[i]) * TailleCase + PosYTabBottom, TailleCase, TailleCase / 2);
                StdDraw.setPenColor(COLOR_CONTOUR);
                StdDraw.setPenRadius(epaisseurContourRectangle);
                StdDraw.rectangle(i * 2 * TailleCase + PosXTabLeft, (5 - tabValue[i]) * TailleCase + PosYTabBottom, TailleCase, TailleCase / 2);
                StdDraw.setPenColor(COLOR_FONT);
                StdDraw.text(i * 2 * TailleCase + PosXTabLeft, (5 - tabValue[i]) * TailleCase + PosYTabBottom, mesure);
                StdDraw.show();
                break;
            case 1:
                //Triolet2
                StdDraw.setPenColor(couleur);
                mesure = TabMesure.tabTriolet2[i][tabValue[i]];
                mesure = mesure.substring(0, mesure.length() - 4);
                StdDraw.filledRectangle(i * 2 * TailleCase + PosXTabRight, (5 - tabValue[i]) * TailleCase + PosYTabBottom, TailleCase, TailleCase / 2);
                StdDraw.setPenColor(COLOR_CONTOUR);
                StdDraw.setPenRadius(epaisseurContourRectangle);
                StdDraw.rectangle(i * 2 * TailleCase + PosXTabRight, (5 - tabValue[i]) * TailleCase + PosYTabBottom, TailleCase, TailleCase / 2);
                StdDraw.setPenColor(COLOR_FONT);
                StdDraw.text(i * 2 * TailleCase + PosXTabRight, (5 - tabValue[i]) * TailleCase + PosYTabBottom, mesure);
                StdDraw.show();
                break;
        }
    }

    /**
     * Trace le titre sur la frame.
     */
    public void traceTitle(){
        Font fontTitle = new Font("Arial", Font.BOLD, 50);
        StdDraw.setFont(fontTitle);
        StdDraw.setPenColor(COLOR_CONTOUR);
        StdDraw.text(805, 895,"Projet d'Algo - Valse Mozart");
        Font fontTitle2 = new Font("Arial", Font.BOLD, 50);
        StdDraw.setFont(fontTitle2);
        StdDraw.setPenColor(COLOR_FONT);
        StdDraw.text(800, 900,"Projet d'Algo - Valse Mozart");
    }

    /**
     *  Trace le nom des auteurs sur la frame.
     */
    public void traceAuthors(){
        Font fontTitle2 = new Font("Arial", Font.ITALIC + Font.BOLD, 30);
        StdDraw.setFont(fontTitle2);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.text(300, 55,"F    L    I    E    D    N    E    R");
        StdDraw.text(525, 20,"F l o r e n t");

        StdDraw.setFont(fontTitle2);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.text(1100, 55,"R    O    B    I    N");
        StdDraw.text(1325, 20,"E r w a n");
    }

    /**
     * Trace l'écran supposé acceuillir les images de partitions menuet.
     * @param i est l'indice de la colonne du tableaux de triolet joué.
     * @param tabValue est le tableaux des valeurs à être jouée.
     * @param swi permet de cibler le tableaux d'image a afficher.
     */
    public void tracePartitionMenuet(int i, int[] tabValue, int swi){
    	StdDraw.setPenColor(StdDraw.WHITE);
    	StdDraw.filledRectangle(POS_X_PART_SCREEN,POS_Y_PART_SCREEN,150,100);
    	StdDraw.setPenRadius(0.02);
    	StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.rectangle(POS_X_PART_SCREEN,POS_Y_PART_SCREEN,150,100);
    	switch(swi) {
    	    case 0 :
                traceBarre(POS_X_PART_SCREEN, POS_Y_PART_SCREEN, TabMesure.tabImgMenuet1[i][tabValue[i]],SCALE_X_IMG_PART,SCALE_Y_IMG_PART);
    			break;
    		case 1 :
                traceBarre(POS_X_PART_SCREEN, POS_Y_PART_SCREEN, TabMesure.tabImgMenuet2[i][tabValue[i]],SCALE_X_IMG_PART,SCALE_Y_IMG_PART);
    			break;
    	}
    }

    /**
     * Trace l'écran supposé acceuillir les images de partitions triolet.
     * @param i est l'indice de la colonne du tableaux de triolet joué.
     * @param tabValue est le tableaux des valeurs à être jouée.
     * @param swi permet de cibler le tableaux d'image a afficher.
     */
    public void tracePartitionTriolet(int i, int[] tabValue, int swi){
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledRectangle(POS_X_PART_SCREEN,POS_Y_PART_SCREEN,150,100);
        StdDraw.setPenRadius(0.02);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.rectangle(POS_X_PART_SCREEN,POS_Y_PART_SCREEN,150,100);
        switch(swi) {
            case 0 :
                traceBarre(POS_X_PART_SCREEN, POS_Y_PART_SCREEN, TabMesure.tabImgTriolet1[i][tabValue[i]],SCALE_X_IMG_PART,SCALE_Y_IMG_PART);
                break;
            case 1 :
                traceBarre(POS_X_PART_SCREEN, POS_Y_PART_SCREEN, TabMesure.tabImgTriolet2[i][tabValue[i]],SCALE_X_IMG_PART,SCALE_Y_IMG_PART);
                break;
        }
    }

    /**
     * Affiche les valeurs possibles des deux dès lancés.
     */
    public void traceValeurMenuet(){
        String[] desMenuet = {"2","3","4","5","6","7","8","9","10","11","12"};
        String valDes;
        for (int i = 0; i < desMenuet.length; i++) {
            valDes = desMenuet[10 - i];
            StdDraw.setPenColor(COLOR_COL_DES);
            StdDraw.filledRectangle(VAL_X, i* TailleCase + PosYTabTop, TailleCase, TailleCase / 2);
            StdDraw.setPenColor(COLOR_CONTOUR);
            StdDraw.setPenRadius(epaisseurContourRectangle);
            StdDraw.rectangle(VAL_X, i* TailleCase + PosYTabTop, TailleCase, TailleCase / 2);
            StdDraw.setPenColor(COLOR_FONT);
            StdDraw.text(VAL_X, i* TailleCase + PosYTabTop, valDes);
        }
    }

    /**
     * Affiche les valeurs possibles du dès lancés.
     */
    public void traceValeurTriolet(){
        String[] desMenuet = {"1","2","3","4","5","6"};
        String valDes;
        for (int i = 0; i < desMenuet.length; i++) {
            valDes = desMenuet[5 - i];
            StdDraw.setPenColor(COLOR_COL_DES);
            StdDraw.filledRectangle(VAL_X, i * TailleCase + PosYTabBottom, TailleCase, TailleCase / 2);
            StdDraw.setPenColor(COLOR_CONTOUR);
            StdDraw.setPenRadius(epaisseurContourRectangle);
            StdDraw.rectangle(VAL_X, i * TailleCase + PosYTabBottom, TailleCase, TailleCase / 2);
            StdDraw.setPenColor(COLOR_FONT);
            StdDraw.text(VAL_X, i * TailleCase + PosYTabBottom, valDes);
        }
    }

    /**
     *
     * @param x position en x de l'image
     * @param y position en y de l'image
     * @param namefile nom de l'image selon les tableaux imgTab
     * @param scaleX echelle X de l'image
     * @param scaleY echelle Y de l'image
     */
    public void traceBarre(double x, double y, String namefile, double scaleX, double scaleY){
        for (int i = 40; i < 265; i++){
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledRectangle(POS_X_PART_SCREEN,POS_Y_PART_SCREEN,150,100);
            StdDraw.picture(x,y,namefile,scaleX,scaleY);
            StdDraw.setPenRadius(0.01);
            StdDraw.setPenColor(StdDraw.BOOK_BLUE);
            StdDraw.line(POS_X_PART_SCREEN - TAILLE_REC_X + i, POS_Y_PART_SCREEN - TAILLE_REC_Y + 10,POS_X_PART_SCREEN - TAILLE_REC_X + i , POS_Y_PART_SCREEN + TAILLE_REC_Y -10);
            StdDraw.show();
        }
    }
}























