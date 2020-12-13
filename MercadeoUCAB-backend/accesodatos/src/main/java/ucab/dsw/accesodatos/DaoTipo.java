package ucab.dsw.accesodatos;

import ucab.dsw.entidades.Tipo;
import javax.persistence.EntityManager;

public class DaoTipo extends Dao<Tipo>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoTipo (){
        super (_handler);
    }

}
