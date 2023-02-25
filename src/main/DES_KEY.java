package main;

/**
 * @author OTMANE ER-RAGRAGUI  120 117 39
 * @author ABDESSAMAD BOUZEKRI 120 122 48
 */

public class DES_KEY
{
    //Permutation PC-1 et PC-2

    static int[] PC_1 = {56,48,40,32,24,17, 8,
            0,57,49,41,33,25,17,
            9, 1,58,50,42,34,26,
            18,10, 2,59,51,43,35,
            62,54,46,38,30,22,14,
            6,61,53,45,37,29,21,
            13, 5,60,52,44,36,28,
            20,12, 4,27,19,11, 3};

    static int[] PC_2 = {13,16,10,23, 0, 4,
            2,27,14, 5,20, 9,
            22,18,11, 3,25, 7,
            15, 6,26,19,12, 1,
            40,51,30,36,46,54,
            29,39,50,44,32,47,
            43,48,38,55,33,52,
            45,41,49,35,28,31};

    static int[] Left_shift = {1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1};

    //*****************************************************************************
    int nb_subKeys = 16; //de K1 � K16 (ici de K0 � K15)
    int[][] subKeys = new int[nb_subKeys][48];

    //La fonction qui genere les clefs *********************************************

    void KeyG(String clef) throws Exception {
        int[] key = new int[64]; //clef initiale

        int[] gauche = new int[28];
        int[] droite = new int[28];
        int[] g_d = new int[56]; //concatenation de la partie gauche et droite
        int nb_subKeys = 16;
        int[][] subKeys = new int[nb_subKeys][48];

        key = FUNCTIONS.convert_test(clef, key);

        key = FUNCTIONS.permutation(56, key, PC_1); //On permute avec PC-1

        //On coupe en 2 parties gauche et droite

        System.arraycopy(key, 0, gauche, 0, gauche.length);
        System.arraycopy(key, 28, droite, 0, droite.length);


        for (int i = 0 ; i < nb_subKeys ; i++)
        {
            //On fait un shift gauche
            gauche = FUNCTIONS.shiftLeft(28,gauche,Left_shift[i]);
            droite = FUNCTIONS.shiftLeft(28,droite,Left_shift[i]);

            //On concatene
            System.arraycopy(gauche, 0, g_d, 0, gauche.length);
            System.arraycopy(droite, 0, g_d, gauche.length, droite.length);

            subKeys[i] = FUNCTIONS.permutation(48, g_d, PC_2); //On permute avec PC_2
        }

        this.subKeys= subKeys;


    }

    //retourne les sous clefs
    public int[][] getSubKeys()
    {
        return this.subKeys;
    }
}
