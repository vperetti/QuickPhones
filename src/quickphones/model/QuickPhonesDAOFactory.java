package quickphones.model;



/**
 *
 * @author vinicius
 * 
 * Interface para fabrica de daos da aplicação Schedula
 */
public interface QuickPhonesDAOFactory {

    
    UsuarioDAO getUsuarioDAO();
    
    ContatoDAO getContatoDAO();
    
}
