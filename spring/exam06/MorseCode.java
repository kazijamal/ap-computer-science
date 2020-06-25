import java.util.Scanner;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class MorseCode {

    private static Map<Character, String> letterMap;
    private static Map<String, Character> morseMap;

    public static void init() {
        letterMap = new HashMap<Character, String>();
        morseMap = new HashMap<String, Character>();
        letterMap.put('A', ".-");
        letterMap.put('B', "-...");
        letterMap.put('C', "-.-.");
        letterMap.put('D', "-..");
        letterMap.put('E', ".");
        letterMap.put('F', "..-.");
        letterMap.put('G', "--.");
        letterMap.put('H', "....");
        letterMap.put('I', "..");
        letterMap.put('J', ".---");
        letterMap.put('K', "-.-");
        letterMap.put('L', ".-..");
        letterMap.put('M', "--");
        letterMap.put('N', "-.");
        letterMap.put('O', "---");
        letterMap.put('P', ".--.");
        letterMap.put('Q', "--.-");
        letterMap.put('R', ".-.");
        letterMap.put('S', "...");
        letterMap.put('T', "-");
        letterMap.put('U', "..-");
        letterMap.put('V', "...-");
        letterMap.put('W', ".--");
        letterMap.put('X', "-..-");
        letterMap.put('Y', "-.--");
        letterMap.put('Z', "--..");
        for (Object letter : letterMap.keySet()) {
            morseMap.put(letterMap.get(letter), (Character) letter);
        }
    }

    public static String toMorse(String l) {
        String m = new String();
        for (int i = 0; i < l.length(); i++) {
            char c = l.charAt(i);
            if (letterMap.containsKey(c)) {
                c = Character.toUpperCase(c);
                m += letterMap.get(c) + " ";
            }
        }
        return m;
    }

    public static String toLetters(String m) {
        String l = new String();
        String[] mArr = m.split(" ");
        for (String s : mArr) {
            if (morseMap.containsKey(s))
                l += morseMap.get(s);
        }
        return l;
    }

    public static void main(String[] args) {
        init();
        Scanner sys = new Scanner(System.in);
        String input = sys.nextLine();
        while (!(input.equals(""))) {
            String ans = new String();
            if (input.charAt(0) == '.' || input.charAt(0) == '-') 
                ans = toLetters(input);
            else
                ans = toMorse(input);
            System.out.println(ans);
            input = sys.nextLine();
        }
        sys.close();
    }

}