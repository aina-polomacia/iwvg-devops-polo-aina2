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
}
