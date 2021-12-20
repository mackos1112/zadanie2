package com.mycompany.zadanie2;

import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 * @author MAciek
 */
       

public class Main {
    
   static void pokazMenu(){ 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Witaj");
        System.out.println("");
        System.out.println("Wybierz Opcje:");
        System.out.println("");
        System.out.println("1- losowanie z powtórzeniami");
        System.out.println("2- losowanie bez powtórzeń");
        System.out.println("3- Loteria!");
        System.out.println("4- Symulacja Loterii");
        System.out.println("5- Koniec programu");
        
        int ktoraOpcja;
        ktoraOpcja = parseInt(scanner.nextLine());
        /*
        
        LosujZPowtorzeniami losowanieZPowtorzeniami = new LosujZPowtorzeniami();
        LosujBezPowtorzen losowanieBezPowtorzen = new LosujBezPowtorzen();
        int[] tabelaZPowtorzeniami = losowanieZPowtorzeniami.losujZPowtorzeniami();
        System.out.println("");
        System.out.println("");
        int[] tabelaBezPowtorzen = losowanieBezPowtorzen.losujBezPowtorzen();
        */
        
        switch(ktoraOpcja){
        
            case 1:{ //losu z powtorzeniami
                LosujZPowtorzeniami losowanieZPowtorzeniami = new LosujZPowtorzeniami();
                int[] tabelaZPowtorzeniami = losowanieZPowtorzeniami.losujZPowtorzeniami();
                pokazMenu();
                break;
            }
            case 2:{//losu bez powtotzen
                LosujBezPowtorzen losowanieBezPowtorzen = new LosujBezPowtorzen();
                losowanieBezPowtorzen.ustawZakres();
                if(losowanieBezPowtorzen.sprawdzZakres()){
                int[] tabelaBezPowtorzen = losowanieBezPowtorzen.losujBezPowtorzen();
                }else{
                    System.out.println("To nie ma prawa działać spróbuj ponownie.");
                    pokazMenu();
                }
                pokazMenu();
                break;
            }
            case 3:{ // LOTERYJA
                Loteria loteria = new Loteria();
                loteria.ustawieniaLoteri();
                loteria.sprawdzanieWygranej();
                pokazMenu();
                break;
            }
            
            case 4:{ //SYMULACJA LOTERII
                Loteria loteria =  new Loteria();
                loteria.ustawieniaLoteri();
                loteria.symulator();
                pokazMenu();
                break;
            }
            
            case 5:{ //koniec programu
                System.exit(0);
            }
            default:{
                System.out.println("To nie jest liczba związana z programem.");
                pokazMenu();
            }
    }
    }
   


    
    public static void main(String[] args) {
       new Main().pokazMenu();
    }
   
}