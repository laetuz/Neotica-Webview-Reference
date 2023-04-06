package com.neotica.neoticawebview

import android.annotation.SuppressLint
import android.net.http.SslError
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient
import com.neotica.neoticawebview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindingWeb()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun bindingWeb(){
        binding.apply {
            webView.loadUrl("https://www.neotica.id")
            webView.webViewClient = MyWebViewClient()
            webView.settings.javaScriptEnabled = true
        }
    }
}

class MyWebViewClient : WebViewClient() {
    override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
        handler?.proceed() // Ignore SSL certificate errors
    }
}