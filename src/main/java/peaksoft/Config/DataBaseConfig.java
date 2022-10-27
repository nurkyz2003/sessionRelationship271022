package peaksoft.Config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.models.Company;
import peaksoft.models.Course;
import peaksoft.models.Student;

import java.util.Properties;

public class DataBaseConfig {
    public static SessionFactory createSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/session2710");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "nurkyz200319yearsss");

        properties.put(Environment.HBM2DDL_AUTO, "create");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Student.class);

        return configuration.buildSessionFactory();
    }
}
