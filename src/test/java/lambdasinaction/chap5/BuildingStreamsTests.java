package lambdasinaction.chap5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lambdasinaction.chap5.Utils.toListOfListsOfIntegers;
import static java.util.stream.Collectors.toList;
import static lambdasinaction.chap5.BuildingStreams.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BuildingStreamsTests {

  @Test
  @DisplayName("Stream of strings")
  public void shouldGetStreamOfStrings() {
    assertThat(getStreamFromStringArgs().collect(toList()),
        is(Arrays.asList("JAVA 8", "LAMBDAS", "IN", "ACTION")));
  }

  @Test
  @DisplayName("Empty stream of strings")
  public void shouldGetEmptyStream() {
    assertThat(getEmptyStream().collect(toList()), is(new ArrayList<>()));
  }

  @Test
  @DisplayName("Sum an array")
  public void shouldGetArraySum() {
    assertThat(getArraySum(), is(41));
  }

  @Test
  @DisplayName("Number of distinct words in a file")
  public void shouldGetNumberOfWordsInFile() throws IOException {
    assertThat(getNumberOfUniqueWordsInFile(), is(9L));
  }

  @Test
  @DisplayName("First ten even numbers")
  public void shouldGetIterateStream() {
    List<Integer> expectedList = Arrays.asList(0, 2, 4, 6, 8, 10, 12, 14, 16, 18);
    assertThat(getStreamViaIterate().collect(toList()), is(expectedList));
  }

  @Test
  @DisplayName("Fibonacci sequence pairs")
  public void shouldGenerateFibonacciSequencePairs() {
    List<List<Integer>> expectedFibonacciSequencePairs = Arrays.asList(
        Arrays.asList(0, 1), Arrays.asList(1, 1),
        Arrays.asList(1, 2), Arrays.asList(2, 3),
        Arrays.asList(3, 5), Arrays.asList(5, 8),
        Arrays.asList(8, 13), Arrays.asList(13, 21),
        Arrays.asList(21, 34), Arrays.asList(34, 55)
    );

    List<List<Integer>> fibonacciSequencePairs =
        toListOfListsOfIntegers(generateFibonacciSequencePairs());

    assertThat(fibonacciSequencePairs, is(expectedFibonacciSequencePairs));
  }

  @Test
  @DisplayName("Fibonacci sequence via iterate")
  public void shouldGenerateFibonacciSequence() {
    List<Integer> expectedFibonacciSequence = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);

    List<Integer> fibonacciSequence = generateFibonacciSequence();

    assertThat(fibonacciSequence, is(expectedFibonacciSequence));
  }

  @Test
  @DisplayName("A stream of five 1's")
  public void shouldGenerateAStreamOfFiveOnes() {
    List<Integer> expectedList = Arrays.asList(1, 1, 1, 1, 1);

    assertThat(generateAStreamOfFiveOnes().boxed().collect(toList()), is(expectedList));
  }

  @Test
  @DisplayName("A stream of five 2's")
  public void shouldGenerateAStreamOfFiveTwos() {
    List<Integer> expectedList = Arrays.asList(2, 2, 2, 2, 2);

    assertThat(generateAStreamOfFiveTwos().boxed().collect(toList()), is(expectedList));
  }

  @Test
  @DisplayName("Fibonacci sequence via generate")
  public void shouldGenerateFibonacciSequenceStream() {
    List<Integer> expectedFibonacciSequence = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);

    List<Integer> fibonacciSequence = generateFibonacciSequenceStream().boxed().collect(toList());

    assertThat(fibonacciSequence, is(expectedFibonacciSequence));
  }
}