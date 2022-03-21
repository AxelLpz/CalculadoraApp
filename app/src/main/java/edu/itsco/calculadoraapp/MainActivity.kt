package edu.itsco.calculadoraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var oper:Int=0
    var numero1:Double=0.0
    lateinit var tv_num1:TextView
    lateinit var tv_num2:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_num1=findViewById(R.id.tv_num1)
        tv_num2=findViewById(R.id.tv_num2)
        val btnBorrar:Button=findViewById(R.id.btn_limpiar)
        val btnIgual:Button=findViewById(R.id.btn_igual)
        val btnRetroceso:ImageButton=findViewById(R.id.btn_retroceso)

        btnIgual.setOnClickListener {
            var numero2:Double=tv_num2.text.toString().toDouble()
            var resp:Double=0.0

            when(oper){
                1-> resp = numero1 + numero2
                2-> resp = numero1 - numero2
                3-> resp = numero1 * numero2
                4-> resp = numero1 / numero2
            }

            tv_num2.setText(resp.toString())
            tv_num1.setText(" ")

        }

        btnBorrar.setOnClickListener {
            tv_num1.setText("")
            tv_num2.setText("")
            numero1 = 0.0
            oper = 0
        }

        btnRetroceso.setOnClickListener{
            val lenght = tv_num2.length()
            if (lenght > 0)
                tv_num2.text = tv_num2.text.subSequence(0,lenght - 1)
        }

    }
    fun presionarDigito(view: View){
        var num2:String=tv_num2.text.toString()

        when(view.id){
            R.id.btn0->tv_num2.setText(num2+"0")
            R.id.btnUno->tv_num2.setText(num2+"1")
            R.id.btnDos->tv_num2.setText(num2+"2")
            R.id.btnTres->tv_num2.setText(num2+"3")
            R.id.btnCuatro->tv_num2.setText(num2+"4")
            R.id.btnCinco->tv_num2.setText(num2+"5")
            R.id.btnSeis->tv_num2.setText(num2+"6")
            R.id.btnSiete->tv_num2.setText(num2+"7")
            R.id.btnOcho->tv_num2.setText(num2+"8")
            R.id.btnNueve->tv_num2.setText(num2+"9")
            R.id.btn_punto->tv_num2.setText(num2+".")

        }

    }
    fun ClicOperacion(view: View){
        numero1=tv_num2.text.toString().toDouble()
        var num2_Text:String=tv_num2.text.toString()
        tv_num2.setText(" ")
        when(view.id){
            R.id.btn_suma->{
                tv_num1.setText(num2_Text+"+")
                oper=1
            }
            R.id.btn_resta->{
                tv_num1.setText(num2_Text+"-")
                oper=2
            }
            R.id.btn_multi->{
                tv_num1.setText(num2_Text+"*")
                oper=3
            }
            R.id.btn_div->{
                tv_num1.setText(num2_Text+"/")
                oper=4
            }
        }
   }


}