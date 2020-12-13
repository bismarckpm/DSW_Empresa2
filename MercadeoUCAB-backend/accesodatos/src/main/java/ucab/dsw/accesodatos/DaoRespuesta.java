package ucab.dsw.accesodatos;

import ucab.dsw.entidades.Respuesta;
import javax.persistence.EntityManager;

public class DaoRespuesta extends Dao<Respuesta>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoRespuesta (){
        super (_handler);
    }

}
