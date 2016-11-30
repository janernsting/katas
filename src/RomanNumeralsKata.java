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
    if (number == 2) {
      return "I" + "I";
    }
    return "I";
  }
}
