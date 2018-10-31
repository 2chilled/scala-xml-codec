package ch.srg.xml.util

import shapeless.{HList, HNil, ::}

sealed trait CompactHList[A, B] {
  def to: A => B
  def from: B => A
}

trait CompactHListLow {
  implicit def default[L <: HList]: CompactHList[L, L] =
    new CompactHList[L, L] {
      override def to: L => L = identity
      override def from: L => L = identity
    }
}

object CompactHList extends CompactHListLow {
  implicit def singleElem[A]: CompactHList[A :: HNil, A] =
    new CompactHList[A :: HNil, A] {
      override def to: A :: HNil => A = { case h :: HNil => h }
      override def from: A => A :: HNil = _ :: HNil
    }
}