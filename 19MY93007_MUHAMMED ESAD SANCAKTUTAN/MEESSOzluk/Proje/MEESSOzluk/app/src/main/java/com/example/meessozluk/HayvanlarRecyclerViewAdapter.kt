package com.example.meesozluk

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.meessozluk.DetayActivity
import com.example.meessozluk.FilterHelper
import com.example.meessozluk.Hayvan
import com.example.meessozluk.R
import kotlinx.android.synthetic.main.tek_uye.view.*


class HayvanlarRecyclerViewAdapter(tumHayvanlar:ArrayList<Hayvan>) : RecyclerView.Adapter<HayvanlarRecyclerViewAdapter.HayvanViewHolder>(), Filterable {

    var hayvanlar=tumHayvanlar
    var myFilter:FilterHelper= FilterHelper(tumHayvanlar, this)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HayvanViewHolder {
        var inflater=LayoutInflater.from(parent?.context)
        var tek_uye= inflater.inflate(R.layout.tek_uye, parent,false)

        return HayvanViewHolder(tek_uye)

    }

    override fun getItemCount(): Int {
        return hayvanlar.size

    }

    override fun onBindViewHolder(holder: HayvanViewHolder, position: Int) {

        var oanOlusturulanHayvan=hayvanlar.get(position)
        holder?.setData(oanOlusturulanHayvan, position)

    }

    fun setFilter(arrayList: ArrayList<Hayvan>) {

        hayvanlar = arrayList
    }

    inner class HayvanViewHolder(tekUye: View) : RecyclerView.ViewHolder(tekUye) {

        var tekHayvanBilgisi=tekUye as CardView

        var hayvanAd=tekHayvanBilgisi.tvHayvanAdi
        var hayvanResim=tekHayvanBilgisi.imgHayvan

        fun setData(oanOlusturulanHayvan: Hayvan, position: Int){

            hayvanAd.text=oanOlusturulanHayvan.isim
            hayvanResim.setImageResource(oanOlusturulanHayvan.resim)

            tekHayvanBilgisi.setOnClickListener{ v ->
                Toast.makeText(tekHayvanBilgisi.context,"Tıklanılan Öğe : " + position + " Adı:"+oanOlusturulanHayvan.isim, Toast.LENGTH_SHORT).show()
                var intent= Intent(v.context, DetayActivity::class.java)
                intent.putExtra("ad", oanOlusturulanHayvan.isim)
                intent.putExtra("resim", oanOlusturulanHayvan.resim)
                v.context.startActivity(intent)
            }


        }

    }

    override fun getFilter(): Filter {
        return myFilter
    }



}