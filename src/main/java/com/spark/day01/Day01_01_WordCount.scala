package com.spark.day01

import org.apache.spark.{SparkConf, SparkContext}

object Day01_01_WordCount {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordcount")
    val sc = new SparkContext(sparkConf)

    val wordsRDD = sc.textFile("input/words.txt")

    val wordRDD = wordsRDD.flatMap(words => words.split(" "))

    val wordAndOne = wordRDD.map(word => (word, 1))

    val wordAndCount = wordAndOne.reduceByKey(_ + _)

    wordAndCount.collect().foreach(println)

    sc.stop()
  }

}
