package com.backend.dao.impl;

import com.backend.dao.H2Connection;
import com.backend.dao.IDao;

import com.backend.entity.Odontologo;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);

    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        try{
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);


            PreparedStatement ps = connection.prepareStatement("INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES (?, ?, ?)");
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getApellido());
            ps.setString(1, odontologo.getMatricula());
            ps.execute();

            connection.commit();
            LOGGER.info("Se ha registrado el odontologo: " + odontologo);

        }catch (Exception e){
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if(connection != null){
                try {
                    connection.rollback();
                    System.out.println("Tuvimos un problema");
                    e.printStackTrace();
                } catch (SQLException exception){
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception e){
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + e.getMessage());
                e.printStackTrace();
            }
        }

        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        Connection connection = null;
        List<Odontologo> odontologos= new ArrayList<>();

        try {
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Odontologo odontologo = crearObjetoOdontologo(rs);
                odontologos.add(odontologo);
            }

            LOGGER.info("Listado de todos los odontologos: " + odontologos);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return odontologos;
    }


    private Odontologo crearObjetoOdontologo(ResultSet resultSet) throws SQLException {
        String matriculaOdontologo = resultSet.getString("matricula");
        String nombreOdontologo = resultSet.getString("nombre");
        String apellidoOdontologo = resultSet.getString("apellido");

        return new Odontologo(matriculaOdontologo,nombreOdontologo, apellidoOdontologo);
    }


}


