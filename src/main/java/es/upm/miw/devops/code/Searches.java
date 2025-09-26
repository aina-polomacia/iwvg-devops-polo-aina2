package es.upm.miw.devops.code;

import java.util.Objects;
import java.util.stream.Stream;

public class Searches {
    public Fraction findFractionMultiplicationByUserFamilyName(String familyName) {
        return new UsersDatabase().findAll()
                .filter(user -> familyName.equals(user.getFamilyName()))
                .flatMap(user -> user.getFractions().stream()
                        .filter(Objects::nonNull)
                )
                .reduce(Fraction::multiply)
                .orElse(null);
    }

    public Stream<String> findUserIdByAllProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> !user.getFractions().isEmpty()
                        && user.getFractions().stream().allMatch(Fraction::isProper))
                .map(User::getId);
    }

    public Fraction findFirstProperFractionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> id.equals(user.getId()))
                .flatMap(user -> user.getFractions().stream())
                .filter(Fraction::isProper)
                .findFirst()
                .orElse(null);
    }

    public Stream<Double> findDecimalFractionByNegativeSignFraction() {
        return new UsersDatabase().findAll()
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::decimal)
                .filter(decimal -> decimal < 0);
    }
}
