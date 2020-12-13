package ucab.dsw.accesodatos;

import ucab.dsw.entidades.Usuario;

import javax.persistence.EntityManager;

public class DaoUsuario extends Dao<Usuario>
{
    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();


    public DaoUsuario( )
    {
        super( _handler );
    }
}