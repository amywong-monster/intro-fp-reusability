package org.jinilover.resuability

import org.jinilover.resuability.ImplicitInstances._

object HowToUseTemplateCode {
  TemplateCode.genericFlip(List(Option(1), Option(2), Option(3)))

  type Disjunction[A] = Either[String, A]
  TemplateCode.genericFlip[Disjunction](List(Right(1), Right(2), Right(3)))
}
