package org.jinilover.resuability

object DuplicatedCodeExample2 {
  def flip(eithers: List[Either[String, Int]]): Either[String, List[Int]] =
    eithers.foldLeft[Either[String, List[Int]]](Right(List.empty[Int])) { (accmulator, either) =>
      accmulator.flatMap(accV => either.map(v => accV ++ List(v)))
    }
}
