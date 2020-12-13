package ucab.dsw.accesodatos;

import ucab.dsw.entidades.Rol;
import javax.persistence.EntityManager;

public class DaoRol extends Dao<Rol>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoRol (){
        super (_handler);
    }

}
