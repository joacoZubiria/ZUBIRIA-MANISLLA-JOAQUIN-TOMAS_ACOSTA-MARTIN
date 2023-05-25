package com.backend.dao.impl;

import com.backend.dao.IDao;
import com.backend.entity.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ColeccionOdontologoDao implements IDao<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);
    private List<Odontologo> odontologos = new ArrayList<>();
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologos.add(odontologo);
        LOGGER.info("Se agregó el odontologo " + odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        for(Odontologo odontologo : odontologos){
            LOGGER.info(odontologo.getMatricula() + "-" + odontologo.getNombre() + "-" + odontologo.getApellido());
        }
        return odontologos;
    }
}
