package taller

class ConJuntosDifusos {
  

    //Definicion del Type
    type ConjuntoDifuso = Int => Double

    object conjDifuso {
        def apply(f: Int => Double): ConjuntoDifuso = f
    }

    //Funcion Aux para redondear decimales
    def redondear(valor: Double): Double = {
    BigDecimal(valor).setScale(3, BigDecimal.RoundingMode.HALF_UP).toDouble
    }


    //Punto 1.1 (Generacion de Funciones propuestas)
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

    //Punto 1.2.1 Conjunto Difuso de numeros grandes

    def grande(d: Int, e: Int): ConjuntoDifuso = {
        
        def Auxgrande(x: Int): Double={
            try {
            redondear(math.pow(x.toDouble / (x + d).toDouble, e.toDouble))
            }catch{
                case e: Exception =>  throw new RuntimeException("error", e) 
            }
        
        }
        Auxgrande
    }

    //Punto 1.2.2 Complemento, Union e Interseccion
    def complemento(s: ConjuntoDifuso): ConjuntoDifuso = {
        //Aux usando match
        def Auxcomplemento(x: Int): Double={
            try{
            s match {
                case s => 1.0 - s(x) 
                
            }
        }catch{
            case e: Exception =>  throw new RuntimeException("error", e) // Valor en caso de que falle
        }

        }
        Auxcomplemento
    }

    def Union(cd1: ConjuntoDifuso, cd2: ConjuntoDifuso): ConjuntoDifuso = {
        //Aux usando match
        def AuxUnion(x: Int): Double={
            try{
            cd1 match {
                case cd1 => if (cd1(x) > cd2(x)) cd1(x) else cd2(x)
                
            }
        }catch{ 
             case e: Exception =>  throw new RuntimeException("error", e) //Valor en caso de error
        }

        }
        AuxUnion
    }

    def Interseccion(cd1: ConjuntoDifuso, cd2: ConjuntoDifuso): ConjuntoDifuso = {
        //Aux usando match
        def AuxInterseccion(x: Int): Double={
            try{
            cd1 match {
                //La interseccion toma el minimo grado de pertenencia entre los dos conjuntos difusos
                case _ => redondear(math.min(cd1(x), cd2(x)))
                
            }
        }catch{
            case e: Exception =>  throw new RuntimeException("error", e)//Valor en caso de error
        }

        }
        AuxInterseccion
    }





}


