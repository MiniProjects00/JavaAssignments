
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	

	public static Session hibernate= null;
	
	static {
		
		Configuration cfg = new Configuration();
		
		SessionFactory factoryToProvideORM = cfg.configure().buildSessionFactory();
		
		hibernate = factoryToProvideORM.openSession();
	}
	

	public static Session getHibernateLink() {
		
		return hibernate;
	}
}
