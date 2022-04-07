/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadmuseo;

import cadmuseo.museo.Obra;
import cadmuseo.museo.Artista;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paula Unibaso
 */
public class CadMUSEO {

    Connection conexion;

    /**
     * ConstructoR Utiliza la librería de Oracle
     *
     * @throws ExcepcionMUSEO En caso de algún error se produce la excepción
     * personalizada a través de MuseoException
     */
    public CadMUSEO() throws ExcepcionMUSEO {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            ExcepcionMUSEO e = new ExcepcionMUSEO();
            e.setCodigoError(null);
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(null);
            e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador");
            throw e;
        }
    }

    /**
     * Método para crear la conexión a la Base de Datos
     *
     * @throws ExcepcionMUSEO
     */
    private void conectarMUSEO() throws ExcepcionMUSEO {
        try {
          //conexion = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.69:1521:test", "MUSEO", "kk");
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@172.16.200.69:1521:test", "MUSEO", "kk");

        } catch (SQLException ex) {
            ExcepcionMUSEO e = new ExcepcionMUSEO();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(null);
            e.setMensajeErrorUsuario("Error general del sistema. Consule con el administrador ");
            throw e;
        }
    }

    /**
     * Método para insertar un nueva artista en la Base de datos
     *
     * @param artista Objeto Artista con todos los datos que se quieren insertar
     * @return Cantidad de registros insertados (1 si se ha insertado, 0 si no.)
     * @throws ExcepcionMUSEO En caso de algún error se produce la excepción
     * personalizada a través de MuseoException
     */
    public int insertarArtista(Artista artista) throws ExcepcionMUSEO {
        conectarMUSEO();
        int registrosAfectados = 0;
        String dml = null;
        try {
            dml = "{call insertar_artista(?,?,?,?,?,?)}";

            CallableStatement cs = conexion.prepareCall(dml);
            cs.setObject(1, artista.getAlias());
            cs.setObject(2, artista.getNombre());
            cs.setObject(3, artista.getApellido());
            cs.setObject(4, artista.getDNI());
            cs.setObject(5, artista.getTlfn());
            cs.setObject(6, artista.getEmail());
            registrosAfectados = cs.executeUpdate();
            cs.close();
            conexion.close();

        } catch (SQLException ex) {
            ExcepcionMUSEO e = new ExcepcionMUSEO();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(dml);
            switch (ex.getErrorCode()) {
                case 1:
                    e.setMensajeErrorUsuario("El alias, el DNI y el email deben ser únicos");
                    break;
                case 1400:
                    e.setMensajeErrorUsuario("El nombre, el apellido, el DNI, y el teléfono son obligatorios");
                    break;
                case 2291:
                    e.setMensajeErrorUsuario("EL DNI y el teléfono deben tener 9 caracteres exactos");
                    break;
                case 12899:
                    e.setMensajeErrorUsuario("EL DNI debe tener 8 números y 1 letra");
                    break;
                case 2290:
                    e.setMensajeErrorUsuario("Error en el formato: El email debe llevar el caracter \"@\", el DNI 8 dígitos y una letra, y el teléfono 9 dígitos.");
                    break;
                case 20004:
                    e.setMensajeErrorUsuario(" El nombre de la obra no puede contener al alias del artista.");
                    break;
                default:
                    e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador.");
            }
            throw e;
        }
        return registrosAfectados;
    }

    /**
     * Método para eliminar un artista de la Base de datos
     *
     * @param artistaId id del artista que se quiere eliminar
     * @return Cantidad de registros insertados (1 si se ha eliminado, 0 si no)
     * @throws ExcepcionMUSEO En caso de algún error se produce la excepción
     * personalizada a través de MuseoException
     */
    public int eliminarArtista(Integer artistaId) throws ExcepcionMUSEO {
        conectarMUSEO();

        String dml = "delete from Artista where Artista_id=" + artistaId;
        int registrosAfectados = 0;

        try {
            Statement sentencia = conexion.createStatement();
            registrosAfectados = sentencia.executeUpdate(dml);
            sentencia.close();
            conexion.close();

        } catch (SQLException ex) {
            ExcepcionMUSEO e = new ExcepcionMUSEO();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(dml);
            switch (ex.getErrorCode()) {
                case 904:
                    e.setMensajeErrorUsuario("No existe un artista con el identificador indicado.");
                case 2292:
                    e.setMensajeErrorUsuario("No se puede eliminar el artista porque tiene obras asociadas");
                    break;
                default:
                    e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador.");
            }
            throw e;
        }
        return registrosAfectados;
    }

    /**
     * Método para actualizar la información de un artista
     *
     * @param artistaId id del artista que se quiere actualizar
     * @param a objeto de tipo Artista con los datos nuevos
     * @return Cantidad de registros modificados (1 si se ha modificado, 0 si
     * no)
     * @throws ExcepcionMUSEO En caso de algún error se produce la excepción
     * personalizada a través de MuseoException
     */
    public int actualizarArtista(Integer artistaId, Artista a) throws ExcepcionMUSEO {

        conectarMUSEO();
        int registrosafectados = 0;
        String dml = "update ARTISTA set ALIAS = ?, NOMBRE = ?, APELLIDO = ?, DNI = ?, TLFN = ?, EMAIL = ? where ARTISTA_ID = ?";
        try {
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(dml);
            sentenciaPreparada.setObject(1, a.getAlias());
            sentenciaPreparada.setObject(2, a.getNombre());
            sentenciaPreparada.setObject(3, a.getApellido());
            sentenciaPreparada.setObject(4, a.getDNI());
            sentenciaPreparada.setObject(5, a.getTlfn());
            sentenciaPreparada.setObject(6, a.getEmail());
            sentenciaPreparada.setInt(7, artistaId);
            registrosafectados = sentenciaPreparada.executeUpdate();
            sentenciaPreparada.close();
            conexion.close();

        } catch (SQLException ex) {
            ExcepcionMUSEO e = new ExcepcionMUSEO();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(dml);

            switch (ex.getErrorCode()) {
                case 1:
                    e.setMensajeErrorUsuario("El alias y el email deben ser únicos.");
                    break;
                case 1407:
                    e.setMensajeErrorUsuario("El nombre, el apellido, el DNI, y el teléfono son obligatorios");
                    break;
                // case 2292:
                //    e.setMensajeErrorUsuario("No se puede moficiar el id del artista");
                case 2290:
                    e.setMensajeErrorUsuario("Error en el formato: El email debe llevar el caracter \"@\", el DNI 8 dígitos y una letra, y el teléfono 9 dígitos.");
                    break;
                case 12899:
                    e.setMensajeErrorUsuario("EL DNI y el teléfono deben tener 9 caracteres exactos");
                    break;
                case 20004:
                    e.setMensajeErrorUsuario(" El nombre de la obra no puede contener al alias del artista.");
                    break;
                default:
                    e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador.");
            }
            throw e;
        }
        return registrosafectados;
    }

    /**
     * Método para buscar la información de un artista de la Base de Datos
     *
     * @param artistaId El id del artista que se quiere buscar
     * @return a Devuelve un artista con la informacion encontrada en la BD
     * @throws ExcepcionMUSEO En caso de algún error se produce la excepción
     * personalizada a través de MuseoException
     *
     */
    public Artista buscarArtista(Integer artistaId) throws ExcepcionMUSEO {
        Artista a = new Artista();
        conectarMUSEO();
        String dml = "select * from ARTISTA where Artista_ID = ?";
        try {

            PreparedStatement sentenciaPreparada = conexion.prepareStatement(dml);
            sentenciaPreparada.setInt(1, artistaId);
            ResultSet resultado = sentenciaPreparada.executeQuery();

            resultado.next();
            a.setArtistaId(resultado.getInt("ARTISTA_ID"));
            a.setAlias(resultado.getString("ALIAS"));
            a.setNombre(resultado.getString("NOMBRE"));
            a.setApellido(resultado.getString("APELLIDO"));
            a.setDNI(resultado.getString("DNI"));
            a.setTlfn(resultado.getString("TLFN"));
            a.setEmail(resultado.getString("EMAIL"));

            sentenciaPreparada.close();
            conexion.close();

        } catch (SQLException ex) {
            ExcepcionMUSEO e = new ExcepcionMUSEO();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(dml);
            switch (ex.getErrorCode()) {

                case 17011:
                    e.setMensajeErrorUsuario("No existe ningún artista con ese ID.");
                    break;
                default:
                    e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador.");

            }
            throw e;
        }
        return a;
    }

    /**
     * Método para ver todos los artistas de la Base de datos
     *
     * @return ListaArtistas. Devuelve un ArrayList con la lista de artistas
     * @throws ExcepcionMUSEO En caso de algún error se produce la excepción
     * personalizada a través de MuseoException
     */
    public ArrayList<Artista> leerArtistas() throws ExcepcionMUSEO {
        ArrayList<Artista> listaArtistas = new ArrayList<Artista>();
        conectarMUSEO();
        String dql1 = "select * from ARTISTA";

        try {
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(dql1);

            while (resultado.next()) {
                Artista a = new Artista();
                a.setArtistaId(resultado.getInt("ARTISTA_ID"));
                a.setAlias(resultado.getString("ALIAS"));
                a.setNombre(resultado.getString("NOMBRE"));
                a.setApellido(resultado.getString("APELLIDO"));
                a.setDNI(resultado.getString("DNI"));
                a.setTlfn(resultado.getString("TLFN"));
                a.setEmail(resultado.getString("EMAIL"));
                listaArtistas.add(a);
            }
            resultado.close();

            sentencia.close();
            conexion.close();
        } catch (SQLException ex) {
            ExcepcionMUSEO e = new ExcepcionMUSEO();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(dql1);
            e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador.");

            throw e;
        }
        return listaArtistas;
    }

    /**
     * Método para insertar una nueva Obra en la Base de datos
     *
     * @param obra Objeto Artista con todos los datos que se quieren insertar
     * @return Cantidad de registros insertados (1 si se ha insertado, 0 si no.)
     * @throws ExcepcionMUSEO En caso de algún error se produce la excepción
     * personalizada a través de MuseoException
     */
    public int insertarObra(Obra obra) throws ExcepcionMUSEO {
        conectarMUSEO();
        int registrosafectados = 0;
        String dml = "insert into OBRA(OBRA_ID, OBRA_NOMBRE, ARTISTA_ID)"
                + "values (OBRA_SEQ.nextval, ?, ?)";
        try {
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(dml);
            sentenciaPreparada.setObject(1, obra.getNombreObra());
            sentenciaPreparada.setObject(2, obra.getArtista().getArtistaId());
            registrosafectados = sentenciaPreparada.executeUpdate();
            sentenciaPreparada.close();
            conexion.close();
        } catch (SQLException ex) {
            ExcepcionMUSEO e = new ExcepcionMUSEO();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(dml);

            switch (ex.getErrorCode()) {
                case 1400:
                    e.setMensajeErrorUsuario("El nombre de la obra y el identificador del artista son obligatorios.");
                    break;
                case 1403:
                    e.setMensajeErrorUsuario("No existe el artista seleccionado.");
                case 2291:
                    e.setMensajeErrorUsuario("No existe el artista seleccionado.");
                    break;
                case 20002:
                    e.setMensajeErrorUsuario(" El nombre de la obra no puede contener el alias del artista.");
                    break;
                default:
                    e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador.");
            }
            throw e;

        }

        return registrosafectados;
    }

    /**
     * Método para eliminar una obra de la Base de datos
     *
     * @param obraId id de la obra que se quiere eliminar
     * @return Cantidad de registros insertados (1 si se ha eliminado, 0 si no)
     * @throws ExcepcionMUSEO En caso de algún error se produce la excepción
     * personalizada a través de MuseoException
     */
    public int eliminarObra(Integer obraId) throws ExcepcionMUSEO {
        conectarMUSEO();

        String dml = "delete from OBRA where OBRA_ID = " + obraId;
        int registrosAfectados = 0;

        try {
            Statement sentencia = conexion.createStatement();
            registrosAfectados = sentencia.executeUpdate(dml);
            sentencia.close();
            conexion.close();

        } catch (SQLException ex) {
            ExcepcionMUSEO e = new ExcepcionMUSEO();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(dml);
            switch (ex.getErrorCode()) {
                default:
                    e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador.");
            }
            throw e;
        }
        return registrosAfectados;
    }

    /**
     * Método para actualizar la información de un artista
     *
     * @param obraId id de la obra que se quiere actualizar
     * @param o objeto de tipo Obra con los datos nuevos
     * @return Cantidad de registros modificados (1 si se ha modificado, 0 si
     * no)
     * @throws ExcepcionMUSEO En caso de algún error se produce la excepción
     * personalizada a través de MuseoException
     */
    public int actualizarObra(Integer obraId, Obra o) throws ExcepcionMUSEO {
        conectarMUSEO();
        int registrosAfectados = 0;
        String dml = null;
        try {
            dml = "{call actualizar_obra(?,?,?)}";
            CallableStatement cs = conexion.prepareCall(dml);
            cs.setInt(1, obraId);
            cs.setObject(2, o.getNombreObra());
            cs.setObject(3, o.getArtista().getArtistaId());

            registrosAfectados = cs.executeUpdate();
            cs.close();
            conexion.close();

        } catch (SQLException ex) {
            ExcepcionMUSEO e = new ExcepcionMUSEO();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(dml);
            switch (ex.getErrorCode()) {
                case 1407:
                    e.setMensajeErrorUsuario("El nombre de la obra y el identificador del artista son obligatorios.");
                    break;
                case 1403:
                    e.setMensajeErrorUsuario("No existe ningúna artista con ese identificador.");
                    break;
                case 20002:
                    e.setMensajeErrorUsuario(" El nombre de la obra no puede contener el alias del artista.");
                    break;
                default:
                    e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador.");
            }
            throw e;
        }
        return registrosAfectados;
    }

    /**
     * Método para buscar una obra
     *
     * @param obraId Id de la obra que se quiere buscar
     * @return o Devuelve un objeto de Obra con los datos de la misma
     * @throws ExcepcionMUSEO En caso de algún error se produce la excepción
     * personalizada a través de MuseoException
     */
    public Obra buscarObra(Integer obraId) throws ExcepcionMUSEO {
        Obra o = new Obra();
        conectarMUSEO();
        CadMUSEO cad = new CadMUSEO();
        String dml = "select * from OBRA where OBRA_ID = ?";
        try {

            PreparedStatement sentenciaPreparada = conexion.prepareStatement(dml);
            sentenciaPreparada.setInt(1, obraId);

            ResultSet resultado = sentenciaPreparada.executeQuery();

            resultado.next();
            o.setObraId(resultado.getInt("OBRA_ID"));
            o.setNombreObra(resultado.getString("OBRA_NOMBRE"));
            Artista a = new Artista();            
            a.setArtistaId(resultado.getInt("ARTISTA_ID"));
            int idaux = resultado.getInt("ARTISTA_ID");
            a = cad.buscarArtista(idaux);   
                 
            o.setArtista(a);
            

            sentenciaPreparada.close();
            conexion.close();

        } catch (SQLException ex) {
            ExcepcionMUSEO e = new ExcepcionMUSEO();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(dml);
            switch (ex.getErrorCode()) {

                case 17011:
                    e.setMensajeErrorUsuario("No existe ninguna obra con ese ID.");
                    break;
                default:
                    e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador.");

            }
            throw e;
        }

        return o;
    }

    /**
     * Método para ver todos los artistas de la Base de datos
     *
     * @return ListaObras Devuelve un ArrayList con la lista de obras
     * @throws ExcepcionMUSEO En caso de algún error se produce la excepción
     * personalizada a través de MuseoException
     */
    public ArrayList<Obra> leerObras() throws ExcepcionMUSEO {

        ArrayList<Obra> listaObras = new ArrayList<Obra>();
        conectarMUSEO();
        String dql1 = "select * from ARTISTA A, OBRA O where O.ARTISTA_ID = A.ARTISTA_ID";

        try {
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(dql1);

            while (resultado.next()) {
                Obra o = new Obra();
                o.setObraId(resultado.getInt("OBRA_ID"));
                o.setNombreObra(resultado.getString("OBRA_NOMBRE"));
                Artista a = new Artista();
                a.setArtistaId(resultado.getInt("ARTISTA_ID"));
                a.setAlias(resultado.getString("ALIAS"));
                o.setArtista(a);
                listaObras.add(o);
            }
            resultado.close();

            sentencia.close();
            conexion.close();
        } catch (SQLException ex) {
            ExcepcionMUSEO e = new ExcepcionMUSEO();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(dql1);
            e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador.");
            throw e;
        }
        return listaObras;

    }
}
