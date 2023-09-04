package com.mblagov

import org.apache.spark.sql.SparkSession

import java.util.Properties

object SparkEvoApp extends App {

  val spark = SparkSession.builder()
    .master("local[1]")
    .appName("SparkByExample")
    .getOrCreate();

  println("First SparkContext:")
  println("APP Name :" + spark.sparkContext.appName);
  println("Deploy Mode :" + spark.sparkContext.deployMode);
  println("Master :" + spark.sparkContext.master);

  val connectionProperties = new Properties()
  connectionProperties.put("user", "postgres")
  connectionProperties.put("password", "postgres")

  val employeesDf = spark.read.jdbc("jdbc:postgresql://localhost:54321/", "public.employees", connectionProperties)
  employeesDf.write
    .mode("append")
    .option("path", "./employees")
    .saveAsTable("employees")

  spark.sql("select * from employees").show(100)
}