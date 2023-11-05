
import org.apache.spark.SparkContext
import java.nio.file.{Path, Paths}
import org.apache.spark.sql.{DataFrame, SparkSession}
import java.io.File
import org.apache.jena.rdf.model.{Model, ModelFactory, ResourceFactory, Statement}
import org.apache.jena.vocabulary.RDF
object PQ2NT {
  val spark: SparkSession = Configuration.Configuration.sparkSession
  val _sc: SparkContext = spark.sparkContext

  import spark.implicits._
  def main(args: Array[String]): Unit = {
    // 将parquet 转换成nt
    val parquetFile = "xx"
    val curDF = spark.read.parquet(parquetFile).toDF()
    curDF.show()
    val model: Model = ModelFactory.createDefaultModel()

    // 遍历DataFrame的每一行，将数据添加到Jena模型中
    curDF.collect().foreach(row => {

      val subject = ResourceFactory.createResource(row.getAs("sub").toString)
      val predicate = ResourceFactory.createProperty(row.getAs("pred").toString)
      val obj = ResourceFactory.createPlainLiteral(row.getAs("obj").toString)

      val statement: Statement = ResourceFactory.createStatement(subject, predicate, obj)
      model.add(statement)
    })

    // 将NT格式数据写入文件
    val ntPath = "xx.nt"
    model.write(System.out, "N-TRIPLES")
    model.write(new java.io.FileWriter(ntPath), "N-TRIPLES")
  }
}
