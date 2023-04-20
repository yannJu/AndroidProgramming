package com.example.menu

import android.os.Bundle
import android.view.ContextMenu
import android.view.Gravity
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.EditorInfo
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.menu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        var URL = "URL"
    }

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.contentLayout.webView.apply {
            settings.javaScriptEnabled = true
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView, url: String) {
                    binding.contentLayout.txtUrl.setText(url)
                }
            }
        }

        registerForContextMenu(binding.contentLayout.webView)

        if (savedInstanceState != null) binding.contentLayout.webView.loadUrl(savedInstanceState.getString(URL)!!)
        else binding.contentLayout.webView.loadUrl("https://www.google.com")

        binding.contentLayout.txtUrl.setOnEditorActionListener { textView, actionID, keyEvent ->
            if (actionID == EditorInfo.IME_ACTION_SEARCH) {
                var url = binding.contentLayout.txtUrl.text.toString()

                if (url.startsWith("http://") || url.startsWith("https://")) binding.contentLayout.webView.loadUrl(binding.contentLayout.txtUrl.text.toString())
                else {
                    url = "http://" + url
                    binding.contentLayout.webView.loadUrl(url)
                }
                true
            }
            else false
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
            R.id.action_home, R.id.action_google -> {
                binding.contentLayout.webView.loadUrl("https://www.google.com")
                true
            }
            R.id.action_daum -> {
                binding.contentLayout.webView.loadUrl("https://www.daum.net")
                true
            }
            R.id.action_naver -> {
                binding.contentLayout.webView.loadUrl("https://www.naver.com")
                true
            }
            R.id.action_call -> true
            R.id.action_send_text -> true
            R.id.action_email -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onBackPressed() {
        if (binding.contentLayout.webView.canGoBack()) binding.contentLayout.webView.goBack()
        else super.onBackPressed()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val url = binding.contentLayout.txtUrl.text.toString()
        outState.putString(URL, url)

        super.onSaveInstanceState(outState)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }

    // context 메뉴 만들기 =============
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context, menu)

//        val toast = Toast(applicationContext)
//        toast.setGravity(Gravity.CENTER, 0, 0)
//        toast.duration = Toast.LENGTH_SHORT
//        toast.view = menuInflater.inflate(R.menu.context?, null)
//
//        toast.show()
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
//            R.id.action_share -> {
//                binding.webView.url?.let { url ->
//
//                }
//            }
//            R.id.action_browser -> {
//                binding.webView.url?.let { url ->
//
//                }
//            }
        }

        return super.onContextItemSelected(item)
    }
}