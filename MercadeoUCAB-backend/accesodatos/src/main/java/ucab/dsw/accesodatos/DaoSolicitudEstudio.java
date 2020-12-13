
package ucab.dsw.accesodatos;

/**
 *
 * @author Emanuel
 */

import ucab.dsw.entidades.SolicitudEstudio;
import javax.persistence.EntityManager;

public class DaoSolicitudEstudio extends Dao<SolicitudEstudio>{
    
    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();
    
    public DaoSolicitudEstudio (){
        super(_handler);
    }
    
}
