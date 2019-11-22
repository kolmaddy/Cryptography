/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import java.util.ArrayList;

/**
 *
 * @author kamod
 */
public class AntiCaesar {
    public static ArrayList<String> Encrypting (ArrayList<String> outputCaesar, ArrayList<CharStat> text1Stat, ArrayList<CharStat> text2Stat){
        ArrayList<String> antiCaesar = new ArrayList<>();
        // методом сортировки
        char tempChar;
        for (int i = 0; i < outputCaesar.size(); i++) { //для каждой строки
            StringBuilder tempString = new StringBuilder();
            tempString.append(outputCaesar.get(i));
            for (int j = 0; j < tempString.length(); j++) { //для каждого символа
                tempChar = tempString.charAt(j);
                for (int k = 0; k < text2Stat.size(); k++) {
                    if (tempChar == text2Stat.get(k).GetSymb()){ //если этот символ равен какому-то из text2Stat
                        if (k<text1Stat.size()) {
                            tempString.deleteCharAt(j);//то в строке заменяем символ на символ из text1Stat с тем же индексом
                            tempString.insert(j, text1Stat.get(k).GetSymb());
                            break;
                        }
                    }
                }
            }
            antiCaesar.add(tempString.toString());
            tempString.delete(0, tempString.length()); //очищаем темповую строку
        }
    
        /*// методом приближенных значений
        int checker = 0;
        for (int i = 0; i < outputCaesar.size(); i++) { //для каждой строки
            StringBuilder tempString = new StringBuilder();
            tempString.append(outputCaesar.get(i));
            for (int j = 0; j < tempString.length(); j++) { //для каждого символа
                char tempChar = tempString.charAt(j);
                double tempFreq = -1;
                for (int k = 0; k < text2Stat.size(); k++) { //просматриваем его во массиве шифрованных символов и ищем ближайшую частоту
                    if (tempChar == text2Stat.get(k).GetSymb()){ //если находим совпадение
                        tempFreq = text2Stat.get(k).GetFreq(); //записываем его частоту
                        break;
                    }
                }
                if (tempFreq != -1){ //Если нашли символьное совпадение
                    double tempFreqDiff = -1;
                    int tempFreqIndx = 0;
                    for (int k = 0; k < text1Stat.size(); k++) { //ищем наименьшую разницу частот
                        if (k==0) {
                            tempFreqDiff = Math.abs(text1Stat.get(k).GetFreq() - tempFreq);
                        } else {
                            if (tempFreqDiff > Math.abs(text1Stat.get(k).GetFreq() - tempFreq)){
                                tempFreqDiff = Math.abs(text1Stat.get(k).GetFreq() - tempFreq);
                                tempFreqIndx = k;
                            }
                        }
                    }
                    if (tempFreqDiff != -1){
                        if (checker < 30){
                            checker++;
                            //System.out.println("Максимальное совпадение для " + tempChar + " с разницей " + tempFreqDiff + " подходит " + text1Stat.get(tempFreqIndx).GetSymb() );
                        }
                        tempString.deleteCharAt(j);// в строке заменяем символ на символ из text1Stat
                        tempString.insert(j, text1Stat.get(tempFreqIndx).GetSymb());
                    }
                }
            }
            antiCaesar.add(tempString.toString());
            tempString.delete(0, tempString.length()); //очищаем темповую строку
        }*/

    return antiCaesar;
    }
}
