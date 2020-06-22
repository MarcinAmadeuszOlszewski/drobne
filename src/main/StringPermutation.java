import com.sun.istack.internal.NotNull;
import java.util.Set;
import java.util.TreeSet;

class StringPermutation {

  public static Set<String> permute(@NotNull String word) {
    if (word == null)
      throw new NullPointerException("word must be != null");

    Set<String> out = new TreeSet<>();
    permute(word, 0, out);
    return out;
  }

  private static void permute(String word, int start, Set<String> out) {
    if (start + 1 == word.length()) {
      out.add(word);
    } else {
      for (int i = start; i < word.length(); i++) {
        String wordSwapped = swap(word, start, i);
        permute(wordSwapped, start + 1, out);
      }
    }
  }

  private static String swap(String word, int startPos, int currentPos) {
    StringBuilder sb = new StringBuilder(word);
    char charAtStart = word.charAt(startPos);
    char charAtCurrent = word.charAt(currentPos);
    sb.setCharAt(startPos, charAtCurrent);
    sb.setCharAt(currentPos, charAtStart);
    return sb.toString();
  }
}