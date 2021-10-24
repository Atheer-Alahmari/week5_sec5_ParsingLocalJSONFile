package com.example.week5_sec5_parsinglocaljsonfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    private lateinit var image: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
     image= arrayListOf()
        read_Json()


    }

    private fun read_Json() {
       var json: String? =null
        try{
            val input_Stream: InputStream = assets.open("data.json")
            json = input_Stream.bufferedReader().use { it.readText() }

            val json_Array=JSONArray(json)
            for(i in 0..json_Array.length()-1){
                var obj=json_Array.getJSONObject(i)
                val url=obj.getString("url")
                image.add(url)
            }

            recycler_View.adapter=RVAdapter(image)
            recycler_View.layoutManager= LinearLayoutManager(this)

            recycler_View.adapter?.notifyDataSetChanged()
            // tvMain.text = text
        }catch (e: IOException) {
            println("ISSUE: $e")
        }
    }
}