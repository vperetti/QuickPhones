/*
 * QuickPhonesApp.java
 */

package quickphones;

import br.com.perettis.gets.dao.DAOFactoryAbstract;
import java.util.logging.Logger;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import quickphones.model.HibernateDAOFactory;
import quickphones.model.QuickPhonesDAOFactory;

/**
 * The main class of the application.
 */
public class QuickPhonesApp extends SingleFrameApplication {

    QuickPhonesDAOFactory daoFactory = null;
	
    public void initFactories() {
        try {
            daoFactory = (QuickPhonesDAOFactory) DAOFactoryAbstract.instance(HibernateDAOFactory.class);
        } catch (Exception e) {
            System.out.println("Erro:" + e.toString());
            System.exit(1);
        }
    }
    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        initFactories();
        daoFactory.getUsuarioDAO();
        Autenticacao autenticacao = new Autenticacao(daoFactory);
        autenticacao.setVisible(true);
        if (autenticacao.getUsuario() == null ) System.exit(1);
        
        QuickPhonesView quickPhonesView = new QuickPhonesView(this);
        quickPhonesView.setUsuarioAutenticado(autenticacao.getUsuario());
        quickPhonesView.setDaoFactory(daoFactory);
		show(quickPhonesView);
        //show(new QuickPhonesView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of QuickPhonesApp
     */
    public static QuickPhonesApp getApplication() {
        return Application.getInstance(QuickPhonesApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(QuickPhonesApp.class, args);
        
    }
}
