package ucab.dsw.accesodatos;

import ucab.dsw.entidades.Informacion;
import javax.persistence.EntityManager;

public class DaoInformacion extends Dao<Informacion>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoInformacion (){
        super (_handler);
    }
}
