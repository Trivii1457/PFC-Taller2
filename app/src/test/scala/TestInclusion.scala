package taller
import org.scalatest.funsuite.AnyFunSuite

class TestInclusion extends AnyFunSuite {
  val objConjDifusos = new inclusionigualdad()

  // Test Inclusión

 test("El conjunto vacío está incluido en el conjunto completo") {
    val conjuntoVacio = objConjDifusos.ConjuntoDifuso(x => 0.0) // Definir conjunto vacío
    val conjuntoCompleto = objConjDifusos.ConjuntoDifuso(x => 1.0) // Definir conjunto completo
    assert(objConjDifusos.inclusion(conjuntoVacio, conjuntoCompleto) == true)
  }

  test("Conjunto con valores menores está incluido en conjunto con valores mayores") {
    val conjuntoMenor = objConjDifusos.ConjuntoDifuso(x => x * 0.1)
    val conjuntoMayor = objConjDifusos.ConjuntoDifuso(x => x * 0.2)
    assert(objConjDifusos.inclusion(conjuntoMenor, conjuntoMayor) == true)
  }

  test("Conjunto con valores iguales no está incluido en conjunto con valores menores") {
    val conjuntoIgual = objConjDifusos.ConjuntoDifuso(x => x * 0.2)
    val conjuntoMenor = objConjDifusos.ConjuntoDifuso(x => x * 0.1)
    assert(objConjDifusos.inclusion(conjuntoIgual, conjuntoMenor) == false)
  }

  test("Conjunto con valores aleatorios está incluido en conjunto con valores constantes mayores") {
    val conjuntoAleatorio = objConjDifusos.ConjuntoDifuso(x => if (x % 2 == 0) 0.3 else 0.5)
    val conjuntoConstante = objConjDifusos.ConjuntoDifuso(x => 0.6)
    assert(objConjDifusos.inclusion(conjuntoAleatorio, conjuntoConstante) == true)
  }

  test("Conjunto con valores decrecientes no está incluido en conjunto con valores crecientes") {
    val conjuntoDecreciente = objConjDifusos.ConjuntoDifuso(x => 1.0 - (x * 0.1))
    val conjuntoCreciente = objConjDifusos.ConjuntoDifuso(x => x * 0.1)
    assert(objConjDifusos.inclusion(conjuntoDecreciente, conjuntoCreciente) == false)
  }

  //test Igualdad

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

  test("Conjunto con valores constantes iguales") {
    val conjuntoA = objConjDifusos.ConjuntoDifuso(x => 0.5)
    val conjuntoB = objConjDifusos.ConjuntoDifuso(x => 0.5)
    assert(objConjDifusos.Igualdad(conjuntoA, conjuntoB) == true)
  }

  test("Conjunto con valores constantes diferentes") {
    val conjuntoA = objConjDifusos.ConjuntoDifuso(x => 0.5)
    val conjuntoB = objConjDifusos.ConjuntoDifuso(x => 0.6)
    assert(objConjDifusos.Igualdad(conjuntoA, conjuntoB) == false)
  }

  test("Conjunto con valores crecientes iguales") {
    val conjuntoA = objConjDifusos.ConjuntoDifuso(x => x * 0.1)
    val conjuntoB = objConjDifusos.ConjuntoDifuso(x => x * 0.1)
    assert(objConjDifusos.Igualdad(conjuntoA, conjuntoB) == true)
  }

  test("Conjunto con valores crecientes diferentes") {
    val conjuntoA = objConjDifusos.ConjuntoDifuso(x => x * 0.1)
    val conjuntoB = objConjDifusos.ConjuntoDifuso(x => x * 0.2)
    assert(objConjDifusos.Igualdad(conjuntoA, conjuntoB) == false)
  }
}