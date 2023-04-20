package com.example.customweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.customweb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        var URL = "URL"
    }

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.webView.apply {
            settings.javaScriptEnabled = true
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView, url: String) {
                    binding.txtUrl.setText(url)
                }
            }
        }

        if (savedInstanceState != null) binding.webView.loadUrl(savedInstanceState.getString(URL)!!)
        else binding.webView.loadUrl("https://www.google.com")

        binding.txtUrl.setOnEditorActionListener { textView, actionID, keyEvent ->
            if (actionID == EditorInfo.IME_ACTION_SEARCH) {
                var url = binding.txtUrl.text.toString()

                if (url.startsWith("http://") || url.startsWith("https://")) binding.webView.loadUrl(binding.txtUrl.text.toString())
                else {
                    url = "http://" + url
                    binding.webView.loadUrl(url)
                }
                true
            }
            else false
        }
    }

    override fun onBackPressed() {
        if (binding.webView.canGoBack()) binding.webView.goBack()
        else super.onBackPressed()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val url = binding.txtUrl.text.toString()
        outState.putString(URL, url)

        super.onSaveInstanceState(outState)
    }
}