package com.example.intent

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.INotificationSideChannel
import android.widget.AdapterView
import android.widget.Toast
import com.example.intent.databinding.ActivityMainBinding


@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    val listaccount = ArrayList<OutData>()
    lateinit var  customadpt : customadapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addaccount(listaccount)
        customadpt= customadapter(this, listaccount)
        binding.lvaccount.adapter= customadpt
        addevents()
        val mess = "this is a new change"
        val mess2 = "this is a message from branch one"

    }


    private fun addevents() {
        binding.lvaccount.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
//            val intent = Intent(this, SecondActivity::class.java)
//            intent.putExtra("username", listaccount[position].name)
//            startActivity(intent)
            if(position==0){
                val i = packageManager.getLaunchIntentForPackage("com.facebook.katana")
                if(i!=null){
                    applicationContext.startActivity(i)
                }else {
                    intent= Intent(Intent.ACTION_VIEW)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    intent.setData(Uri.parse("market://details?id="+"com.netflix.ninja"))
                    startActivity(intent)
                }
            }
            else if(position==1){
                val i = packageManager.getLaunchIntentForPackage("app.rvx.android.youtube")
                if(i!=null) startActivity(i)
                else {
                    Toast.makeText(this, "this app isn't be installed", Toast.LENGTH_SHORT).show()
                }
            }

        }
        binding.btnlogon.setOnClickListener {
            //val intent = Intent(this, SecondActivity::class.java)
            //startActivity(intent)
            val i = packageManager.getLaunchIntentForPackage("com.example.listview")
            if(i!=null){
                startActivity(i)
            }else {
                intent= Intent(Intent.ACTION_VIEW)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.setData(Uri.parse("market://details?id="+"com.google.android.youtube"))
                startActivity(intent)
            }
        }
        binding.btncreate.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/luudinhkien1235/"))
            startActivity(intent)
        }
        binding.imageView2.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        binding.imageView2.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("username", listaccount[0].name)
            startActivity(intent)
        }

    }

    private fun addaccount(listaccount: ArrayList<OutData>) {
        listaccount.add(OutData(R.drawable.proflie, "Dinh Kien"))
        listaccount.add(OutData(R.drawable.proflie, "Thuy Nga"))
    }
}
