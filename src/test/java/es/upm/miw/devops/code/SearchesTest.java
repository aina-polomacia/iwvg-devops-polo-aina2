package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SearchesTest {
    @Test
    void testFindFractionMultiplicationByUserFamilyName() {
        Fraction result = new Searches().findFractionMultiplicationByUserFamilyName("López");
        assertThat(result.getNumerator()).isEqualTo(12);
        assertThat(result.getDenominator()).isEqualTo(-240);
    }

    @Test
    void testFindUserIdByAllProperFraction() {
        assertThat(new Searches().findUserIdByAllProperFraction().toList())
                .containsExactly();
    }

    @Test
    void testFindFirstProperFractionByUserId() {
        Fraction result = new Searches().findFirstProperFractionByUserId("3");
        assertThat(result.getNumerator()).isEqualTo(1);
        assertThat(result.getDenominator()).isEqualTo(5);
    }

    @Test
    void testFindDecimalFractionByNegativeSignFraction() {
        assertThat(new Searches().findDecimalFractionByNegativeSignFraction().toList())
                .containsExactly(-0.2, -0.5);
    }
}
