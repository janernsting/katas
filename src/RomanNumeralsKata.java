import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

public class RomanNumeralsKata {

  NumberToRomanNumeralConverter converter = new NumberToRomanNumeralConverter();
  
  @Test
  public void shouldHandleSimpleNumerals() {
    assertThat(theRomanNumeralOf(1), is("I"));
  }
  
  private String theRomanNumeralOf(int number) {
    return converter.arabicToRoman(number);
  }

  @Test
  public void shouldHandleAdditiveNumerals() {
    assertThat(theRomanNumeralOf(23), is("XXIII"));
  }
  
  @Test
  public void shouldHandleSubtractiveNumerals() {
    assertThat(theRomanNumeralOf(4), is("IV"));
  }
  
  @Test
  public void shouldHandleCombinationsOfSubtractiveNumerals() {
    assertThat(theRomanNumeralOf(44), is("XLIV"));
  }
}
