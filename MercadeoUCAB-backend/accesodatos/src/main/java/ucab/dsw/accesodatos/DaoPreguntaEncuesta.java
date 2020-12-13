package ucab.dsw.accesodatos;

import ucab.dsw.entidades.PreguntaEncuesta;
import javax.persistence.EntityManager;

public class DaoPreguntaEncuesta extends Dao<PreguntaEncuesta>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoPreguntaEncuesta(){
        super (_handler);
    }

}
