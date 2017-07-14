package nnclass.chapter1

/**
  * Created by f on 5/12/2017.
  */
object MultiCase extends App {

  def fm(a: Double, b: Double): Double = a * b

  def fa(a: Double, b: Double): Double = a + b

  def f(x: Double, y: Double, z: Double): Double = fm(fa(x, y), z)

  val x = -2
  val y = 5
  val z = -4

  println(f(x, y, z))

  def analyticGradient(xyz: (Double, Double, Double)): Unit = {
    val (x, y, z) = xyz
    val q = fa(x, y)
//    val f = fm(q, z)

    val dfz = q
    val dfq = z

    val dqx = 1.0
    val dqy = 1.0

    //chainz rule
    val dfx = dfq * dqx
    val dfy = dfq * dqy

//    val dfxyz = (dfx, dfy, dfz)

    val step = 0.01

    val xh = x + step * dfx
    val yh = y + step * dfy
    val zh = z + step * dfz

    val qh = fa(xh, yh)
    val fh = fm(qh, zh)

    println(s"f($xh,$yh,$zh) = $fh")
  }

  analyticGradient((x, y, z))
}
