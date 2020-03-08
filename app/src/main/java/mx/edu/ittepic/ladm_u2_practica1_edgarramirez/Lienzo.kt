package mx.edu.ittepic.ladm_u2_practica1_edgarramirez

import android.graphics.Canvas
import android.graphics.Paint
import android.view.View
import android.graphics.Color


class Lienzo(p: MainActivity) : View(p) {
    var puntero = p

    // SOL
    var sol = FiguraGeometrica(0, 0, 200)

    // NUBE
    var nube1 = FiguraGeometrica(450, 150, 60)
    var nube2 = FiguraGeometrica(520, 150, 60)
    var nube3 = FiguraGeometrica(570, 150, 60)

    // CASA
    var casa = FiguraGeometrica(270, 800, 400, 300)

    //PUERTA
    var puerta = FiguraGeometrica(500, 960, 100, 140)

    //VENTANA
    var ventana = FiguraGeometrica(350, 970, 50)

    // TECHO
    var techo = FiguraGeometrica(490f, 700f, 250f, 800f, 690f, 800f)
    var punteroFiguraGeometrica: FiguraGeometrica? = null

    // ARBOL
    var tronco = FiguraGeometrica(80, 920, 100, 180)
    var hojas = FiguraGeometrica(130, 930, 80)
    var hojas1 = FiguraGeometrica(130, 830, 80)


    // Dibujar nieve
    var nieve: Array<FiguraGeometrica> =
        Array(500) { FiguraGeometrica((0..720).random(), (-1520..0).random(), 5) }

    // Dibujar pasto
    var pasto = FiguraGeometrica(0,1000,1200,1500)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint = Paint()
        // FONDO
        canvas.drawColor(Color.rgb(108 ,156,252))

        // PASTO
        paint.color = Color.rgb(137,244,29)
        pasto.pintar(canvas,paint)

        // SOL
        paint.color = Color.rgb(242,255,37)
        sol.pintar(canvas, paint)

        // NUBE
        paint.color = Color.rgb(255, 255, 255)
        nube1.pintar(canvas, paint)
        nube2.pintar(canvas, paint)
        nube3.pintar(canvas, paint)

        // CASA
        paint.color = Color.rgb(253, 164, 7)
        casa.pintar(canvas, paint)

        // VENTANA
        paint.color = Color.rgb(161, 162, 159)
        ventana.pintar(canvas, paint)

        // TECHO
        paint.color = Color.rgb(154, 108, 27)
        techo.pintar(canvas, paint)

        // PUERTA
        paint.style = Paint.Style.FILL
        paint.color = Color.rgb(161, 162, 159)
        puerta.pintar(canvas, paint)

        // ARBOL
        paint.color = Color.rgb(88, 44, 20)
        tronco.pintar(canvas, paint)
        paint.color = Color.rgb(15, 95, 16)
        hojas.pintar(canvas, paint)
        hojas1.pintar(canvas, paint)

        // COPOS
        paint.color = Color.WHITE

        (nieve.indices).forEach() {
            nieve[it].pintar(canvas, paint)
        } // Fin del forEach()


    }//ONDRAW

    // CAIDA DE COPOS
    fun caidaNieve() {
        (nieve.indices).forEach() {
            nieve[it].caida(width, height)
        }
        invalidate()
    }//CAIDANIEVE

}//LIENZO