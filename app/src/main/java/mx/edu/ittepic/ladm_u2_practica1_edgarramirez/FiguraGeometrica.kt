package mx.edu.ittepic.ladm_u2_practica1_edgarramirez

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.view.MotionEvent

class FiguraGeometrica() {
    var x = 0f
    var y = 0f
    var tipo = 1
    var radio = 0f
    var ancho = 0f
    var alto = 0f
    var incY = 3
    var p1x = 0f
    var p1y = 0f
    var p2x = 0f
    var p2y = 0f

    // CONSTRUCTOR DE CIRCULO
    constructor(x: Int, y: Int, radio: Int) : this() {
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.radio = radio.toFloat()
    }

    // CONSTRUCTOR DE RECTANGULO
    constructor(x: Int, y: Int, ancho: Int, alto: Int) : this() {
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.ancho = ancho.toFloat()
        this.alto = alto.toFloat()
        tipo = 2
    }

    // CONSTRUCTOR DE TRIANGULO
    constructor(coordx: Float, coordy: Float, p1x: Float, p1y: Float, p2x: Float, p2y: Float) : this() {
        this.x = coordx.toFloat()
        this.y = coordy.toFloat()
        this.p1x = p1x
        this.p1y = p1y
        this.p2x = p2x
        this.p2y = p2y
        tipo = 3
    }

    // PINTAR FIGURA

    fun pintar(c: Canvas, p: Paint) {
        when (tipo) {
            1 -> {
                c.drawCircle(x, y, radio, p)
            }
            2 -> {
                c.drawRect(x, y, x + ancho, y + alto, p)
            }
            3 -> {
                var path = Path();
                path.moveTo(x, y);
                path.lineTo(p1x, p1y);
                path.lineTo(p2x, p2y);
                c.drawPath(path, p);
            }
        }
    }//PINTAR

    // CAIDA DE OBJETOS
    fun caida(ancho: Int, alto: Int) {
        y += incY
        if (y >= alto) {
            y = -40f
        }
    }//CAIDA

}//FIGURAGEOMETRICA