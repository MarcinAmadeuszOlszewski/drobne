import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StringPermutationTest {

  static Stream<Arguments> cases() {
    return Stream.of(
        Arguments.arguments("", 0, new TreeSet<>()),
        Arguments.arguments("A", 1, new TreeSet<>(Collections.singletonList("A"))),
        Arguments.arguments("ABC", 6, new TreeSet<>(Arrays.asList("ABC", "ACB", "BAC", "BCA", "CAB", "CBA"))),
        Arguments.arguments("ABCD", 24, new TreeSet<>(Arrays
            .asList("ABCD", "ABDC", "ACBD", "ACDB", "ADBC", "ADCB", "BACD", "BADC", "BCAD", "BCDA", "BDAC", "BDCA",
                "CABD", "CADB", "CBAD", "CBDA", "CDAB", "CDBA", "DABC", "DACB", "DBAC", "DBCA", "DCAB", "DCBA"))),
        Arguments.arguments("ABCDE", 120, new TreeSet<>(Arrays
            .asList("ABCDE", "ABCED", "ABDCE", "ABDEC", "ABECD", "ABEDC", "ACBDE", "ACBED", "ACDBE", "ACDEB", "ACEBD",
                "ACEDB", "ADBCE", "ADBEC", "ADCBE", "ADCEB", "ADEBC", "ADECB", "AEBCD", "AEBDC", "AECBD", "AECDB",
                "AEDBC", "AEDCB", "BACDE", "BACED", "BADCE", "BADEC", "BAECD", "BAEDC", "BCADE", "BCAED", "BCDAE",
                "BCDEA", "BCEAD", "BCEDA", "BDACE", "BDAEC", "BDCAE", "BDCEA", "BDEAC", "BDECA", "BEACD", "BEADC",
                "BECAD", "BECDA", "BEDAC", "BEDCA", "CABDE", "CABED", "CADBE", "CADEB", "CAEBD", "CAEDB", "CBADE",
                "CBAED", "CBDAE", "CBDEA", "CBEAD", "CBEDA", "CDABE", "CDAEB", "CDBAE", "CDBEA", "CDEAB", "CDEBA",
                "CEABD", "CEADB", "CEBAD", "CEBDA", "CEDAB", "CEDBA", "DABCE", "DABEC", "DACBE", "DACEB", "DAEBC",
                "DAECB", "DBACE", "DBAEC", "DBCAE", "DBCEA", "DBEAC", "DBECA", "DCABE", "DCAEB", "DCBAE", "DCBEA",
                "DCEAB", "DCEBA", "DEABC", "DEACB", "DEBAC", "DEBCA", "DECAB", "DECBA", "EABCD", "EABDC", "EACBD",
                "EACDB", "EADBC", "EADCB", "EBACD", "EBADC", "EBCAD", "EBCDA", "EBDAC", "EBDCA", "ECABD", "ECADB",
                "ECBAD", "ECBDA", "ECDAB", "ECDBA", "EDABC", "EDACB", "EDBAC", "EDBCA", "EDCAB", "EDCBA")))
    );
  }

  @ParameterizedTest(name = "From {0} -> size {1}")
  @MethodSource("cases")
  void permute(String word, int size, Set<String> out) {
    Set<String> result = StringPermutation.permute(word);
    assertEquals(size, result.size());
    assertEquals(out, result);
  }

  @Test
  void permute_null() {
    assertThrows(NullPointerException.class, () -> StringPermutation.permute(null));
  }
}