
public class main {
    public static void main(String[] args) {
        DAO dao = DAOFactory.getDAO();
        TemplateEntity templateEntity = dao.createTemplateEntity("testing");
        System.out.println("templateEntity = " + templateEntity);
    }
}
