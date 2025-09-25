package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    @Test
    void testEmptyConstructor() {
        User user = new User();
        assertThat(user.getFractions()).isEmpty();
        assertThat(user.getId()).isNull();
        assertThat(user.getName()).isNull();
        assertThat(user.getFamilyName()).isNull();
    }

    @Test
    void testFullConstructorAndGetters() {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction());
        fractions.add(new Fraction());

        User user = new User("u1", "Alice", "Smith", fractions);

        assertThat(user.getId()).isEqualTo("u1");
        assertThat(user.getName()).isEqualTo("Alice");
        assertThat(user.getFamilyName()).isEqualTo("Smith");
        assertThat(user.getFractions()).hasSize(2);
    }

    @Test
    void testSetters() {
        User user = new User();
        user.setName("Bob");
        user.setFamilyName("Johnson");

        assertThat(user.getName()).isEqualTo("Bob");
        assertThat(user.getFamilyName()).isEqualTo("Johnson");
    }

    @Test
    void testAddFraction() {
        User user = new User();
        Fraction fraction = new Fraction();
        user.addFraction(fraction);

        assertThat(user.getFractions()).containsExactly(fraction);
    }

    @Test
    void testFullName() {
        User user = new User("u2", "Charlie", "Brown", new ArrayList<>());
        assertThat(user.fullName()).isEqualTo("Charlie Brown");
    }

    @Test
    void testInitials() {
        User user = new User("u3", "David", "Miller", new ArrayList<>());
        assertThat(user.initials()).isEqualTo("D.");
    }

    @Test
    void testToString() {
        User user = new User("u4", "Eve", "Wilson", new ArrayList<>());
        String str = user.toString();

        assertThat(str)
                .contains("u4")
                .contains("Eve")
                .contains("Wilson")
                .contains("fractions");
    }
}
