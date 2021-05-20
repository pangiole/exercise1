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


  // "3 for the price of 2" on oranges
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  // Each triplet of oranges shall count as two oranges.
  // If you look at the following mathematical series:
  //
  //  count:     1, 2, 3, 4, 5, 6, 7, 8, 9, ...
  //  discount:  1, 2, 2, 3, 4, 4, 5, 6, 6, ...
  //
  // you can state that the discounted number of oranges
  // can be computed as twice the number of triplets plus the rest
  //
  def orangesIn(items: Seq[Item]) = {
    val count = items.count(_ == "Orange")
    val discount = 2 * (count / 3) + count % 3
    Seq.tabulate(discount){ _ => "Orange" }
  }
}
