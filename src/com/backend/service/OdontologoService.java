package com.backend.service;

import com.backend.dao.IDao;
import com.backend.entity.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> OdontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.OdontologoIDao = odontologoIDao;
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return OdontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> listarOdontologos(){
        return OdontologoIDao.listarTodos();
    }


}
