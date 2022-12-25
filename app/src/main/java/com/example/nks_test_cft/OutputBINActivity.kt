package com.example.nks_test_cft

import InformDataClass
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.cft_test_nks.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OutputBINActivity : AppCompatActivity() {




    private lateinit var SchemeNetwork: TextView
    private lateinit var Brand: TextView
    private lateinit var Length: TextView
    private lateinit var longitude: TextView
    private lateinit var latitude: TextView
    private lateinit var Prepaid: TextView
    private lateinit var TypeKart: TextView
    private lateinit var NameBank: TextView
    private lateinit var EmailBank: TextView
    private lateinit var TelefonNamber: TextView
    private lateinit var Country: TextView
    private lateinit var Luhn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output_binactivity)





        val bin = intent.extras?.getString("bin")
        val textview = findViewById<TextView>(R.id.outputBIN)
        textview.text = bin




        val BIN = intent.getIntExtra("bin",0)

        SchemeNetwork=findViewById(R.id.schemeNetwork)
        Brand=findViewById(R.id.brand)
        Length=findViewById(R.id.length)
        longitude=findViewById(R.id.longitude)
        Prepaid=findViewById(R.id.prepaid)
        latitude=findViewById(R.id.latitude)
        TypeKart=findViewById(R.id.typeKart)
        NameBank=findViewById(R.id.nameBank)
        EmailBank=findViewById(R.id.emailBank)
        TelefonNamber=findViewById(R.id.telefonNamber)
        Country=findViewById(R.id.country)
        Luhn=findViewById(R.id.luhn)

        val apiInterface = ApiInterface.create().getInformDataClass("$BIN")
        apiInterface.enqueue( object: Callback<InformDataClass> {
            override fun onResponse(
                call: Call<InformDataClass>?,
                response: Response<InformDataClass>?
            ) {


                SchemeNetwork.text = response?.body()?.scheme
                Brand.text = response?.body()?.brand
                Length.text = response?.body()?.number?.length.toString()
                Luhn.text = response?.body()?.number?.luhn.toString()
                longitude.text = response?.body()?.country?.longitude.toString()
                latitude.text = response?.body()?.country?.latitude.toString()
                Prepaid.text = response?.body()?.prepaid.toString()
                TypeKart.text = response?.body()?.type
                NameBank.text = response?.body()?.bank?.name
                EmailBank.text = response?.body()?.bank?.url
                TelefonNamber.text = response?.body()?.bank?.phone
                Country.text = response?.body()?.country?.name


            }
            override fun onFailure(call:Call<InformDataClass>?, t:Throwable?){


            }
        })
    }
}







