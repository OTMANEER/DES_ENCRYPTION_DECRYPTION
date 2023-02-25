package main;

/**
 * @author OTMANE ER-RAGRAGUI  120 117 39
 * @author ABDESSAMAD BOUZEKRI 120 122 48
 */

public class FUNCTIONS
{
    // S-Boxes

    static int[][] S1 = {{14, 4,13, 1, 2,15,11, 8, 3,10, 6,12, 5, 9, 0, 7},
            { 0,15, 7, 4,14, 2,13, 1,10, 6,12,11, 9, 5, 3, 8},
            { 4, 1,14, 8,13, 6, 2,11,15,12, 9, 7, 3,10, 5, 0},
            {15,12, 8, 2, 4, 9, 1, 7, 5,11, 3,14,10, 0, 6,13}};

    static int[][] S2 = {{15, 1, 8,14, 6,11, 3, 4, 9, 7, 2,13,12, 0, 5,10},
            { 3,13, 4, 7,15, 2, 8,14,12, 0, 1,10, 6, 9,11, 5},
            { 0,14, 7,11,10, 4,13, 1, 5, 8,12, 6, 9, 3, 2,15},
            {13, 8,10, 1, 3,15, 4, 2,11, 6, 7,12, 0, 5,14, 9}};

    static int[][] S3=  {{10, 0, 9,14, 6, 3,15, 5, 1,13,12, 7,11, 4, 2, 8},
            {13, 7, 0, 9, 3, 4, 6,10, 2, 8, 5,14,12,11,15, 1},
            {13, 6, 4, 9, 8,15, 3, 0,11, 1, 2,12, 5,10,14, 7},
            { 1,10,13, 0, 6, 9, 8, 7, 4,15,14, 3,11, 5, 2,12}};

    static int[][] S4 = {{ 7,13,14, 3, 0, 6, 9,10, 1, 2, 8, 5,11,12, 4,15},
            {13, 8,11, 5, 6,15, 0, 3, 4, 7, 2,12, 1,10,14, 9},
            {10, 6, 9, 0,12,11, 7,13,15, 1, 3,14, 5, 2, 8, 4},
            { 3,15, 0, 6,10, 1,13, 8, 9, 4, 5,11,12, 7, 2,14}};

    static int[][] S5 = {{ 2,12, 4, 1, 7,10,11, 6, 8, 5, 3,15,13, 0,14, 9},
            {14,11, 2,12, 4, 7,13, 1, 5, 0,15,10, 3, 9, 8, 6},
            { 4, 2, 1,11,10,13, 7, 8,15, 9,12, 5, 6, 3, 0,14},
            {11, 8,12, 7, 1,14, 2,13, 6,15, 0, 9,10, 4, 5, 3}};

    static int[][] S6 = {{12, 1,10,15, 9, 2, 6, 8, 0,13, 3, 4,14, 7, 5,11},
            {10,15, 4, 2, 7,12, 9, 5, 6, 1,13,14, 0,11, 3, 8},
            { 9,14,15, 5, 2, 8,12, 3, 7, 0, 4,10, 1,13,11, 6},
            { 4, 3, 2,12, 9, 5,15,10,11,14, 1, 7, 6, 0, 8,13}};

    static int[][] S7 = {{ 4,11, 2,14,15, 0, 8,13, 3,12, 9, 7, 5,10, 6, 1},
            {13, 0,11, 7, 4, 9, 1,10,14, 3, 5,12, 2,15, 8, 6},
            { 1, 4,11,13,12, 3, 7,14,10,15, 6, 8, 0, 5, 9, 2},
            { 6,11,13, 8, 1, 4,10, 7, 9, 5, 0,15,14, 2, 3,12}};

    static int[][] S8 = {{13, 2, 8, 4, 6,15,11, 1,10, 9, 3,14, 5, 0,12, 7},
            { 1,15,13, 8,10, 3, 7, 4,12, 5, 6,11, 0,14, 9, 2},
            { 7,11, 4, 1, 9,12,14, 2, 0, 6,10,13,15, 3, 5, 8},
            { 2, 1,14, 7, 4,10, 8,13,15,12, 9, 0, 3, 5, 6,11}};


// ************************ Fonctions *************************************************//


    //Convertie un binaire vers un nombre decimal *************************
    static int BinToDec(int []bits)
    {
        int resDec=0;
        int tmp = 1;

        for(int i=bits.length-1 ; i>=0;i--)
        {
            resDec = resDec + (bits[i]*tmp);
            tmp = tmp * 2 ;
        }
        return resDec;
    }


    //Convertie un nombre en binaire *******************************************************
    static int[] DecToBinArr(int n)
    {
        int[] binaryNum = new int[4];

        int []tmp0 = new int[4];
        if(n==0)
        {
            tmp0[0]=0;
            tmp0[1]=0;
            tmp0[2]=0;
            tmp0[3]=0;

            return tmp0;
        }
        if(n==1)
        {
            tmp0[0]=0;
            tmp0[1]=0;
            tmp0[2]=0;
            tmp0[3]=1;

            return tmp0;
        }

        int i = 0;
        while (n > 0)
        {
            binaryNum[i] = n % 2;
            n = n / 2;
            i++;
        }

        if(i<2)
        {
            binaryNum[2] = 0;
            binaryNum[3] = 0;
        }

        if(i<3)
        {
            binaryNum[3]=0;
        }

        int[]tmp=new int[4];

        for (int j = i - 1, k=0; j >= 0 && k<i; j--,k++)
        {
            tmp[k]=binaryNum[j];
        }
        return tmp;
    }


    //Afficher un tableau ***************************************************
    public static void AffichageTableau(int[] arr, int len)
    {
        for(int i=0;i<len;i++)
        {
            System.out.print(arr[i]);
        }
    }


    //Fonction permutation *****************************************************************

    static int[] permutation(int i, int [] obj, int [] position)
    {
        int[] tmp = new int[i];

        for(int j = 0; j<i; j++)
        {
            tmp[j] = obj[position[j]];
        }

        return tmp;
    }

    //Fonction shift gauche ***********************************************

    static int[] shiftLeft(int i, int [] obj, int nb_shift)
    {
        int[] tmp = new int[i];
        int[] shift_1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,0};
        int[] shift_2 = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,0,1};

        if(nb_shift == 1)
        {
            for(int k=0; k<i; k++)
            {
                tmp[k] = obj[shift_1[k]];
            }

        }else if(nb_shift == 2)
        {
            for(int k=0; k<i; k++)
            {
                tmp[k] = obj[shift_2[k]];
            }
        }

        return tmp;

    }


    //Fonction qui teste si obj est compos� de 0 et 1 et le convertit en entier (integer) ***********************

    static int[] convert_test(String obj, int[]obj_res) throws Exception
    {
        char caractere;
        String obj_string;
        int taille = obj.length();

        for(int i=0;i<taille;i++)
        {
            caractere = obj.charAt(i);
            obj_string = Character.toString(caractere);
            obj_res[i] = Integer.parseInt(obj_string);

            if(obj_res[i] !=0 && obj_res[i]!=1)
            {
                System.out.println("\n Veuillez entrer une clef comportant des 1 et des 0");
                System.exit(0);
            }
        }
        return obj_res;
    }



    //Fonction OU EXCLUSIF XOR *******************************************************************

    static int[] XOR(int[] obj1, int[] obj2)
    {
        int[] xor = new int[obj1.length];

        for (int i = 0 ; i < obj1.length ; i++)
        {
            xor[i] = (int) (obj1[i] ^ obj2[i]);
        }

        return xor;
    }

    //Recuperer SBOX ******************************************************************************

    static int[][] getSBox(int i)
    {
        switch (i)
        {
            case 0: return S1;
            case 1: return S2;
            case 2: return S3;
            case 3: return S4;
            case 4: return S5;
            case 5: return S6;
            case 6: return S7;
            case 7: return S8;


            default: return null;
        }
    }

    //SBOX ***************************************************************************************
    static int[] sBox(int[] entree)
    {

        int[][] resSbox = new int[8][4];  //8 SBOX et 4 sorties pour chaque SBOX
        int[] resSbox_final = new int[32]; //sortie finale (concatenation des sorties de chaque SBOX)

        int [] part = new int[6];

        int bit1, bit2, bit3, bit4, bit5, bit6;
        int []bitLigne = new int[2];
        int []bitColonne = new int[4];
        int ligneDec, colonneDec;

        int[][] Sbox;
        int resSboxDec;

        for(int i=0; i<8;i++)
        {

            //on separe l'entree en 8 groupes de 6 bits (6 bits par SBox)
            System.arraycopy(entree, i*6, part, 0, 6); //pour i=0 il y a les 4 premiers bits pour i=1 les 4 suivants

            //Chaque S-Box a 4 entr�s et 2 sorties : la valeur trouv� (0-4) est encod�e en binaire sur 2 bits

            bit1 = part[0]; // 1er bit
            bit2 = part[1]; // 2eme bit
            bit3 = part[2]; // 3eme bit
            bit4 = part[3]; // 4eme bit
            bit5 = part[4]; // 5eme bit
            bit6 = part[5]; // 6eme bit

            bitLigne[0] = bit1;
            bitLigne[1] = bit6;

            bitColonne[0] = bit2;
            bitColonne[1] = bit3;
            bitColonne[2] = bit4;
            bitColonne[3] = bit5;

            ligneDec = BinToDec(bitLigne);    //On convertit le bit en decimal
            colonneDec = BinToDec(bitColonne);

            Sbox = getSBox(i); //On determine quel Sbox utilis� (i = 0 -> S0)

            resSboxDec = Sbox[ligneDec][colonneDec]; //On recupere la valeur de la SBOX selon la ligne et la colonne

            resSbox[i] = DecToBinArr(resSboxDec); //On convertit la valeur de la SBOX en binaire (sur 4 bits)

        }


        for (int j=0; j<8; j++ )
        {
            System.arraycopy(resSbox[j], 0, resSbox_final, j*4, 4);
        }

        return resSbox_final;

    }
}