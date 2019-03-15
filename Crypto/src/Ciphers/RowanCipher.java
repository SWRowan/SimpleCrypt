import static java.lang.Character.isUpperCase;

public class RowanCipher extends ROT13 {

    public RowanCipher(){
        super('s', 'v');
    }

    @Override
    public String crypt(String text, int rot) throws UnsupportedOperationException {
        char[] arr = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (Character c : arr) {
            if (!Character.isLetter(c)) {
                sb.append(c);
            } else if (isUpperCase(c)) {
                sb.append(getLowerCaseChar(rot, Character.toLowerCase(c)));
            } else {
                sb.append(getUpperCaseChar(rot, Character.toUpperCase(c)));
            }
        }

        return sb.toString();
    }
}
