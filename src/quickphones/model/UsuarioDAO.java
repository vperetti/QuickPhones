/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quickphones.model;

import br.com.perettis.gets.dao.GenericHibernateDAO;
import quickphones.entity.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;

/**
 *
 * @author vinicius
 */
public class UsuarioDAO
	extends GenericHibernateDAO<Usuario, Long> {

	public Usuario buscaPorApelido(String apelido) {
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.add(Expression.like("apelido", apelido));
		List result = criteria.list();
		if (result.isEmpty()) {
			return null;
		} else {
			return (Usuario) result.get(0);
		}
	}
}
