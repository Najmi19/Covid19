package com.example.Covid19.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Covid19.R
import com.example.Covid19.presentation.api.CovidListResponse

class CovidAdapter(private var dataSet: List<CovidListResponse>, var listener: ((CovidListResponse) -> Unit )? = null) :
    RecyclerView.Adapter<CovidAdapter.ViewHolder>() {
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            textView = view.findViewById(R.id.covid_country)
            textView.setOnClickListener{

            }
        }
    }

    fun updateList(list: List<CovidListResponse>){
        dataSet = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.covid_item, viewGroup, false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val covid =  dataSet[position]
        viewHolder.textView.text = covid.Country
        viewHolder.itemView.setOnClickListener {
            listener?.invoke(covid);
        }
    }
    override fun getItemCount() = dataSet.size

}
