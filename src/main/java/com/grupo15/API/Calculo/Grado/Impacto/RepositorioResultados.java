package com.grupo15.API.Calculo.Grado.Impacto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class RepositorioResultados {

  private static RepositorioResultados instance = null;
  private List<Resultado> resultadoList = new ArrayList<>();

  private RepositorioResultados(){
  }

  public static RepositorioResultados getInstance(){
    if(instance == null){
      instance = new RepositorioResultados();
    }
    return instance;
  }

  public Resultado obtenerImpactoEntidadDeId(long id){
    Optional<Resultado> buscado = resultadoList.stream().filter(resultado -> resultado.getEntidad_id() == id).findFirst();
    if (buscado.isPresent()){
      return buscado.get();
    } else {
      return null;
    }
  }
  public void guardarResultado(Resultado resultado){
    Resultado entidadValor = obtenerImpactoEntidadDeId(resultado.getEntidad_id());
    if (entidadValor == null){
      resultadoList.add(resultado);
    } else {
      entidadValor.setResultadoGradoImpacto(resultado.getResultadoGradoImpacto());
    }
  }

  public List<Resultado> obtenerTodosLosResultadosOrdenados(){
    resultadoList.sort(Comparator.comparingDouble(Resultado::getResultadoGradoImpacto).reversed());
    return resultadoList;
  }
}
