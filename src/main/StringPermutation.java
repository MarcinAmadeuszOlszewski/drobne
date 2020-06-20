import java.util.Set;
import java.util.TreeSet;

class StringPermutation {

  private Set<String> out = new TreeSet<>();

  public static void main(String[] args) {
    StringPermutation stringPermutation = new StringPermutation();
    stringPermutation.start();
  }

  private void start() {
    String a = "ABC";
    permute(a, 0);
    System.out.println(out.size());
    System.out.println(out);

    out.clear();

    a = "ABCD";
    permute(a, 0);
    System.out.println(out.size());
    System.out.println(out);

    out.clear();

    a = "ABCDE";
    permute(a, 0);
    System.out.println(out.size());
    System.out.println(out);
  }

  private void permute(String word, int start) {
    if (start + 1 == word.length()) {
      out.add(word);
    } else {
      for (int i = start; i < word.length(); i++) {
        String wordSwapped = swap(word, start, i);
        permute(wordSwapped, start + 1);
      }
    }
  }

  private String swap(String word, int startPos, int currentPos) {
    StringBuilder sb = new StringBuilder(word);
    char charAtStart = word.charAt(startPos);
    char charAtCurrent = word.charAt(currentPos);
    sb.setCharAt(startPos, charAtCurrent);
    sb.setCharAt(currentPos, charAtStart);
    return sb.toString();
  }
}