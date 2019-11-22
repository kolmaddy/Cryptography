package crypto;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kamod
 */
public class Reader {
    public static ArrayList<String> Reader (String input) throws Exception{
        System.out.println("\n-----------------------------------------------------------\n//Reading " + input);
        ArrayList<String> output = new ArrayList<>();
        FileReader fr = new FileReader (input);
        Scanner scan = new Scanner(fr);
        
        while (scan.hasNextLine()) {
            output.add(scan.nextLine());
        }        
        fr.close();
    return output;
    }
}
