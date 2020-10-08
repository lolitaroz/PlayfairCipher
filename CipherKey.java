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

  public static void main(String[] args) {
    String cipher = args[0];
    String keyString = args[1];
    if (keyString.length() % 2 != 0) keyString += "Z";
    String[][] key = new String[5][5];
    int index = 0;
    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        key[i][j] = keyString.substring(index, index + 1);
        index++;
      }
    }

  }
}
