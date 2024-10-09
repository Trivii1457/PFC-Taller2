package taller
import  org.scalatest.funsuite.AnyFunSuite

val objConjDifusos = new inclusionigualdad()

class TestInclusion {
    test("El conjunto vacío está incluido en el conjunto completo") {
    assert( objConjDifusos.inclusion() == true)
  }

  

}
