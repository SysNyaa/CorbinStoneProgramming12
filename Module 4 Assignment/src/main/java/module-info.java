module Module4Assignment {
    requires derby;
    requires java.sql;
    requires org.apache.commons.csv;

    opens com.module4.db;
}