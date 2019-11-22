package crypto;

import java.util.ArrayList;

/**
 *
 * @author kamod
 */
public class Caesar {
    public static ArrayList<String> Caesar (ArrayList<String> input, int key) {
        System.out.println("\n-----------------------------------------------------------\n//Caesar encryption, key = " + key);
        ArrayList<String> output = new ArrayList<>();  //массив на выход
        int tempInt;
        char tempChar;
        StringBuilder tempString = new StringBuilder();
        for (int i = 0; i < input.size(); i++){ //для каждой строки инпут массива
            for (int j = 0; j < input.get(i).length(); j++){ //для каждого символа
                tempInt = input.get(i).charAt(j);
                tempChar = (char) (tempInt+key); //смещаем код символа на величину ключа
                if (input.get(i).charAt(j)==' '){
                    tempString.append(' '); //если это пробел, то суем пробел в темповую строку
                }
                else{
                    tempString.append(tempChar); //если не пробел, то суем полученный символ в темповую строку
                }                
            }
        output.add(tempString.toString()); //добавляем строку в оутпутовый массив
        tempString.delete(0, tempString.length()); //очищаем строку
        }
    return output;
    }
}
