package com.rhabad.service;

import com.rhabad.dao.IIndividuoDAO;
import com.rhabad.domain.Individuo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IndividuoServiceImplement implements IndividuosServices {

    @Autowired
    private IIndividuoDAO indiDAO;


    @Override
    @Transactional(readOnly = true) //solo son de lectura
    public List<Individuo> listaIndividuos() {
        return (List<Individuo>) indiDAO.findAll();
    }

    @Override
    @Transactional
    public void salvar(Individuo individuo) {
        indiDAO.save(individuo);
    }

    @Override
    @Transactional
    public void borrar(Individuo individuo) {
        indiDAO.delete(individuo);
    }

    @Override
    @Transactional(readOnly = true)
    public Individuo traerIndividuo(Individuo individuo) {
        return  indiDAO.findById(individuo.getIdIndividuo()).orElse(null);
    }
}
