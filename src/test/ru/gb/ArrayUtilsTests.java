package ru.gb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.stream.Stream;

public class ArrayUtilsTests {

    @ParameterizedTest
    @MethodSource("valuesForSuccessfulCheckingContainFourAndOneProvider")
    void testSuccessCheckingContainFourAndOne_whenValidArrayPassed(List<Integer> arg) {
        Assertions.assertTrue(ArrayUtils.isContainFourAndOne(arg));
    }

    private static Stream<Arguments> valuesForSuccessfulCheckingContainFourAndOneProvider() {
        return Stream.of(
                Arguments.of(List.of(1,4)),
                Arguments.of(List.of(1,4,1,4,1,4,1)),
                Arguments.of(List.of(1,3,4,1,7,2,2))
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("valuesForFailedCheckingContainFourAndOneProvider")
    void testFailedCheckingContainFourAndOne_whenArrayWithoutOneOrFourPassed(List<Integer> arg) {
        Assertions.assertFalse(ArrayUtils.isContainFourAndOne(arg));
    }

    private static Stream<Arguments> valuesForFailedCheckingContainFourAndOneProvider() {
        return Stream.of(
                Arguments.of(List.of(2,3,5,6,7,8,9)),
                Arguments.of(List.of(1,2,3,5,6,7,8,9)),
                Arguments.of(List.of(2,3,4,5,6,7,8,9)),
                Arguments.of(List.of(11, 44, 111, 444, 1111, 4444))
        );
    }

    @ParameterizedTest
    @MethodSource("valuesForSuccessfulGettingSubArrayAfterFourProvider")
    void testSuccessGettingSubArrayAfterFour_whenValidArrayPassed(List<Integer> expected, List<Integer> arg) {
        Assertions.assertEquals(expected, ArrayUtils.getSubArrayAfterLastFour(arg));
    }

    private static Stream<Arguments> valuesForSuccessfulGettingSubArrayAfterFourProvider() {
        return Stream.of(
                Arguments.of(List.of(1,7), List.of(1,2,4,4,2,3,4,1,7)),
                Arguments.of(List.of(), List.of(1,2,4,4)),
                Arguments.of(List.of(1,22,333,4444,55555,666666), List.of(4,1,22,333,4444,55555,666666))
        );
    }

    @ParameterizedTest
    @MethodSource("valuesWithArrayWithoutFourProvider")
    @NullAndEmptySource
    void testFailedGettingSubArrayAfterFour_whenArrayWithoutFourPassed(List<Integer> arg) {
        Assertions.assertThrows(RuntimeException.class, () -> ArrayUtils.getSubArrayAfterLastFour(arg));
    }

    private static Stream<Arguments> valuesWithArrayWithoutFourProvider() {
        return Stream.of(
                Arguments.of(List.of(1,2,2,3,1,7)),
                Arguments.of(List.of(1,2,3,5,6,7,8,9)),
                Arguments.of(List.of(8, 44, -4))
        );
    }
}
