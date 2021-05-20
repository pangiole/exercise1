package exercise

object CheckoutSystem {

  type Item = String

  val prices =  Map(
    "Apple" -> 0.60,
    "Orange" -> 0.25
  )

  def scan(items: Item*): Double = items.map(prices).sum
}
