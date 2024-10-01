package taller

class ConJuntosDifusos {
  

    //Definicion del Type
    type ConjuntoDifuso = Int => Double


    //Punto 1.1 (Genracion de Funciones propuestas)
    //------------------------------------------------------------------------------------------------
    def Pertenece(elemen : Int, s: ConjuntoDifuso): Double = {
        s(elemen)
    }


    def  muchoMayorQue(a: Int, m:Int): ConjuntoDifuso = {
        
        def mma(x: Int): Double={
            
            if (x <= a) 0.0
            else if (x > a && x <= m) (x-a).toDouble/(m-a).toDouble
            else 1.0
        
        }
        mma
    }
    //------------------------------------------------------------------------------------------------

    




}
