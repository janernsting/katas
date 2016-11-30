import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

public class RomanNumeralsKata {

  NumberToRomanNumeralConverter converter = new NumberToRomanNumeralConverter();
  
  @Test
  public void shouldConvertSimpleNumbers() {
    assertThat(theRomanNumeralOf(1), is("I"));
    assertThat(theRomanNumeralOf(5), is("V"));
    assertThat(theRomanNumeralOf(10), is("X"));
  }
  
  private String theRomanNumeralOf(int number) {
    return converter.arabicToRoman(number);
  }

  @Test
  public void shouldAddNumerals() {
    assertThat(theRomanNumeralOf(23), is("XXIII"));
  }
  
  @Test
  public void shouldHandleSubtractiveRomanNumerals() {
    assertThat(theRomanNumeralOf(4), is("IV"));
    assertThat(theRomanNumeralOf(9), is("IX"));
    assertThat(theRomanNumeralOf(40), is("XL"));
  }
  
  @Test
  public void shouldHandleCombinationsOfSubtractiveRomanNumerals() {
    assertThat(theRomanNumeralOf(44), is("XLIV"));
  }
}
