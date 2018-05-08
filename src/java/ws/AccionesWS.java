package ws;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import mappers.mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Acciones;
import pojos.Mensaje;

@Path("aciones")
public class AccionesWS {

    @Context
    private UriInfo context;

    public AccionesWS() {
    }
    
    @POST
    @Path("registro")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje RegistrarAccion(
            @FormParam("tiempo") String tiempo,
            @FormParam("nombre") String nombre)
            {

        Mensaje resultado;
        Acciones c = new Acciones(nombre,tiempo);
        SqlSession conn = MyBatisUtil.getSqlSessionFactory();
        try{
            conn.insert("Acciones.registrarTiempo",c);
            conn.commit();
            resultado = new Mensaje("Acción registrada", false);
        }catch(Exception ex){
            resultado = new Mensaje(ex.getMessage(),true);
        }finally{
            conn.close();
        }
        return resultado;
    }
}