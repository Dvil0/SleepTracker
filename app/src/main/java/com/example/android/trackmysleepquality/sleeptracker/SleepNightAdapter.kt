package com.example.android.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.databinding.ListItemSleepNightBinding

class SleepNightAdapter : RecyclerView.Adapter<SleepNightAdapter.ViewHolder>(){

    var data = listOf<SleepNight>()
        set( value ) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder( holder : ViewHolder, position : Int ){
        val item = data[ position ]
        holder.bind( item )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from( parent )
    }

    class ViewHolder private constructor( val binding : ListItemSleepNightBinding ) : RecyclerView.ViewHolder( binding.root ){

        fun bind( item : SleepNight ){
            binding.sleep = item
            binding.executePendingBindings()
        }

        companion object{
            fun from( parent : ViewGroup ) : ViewHolder{
                val inflater = LayoutInflater.from( parent.context )
                val binding = ListItemSleepNightBinding.inflate( inflater, parent, false)
                return ViewHolder( binding )
            }
        }
    }
}