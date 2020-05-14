package models;

import org.sql2o.Sql2o;

public class DB {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-35-174-127-63.compute-1.amazonaws.com:5432/df449is66amqp3","kurvqzkeanirpv", "68d3dd76b116719896ae0ae1b7fc8c00f4a6af2166409f6b018cb59e9c953ffe");
}