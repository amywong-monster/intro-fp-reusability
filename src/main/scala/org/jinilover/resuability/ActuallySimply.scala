package org.jinilover.resuability

// should be imported to use the template code `sequence` and Option, Either instances
import cats.implicits._

object ActuallySimply {
  // same as TemplateCode.genericFlip(List(Option(1), Option(2), Option(3)))
  List(Option(1), Option(2), Option(3)).sequence

  List[Either[String, Int]](Right(1), Right(2), Right(3)).sequence

}
