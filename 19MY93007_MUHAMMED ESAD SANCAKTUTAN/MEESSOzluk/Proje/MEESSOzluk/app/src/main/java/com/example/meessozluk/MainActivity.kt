package com.example.meessozluk

import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.meesozluk.HayvanlarRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var tumHayvanlar=ArrayList<Hayvan>()
    lateinit var myAdapter:HayvanlarRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        veriKaynagınıDoldur()

        myAdapter=HayvanlarRecyclerViewAdapter(tumHayvanlar)
        recyclerviewHayvanlar.adapter = myAdapter

        var mylayoutManager= StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerviewHayvanlar.layoutManager= mylayoutManager

        searchViewHayvan.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                myAdapter.filter.filter(newText)

                return false
            }


        })


    }

    private fun veriKaynagınıDoldur() {

        var resimler = arrayOf(
            R.drawable.a,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.j,
            R.drawable.kunduz,
            R.drawable.boga,
            R.drawable.k,
            R.drawable.karga,
            R.drawable.deve,
            R.drawable.inek,
            R.drawable.kedi,
            R.drawable.tavuk,
            R.drawable.timsah,
            R.drawable.essek,
            R.drawable.kopek,
            R.drawable.yunus,
            R.drawable.guvercin,
            R.drawable.ordek,
            R.drawable.fil,
            R.drawable.balik,
            R.drawable.kurbaga,
            R.drawable.tilki,
            R.drawable.cekirge,
            R.drawable.keci,
            R.drawable.zurafa,
            R.drawable.hamster,
            R.drawable.at,
            R.drawable.impala,
            R.drawable.iguana,
            R.drawable.cakal,
            R.drawable.jaguar,
            R.drawable.denizanasi,
            R.drawable.kanguru,
            R.drawable.koala,
            R.drawable.kuzu,
            R.drawable.leopar,
            R.drawable.aslan,
            R.drawable.fare,
            R.drawable.sivrisinek,
            R.drawable.maymun,
            R.drawable.kostebek,
            R.drawable.ahtapot,
            R.drawable.baykus,
            R.drawable.panter,
            R.drawable.papagan,
            R.drawable.tavukkusu,
            R.drawable.pelikan,
            R.drawable.penguen,
            R.drawable.domuz,
            R.drawable.pirana,
            R.drawable.piton,
            R.drawable.tavsan,
            R.drawable.rakun,
            R.drawable.horoz,
            R.drawable.sincap,
            R.drawable.marti,
            R.drawable.koyun,
            R.drawable.kopekbaligi,
            R.drawable.orumcek,
            R.drawable.serce,
            R.drawable.yilan,
            R.drawable.tarantula,
            R.drawable.kaplan,
            R.drawable.hindi,
            R.drawable.kaplumbaga,
            R.drawable.akbaba,
            R.drawable.balina,
            R.drawable.kurt,
            R.drawable.zebra
        )

        var isimler =
            arrayOf("Karınca  -  Ant", "Arı  -  Bee", "Kelebek-Butterfly", "Serçe  -  Sparrow", "Yarasa  -  Bat", "Ayı  -  Bear", "Çita  -  Cheetah", "Kunduz  -  Beaver", "Boğa  -  Bull", "Civciv  -  Chick", "Karga  -  Crow", "Deve  -  Camel", "İnek  -  Cow", "Kedi  -  Cat", "Tavuk  -  Chicken", "Timsah-Crocodile", "Eşşek  -  Donkey", "Köpek  -  Dog", "Yunus  -  Dolphin", "Güvercin-Pigeon", "Ördek  -  Duck", "Fil  -  Elephant", "Balık  -  Fish", "Kurbağa  -  Frog", "Tilki  -  Fox", "Çekirge-Grasshopper", "Keçi  -  Goat", "Zürafa  -  Giraffe", "Hamster-Hamster", "At  -  Horse", "İmpala  -  Impala", "İquana  -  Iquana", "Çakal  -  Jackal", "Jaguar  -  Jaguar", "Denizanası-Jellyfish", "Kanguru- Kangaroo", "Koala  -  Koala", "Kuzu  -  Lamb", "Leopar - Leopard", "Aslan  -  Lion", "Fare  -  Mouse", "Sivrisinek-Mosquito", "Maymun-Monkey", "Köstebek  -  Mole", "Ahtapot-Octopus", "Baykuş  -  Owl", "Panter-Panther", "Papağan-Parrot", "Tavus Kuşu-Peacock", "Pelikan  -  Pelican", "Penguen-Penguin", "Domuz  -  Pig", "Pirana  -  Piranha", "Piton  -  Python", "Tavşan  -  Rabbit", "Rakun  -  Raccoon", "Horoz  -  Cock", "Sincap - Squirrel", "Martı  -  Seagull", "Koyun  -  Sheep", "Köpekbalığı-Shark", "Örümcek-Spider", "Serçe  -  Sparrow", "Yılan  -  Snake", "Tarantula-Tarantula", "Kaplan  -  Tiger", "Hindi  -  Turkey", "Kamplumbağa-Turtle", "Akbaba-Vulture", "Balina  -  Whale", "Kurt  -  Wolf", "Zebra  -  Zebra")

        for (i in 0..resimler.size-1) {

            var eklenecekHayvan = Hayvan(isimler[i], resimler[i])
            tumHayvanlar.add(eklenecekHayvan)

        }
    }




}

