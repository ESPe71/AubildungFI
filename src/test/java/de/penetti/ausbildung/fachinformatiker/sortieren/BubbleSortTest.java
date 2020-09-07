package de.penetti.ausbildung.fachinformatiker.sortieren;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;

import static java.time.ZoneOffset.UTC;
import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {
  private static final int[] EXPECTED = new int[]{6, 12, 18, 42, 44, 55, 67, 94};

  static int[][] testBubbleSort() {
    return new int[][] {{12, 18, 42, 44, 55, 67, 94,  6},
                        {94,  6, 12, 18, 42, 44, 55, 67},
                        { 6, 12, 18, 42, 44, 55, 67, 94},
                        {94, 67, 55, 44, 42, 18, 12,  6}};
  }

  static int[][] testBubbleSortMagic() {
    return new int[][] {
      {magic(), magic(), magic(), magic(), magic(), magic(), magic(), magic()},
      {magic(), magic(), magic(), magic(), magic(), magic(), magic(), magic()},
      {magic(), magic(), magic(), magic(), magic(), magic(), magic(), magic()},
      {magic(), magic(), magic(), magic(), magic(), magic(), magic(), magic()},
      {magic(), magic(), magic(), magic(), magic(), magic(), magic(), magic()},
      {magic(), magic(), magic(), magic(), magic(), magic(), magic(), magic()},
      {magic(), magic(), magic(), magic(), magic(), magic(), magic(), magic()}};
  }

  @ParameterizedTest
  @MethodSource
  void testBubbleSort(int[] toSort) {

    int[] sorted = BubbleSort.sort(toSort);

    assertArrayEquals(EXPECTED, sorted);
  }

  @ParameterizedTest
  @MethodSource
  void testBubbleSortMagic(int[] toSort) {
    int[] sorted = BubbleSort.sort(toSort);

    for(int i = 0; i < sorted.length - 1; i++) {
      assertTrue(sorted[i] <= sorted[i + 1]);
    }

  }

  @ParameterizedTest
  @MethodSource("testBubbleSort")
  void testBubbleSort2(int[] toSort) {

    int[] sorted = BubbleSort.sort2(toSort);

    assertArrayEquals(EXPECTED, sorted);
  }

  @ParameterizedTest
  @MethodSource("testBubbleSortMagic")
  void testBubbleSort2Magic(int[] toSort) {
    int[] sorted = BubbleSort.sort2(toSort);

    for(int i = 0; i < sorted.length - 1; i++) {
      assertTrue(sorted[i] <= sorted[i + 1]);
    }

  }

  private static int magic() {
    return SecureRandomHolder.random.nextInt(101);
  }
  private static class SecureRandomHolder {
    private static SecureRandom random;

    static {
      try {
        random = SecureRandom.getInstanceStrong();
      }
      catch (NoSuchAlgorithmException e) {
        random = new SecureRandom(("" + LocalDateTime.now().toEpochSecond(UTC)).getBytes());
      }
    }
  }
}