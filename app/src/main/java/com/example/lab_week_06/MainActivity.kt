package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recycler_view) }
    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object : CatViewHolder.OnClickListener {
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        // Tambahkan 10 data
        catAdapter.setData(
            listOf(
                CatModel(Gender.Male, CatBreed.BalineseJavanese, "Fred", "Silent and deadly", "https://cdn2.thecatapi.com/images/7dj.jpg"),
                CatModel(Gender.Female, CatBreed.ExoticShorthair, "Wilma", "Cuddly assassin", "https://cdn2.thecatapi.com/images/egv.jpg"),
                CatModel(Gender.Unknown, CatBreed.AmericanCurl, "Curious George", "Award winning investigator", "https://cdn2.thecatapi.com/images/bar.jpg"),
                CatModel(Gender.Male, CatBreed.AmericanCurl, "Tommy", "Always hungry", "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"),
                CatModel(Gender.Female, CatBreed.BalineseJavanese, "Lucy", "Loves sleeping", "https://cdn2.thecatapi.com/images/bpc.jpg"),
                CatModel(Gender.Male, CatBreed.ExoticShorthair, "Max", "Playful and energetic", "https://cdn2.thecatapi.com/images/MTg5ODk2OQ.jpg"),
                CatModel(Gender.Female, CatBreed.AmericanCurl, "Molly", "Clever and curious", "https://cdn2.thecatapi.com/images/5j6.jpg"),
                CatModel(Gender.Unknown, CatBreed.ExoticShorthair, "Shadow", "Likes to hide", "https://cdn2.thecatapi.com/images/MTk4MTQ2NQ.jpg"),
                CatModel(Gender.Male, CatBreed.BalineseJavanese, "Simba", "King of the house", "https://cdn2.thecatapi.com/images/9j5.jpg"),
                CatModel(Gender.Female, CatBreed.AmericanCurl, "Luna", "Sweet and gentle", "https://cdn2.thecatapi.com/images/4h2.jpg")
            )
        )
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}
