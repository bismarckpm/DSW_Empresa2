package ucab.dsw.accesodatos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class DaoHandler
{
    private static EntityManagerFactory _emf;
    private EntityManager _em;
    private EntityTransaction _et;
    private boolean _isTransaction;

    /**
     *
     */
    public DaoHandler()
    {
        if ( _emf == null )
        {
            try
            {
                _emf = Persistence.createEntityManagerFactory( "mercadeoUcabPU" );
            }
            catch ( PersistenceException e )
            {
                throw e;
            }
            catch ( RuntimeException e )
            {
                throw e;
            }
            catch ( Exception e )
            {
                throw e;
            }

        }
    }

    /**
     * @return
     */
    public EntityManager getSession()
    {
        try
        {
            if ( _em == null )
            {
                _em = _emf.createEntityManager();
            }
        }
        catch ( PersistenceException e )
        {
            throw e;
        }
        catch ( RuntimeException e )
        {
            throw e;
        }
        catch ( Exception e )
        {
            throw e;
        }
        return _em;
    }

    /**
     *
     */
    public void closeSession()
    {
        try
        {
            if ( _em != null )
            {
                _em.close();
                _em = null;
            }
        }
        catch ( PersistenceException e )
        {
            throw e;
        }
        catch ( RuntimeException e )
        {
            throw e;
        }
        catch ( Exception e )
        {
            throw e;
        }
    }

    /**
     * @return
     */
    public Object beginTransaction()
    {
        if ( _em == null )
        {
            getSession();
        }
        if ( _et == null )
        {
            _et = _em.getTransaction();
        }
        if ( !_et.isActive() )
        {
            _et.begin();
        }

        return _et;
    }

    /**
     *
     */
    public void finishTransaction()
    {
        if ( _et != null && _et.isActive() )
        {
            _et.commit();
            _et = null;
        }
    }

    /**
     *
     */
    public void revertTransaction()
    {
        if ( _et != null && _et.isActive() )
        {
            _et.rollback();
            _et = null;
        }
    }

    /**
     * @return
     */
    public boolean isTransaction()
    {
        return _isTransaction;
    }

    /**
     * @param transaction
     */
    public void setTransaction( boolean transaction )
    {
        _isTransaction = transaction;
    }

}
