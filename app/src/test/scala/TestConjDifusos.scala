package taller
import  org.scalatest.funsuite.AnyFunSuite

class TestConjDifusos extends  AnyFunSuite{

    val objConjDifusos = new ConJuntosDifusos()

    test("Pertenece 3 en muchoMayorQue(3, 7)"){
        assert(objConjDifusos.Pertenece(3, objConjDifusos.muchoMayorQue(3, 7)) == 0.0)
    }
    
  
}
