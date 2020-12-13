package ucab.dsw.accesodatos;

import ucab.dsw.entidades.Telefono;
import javax.persistence.EntityManager;

public class DaoTelefono extends Dao<Telefono>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoTelefono(){
        super (_handler);
    }

}
