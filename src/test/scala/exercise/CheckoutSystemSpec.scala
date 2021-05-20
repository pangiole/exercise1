package exercise

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class CheckoutSystemSpec extends AnyFlatSpec with Matchers{

  behavior of "checkout system"

  it should "scan an empty list of items and compute zero as total price" in {
    CheckoutSystem.scan() mustBe 0
  }

  it should "scan the given list of item and compute the total price" in {
    CheckoutSystem.scan("Orange", "Orange", "Apple") mustBe 1.10
  }

  it should "apply 'buy-1-get-1-free' offer on apples" in {
    CheckoutSystem.scan("Apple", "Apple", "Orange", "Apple") mustBe 1.45
  }

  it should "apply '3-for-the-price-of-2' offer on oranges" in {
    CheckoutSystem.scan("Orange", "Apple", "Orange", "Orange", "Orange") mustBe 1.35
  }

  it should "apply offers on both pairs of apples and triplets of oranges" in {
    CheckoutSystem.scan("Orange", "Apple", "Apple", "Orange", "Apple", "Orange", "Orange") mustBe 1.95
  }
}

