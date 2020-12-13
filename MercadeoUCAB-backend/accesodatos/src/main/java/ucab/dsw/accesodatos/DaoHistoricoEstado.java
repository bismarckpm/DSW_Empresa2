package ucab.dsw.accesodatos;

import ucab.dsw.entidades.HistoricoEstado;
import javax.persistence.EntityManager;

public class DaoHistoricoEstado extends Dao<HistoricoEstado>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoHistoricoEstado (){
        super (_handler);
    }

}
