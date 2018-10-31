package ch.srg.xml

import scalaz.Id.Id
import scalaz.Monad

class Dsl[F[_]:Monad] {

  val encode: EncoderDsl[F] = new EncoderDsl[F]
  val decode: DecoderDsl[F] = new DecoderDsl[F]
  val codec: CodecDsl[F] = new CodecDsl[F]

}

object Dsl {

  lazy val simple = new Dsl[Id]

  def apply[F[_]:Monad]: Dsl[F] = new Dsl[F]

}
