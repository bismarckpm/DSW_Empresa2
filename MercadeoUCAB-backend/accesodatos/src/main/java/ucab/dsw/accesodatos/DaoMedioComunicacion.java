package ucab.dsw.accesodatos;

import ucab.dsw.entidades.MedioComunicacion;
import javax.persistence.EntityManager;

public class DaoMedioComunicacion extends Dao<MedioComunicacion>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoMedioComunicacion (){
        super (_handler);
    }

}
