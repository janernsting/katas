import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

public class RomanNumeralsKata {

  NumberToRomanNumeralConverter converter = new NumberToRomanNumeralConverter();
  
  @Test
  public void shouldConvertSimpleNumbers() {
    assertThat(converter.arabicToRoman(1), is("I"));
    assertThat(converter.arabicToRoman(5), is("V"));
    assertThat(converter.arabicToRoman(10), is("X"));
  }

  @Test
  public void shouldAddNumerals() {
    assertThat(converter.arabicToRoman(23), is("XXIII"));
  }
  
  @Test
  public void shouldHandleSubtractiveRomanNumerals() {
    assertThat(converter.arabicToRoman(4), is("IV"));
    assertThat(converter.arabicToRoman(9), is("IX"));
    assertThat(converter.arabicToRoman(40), is("XL"));
  }
}
