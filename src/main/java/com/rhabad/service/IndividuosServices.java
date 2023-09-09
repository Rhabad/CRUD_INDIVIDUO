package com.rhabad.service;

import com.rhabad.domain.Individuo;

import java.util.List;

public interface IndividuosServices {

    public List<Individuo> listaIndividuos();

    public void salvar(Individuo individuo);

    public void borrar(Individuo individuo);

    public Individuo traerIndividuo(Individuo individuo);

}
