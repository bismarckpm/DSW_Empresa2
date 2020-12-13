package ucab.dsw.accesodatos;

import ucab.dsw.entidades.RespuestaPregunta;
import javax.persistence.EntityManager;

public class DaoRespuestaPregunta extends Dao<RespuestaPregunta>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoRespuestaPregunta(){
        super (_handler);
    }

}
