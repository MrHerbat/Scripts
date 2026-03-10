//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Random;
import java.util.Scanner;

public class Konsolowa {
    public static int[][] losowanieLiczb(int liczbaLosowan){
        Random rand = new Random();
        int[] temp = new int[6];
        int[][] tab = new int[liczbaLosowan][6];
        for (int i = 0; i < liczbaLosowan; i++) {
            for (int j = 0; j < 6; j++) {
                tab[i][j] = rand.nextInt(1, 50);
                temp[j] = tab[i][j];
            }
        }
        for (int i = 0; i < liczbaLosowan; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    while(temp[k]==tab[i][j]){
                        tab[i][j] = rand.nextInt(1, 50);
                    }
                }
            }
        }
        return tab;
    }
    public static void wypiszLosowanie(int[][] tab){
        for (int i = 0; i < tab.length; i++) {
            System.out.print("Losowanie "+(i+1)+": ");
            for (int j = 0; j < tab[0].length; j++) {
                System.out.print(tab[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void zliczWystapienia(int[][] tab){
        int[] zliczone = new int[49];
        for (int i = 0; i < zliczone.length; i++) {
            zliczone[i]=0;
        }
        int temp = 0;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                temp = tab[i][j];
                zliczone[temp - 1]++;
            }
        }
        for (int i = 0; i < 49; i++) {
            System.out.println("Wystąpienie liczby "+(i+1)+": "+zliczone[i]);
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Ile wygenerować losowań?");
        int liczbaLosowan = s.nextInt();
        int[][] losowania = losowanieLiczb(liczbaLosowan);
        wypiszLosowanie(losowania);
        zliczWystapienia(losowania);
    }

}