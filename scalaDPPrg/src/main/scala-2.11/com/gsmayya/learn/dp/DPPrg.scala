package com.gsmayya.learn.dp

import java.util

import com.gsmayya.learn.java.dp.{DPJavaPrg, Int3Function, LCS}

/**
  * Created by gsmay on 14-08-2016.
  */
class DPPrg () {

  def getCount(n:Int) :Int = {
    var dp = new Array[Integer](n+1)
    dp(0) = 1
    dp(1) = 1
    dp(2) = 1
    dp(3) = 2

    for (i <- 4 to n) {
      dp(i) = dp(i-1) + dp(i-3) + dp(i-4)
    }
    dp(n)
  }

}

object DPPrg {
  def main(args : Array[String]) = {
    val scalaDPPrg = new DPPrg
    val javaDPPrg = new DPJavaPrg
    println(scalaDPPrg.getCount(5))
    println(javaDPPrg.getCount(5))

    val javaLCS = new LCS

    println(javaLCS.maxLCS("ABCBDAB", "BDCABC"))

    val int3 = new Int3Function

    println(int3.getMinSteps(10))
    println(int3.getMinStepsBottomUp(10))
  }
}