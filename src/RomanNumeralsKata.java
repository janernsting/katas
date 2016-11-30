import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    assertThat(arabicToRoman(23), is("XXIII"));
  }
  
  @Test
  public void shouldHandleSubtractiveRomanNumerals() {
    assertThat(arabicToRoman(4), is("IV"));
    assertThat(arabicToRoman(9), is("IX"));
    assertThat(arabicToRoman(40), is("XL"));
  }

  private String arabicToRoman(Integer number) {
    Map<Integer, String> numberToNumeral = setupLookup();
    List<Integer> numberCategories = setupDescendingNumberCategories(numberToNumeral.keySet());
    Map<Integer, Integer> subtractivePairs = subtractivePairs();
    
    StringBuilder result = new StringBuilder();
    for (Integer numberCategory : numberCategories) {
      if (subtractivePairs.containsKey(numberCategory)) {
        Integer subtractor = subtractivePairs.get(numberCategory);
        if (number == numberCategory - subtractor) {
          result.append(numberToNumeral.get(subtractor));
          number += subtractor;
        }
      }
      while (number >= numberCategory) {
        result.append(numberToNumeral.get(numberCategory));
        number -= numberCategory;
      }
    }
    return result.toString();
  }

  private Map<Integer, String> setupLookup() {
    Map<Integer, String> numberToNumeral = new HashMap<>();
    numberToNumeral.put(1, "I");
    numberToNumeral.put(5, "V");
    numberToNumeral.put(10, "X");
    numberToNumeral.put(50, "L");
    return numberToNumeral;
  }

  private List<Integer> setupDescendingNumberCategories(Set<Integer> numberSet) {
    List<Integer> numberCategories = new ArrayList<>(numberSet);
    Collections.sort(numberCategories);
    Collections.reverse(numberCategories);
    return numberCategories;
  }
  
  private Map<Integer, Integer> subtractivePairs() {
    HashMap<Integer, Integer> pairs = new HashMap<>();
    pairs.put(5, 1);
    pairs.put(10, 1);
    pairs.put(50, 10);
    return pairs;
  }
}
