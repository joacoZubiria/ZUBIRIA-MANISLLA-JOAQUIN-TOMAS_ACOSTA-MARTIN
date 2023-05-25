package com.backend.service;

import com.backend.dao.IDao;
import com.backend.entity.Odontologo;

import java.util.List;

public class ColeccionOdontologoService {
    private IDao<Odontologo> coleccionOdontologoIDao;

    public ColeccionOdontologoService(IDao<Odontologo> coleccionOdontologoIDao) {
        this.coleccionOdontologoIDao = coleccionOdontologoIDao;
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return coleccionOdontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> listarOdontologos(){
        return coleccionOdontologoIDao.listarTodos();
    }
}
