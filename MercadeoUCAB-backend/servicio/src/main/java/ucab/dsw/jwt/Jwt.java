package ucab.dsw.jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import ucab.dsw.dtos.UsuarioDto;

import java.util.Date;

public class Jwt {
    private String KEY;

    public Jwt() {
        this.KEY = "dsw.mercadeoucab";
    }

    public String generarToken(UsuarioDto usuarioDto){


        try{
            String token=Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256,KEY)
                    .setSubject(usuarioDto.get_correo())
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis()+300000))
                    .compact();

            return token;

        }catch(Exception ex){
            return ex.getMessage();
        }

    }
}