package hibernate_session;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtils {


    //Annotation based configuration
    private static SessionFactory sessionAnnotationFactory;

    //Property based configuration
    //private static SessionFactory sessionJavaConfigFactory;

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();

        } catch (HibernateException he) {
            System.out.println("Session Factory creation failure");
            throw he;
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

//    private static SessionFactory buildSessionJavaConfigFactory() {
//        try {
//            Configuration configuration = new Configuration();
//
//            //Create Properties, can be read from property files too
//            Properties props = new Properties();
//            props.put("hibernate_session.connection.driver_class", "com.mysql.jdbc.Driver");
//            props.put("hibernate_session.connection.url", "jdbc:mysql://localhost/TestDB");
//            props.put("hibernate_session.connection.username", "pankaj");
//            props.put("hibernate_session.connection.password", "pankaj123");
//            props.put("hibernate_session.current_session_context_class", "thread");
//
//            configuration.setProperties(props);
//
//            //we can set mapping file or class with annotation
//            //addClass(Employee1.class) will look for resource
//            // com/journaldev/hibernate_session/model/Employee1.hbm.xml (not good)
//            configuration.addAnnotatedClass(Employee1.class);
//
//            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//            System.out.println("Hibernate Java Config serviceRegistry created");
//
//            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//
//            return sessionFactory;
//        }
//        catch (Throwable ex) {
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }


//
//    public static SessionFactory getSessionJavaConfigFactory() {
//        if(sessionJavaConfigFactory == null) sessionJavaConfigFactory = buildSessionJavaConfigFactory();
//        return sessionJavaConfigFactory;
//    }

}
