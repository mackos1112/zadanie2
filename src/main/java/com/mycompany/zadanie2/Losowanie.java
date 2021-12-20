package com.mycompany.zadanie2;

import static java.lang.Integer.parseInt;
import java.util.Scanner;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;

/**
 *
 * @author MAciek
 */
public class Losowanie {
    
   private int max;
   private int min;
   private int ile;
   Scanner scanner = new Scanner(System.in);
   
   public int getIle(){
       return ile;
   }
   public int getMin(){
       return min;
   }
   public int getMax(){
       return max;
   }
   
   boolean flagaLiczba(String str){
        return str != null && str.matches("[0-9]+");
    }
    int wprowadzanieLiczb(){
        int liczba = 0;
        
        int i = 0;
        while(i<=0){
            String wprowadzone =scanner.nextLine();
            if(this.flagaLiczba(wprowadzone)){
                liczba = parseInt(wprowadzone);
                i++;
            }else{
                System.out.println("To nie liczba, prosze podać liczbę.");
            }
        }
        return liczba;
    }


     Losowanie(){}
     public void ustawZakres(){
            

            System.out.println("Prosze podaj ilość liczb które zostaną wylosowane:");
            this.ile = this.wprowadzanieLiczb();
        
            System.out.println("Świetnie teraz podaj początek zakresu maszyny losującej:");
            this.min = this.wprowadzanieLiczb();
        
            System.out.println("A teraz koniec zakresu:");
            this.max = this.wprowadzanieLiczb();
        
            if(this.max<=this.min){
                System.out.println("Podałeś nie właściwe wartości. Maszyna zamienia ich wartość w celu prawidłowego działania programu.");
                int tmp =this.max;
                this.max=this.min;
                this.min=tmp;
            }
        
     }
     
     
     public boolean sprawdzZakres(){
         if(this.getMax()+1-this.getMin()<this.getIle())
            return false;
         else
             return true;
     }
}
@SupportedSourceVersion(SourceVersion.RELEASE_8)
class LosujZPowtorzeniami extends Losowanie{
    
        
            int[] losujZPowtorzeniami(){
                
                this.ustawZakres();
                
                int losoweLiczby[] = new int[this.getIle()];
                int i=0;
                while(i<this.getIle()){
                     int liczbaLosowa = (int)Math.round(Math.random()*(this.getMax()-this.getMin())+this.getMin());

                    losoweLiczby[i]= liczbaLosowa;
                    if(i==0){
                         System.out.print("Oto wylosowane liczby : " + losoweLiczby[i]);
                    }else{
                        System.out.print(" "+losoweLiczby[i]);
                    }
                    
                        i++;
                            
                }
                
                return losoweLiczby;
            }
}

class LosujBezPowtorzen extends Losowanie{
     int[] losujBezPowtorzen(){
         
         //this.ustawZakres();       
                
                int losoweLiczby[] = new int[this.getIle()];
                    int i=0;
                    int l = 0;

                    while(i<this.getIle()){
                        int liczbaLosowa = (int)Math.round(Math.random()*(this.getMax()-this.getMin())+this.getMin());

                        losoweLiczby[i]= liczbaLosowa;
                         for(int j=0;j<i;j++){
                            if(losoweLiczby[i]==losoweLiczby[j]){
                                i--;
                            }
                        }
                        
                        i++;
                    }
                    while(l<this.getIle()){
                        
                        if(l==0){
                            System.out.print("Oto liczby : " + losoweLiczby[l]);
                        }else{
                            System.out.print(" "+losoweLiczby[l]);
                    }

                        l++;
                    }
                    System.out.println("");
                return losoweLiczby;
            }

}