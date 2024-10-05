package taller
import  org.scalatest.funsuite.AnyFunSuite

class TestConjDifusos extends  AnyFunSuite{

    val objConjDifusos = new ConJuntosDifusos()

    test("Pertenece 3 en muchoMayorQue(3, 7)"){
        assert(objConjDifusos.Pertenece(3, objConjDifusos.muchoMayorQue(3, 7)) == 0.0)
    }
    //------------------------------------------------------------------------------------------------

    //Test Grande, Complemento, Union e Interseccion

    test("Grande con valor normal 1") {
        assert(objConjDifusos.grande(1, 5)(3) == 0.5)
    }

    test("Grande con valor normal 2") {
        assert(objConjDifusos.grande(1, 5)(4) == 0.75)
    }

    test("Grande con valor grande 1") {
        assert(objConjDifusos.grande(1, 1000)(500) == 0.5)
    }

    test("Grande con valor grande 2") {
        assert(objConjDifusos.grande(1, 1000)(999) == 0.999)
    }

    // Test para la función Complemento
    test("Complemento con valor normal 1") {
        assert(objConjDifusos.complemento(objConjDifusos.grande(1, 5))(3) == 0.5)
    }

    test("Complemento con valor normal 2") {
        assert(objConjDifusos.complemento(objConjDifusos.grande(1, 5))(4) == 0.25)
    }

    test("Complemento con valor grande 1") {
        assert(objConjDifusos.complemento(objConjDifusos.grande(1, 1000))(500) == 0.5)
    }

    test("Complemento con valor grande 2") {
        assert(objConjDifusos.complemento(objConjDifusos.grande(1, 1000))(999) == 0.001)
    }

    test("Complemento con valor fuera de rango") {
        assertThrows[RuntimeException] {
            objConjDifusos.complemento(objConjDifusos.grande(1, 5))(-1)
        }
    }

    // Test para la función Union
    test("Union con valor normal 1") {
        assert(objConjDifusos.Union(objConjDifusos.grande(1, 5), objConjDifusos.muchoMayorQue(3, 7))(3) == 0.5)
    }

    test("Union con valor normal 2") {
        assert(objConjDifusos.Union(objConjDifusos.grande(1, 5), objConjDifusos.muchoMayorQue(3, 7))(4) == 0.75)
    }

    test("Union con valor grande 1") {
        assert(objConjDifusos.Union(objConjDifusos.grande(1, 1000), objConjDifusos.muchoMayorQue(500, 1000))(500) == 0.5)
    }

    test("Union con valor grande 2") {
        assert(objConjDifusos.Union(objConjDifusos.grande(1, 1000), objConjDifusos.muchoMayorQue(500, 1000))(999) == 0.999)
    }

    test("Union con valor fuera de rango") {
        assertThrows[RuntimeException] {
            objConjDifusos.Union(objConjDifusos.grande(1, 5), objConjDifusos.muchoMayorQue(3, 7))(-1)
        }
    } 


  
}
