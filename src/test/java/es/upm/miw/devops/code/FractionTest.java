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
    void testIsProper() {
        Fraction proper = new Fraction(2, 3);
        Fraction improper = new Fraction(5, 4);

        assertThat(proper.isProper()).isTrue();
        assertThat(improper.isProper()).isFalse();
    }

    @Test
    void testIsImproper() {
        Fraction proper = new Fraction(2, 3);
        Fraction improper = new Fraction(5, 4);

        assertThat(proper.isImproper()).isFalse();
        assertThat(improper.isImproper()).isTrue();
    }

    @Test
    void testIsEquivalent() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);
        Fraction f3 = new Fraction(3, 4);

        assertThat(f1.isEquivalent(f2)).isTrue();
        assertThat(f1.isEquivalent(f3)).isFalse();
    }

    @Test
    void testAdd() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        Fraction sum = f1.add(f2);

        assertThat(sum.getNumerator()).isEqualTo(5);
        assertThat(sum.getDenominator()).isEqualTo(6);
    }

    @Test
    void testMultiply() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(3, 4);
        Fraction product = f1.multiply(f2);

        assertThat(product.getNumerator()).isEqualTo(6);
        assertThat(product.getDenominator()).isEqualTo(12);
    }

    @Test
    void testDivide() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(4, 5);
        Fraction quotient = f1.divide(f2);

        assertThat(quotient.getNumerator()).isEqualTo(10);
        assertThat(quotient.getDenominator()).isEqualTo(12);
    }

    @Test
    void testDivideByZeroFractionThrows() {
        Fraction f1 = new Fraction(1, 2);
        Fraction zeroNumerator = new Fraction(0, 5);

        assertThatThrownBy(() -> f1.divide(zeroNumerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Cannot divide by zero fraction");
    }

    @Test
    void testToString() {
        Fraction fraction = new Fraction(2, 3);
        String str = fraction.toString();
        assertThat(str).contains("2").contains("3").contains("numerator").contains("denominator");
    }
}
