package crypto;

import static crypto.AntiCaesar.Encrypting;
import static crypto.Caesar.Caesar;
import static crypto.CharStat.FreqAnalys;
import static crypto.Reader.Reader;
import java.util.ArrayList;


/**
 *
 * @author kamod
 */
public class Crypto {

    public static void main(String[] args) throws Exception {
        String fileName1 = "BookMain.txt"; // Война и мир
        String fileName2 = "BookExcerpt.txt"; // Часть войны и мир
        int key = 5;                 // ключ для шифра цезаря
        int strView = 10;           // по сколько строчек выводить
        int strViewFreq = 20;      // по сколько строчек частоты выводить
        
        //считываем файл в массив
        ArrayList<String> input1 = Reader(fileName1);
        for (int i = 0; (i < input1.size()) & (i < strView); i++){
            System.out.println(input1.get(i));
        }
        
        //считываем файл отрывка в массив
        ArrayList<String> input2 = Reader(fileName2);
        for (int i = 0; (i < input2.size()) & (i < strView); i++){
            System.out.println(input2.get(i));
        }
        
        //шифруем отрывок цезарем, второй параметр - ключ
        ArrayList<String> outputCaesar = Caesar(input2, key);
        for (int i = 0; (i < outputCaesar.size()) & (i < strView); i++){
            System.out.println(outputCaesar.get(i));
        }   
        
        // частотный анализ
        ArrayList<CharStat> text1Stat = FreqAnalys(input1);
        for (int i = 0; (i < text1Stat.size())& (i < strViewFreq); i++){
            text1Stat.get(i).info();
        }
        
        ArrayList<CharStat> text2Stat = FreqAnalys(outputCaesar);
        for (int i = 0; (i < text2Stat.size())& (i < strViewFreq); i++){
            text2Stat.get(i).info();
        }
        
        //дешифровка частотным анализом
        ArrayList<String> antiCaesar = Encrypting(outputCaesar,text1Stat,text2Stat);        
        
        System.out.println("---------------------------------\nИсходный текст");
        for (int i = 0; (i < input2.size()) & (i < strView); i++){ //исходный
            System.out.println(input2.get(i));
        }
        System.out.println("---------------------------------\nЗашифрованый текст с ключем = " + key);
        for (int i = 0; (i < outputCaesar.size()) & (i < strView); i++){ //зашифрованый
            System.out.println(outputCaesar.get(i));
        }
        System.out.println("---------------------------------\nДешифрованый текст");
        for (int i = 0; (i < antiCaesar.size()) & (i < strView); i++) { //дешифрованый
            System.out.println(antiCaesar.get(i));
        }

    }
    
}
