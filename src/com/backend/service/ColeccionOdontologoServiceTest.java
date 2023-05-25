package com.backend.service;

import com.backend.dao.impl.ColeccionOdontologoDao;
import com.backend.entity.Odontologo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColeccionOdontologoServiceTest {
    private static OdontologoService odontologoService = new OdontologoService(new ColeccionOdontologoDao());
    @BeforeAll
    public static void agregar2Odontologos(){
        odontologoService.guardarOdontologo(new Odontologo("123123", "CARLOS", "ASDAD"));
        odontologoService.guardarOdontologo(new Odontologo("432423","MATIAS","DSADAD"));
    }
    @Test
    public void listarTodosLosPacientes(){
        List<Odontologo> odontologosTest = odontologoService.listarOdontologos();
        assertFalse(odontologosTest.isEmpty());
        assertTrue(odontologosTest.size() >= 2);

    }
}