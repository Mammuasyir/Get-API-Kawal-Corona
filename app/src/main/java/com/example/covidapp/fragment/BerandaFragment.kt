package com.example.covidapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.covidapp.R
import com.example.covidapp.api.ApiConfig
import com.example.covidapp.model.ResponseGetCoronaItem
import kotlinx.android.synthetic.main.fragment_beranda.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BerandaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_beranda, container, false)

        getDataCovid()
        return view
    }

    private fun getDataCovid() {
        ApiConfig.instance.getCovidIndonesia().enqueue(
            object : Callback<List<ResponseGetCoronaItem?>?> {
                override fun onResponse(
                    call: Call<List<ResponseGetCoronaItem?>?>,
                    response: Response<List<ResponseGetCoronaItem?>?>
                ) {
                    val indonesia = response.body()?.get(0)

                    tv_positif.text = indonesia?.positif
                    tv_sembuh.text = indonesia?.sembuh
                    tv_meninggal.text = indonesia?.meninggal
                    tv_rawat.text = indonesia?.dirawat

                }

                override fun onFailure(call: Call<List<ResponseGetCoronaItem?>?>, t: Throwable) {
                    Toast.makeText(activity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

            }
        )
    }




}