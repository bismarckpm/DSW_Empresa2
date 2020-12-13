package ucab.dsw.accesodatos;

import javax.persistence.EntityManager;
import ucab.dsw.entidades.EstudioLugar;

public class DaoEstudioLugar extends Dao<EstudioLugar>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoEstudioLugar(){
        super(_handler);
    }
}
