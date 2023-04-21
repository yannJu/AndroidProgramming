package com.example.recyclerview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.ui.AppBarConfiguration
import android.view.Menu
import android.view.MenuItem
import android.view.Surface
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.databinding.ItemMainBinding
import java.util.TimerTask
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding


    var items: MutableList<MainData> = mutableListOf()
    init {
        (1..10).forEach {
            items += MainData("Title_$it", "Content_$it")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        binding.contentLayout.mainList.apply {
            adapter = MainAdapter()

            // 가로모드 인 경우
            if (windowManager.defaultDisplay.rotation == Surface.ROTATION_90 || windowManager.defaultDisplay.rotation == Surface.ROTATION_270) {
                layoutManager = GridLayoutManager(this@MainActivity, 3)
            } // 세로모드 인 경우
            else layoutManager = LinearLayoutManager(this@MainActivity)
        }

        // 3초 간격으로 10개씩 데이터 추가
        timer(period = 5000) {
            (1..10).forEach {
                items += MainData("Title_${items.size + it}", "Content_${items.size + it}")
            }

            runOnUiThread {
                binding.contentLayout.mainList.adapter?.notifyDataSetChanged()
            }
        }


//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//
//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAnchorView(R.id.fab)
//                .setAction("Action", null).show()
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }

    inner class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
        inner class MainViewHolder(itemView: ItemMainBinding) : RecyclerView.ViewHolder(itemView.root) {
            val txtTitle = itemView.mainTitle
            val txtContent = itemView.tvMainContent
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainViewHolder {
            val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MainViewHolder(binding)
        }

        override fun getItemCount(): Int = items.size

        override fun onBindViewHolder(holder: MainAdapter.MainViewHolder, position: Int) {
            items[position].let { item ->
                holder.apply {
                    txtTitle.text = item.title
                    txtContent.text = item.content
                }

                holder.itemView.setOnClickListener {
                    onItemClick(item, position)
                }
            }
        }
    }

    fun onItemClick(item: MainData, position: Int) {
        Toast.makeText(application, "Item : <${item.toString()}>, Position : <$position>", Toast.LENGTH_SHORT).show()
    }
}
