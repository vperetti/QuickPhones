/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package quickphones.model;

import br.com.perettis.gets.dao.DAOFactoryAbstract;
import br.com.perettis.gets.dao.GenericDAO;
import br.com.perettis.gets.dao.GenericHibernateDAO;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author vinicius
 */
public class HibernateDAOFactory extends DAOFactoryAbstract implements QuickPhonesDAOFactory {

    public GenericDAO instantiateDAO(Class daoClass) {
        try {
            GenericHibernateDAO dao = (GenericHibernateDAO)daoClass.newInstance();
            dao.setSession(getCurrentSession());
            return dao;
        } catch (Exception ex) {
            throw new RuntimeException("Can not instantiate DAO: " + daoClass, ex);
        }
    }

    // You could override this if you don't want HibernateUtil for lookup
    protected Session getCurrentSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    // Inline concrete DAO implementations with no business-related data access methods.
    // If we use public static nested classes, we can centralize all of them in one source file.

 /*   public static class ContatoDAO
            extends GenericHibernateDAO<Uf, Integer> {

        public List<Uf> findByPropertyLike(String property, Object value, int type) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
*/
    public Object getDAObyClass(Class dao) {
        return instantiateDAO(dao);
    }

    public UsuarioDAO getUsuarioDAO() {
        return (UsuarioDAO) instantiateDAO(UsuarioDAO.class);
    }

    public ContatoDAO getContatoDAO() {
        return (ContatoDAO) instantiateDAO(ContatoDAO.class);
    }


/*    public static class ShipmentDAOHibernate
            extends GenericHibernateDAO<Shipment, Long>
            implements ShipmentDAO {}
*/
}

