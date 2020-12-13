package ucab.dsw.accesodatos;

import ucab.dsw.entidades.PreguntaEstudio;
import javax.persistence.EntityManager;

public class DaoPreguntaEstudio extends Dao<PreguntaEstudio>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoPreguntaEstudio(){
        super (_handler);
    }

}
