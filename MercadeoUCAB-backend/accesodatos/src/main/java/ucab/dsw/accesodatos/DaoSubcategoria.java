package ucab.dsw.accesodatos;

/**
 *
 * @author Emanuel
 */

import javax.persistence.EntityManager;
import ucab.dsw.entidades.Subcategoria;


public class DaoSubcategoria extends Dao<Subcategoria>{
    
    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();
    
    public DaoSubcategoria(){
        super(_handler);
    }
    
}
