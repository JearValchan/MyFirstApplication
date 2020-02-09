package valencia.armando.myfirstapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var contador: Int = 0
    var num: Int = 0
    var numAnterior: Int = 0
    var base = 0
    var tope = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val label: TextView = findViewById(R.id.etiqutaPrincipal)
        val down: Button = findViewById(R.id.down)
        val up: Button = findViewById(R.id.up)
        val generate: Button = findViewById(R.id.generate)
        up.isEnabled = false
        up.visibility = android.view.View.INVISIBLE
        down.isEnabled = false
        down.visibility = android.view.View.INVISIBLE

        generate.setOnClickListener {
            base = 0
            tope = 100
            num = Random.nextInt(base ,tope)
            label.setText(""+num+"")
            up.isEnabled = true
            up.visibility = android.view.View.VISIBLE
            down.isEnabled = true
            down.visibility = android.view.View.VISIBLE
        }

        up.setOnClickListener{
            base = num
            if (((tope - base) == 1)){
                label.setText("Ya adiviné!")
                up.isEnabled = false
                up.visibility = android.view.View.INVISIBLE
                down.isEnabled = false
                down.visibility = android.view.View.INVISIBLE
            }else{
                numAnterior = num
                num = Random.nextInt(base, tope)
                if (num == numAnterior) num = Random.nextInt(base, tope) else label.setText(""+num+"")
            }
        }

        down.setOnClickListener{
            tope = num
            if (((tope - base) == 1)){
                label.setText("Ya adiviné!")
                up.isEnabled = false
                up.visibility = android.view.View.INVISIBLE
                down.isEnabled = false
                down.visibility = android.view.View.INVISIBLE
            }else{
                numAnterior = num
                num = Random.nextInt(base, tope)
                if (num == numAnterior) num = Random.nextInt(base, tope) else label.setText(""+num+"")
            }
        }
    }
}
