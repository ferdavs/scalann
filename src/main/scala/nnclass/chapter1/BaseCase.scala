package nnclass.chapter1

import scala.util.Random

/**
  * Created by f on 5/12/2017.
  */
object BaseCase extends App {

  def rand(): Double = Random.nextDouble()

  def f(x: Double, y: Double): Double = x * y

  //  println(f(-2, 3))

  //goal maximize f(x,y)
  //given x and y
  val x = -2.0
  val y = 3.0

  //Strategy #1: Random Local Search
  def localRandomSearch(xy: (Double, Double), f: (Double, Double) => Double) = {
    Console println "<<<<<<<< Local Random Search >>>>>>>>>"

    val (x, y) = xy
    val tweak_amount = 0.01
    var best = -Double.MaxValue
    var best_x = x
    var best_y = y

    Range(0, 100).foreach(_ => {
      val xt = x + tweak_amount * (rand() * 2 - 1)
      val yt = y + tweak_amount * (rand() * 2 - 1)
      val out = f(xt, yt)
      if (out > best) {
        best = out
        best_x = xt
        best_y = yt
      }
    })

    Console println s"f($best_x, $best_y) = ${f(best_x, best_y)}"
    Console println "===================================="
    (best_x, best_y)
  }

  localRandomSearch((x, y), f)

  //Stategy #2: Numerical Gradient
  def numericGradient(xy: (Double, Double), f: (Double, Double) => Double) = {
    Console println "<<<<<<<< Numerical Gradient >>>>>>>>>"
    val (x, y) = xy

    val h = 0.0001
    var out = f(x, y)

    val out2 = f(x + h, y)
    val dx = (out2 - out) / h

    val out3 = f(x, y + h)
    val dy = (out3 - out) / h

    //    Console println s"out2=$out2 dx=$dx   out3=$out3 dy=$dy "

    val step = 0.01

    val xnew = x + dx * step
    val ynew = y + dy * step

    Console println s"f($xnew, $ynew) = ${f(xnew, ynew)}"
    Console println "===================================="

    (xnew, ynew)
  }

  numericGradient((x, y), f)
  //  var xy = numericGradient((x, y), f)
  //  Range(0, 100).foreach(_ => {
  //    xy = numericGradient(xy, f)
  //    Console println s"f(${xy._1}, ${xy._2}) = ${f(xy._1, xy._2)}"
  //  })

  //Strategy #3: Analytic Gradient
  def analyticGradient(xy: (Double, Double), f: (Double, Double) => Double) = {
    Console println "<<<<<<<< Analytic Gradient >>>>>>>>>"
    val (x, y) = xy
    val step = 0.01
    //derivative of f(x,y)=x*y over x is y
    val dy = x
    val dx = y
    val xnew = x + dx * step
    val ynew = y + dy * step

    Console println s"f($xnew, $ynew) = ${f(xnew, ynew)}"
    Console println "===================================="

    (xnew, ynew)
  }

  analyticGradient((x, y), f)
}
