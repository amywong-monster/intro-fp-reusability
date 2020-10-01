package org.jinilover.resuability

object DuplicatedCodeExample1 {

  /**
   * flip(List(Option(1), Option(2), Option(3)))
   * val res0: Option[List[Int]] = Some(List(1, 2, 3))
   *
   * flip(List(Option(1), None, Option(3)))
   * val res4: Option[List[Int]] = None
   *
   * @param options
   * @return
   */
  def flip(options: List[Option[Int]]): Option[List[Int]] =
    options.foldLeft[Option[List[Int]]](Option(List.empty[Int])) { (accumulator, opt) =>
      accumulator.flatMap(accV => opt.map(v => accV ++ List(v)))
    }
}
