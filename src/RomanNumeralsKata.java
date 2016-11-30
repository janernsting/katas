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

  private String arabicToRoman(int number) {
    if (number == 5) {
      return "V";
    }
    StringBuilder result = new StringBuilder();
    for (; number > 0;) {
      result.append("I");
      number -= 1;
    }
    return result.toString();
  }
}
