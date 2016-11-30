import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class NumberToRomanNumeralConverter {
  
  private Map<Integer, Integer> subtractivePairs = new HashMap<>();
  private List<Integer> numberCategories = new ArrayList<>();
  private Map<Integer, String> numberToNumeral = new HashMap<>();

  public NumberToRomanNumeralConverter() {
    setupLookup();
    setupDescendingNumberCategories(numberToNumeral.keySet());
    setupSubtractivePairs();
  }
  
  private void setupLookup() {
    numberToNumeral.put(1, "I");
    numberToNumeral.put(5, "V");
    numberToNumeral.put(10, "X");
    numberToNumeral.put(50, "L");
  }
  
  private void setupDescendingNumberCategories(Set<Integer> numberSet) {
    numberCategories.addAll(numberSet);
    Collections.sort(numberCategories);
    Collections.reverse(numberCategories);
  }
  
  private void setupSubtractivePairs() {
    subtractivePairs.put(5, 1);
    subtractivePairs.put(10, 1);
    subtractivePairs.put(50, 10);
  }

  public String arabicToRoman(Integer number) {
    StringBuilder result = new StringBuilder();
    for (Integer numberCategory : numberCategories) {
      if (mayRequireSubtraction(numberCategory)) {
        Integer subtractor = subtractivePairs.get(numberCategory);
        if (number / subtractor * subtractor + subtractor == numberCategory) {
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

  private boolean mayRequireSubtraction(Integer numberCategory) {
    return subtractivePairs.containsKey(numberCategory);
  }

}
