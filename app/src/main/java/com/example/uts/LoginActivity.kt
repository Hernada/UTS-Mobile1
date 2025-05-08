package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uts.MainActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val Username = findViewById<EditText>(R.id.etUsername)
        val Password = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegister = findViewById<TextView>(R.id.tvRegister)

        btnLogin.setOnClickListener {
            val inputUsername = Username.text.toString()
            val inputPassword = Password.text.toString()

            // Ambil data dari SharedPreferences
            val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
            val savedUsername = sharedPref.getString("username", "")
            val savedPassword = sharedPref.getString("password", "")

            if (inputUsername == savedUsername && inputPassword == savedPassword) {
                Toast.makeText(this, "Selamat Datang! $inputUsername", Toast.LENGTH_SHORT).show()
                Log.d("LOGIN", "Login sukses untuk user $inputUsername")

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show()
                Log.d("LOGIN", "Login gagal untuk user $inputUsername")
            }
        }

        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}