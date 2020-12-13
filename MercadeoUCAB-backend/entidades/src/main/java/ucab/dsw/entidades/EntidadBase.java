package ucab.dsw.entidades;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class EntidadBase implements Serializable
{

    @Id
    @Column( name = "Id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long _id;

    @Column(name = "estatus")
    private String _estatus;

    //endregion

    //region Method


    public EntidadBase( long id )
    {
        _id = id;
    }

    public EntidadBase (String estatus) {
        _estatus = estatus;
    }

    public EntidadBase()
    {
    }


    public long get_id()
    {
        return _id;
    }

    public String get_estatus() {
        return _estatus;
    }

    public void set_estatus(String _estatus) {
        this._estatus = _estatus;
    }
}
