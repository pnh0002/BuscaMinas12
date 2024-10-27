package Wrapper;

import java.util.Scanner;

public class Buscaminas {
    public static void generarMinas(String[][] minas){
        int filaAlea;
        int columnAlea;
        int contador = 10;

        for(int i=0; i<minas.length; i++){
            for(int j=0; j<minas[i].length; j++){
                minas[i][j] = "| @ |";
            }
        }

        while(contador!=0){
            filaAlea = (int)(Math.random()*5);
            columnAlea = (int)(Math.random()*5);

            if(minas[filaAlea][columnAlea].equals("| -1|")){

            }else {
                minas[filaAlea][columnAlea] = "| -1|";
                contador--;
            }
        }
    /*
        for(int i=0; i<minas.length; i++){
            for(int j=0; j<minas[i].length; j++){
                System.out.print(minas[i][j]);
            }
            System.out.println();
        }

     */
        System.out.println("****************************");
        asignarNum(minas);
    }

    public static void asignarNum(String[][] minas){
        for(int i=0; i<minas.length; i++){
            for(int j=0; j<minas[i].length; j++) {
                if (minas[i][j].equals("| -1|")){
                    if (i >= 1 && i < minas.length - 1 && j >= 1 && j < minas[i].length - 1) {
                        minas[i - 1][j] = "| 1 |";
                        minas[i][j - 1] = "| 1 |";
                        minas[i - 1][j - 1] = "| 1 |";

                    }

                }
            }
        }
        for(int i=0; i<minas.length; i++){
            for(int j=0; j<minas[i].length; j++){
                if(!(minas[i][j].equals("| -1|"))&&!(minas[i][j].equals("| 1 |"))){
                    minas[i][j] = "| 0 |";
                }
            }
        }
        /*
        System.out.println("******************************");
        for(int i=0; i<minas.length; i++){
            for(int j=0; j<minas[i].length; j++){
                System.out.print(minas[i][j]);
            }
            System.out.println();
        }
        */
        System.out.println("Se asignaron los valores");

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] minas = new String [5][5];
        String[][] tablero = new String[5][5];
        int fila = 0;
        int columna = 0;

        generarMinas(minas);
        generarTablero(tablero);

        do{
            System.out.println("****************************");
            for(int i=0; i<minas.length; i++){
                for(int j=0; j<minas[i].length; j++){
                    System.out.print(minas[i][j]);
                }
                System.out.println();
            }
            System.out.println("****************************");
            System.out.println("Dime una fila: ");
            fila = sc.nextInt();
            System.out.println("Dime una columna: ");
            columna = sc.nextInt();

            if(minas[fila][columna].equals("| -1|")){
                pierde(minas);
            }else if(!(minas[fila][columna].equals("| -1|"))){
                tablero[fila][columna] = minas[fila][columna];
            }
            for(int i=0; i<tablero.length; i++){
                for(int j=0; j<tablero[i].length; j++){
                    System.out.print(tablero[i][j]);
                }
                System.out.println();
            }

        }while(true);


    }
    public static void generarTablero(String[][] tablero){
        for(int i=0; i<tablero.length; i++){
            for(int j=0; j<tablero[i].length; j++){
                tablero[i][j] = "| @ |";
            }
        }

        for(int i=0; i<tablero.length; i++){
            for(int j=0; j<tablero[i].length; j++){
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
    }

    public static void pierde(String[][] minas){
        System.out.println("Usted ha perdido!");
        for(int i=0; i<minas.length; i++){
            for(int j=0; j<minas[i].length; j++){
                System.out.print(minas[i][j]);
            }
            System.out.println();
        }
        System.exit(0);
    }
}
