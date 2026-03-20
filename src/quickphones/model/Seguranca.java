/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package quickphones.model;

import br.com.perettis.gets.security.CryptoMD5;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinicius
 */
public class Seguranca {
    public static final String CriptografaSenha(String senha){
        try {
            return CryptoMD5.crypto(senha);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Seguranca.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
