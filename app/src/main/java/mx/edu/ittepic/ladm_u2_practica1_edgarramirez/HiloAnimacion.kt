package mx.edu.ittepic.ladm_u2_practica1_edgarramirez

class HiloAnimacion(p: MainActivity) : Thread() {
    var puntero = p

    //CONFIGURACION DE LOS COPOS
    override fun run() {
        super.run()
        sleep(3000) // TIEMPO DE ESPERA
        while (true) {
            sleep(100) // VELOCIDAD
            puntero.runOnUiThread {
                puntero.lienzo!!.caidaNieve()
            }
        }
    }//RUN

}//HILOANIMACION