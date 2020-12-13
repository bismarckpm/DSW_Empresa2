package ucab.dsw.accesodatos;

import ucab.dsw.entidades.Presentacion;
import javax.persistence.EntityManager;

public class DaoPresentacion extends Dao<Presentacion>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoPresentacion(){
        super (_handler);
    }

}
