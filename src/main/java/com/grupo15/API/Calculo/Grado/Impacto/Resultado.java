package com.grupo15.API.Calculo.Grado.Impacto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Resultado {
  private long entidad_id;
  private double resultadoGradoImpacto;

  public Resultado(long entidad_id, double resultadoGradoImpacto) {
    this.entidad_id = entidad_id;
    this.resultadoGradoImpacto = resultadoGradoImpacto;
  }
}
