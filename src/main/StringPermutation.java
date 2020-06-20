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

  }

  private void permute(String word, int start) {
    for (int i = start; i < word.length(); i++) {
      word = swap(word, start, i);
      permute(word, start + 1);
      word = swap(word, i, start);
      if (start + 1 == word.length())
        out.add(word);
    }
  }

  private String swap(String word, int startPos, int currentPos) {
    StringBuilder s = new StringBuilder(word);
    char charAtStart = word.charAt(startPos);
    char charAtCurrent = word.charAt(currentPos);
    s.setCharAt(startPos, charAtCurrent);
    s.setCharAt(currentPos, charAtStart);
    return s.toString();
  }
}