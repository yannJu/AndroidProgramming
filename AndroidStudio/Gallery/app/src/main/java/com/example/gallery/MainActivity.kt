package com.example.gallery

import android.Manifest
import android.content.ContentUris
import android.content.pm.PackageManager
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.gallery.databinding.ActivityMainBinding
import kotlin.concurrent.timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding


        private val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()) { isGranted ->
                if (isGranted) { // 권한 허용
                    getAllPhotos()
                } else {
                    Toast.makeText(this, "접근권한없음", Toast.LENGTH_LONG).show()
                    finish()
                }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            return
//            Toast.makeText(this, "접근권한없음", Toast.LENGTH_LONG).show()
//            return // 권한이 없다면 바로 return 해야한다.
        }

        // 권한 접근 성공
        getAllPhotos()

//        getAllPhotos()

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

    private fun getAllPhotos() {
        Toast.makeText(application, "사진 가져오기 성공", Toast.LENGTH_SHORT).show()
        val uris = mutableListOf<Uri>()

        contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            null, //select 절
            null,  // where 절
            null, //group by 절
            "${MediaStore.Images.ImageColumns.DATE_TAKEN} DESC" //order by
        )?.use { cursor ->
            while (cursor.moveToNext()) {
                val id = cursor.getLong(cursor.getColumnIndexOrThrow(
                    MediaStore.Images.Media._ID
                ))
                val contentUri = ContentUris.withAppendedId(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    id
                )
                uris.add(contentUri)
            }
        }
        Log.d("MainActivity", "getAllPhotos : $uris")

        val adapter = PageAdapter(supportFragmentManager, lifecycle)
        adapter.uris = uris

        binding.contentLayout.viewPager.adapter = adapter
        autoSlide(binding.contentLayout.viewPager, adapter)
    }

    fun autoSlide(viewPager: ViewPager2, adapter: PageAdapter) {
        timer(period = 3000) {
            runOnUiThread {
                if (viewPager.currentItem < adapter.itemCount - 1) {
                    viewPager.currentItem = viewPager.currentItem + 1
                } else viewPager.currentItem = 0
            }
        }
    }

}
