import javax.swing.*;
import java.awt.*;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public String alfabet = "abcdefghijklmnopqrstuvwxyz";
    public static String szyfrCezara(String jawny, int klucz){
        String zakodowane = "";
        int temp = 0;
        int temp2 = 0;
        for (int i = 0; i < jawny.length(); i++) {
            if((int)jawny.charAt(i)+klucz>122){
                temp = ((int)jawny.charAt(i)+(klucz-26));
            } else if ((int)jawny.charAt(i)+klucz<97) {
                temp = ((int)jawny.charAt(i)+((klucz+26)));
            } else{
                temp= (int)jawny.charAt(i)+klucz;
            }
            zakodowane+=(char)temp;
        }

        return zakodowane;
    }
    public static void main(String[] args) {
        System.out.println(szyfrCezara("xyz",3));
    }
}