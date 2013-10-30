
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class DAOFactory {
    private static boolean started = false;

    private static SessionFactory sessionFactory = null;
    private static Session currentSession = null;
    private static DAO dao;

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration
                    .getProperties());
            sessionFactory = configuration
                    .buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());

            return sessionFactory;
        } catch (Throwable ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static DAO getDAO() {
        if (!started) {
            started = true;
            sessionFactory = buildSessionFactory();
            currentSession = sessionFactory.openSession();
            dao = new DAO(currentSession);
        }
        return dao;
    }
    public static void restartDB() {
        if (started) {
            currentSession.close();
            sessionFactory.close();
            started = false;
        }
    }
}
