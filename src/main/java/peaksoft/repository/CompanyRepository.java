package peaksoft.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.Config.DataBaseConfig;
import peaksoft.models.Company;

public class CompanyRepository implements AutoCloseable{
      public final SessionFactory sessionFactory = DataBaseConfig.createSessionFactory();
      public void save(Company company){
          try(Session session = sessionFactory.openSession()){
              session.beginTransaction();

              session.persist(company);

              session.getTransaction().commit();
          }
      }


    @Override
    public void close() throws Exception {
       sessionFactory.close();
    }
}
