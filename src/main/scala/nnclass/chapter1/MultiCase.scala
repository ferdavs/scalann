package nnclass.chapter1

/**
  * Created by f on 5/12/2017.
  */
object MultiCase extends App {

  def fm(a: Double, b: Double) = a * b

  def fa(a: Double, b: Double) = a + b

  def f(x: Double, y: Double, z: Double) = fm(fa(x, y), z)

  val x = -2
  val y = 5
  val z = -4

  println(f(x, y, z))
}
