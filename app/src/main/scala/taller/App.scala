/*
 * This Scala source file was generated by the Gradle 'init' task.
 */
package taller

object App {
  def main(args: Array[String]): Unit = {
    println(greeting())

    //Ejemplo
    val conJuntosDifusos = new ConJuntosDifusos()
    //Como se formateaba esta joda?? 😥😥😥
    println(conJuntosDifusos.Union(conJuntosDifusos.grande(1, 5), conJuntosDifusos.muchoMayorQue(3, 7)))

  }

  def greeting(): String = "Hello, world!"
}
