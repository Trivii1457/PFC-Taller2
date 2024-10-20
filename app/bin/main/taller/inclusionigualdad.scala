package taller

class inclusionigualdad {
  
    type ConjuntoDifuso = Int => Double

    object ConjuntoDifuso {
        def apply(f: Int => Double): ConjuntoDifuso = f
    }



    // Función de alto orden para verificar inclusión
    def inclusion(cd1: ConjuntoDifuso, cd2: ConjuntoDifuso): Boolean = {
        def inclusionAux(elem: Int): Boolean = {
            if (elem > 1000) true 
            else if (cd1(elem) > cd2(elem)) false
            else inclusionAux(elem + 1)
        }
        inclusionAux(0)  // Comenzamos a iterar desde el elemento 0
    }


    //Teniendo en cuenta que sus grados de pertenecia son iguales
    def Igualdad(cd1: ConjuntoDifuso, cd2: ConjuntoDifuso): Boolean = {
        
        def IgualdadAux(elem: Int): Boolean = {
            if (elem > 1000) true // Si llegamos al final de la iteración, entonces los conjuntos son iguales
            else if (cd1(elem) != cd2(elem)) false// Si encontramos un elemento diferente, entonces los conjuntos no son iguales
            else IgualdadAux(elem + 1)// Seguimos iterando en caso de que los elementos sean iguales
        }
        IgualdadAux(0)  // Comenzamos a iterar desde el elemento 0
    }



}
