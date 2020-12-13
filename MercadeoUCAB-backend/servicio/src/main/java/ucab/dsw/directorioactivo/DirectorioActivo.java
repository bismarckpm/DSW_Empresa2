package ucab.dsw.directorioactivo;

import ucab.dsw.dtos.UsuarioDto;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

public class DirectorioActivo
{

    private DirContext _ldapContext;
    private String _url = "ldap://127.0.0.1:10389";
    private String _connType =  "simple";
    private String _directory =  "ou=users,dc=mercadeoucab,dc=com";
    private String _userDirectory =  "cn=%s";
    private String _user =  "admin";
    private String _password =  "secret";

    public DirectorioActivo()
    {}

    private void connectLDAP(String user, String password)
    {
        try
        {
            Hashtable<String, String> environment = new Hashtable<String, String>();
            environment.put( Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory" );
            environment.put( Context.PROVIDER_URL, _url );
            environment.put( Context.SECURITY_AUTHENTICATION, _connType );
            environment.put( Context.SECURITY_PRINCIPAL, String.format( "uid=%s,ou=system", user ) );
            environment.put( Context.SECURITY_CREDENTIALS, password );
            _ldapContext = new InitialDirContext( environment );

        }
        catch ( Exception e ) {
        }
    }

    private void disconnectLDAP()
    {
        try
        {
            _ldapContext.close();
        }
        catch ( Exception e )
        {

        }
    }

    public void addEntryToLdap(UsuarioDto user)
    {

        try
        {
            connectLDAP( _user, _password );
            Attribute oc = new BasicAttribute( "objectClass" );
            oc.add( "top" );
            oc.add( "person" );
            SimpleDateFormat format = new SimpleDateFormat( "yyyyMMddHHmm" );
            BasicAttributes entry = new BasicAttributes();
            entry.put( oc );
            entry.put( new BasicAttribute( "cn", user.get_correo()) );
            entry.put( new BasicAttribute( "sn", user.get_correo() ) );
            entry.put( new BasicAttribute( "userPassword", user.get_contrasena()) );
            entry.put( new BasicAttribute( "pwdLastSuccess", format.format( new Date() ) + "Z" ) );
            entry.put( new BasicAttribute( "description", user.getNombreRol()));
            _ldapContext.createSubcontext( String.format( _userDirectory + "," + _directory, user.get_correo()), entry );

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void deleteEntry(UsuarioDto user)
    {
        try
        {
            connectLDAP( _user, _password );
            _ldapContext.destroySubcontext( String.format(_userDirectory + "," + _directory, user.get_correo()));
        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
        finally
        {
            disconnectLDAP();
        }
    }

    public void getEntry(UsuarioDto user)
    {
        try
        {
            connectLDAP( _user, _password );
            SearchControls searcCon = new SearchControls();
            searcCon.setSearchScope( SearchControls.SUBTREE_SCOPE );
            NamingEnumeration results =
                    _ldapContext.search( _directory, String.format(_userDirectory, user.get_correo()), searcCon );
            if ( results != null )
            {
                while ( results.hasMore() )
                {
                    SearchResult res = ( SearchResult ) results.next();
                    Attributes atbs = res.getAttributes();
                    Attribute atb = atbs.get( "cn" );
                    String name = ( String ) atb.get();
                }
            }
            else
            {
                System.out.println( "fail" );
            }
        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
        finally
        {
            disconnectLDAP();
        }
    }


    public void changePassword(UsuarioDto user)
    {
        try
        {
            connectLDAP( _user, _password );
            ModificationItem[] modificationItems = new ModificationItem[ 1 ];
            modificationItems[0] = new ModificationItem( DirContext.REPLACE_ATTRIBUTE,
                    new BasicAttribute( "userPassword", user.get_contrasena()
                    ) );
            _ldapContext.modifyAttributes(String.format(_userDirectory + "," + _directory, user.get_correo()), modificationItems );
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            disconnectLDAP();
        }
    }

    public long userAuthentication(UsuarioDto user)
    {
        try {
            if (this.userLogin(user) == true) {
                connectLDAP(_user, _password);
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
                ModificationItem[] modificationItems = new ModificationItem[1];
                modificationItems[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute(
                        "pwdLastSuccess", format.format(new Date()) + "Z"));
                _ldapContext.modifyAttributes(String.format(_userDirectory + "," + _directory, user.get_correo()), modificationItems);
                return 1;
            } else {
                return 0;
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return 0;
        }
        finally
        {
            disconnectLDAP();
        }
    }

    public boolean userLogin(UsuarioDto user){
        try
        {
            Hashtable<String, String> environment = new Hashtable<String, String>();
            environment.put( Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory" );
            environment.put( Context.PROVIDER_URL, _url );
            environment.put( Context.SECURITY_AUTHENTICATION, _connType );
            environment.put( Context.SECURITY_PRINCIPAL, String.format( "cn=%s," + _directory, user.get_correo() ) );
            environment.put( Context.SECURITY_CREDENTIALS, user.get_contrasena() );
            _ldapContext = new InitialDirContext( environment );

        }
        catch ( Exception e ) {
        }
        finally{
            if (_ldapContext != null){
                System.out.println("Login success!");
                return true;

            }
            else {
                System.out.println("Login failed!");
                return false;
            }
        }
    }

    public String getEntryRole(UsuarioDto user)
    {
        String role="";
        try
        {
            connectLDAP( _user, _password );
            SearchControls searcCon = new SearchControls();
            searcCon.setSearchScope( SearchControls.SUBTREE_SCOPE );
            NamingEnumeration results =
                    _ldapContext.search( _directory, String.format(_userDirectory, user.get_correo()), searcCon );

            if ( results != null )
            {
                while ( results.hasMore() )
                {
                    SearchResult res = ( SearchResult ) results.next();
                    Attributes atbs = res.getAttributes();
                    Attribute atb = atbs.get( "description" );
                    role = ( String ) atb.get();
                }
            }
            else
            {
                return null;
            }
        }
        catch ( Exception exception )
        {
            exception.printStackTrace();
        }
        finally
        {
            disconnectLDAP();
        }
        System.out.println(role);
        return role;
    }
}

