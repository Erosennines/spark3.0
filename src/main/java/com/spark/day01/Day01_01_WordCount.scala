package com.spark.day01

import org.apache.spark.{SparkConf, SparkContext}

object Day01_01_WordCount {
  def main(args: Array[String]): Unit = {
    // 创建Spark运行配置对象
    // 其中SparkConf是设置Spark参数的关键方法
    // setMaster是Spark运行的模式，一般在测试时设置；local[*]是使用本地CPU所有核数
    // setAppName则是程序的名称
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordcount")
    // 创建Spark上下文环境对象（连接对象）
    val sc = new SparkContext(sparkConf)

    // 读取文件数据
    val wordsRDD = sc.textFile("input/words.txt")

    // 将文件中的数据进行分词
    val wordRDD = wordsRDD.flatMap(words => words.split(" "))

    // 转换数据结构 word => (word, 1)
    val wordAndOne = wordRDD.map(word => (word, 1))

    // 将转换结构后的数据按照相同的单词进行分组聚合
    val wordAndCount = wordAndOne.reduceByKey(_ + _)

    // 将数据聚合结果采集到内存中，并打印
    wordAndCount.collect().foreach(println)

    //关闭Spark连接
    sc.stop()
  }

}
