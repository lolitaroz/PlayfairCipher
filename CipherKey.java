public class CipherKey{


  public static void main(String[] args) {
    String cipher = args[0];
    String keyString = args[1];
    String[][] key = new String[5][5];
    int index = 0;
    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        key[i][j] = keyString.substring(index, index + 1);
        index++;
        System.out.println(key[i][j]);
      }
    }

  }
}
