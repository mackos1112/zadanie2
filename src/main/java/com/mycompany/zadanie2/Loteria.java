package com.mycompany.zadanie2;

import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 * @author MAciek
 */
public class Loteria {
    LosujBezPowtorzen losu = new LosujBezPowtorzen();
    Scanner scanner = new Scanner(System.in);
    int liczbyDoSkreslenia;
    
    
    
    Loteria(){
        System.out.println("Witaj w LOTERI!");
        
    }
    
    void ustawieniaLoteri(){
        
        losu.ustawZakres();
        
        if(losu.sprawdzZakres()){
            System.out.println("Świetnie! Mamy przedział liczbowy losowania!");
            this.liczbyDoSkreslenia = losu.getIle();
            
        }
    }
    
    int[] wybierzLiczby(){
        
        System.out.println("Teraz po kolei podawaj liczby. Każdą oddzielaj przyciskiem ENTER");
        int[] liczby = new int[this.liczbyDoSkreslenia];
        int i = 0;
        while( i < this.liczbyDoSkreslenia){
            liczby[i]= losu.wprowadzanieLiczb();
            if(liczby[i] < losu.getMin() || liczby[i] > losu.getMax()){
                System.out.println("Niestety twoja liczba nie jest w zakresie. Podaj inną");
                liczby[i]= losu.wprowadzanieLiczb();
            }
            if(i>0){
                for(int j = 0; j < i; j++){
                    if(liczby[j]==liczby[i]){
                        System.out.println("Podałeś już wcześniej podaną liczbę. Podaj inną");
                        i--;
                    }
                } 
                
            }
            if(i == this.liczbyDoSkreslenia-1)
                break;
            System.out.println("Podaj następną liczbę");
            i++;
        }
        return liczby;
    }
    
    
    int sprawdzanieWygranej(){
        int iloscPowtorek = 0;
        int[] testowane = this.wybierzLiczby();
        int[] wylosowane = losu.losujBezPowtorzen();
        for(int i = 0; i < this.liczbyDoSkreslenia; i++){
            if(i==0)
                System.out.print("Twoje wybrane liczby to: " + testowane[i]);
            else
                System.out.print(" "+testowane[i]);
            
        }
        
        System.out.println("");
        
        for(int i = 0; i < this.liczbyDoSkreslenia;i++){
            for(int j = 0; j < this.liczbyDoSkreslenia ; j++){
                if(testowane[j] == wylosowane[i]){
                    iloscPowtorek++;
                    if(iloscPowtorek==1)
                        System.out.print("Trafione to : "+wylosowane[i]);
                    else{
                        System.out.print(" "+wylosowane[i]);
                    }
                    
                }
            }
          
        }  System.out.println("");
        
        
            
        System.out.println("Ilość liczb które się powtórzyły to :"+iloscPowtorek);
        return iloscPowtorek;
    }
   
    
    
     void symulator(){
        int[] testowane = this.wybierzLiczby();
        int iloscProb = 0;
        for(int koniecSymulacji = 0; koniecSymulacji < 1; iloscProb++ ){
            int iloscPowtorek = 0;
            int[] wylosowane = losu.losujBezPowtorzen();
            
            for(int i = 0; i < this.liczbyDoSkreslenia;i++){
                for(int j = 0; j < this.liczbyDoSkreslenia ; j++){
                    if(testowane[j] == wylosowane[i]){
                        iloscPowtorek++;
                    }
                    if(iloscPowtorek == this.liczbyDoSkreslenia)
                        koniecSymulacji++;
                }
            }
        }
         System.out.println("Ilość symulacji do uzyskania pełnego sukcesu w lotrii to: " + iloscProb);
    }
}