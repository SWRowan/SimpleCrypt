import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13 {
    private String abc = "abcdefghijklmnopqrstuvwxyz";
    private int rot;


    public ROT13(Character cs, Character cf) {
        rot = (int) cf - (int) cs;
    }

    public ROT13() {
        rot = 13;

    }

    protected int getRot() {
        if(rot < 0){
            return rot+(rot*2);
        }
        return rot;
    }


    protected String crypt(String text, int rot) throws UnsupportedOperationException {
        char[] arr = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (Character c : arr) {
            if (!Character.isLetter(c)) {
                sb.append(c);
            } else if (isUpperCase(c)) {
                sb.append(getUpperCaseChar(rot, c));
            } else {
                sb.append(getLowerCaseChar(rot, c));
            }
        }

        return sb.toString();
    }

    protected char getLowerCaseChar(int rot, Character c) {
        return (char) ((c + rot - 97) % 26 + 97);
    }

    protected char getUpperCaseChar(int rot, Character c) {
        return (char) ((c + rot - 65) % 26 + 65);
    }

    protected String encrypt(String text, int rot) {
        return crypt(text, rot);
    }

    protected String decrypt(String text, int rot) {

        return crypt(text, 26 - rot);
    }

    protected static String rotate(String str, Character c) {
        int charIndex = str.indexOf(c);
        String answer = str.substring(charIndex) + str.substring(0, charIndex);
        return answer;
    }


    public static void main(String[] args) {
//        Character a = 32;
//        Character b = 122;
//        System.out.println(b);

        //System.out.println((int)s.toCharArray()[1]);

        //System.out.println(110-97);
//        ROT13 cipher = new ROT13('s', 'z');
//        int rot = cipher.getRot();
//        String x = cipher.encrypt("Hello darkness my Old Friend", rot);
//        System.out.println(x);
//        System.out.println(cipher.decrypt(x, rot));
//
//        ROT13 cesar = new CesarCipher();
//        int y = cesar.getRot();
//        String str = cesar.encrypt( "We attack at dawn", y);
//        System.out.println(str);
//        System.out.println(cesar.decrypt(str,y));

        ROT13 myCipher = new RowanCipher();
        int rot = myCipher.getRot();
//        int test = (int)'=';
//        System.out.println(test);
//        System.out.println();
        String str = myCipher.encrypt("Here we go again YEAHHH", rot);
        System.out.println(str);
        System.out.println(myCipher.decrypt(str, rot));

    }
}

