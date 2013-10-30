import org.hibernate.Session;
import org.hibernate.Transaction;

public class DAO {
    private Session currentSession = null;

    public DAO(Session session) {
        currentSession = session;
    }
    private Session getSession() {
        return currentSession;
    }
    public TemplateEntity createTemplateEntity(String test) {
        TemplateEntity templateEntity = new TemplateEntity();
        Session session = getSession();
        Transaction t = session.beginTransaction();
        templateEntity.setTest(test);
        session.persist(templateEntity);
        t.commit();
        return templateEntity;
    }
}
