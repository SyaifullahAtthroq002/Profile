package com.syaifullahatthoriq.recyclerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)

                    val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                    val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }


                }.show()
            }

        })

    }

}