package crypto;

import java.util.ArrayList;

/**
 *
 * @author kamod
 */
public class CharStat { //создаем класс с символом и его количеством в тексте и его частотой
    char symb;
    int combo;
    double freq;
    
    public CharStat (char symb, int combo){
        this.symb = symb;
        this.combo = combo;
    }
    
    public CharStat(){
    }    
    //конструктор
    
    public char GetSymb () {
        return symb;
    }    
    public void SetSymb (char symb) {
        this.symb = symb;
    }
    
    public int GetCombo () {
        return combo;
    }
    public void SetCombo (int combo) {
        this.combo = combo;
    }
    
    public double GetFreq () {
        return freq;
    }
    public void SetFreq (double freq) {
        this.freq = freq;
    }
    
    public void addCombo () {
        this.combo++;
    }
    public void info () {
        System.out.println(this.symb + " - " + this.combo + "; Частота = " + Math.round((this.freq)*100.0)/100.0 + "%");
    }
        
    public static ArrayList<CharStat> FreqAnalys (ArrayList<String> input){
        System.out.println("\n-----------------------------------------------------------\n//Frequency analysis");
        ArrayList<CharStat> mainStat = new ArrayList<>(); //массив для анализируемых символов
        mainStat.add(new CharStat('а',0)); //инициализируем массив
        boolean contains = false;
        
        for (int i = 0; i < input.size(); i++){ //для каждой строки инпут массива
            for (int j = 0; j < input.get(i).length(); j++){ //для каждого символа
                char tempChar = Character.toLowerCase(input.get(i).charAt(j)); //приводим в строчную букву
                for (int k = 0; k < mainStat.size(); k++) {
                    if (mainStat.get(k).GetSymb()==tempChar){
                        mainStat.get(k).addCombo();
                        contains = true;
                        break;
                    }
                }
                if (!contains & (tempChar != ' ')){
                    mainStat.add(new CharStat(tempChar,1));
                }
                contains = false;
            }
        }
        
        int numSymb = 0; //считаем количество символов
        for (int i = 0; i < mainStat.size(); i++){
            numSymb+=mainStat.get(i).GetCombo();
        }
        System.out.println("Всего символов = " + numSymb);
        
        //считаем каждому символу частоту
        for (int i = 0; i < mainStat.size(); i++){
            double freqStat = (Double.valueOf(mainStat.get(i).GetCombo()) / Double.valueOf(numSymb) * 100);
            mainStat.get(i).SetFreq(freqStat);
        }
        
        //сортируем по частоте
        boolean isNice = false;
        CharStat tempChar;
        while (isNice == false){
            isNice = true;
            for (int i = 1; i < mainStat.size(); i++) {                
                if (mainStat.get(i).GetFreq() > mainStat.get(i-1).GetFreq()){
                    tempChar = mainStat.get(i);
                    mainStat.remove(i);
                    mainStat.add(i-1, tempChar);
                    i = 1;
                    isNice = false;
                }
            }  
        }

        return mainStat;
    }
    
}
