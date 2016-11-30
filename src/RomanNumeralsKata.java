import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

public class RomanNumeralsKata {

  @Test
  public void shouldConvertSimpleNumbers() {
    assertThat(arabicToRoman(1), is("I"));
    assertThat(arabicToRoman(5), is("V"));
    assertThat(arabicToRoman(10), is("X"));
  }

  @Test
  public void shouldAddNumerals() {
    assertThat(arabicToRoman(2), is("II"));
  }

  private String arabicToRoman(Integer number) {
    StringBuilder result = new StringBuilder();
    Map<Integer, String> numberToNumeral = new HashMap<>();
    numberToNumeral.put(1, "I");
    numberToNumeral.put(5, "V");
    numberToNumeral.put(10, "X");

    ArrayList<Integer> numbers = new ArrayList<>(numberToNumeral.keySet());
    Collections.sort(numbers);
    Collections.reverse(numbers);

    for (Integer numberCategory : numbers) {
      for (; number >= numberCategory;) {
        result.append(numberToNumeral.get(numberCategory));
        number -= numberCategory;
      }
    }
    return result.toString();
  }
}
