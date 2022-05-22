package com.example.wsrfood

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.wsrfood.server.MyRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class LoginScreen : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var pass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        email = findViewById(R.id.email_et)
        pass = findViewById(R.id.pass_et)
    }

    fun LoginClick(view: View) {
        if (email.text.isNotEmpty() && pass.text.isNotEmpty()){
            if (Patterns.EMAIL_ADDRESS.matcher(email.text).matches()){
                val hashMap = HashMap<String, String>()
                hashMap["email"] = email.text.toString()
                hashMap["password"] = pass.text.toString()

                val call = MyRetrofit.getRetrofit().login(hashMap)
                call.enqueue(object : Callback<HashMap<String, Int>>{
                    override fun onResponse(
                        call: Call<HashMap<String, Int>>,
                        response: Response<HashMap<String, Int>>
                    ) {
                        try {
                            val token = response.body()?.get("token")!!
                            getSharedPreferences("data", Context.MODE_PRIVATE).edit().putInt("token", token).apply()
                            Toast.makeText(this@LoginScreen, token.toString(), Toast.LENGTH_LONG).show()

                            startActivity(Intent(this@LoginScreen, MainScreen::class.java))
                        }
                        catch (ex: Exception){
                            AlertDialog.Builder(this@LoginScreen).setTitle("Error").setMessage(ex.message).show()
                        }
                    }

                    override fun onFailure(call: Call<HashMap<String, Int>>, t: Throwable) {
                        AlertDialog.Builder(this@LoginScreen).setTitle("Error").setMessage(t.message).show()
                    }

                })
            }
            else AlertDialog.Builder(this).setTitle("Error").setMessage("Email invalid").show()
        }
        else AlertDialog.Builder(this).setTitle("Error").setMessage("Empty").show()
    }
}