package ucab.dsw.accesodatos;

import ucab.dsw.entidades.NivelAcademico;
import javax.persistence.EntityManager;

public class DaoNivelAcademico extends Dao<NivelAcademico>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoNivelAcademico (){
        super (_handler);
    }

}
