package exercise

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class CheckoutSystemSpec extends AnyFlatSpec with Matchers{

  behavior of "checkout system"

  it should "scan an empty list of items and compute zero as total price" in {
    CheckoutSystem.scan() mustBe 0
  }

  it should "scan the given list of item and compute the total price" in {
    CheckoutSystem.scan("Apple", "Apple", "Orange", "Apple") mustBe 2.05
  }
}

