package com.example.kotlinsql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.sql.PreparedStatement
import java.sql.SQLException

lateinit var TNombre: EditText
lateinit var TCodigo: EditText
lateinit var BEnviar: Button

class MainActivity : AppCompatActivity() {

    private var connectSql = ConnectSql();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        TNombre = findViewById(R.id.txtNombre)
        TCodigo = findViewById(R.id.txtCodigo)
        BEnviar = findViewById(R.id.btnEnviar)


        if(1==1)
        {
            //aahg
        }

        BEnviar.setOnClickListener {
            try {
                val agregarestudiante: PreparedStatement =
                    connectSql.dbConn()?.prepareStatement("insert into estudiantes values(?,?)")!!
                agregarestudiante.setString(1, TNombre.text.toString())
                agregarestudiante.setString(2, TCodigo.text.toString())

                Toast.makeText(this, "Estudiante agregado", Toast.LENGTH_SHORT).show()
            } catch (ex: SQLException) {
                Toast.makeText(this, "Error al ingresar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}