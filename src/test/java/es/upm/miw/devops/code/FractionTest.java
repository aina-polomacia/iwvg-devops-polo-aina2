package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FractionTest {

    @Test
    void testEmptyConstructor() {
        Fraction fraction = new Fraction();
        assertThat(fraction.getNumerator()).isEqualTo(1);
        assertThat(fraction.getDenominator()).isEqualTo(1);
    }

    @Test
    void testFullConstructorAndGetters() {
        Fraction fraction = new Fraction(3, 4);
        assertThat(fraction.getNumerator()).isEqualTo(3);
        assertThat(fraction.getDenominator()).isEqualTo(4);
    }

    @Test
    void testSetters() {
        Fraction fraction = new Fraction();
        fraction.setNumerator(5);
        fraction.setDenominator(6);

        assertThat(fraction.getNumerator()).isEqualTo(5);
        assertThat(fraction.getDenominator()).isEqualTo(6);
    }

    @Test
    void testDecimal() {
        Fraction fraction = new Fraction(1, 2);
        assertThat(fraction.decimal()).isCloseTo(0.5, within(1e-5));

        fraction.setNumerator(3);
        fraction.setDenominator(4);
        assertThat(fraction.decimal()).isCloseTo(0.75, within(1e-5));
    }

    @Test
    void testToString() {
        Fraction fraction = new Fraction(2, 3);
        String str = fraction.toString();
        assertThat(str).contains("2").contains("3").contains("numerator").contains("denominator");
    }
}