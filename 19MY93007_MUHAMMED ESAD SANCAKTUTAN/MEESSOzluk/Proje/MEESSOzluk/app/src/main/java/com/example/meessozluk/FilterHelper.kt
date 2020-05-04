package com.example.meessozluk

import android.widget.Filter
import com.example.meesozluk.HayvanlarRecyclerViewAdapter

class FilterHelper(tumHayvanlar:ArrayList<Hayvan>, adapter:HayvanlarRecyclerViewAdapter) : Filter() {

    var suankiListe=tumHayvanlar
    var suankiAdapter=adapter

    override fun performFiltering(constraint: CharSequence?): FilterResults {

        var sonuc=FilterResults()

        if(constraint != null && constraint.length>0){

            var aranilanAd = constraint.toString().toLowerCase()

            var eslesenler=ArrayList<Hayvan>()

            for(hayvan in suankiListe){

                var adi=hayvan.isim.toLowerCase()
                if(adi.contains(aranilanAd.toString())) {

                    eslesenler.add(hayvan)

                }

            }

            sonuc.values = eslesenler
            sonuc.count = eslesenler.size

        }else {

            sonuc.values=suankiListe
            sonuc.count=suankiListe.size
        }
        return sonuc
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

        suankiAdapter.setFilter(results?.values as ArrayList<Hayvan>)
        suankiAdapter.notifyDataSetChanged()

    }
}