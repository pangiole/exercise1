package exercise

object CheckoutSystem {

  type Item = String

  val prices =  Map(
    "Apple" -> 0.60,
    "Orange" -> 0.25
  )

  def scan(items: Item*): Double = (applesIn(items) ++ orangesIn(items)).map(prices).sum



  // "buy 1 get 1 free" on apples
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  // Each pair of apples shall count as one single apple.
  // If you look at the following mathematical series:
  //
  //  count:     1, 2, 3, 4, 5, 6, 7, 8, 9, ...
  //  discount:  1, 1, 2, 2, 3, 3, 4, 4, 5, ...
  //
  // you can easily state that the discounted number of apples
  // can be computed as the number of pairs plus the rest
  //
  def applesIn(items: Seq[Item]) = {
    val count = items.count(_ == "Apple")
    val discount = count / 2  + count % 2
    Seq.tabulate(discount){ _ => "Apple" }
  }


  // no discounts .. yet
  def orangesIn(items: Seq[Item]) = {
    items.filter(_ == "Orange")
  }
}
