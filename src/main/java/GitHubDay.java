import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.io.IOException;

/**
 * Created by kecso on 1/19/17.
 */
public class GitHubDay {

    public static void main(String[] args) throws IOException {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName("githublogminer")
                .setMaster("local");
        SparkSession sparkSession = SparkSession.builder()
                .config(sparkConf)
                .getOrCreate();

        final Dataset<Row> gitarchive = sparkSession.read()
                .json("/Users/kecso/Documents/courses/books/sparkinaction/github-archive/2015-03-01-0.json");
        System.out.println(">>>> " + gitarchive.first());
        gitarchive.printSchema();
    }

}
