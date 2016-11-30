import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

public class RomanNumeralsKata {

  @Test
  public void shouldConvertSimpleNumbers() {
    assertThat(arabicToRoman(1), is("I"));
    assertThat(arabicToRoman(2), is("II"));
  }

  private String arabicToRoman(int number) {
    StringBuilder result = new StringBuilder();
    for (; number > 0;) {
      result.append("I");
      number -= 1;
    }
    return result.toString();
  }
}
