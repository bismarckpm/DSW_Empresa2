/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.dsw.accesodatos;

/**
 *
 * @author Emanuel
 */

import ucab.dsw.entidades.NivelEconomico;
import javax.persistence.EntityManager;

public class DaoNivelEconomico extends Dao<NivelEconomico>{
    
    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();
    
    public DaoNivelEconomico(){
        super( _handler );
    }
    
}
