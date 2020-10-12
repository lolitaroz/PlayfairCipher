/*
ENCODE
    1. If the letters are on the same row, use the letters below them to replace them.
    2. If the letters are on the same column, use the letters to their right to replace them.
    3. If the letters are different, replace them with the letters on the same row, but in the column of the other letter
    4. If the letters are the same, insert an X between them.

DECODE (The key is symmetrical [used to encode/decode], but the algorithm is not!)
Be aware that encoding and decoding have opposite shifts for same column/row letters!
 1. If the letters are on the same row, use the letters ABOVE them to replace them.
 2. If the letters are on the same column, use the letters to their LEFT to replace them.
 3. Same.
4. The double letter problem means that there will be extra X's in your code. A human can deal with this.
*/

public class CipherKey{

  public static int[] findRowCol(String[][] key, String letter){
    int[] rowCol = {0, 0};
    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        if (key[i][j].equals(letter)){
          rowCol[0] = i;
          rowCol[1] = j;
        }
      }
    }
    return rowCol;
  }

  public static String[][] makeDoubleArray(String keyString){
    String[][] key = new String[5][5];
    int index = 0;
    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        key[i][j] = keyString.substring(index, index + 1);
        index++;
      }
    }
    return key;
  }

  public static String doubleLetter(String text){
    for (int i = 0; i < text.length() - 1; i += 2){
      if (text.substring(i, i+1).equals(text.substring(i+1, i+2)))
        text = text.substring(0, i+1) + "X" + text.substring(i+1);
    }
    return text;
  }

  public static String vertical(String letterPair, String[][] key, int direction){
    // direction is 1 if encode, -1 if decode
    int[] rc1 = findRowCol(key, letterPair.substring(0, 1));
    int[] rc2 = findRowCol(key, letterPair.substring(1));
    int r = rc1[0] + direction;
    if (r > 4) r = 0;
    if (r < 0) r = 4;
    String newPair = key[r][rc1[1]] + key[r][rc2[1]];
    return newPair;
  }

  public static String horizontal(String letterPair, String[][] key, int direction){
    // direction is 1 if encode, -1 if decode
    int[] rc1 = findRowCol(key, letterPair.substring(0, 1));
    int[] rc2 = findRowCol(key, letterPair.substring(1));
    int c = rc1[1] + direction;
    if (c > 4) c = 0;
    if (c < 0) c = 4;
    String newPair = key[rc1[0]][c] + key[rc1[0]][c];
    return newPair;
  }

  public static String regular(String letterPair, String[][] key){

    return "";
  }

  public static String encode(String plaintext){
    String ciphertext = doubleLetter(plaintext);
    if (ciphertext.length() % 2 != 0) ciphertext += "Z";
    for (int i = 0; i < ciphertext.length(); i += 2){

    }
    return ciphertext;
  }

  public static String decode(String ciphertext){
    String plaintext = "";
    return plaintext;
  }


  public static void main(String[] args) {
    String encode = args[0];
    String text = args[1].toUpperCase();
    String keyString = args[2].toUpperCase();
    String[][] key = makeDoubleArray(keyString);
    if (encode.equals("encode")) System.out.println(encode(text));
    else decode(text);
  }
}
