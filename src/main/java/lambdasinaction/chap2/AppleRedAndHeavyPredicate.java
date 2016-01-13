package lambdasinaction.chap2;

import lambdasinaction.chap1.Apple;

public class AppleRedAndHeavyPredicate implements ApplePredicate {
  public boolean test(Apple apple) {
    return "red".equals(apple.getColour())
        && apple.getWeight() > 150;
  }
}