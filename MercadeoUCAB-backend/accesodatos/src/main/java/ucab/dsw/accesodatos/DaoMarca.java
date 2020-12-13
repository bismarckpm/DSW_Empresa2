package ucab.dsw.accesodatos;

/**
 *
 * @author Emanuel
 */

import ucab.dsw.entidades.Marca;
import javax.persistence.EntityManager;

public class DaoMarca extends Dao<Marca>{
    
    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();
    
    public DaoMarca (){
        super(_handler);
    }
    
}
