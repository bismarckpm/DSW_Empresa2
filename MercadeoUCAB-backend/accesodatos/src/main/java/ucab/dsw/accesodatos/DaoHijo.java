package ucab.dsw.accesodatos;

import ucab.dsw.entidades.Hijo;
import javax.persistence.EntityManager;

public class DaoHijo extends Dao<Hijo>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoHijo (){
        super (_handler);
    }

}
