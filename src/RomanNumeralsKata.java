import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

public class RomanNumeralsKata {

  @Test
  public void shouldConvertSimpleNumbers() {
    assertThat(arabicToRoman(1), is("I"));
    assertThat(arabicToRoman(2), is("II"));
    assertThat(arabicToRoman(5), is("V"));
  }

  private String arabicToRoman(Integer number) {
    StringBuilder result = new StringBuilder();
    Map<Integer, String> numberToNumeral = new HashMap<>();
    numberToNumeral.put(5, "V");

    for (; number > 0;) {
      if (numberToNumeral.containsKey(number)) {
        result.append(numberToNumeral.get(number));
        number -= number;
      } else {
        result.append("I");
        number -= 1;
      }
    }
    return result.toString();
  }
}
