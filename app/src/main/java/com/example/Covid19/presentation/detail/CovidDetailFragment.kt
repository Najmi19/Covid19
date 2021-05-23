package com.example.Covid19.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.Covid19.R
import com.example.Covid19.presentation.list.Singletons
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CovidDetailFragment : Fragment() {
    private lateinit var textViewConfirmed: TextView
    private lateinit var textViewDeaths: TextView
    private lateinit var textViewRecovered: TextView
    private lateinit var textViewActive: TextView
    private lateinit var textViewCountry: TextView
    private lateinit var textViewDate: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_covid_detail, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewActive = view.findViewById(R.id.covid_detail_active);
        textViewConfirmed = view.findViewById(R.id.covid_detail_confirmed);
        textViewDeaths = view.findViewById(R.id.covid_detail_deaths);
        textViewRecovered=view.findViewById(R.id.covid_detail_recovered);
        textViewDate=view.findViewById(R.id.covid_detail_date);
        textViewCountry=view.findViewById(R.id.covid_detail_country);
        callApi()
    }

    private fun callApi() {
        val id = arguments?.getString("covid") ?: ""
        Singletons.covidApi.getCovidDetail(id).enqueue(object : Callback<List<CovidDetailResponse>> {
            override fun onFailure(call: Call<List<CovidDetailResponse>>, t: Throwable) {
            }
            override fun onResponse(
                call: Call<List<CovidDetailResponse>>,
                response: Response<List<CovidDetailResponse>>
            ) {
                if (response.isSuccessful && response.body() != null){

                    textViewCountry.text = "Pays : " + response.body()!!.last().Country
                    textViewActive.text = "Active : " + response.body()!!.last().Active.toString()
                    textViewConfirmed.text = "Confirmed : " + response.body()!!.last().Confirmed.toString()
                    textViewDeaths.text = "Deaths : " + response.body()!!.last().Deaths.toString()
                    textViewRecovered.text = "Recovered : " + response.body()!!.last().Recovered.toString()
                    textViewDate.text = "Date : "+ response.body()!!.last().Date
                }
            }
        })
}}

