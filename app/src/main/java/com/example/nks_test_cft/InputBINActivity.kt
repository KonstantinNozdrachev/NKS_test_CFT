package com.example.nks_test_cft

import InformDataClass
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.cft_test_nks.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InputBINActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextBIN = findViewById<EditText>(R.id.editTextBIN)
        val BIN = editTextBIN.text


        val Button = findViewById<Button>(R.id.button) as Button

        Button.setOnClickListener {

            if (editTextBIN.getText().toString().equals("")) {
                val text = "Введите номер"
                val duration = Toast.LENGTH_LONG
                Toast.makeText(applicationContext, text, duration).show()


            } else {


                val intent = Intent(this, OutputBINActivity::class.java)
                intent.putExtra("bin", editTextBIN.text.toString())
                startActivity(intent)

                  /*val apiInterface = ApiInterface.create().getInformDataClass("$BIN")


        apiInterface.enqueue(object : Callback<InformDataClass> {
            override fun onResponse(call: Call<InformDataClass>?, response: Response<InformDataClass>?) {


            }

            override fun onFailure(call: Call<InformDataClass>?, t: Throwable?) {

            }

        })*/
    }

}


            }
        }


