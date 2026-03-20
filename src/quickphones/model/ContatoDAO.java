/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quickphones.model;

import br.com.perettis.gets.dao.GenericHibernateDAO;
import quickphones.entity.Contato;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;

/**
 *
 * @author Vinicius Peretti
 */
public class ContatoDAO
	extends GenericHibernateDAO<Contato, Long> {

	public Contato buscaPorNome(String nome) {
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.add(Expression.like("nome", nome));
		List<Contato> result = criteria.list();
		if (result.isEmpty()) {
			return null;
		} else {
			return result.get(0);
		}
	}
}
