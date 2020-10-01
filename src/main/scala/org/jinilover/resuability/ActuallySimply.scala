package org.jinilover.resuability

import cats.implicits._

object ActuallySimply {
  List(Option(1), Option(2), Option(3)).sequence

  List[Either[String, Int]](Right(1), Right(2), Right(3)).sequence

}
