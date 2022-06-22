package com.syaifullahatthoriq.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.syaifullahatthoriq.recyclerview.adapter.AdapterTeamBola
import com.syaifullahatthoriq.recyclerview.databinding.ActivityMainBinding
import com.syaifullahatthoriq.recyclerview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Antonio Rudiger", R.drawable.antonio,"bek tengah","2.00m", "Berlin", "3 Maret 1993"))
        listPemain.add(Pemain("Peter Gonzales", R.drawable.petergonzales,"penyerang","1,85m", "Spanyol", "7 Juli 2002"))
        listPemain.add(Pemain("Mario Gila", R.drawable.mariogila,"belakang","1,74m", "Canada", "12 Mei 1998"))
        listPemain.add(Pemain("Miguel Gutierrez", R.drawable.miguel,"belakang","1,84m", "Spanyol", "30 Maret 1980"))
        listPemain.add(Pemain("Toni Fuidas", R.drawable.tonifuidias,"penjaga gawang","1,85m", "Brazil", "23 Juni 1997"))

        binding.list.adapter = AdapterTeamBola(this,listPemain, object : AdapterTeamBola.OnClickListener {
            override fun detailData(item: Pemain?) {
                TODO("Not yet implemented")
            }

        })

    }

}