package taller

class inclusionigualdad {
  
    // Función auxiliar para verificar inclusión con recursión de cola
def inclusionAux(cd1: ConjDifuso, cd2: ConjDifuso, elem: Int): Boolean = {

    if (elem > 1000) true
    else if (cd1(elem) > cd2(elem)) false
    else inclusionAux(cd1, cd2, elem + 1)
}

// Función principal de inclusión
def inclusion(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
    inclusionAux(cd1, cd2, 0)  // Comenzamos a iterar desde el elemento 0
}



}
