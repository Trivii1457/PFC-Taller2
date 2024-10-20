package taller
import org.scalatest.funsuite.AnyFunSuite

class TestInclusion extends AnyFunSuite {
  val objConjDifusos = new inclusionigualdad()

  test("El conjunto vacío está incluido en el conjunto completo") {
    val conjuntoVacio = objConjDifusos.ConjuntoDifuso(x => 0.0) // Definir conjunto vacío
    val conjuntoCompleto = objConjDifusos.ConjuntoDifuso(x => 1.0) // Definir conjunto completo
    assert(objConjDifusos.inclusion(conjuntoVacio, conjuntoCompleto) == true)
  }

  test("Dos conjuntos difusos iguales") {
    val conjuntoA = objConjDifusos.ConjuntoDifuso(x => if (x % 2 == 0) 0.5 else 0.3)
    val conjuntoB = objConjDifusos.ConjuntoDifuso(x => if (x % 2 == 0) 0.5 else 0.3)
    assert(objConjDifusos.Igualdad(conjuntoA, conjuntoB) == true)
  }

  test("Dos conjuntos difusos diferentes") {
    val conjuntoA = objConjDifusos.ConjuntoDifuso(x => if (x % 2 == 0) 0.5 else 0.3)
    val conjuntoB = objConjDifusos.ConjuntoDifuso(x => if (x % 2 == 0) 0.4 else 0.3)
    assert(objConjDifusos.Igualdad(conjuntoA, conjuntoB) == false)
  }
}