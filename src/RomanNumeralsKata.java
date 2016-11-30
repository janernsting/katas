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
    StringBuilder result = new StringBuilder();
    for (; number > 0;) {
      if (number == 5) {
        result.append("V");
        number -= 5;
      } else {
        result.append("I");
        number -= 1;
      }
    }
    return result.toString();
  }
}
