package com.aakash.softuser1.fragment.About

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aakash.softuser1.R

class AboutFragment : Fragment() {

    private lateinit var webView: WebView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_about, container, false)
        webView = root.findViewById(R.id.Webview)
        webView.settings.setJavaScriptEnabled(true)

        webView.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                url:String?
            ): Boolean {
                view?.loadUrl(url.toString())
                return true
            }
        }
        webView.loadUrl("https://softwarica.edu.np/about-softwarica/")
        return root
    }
}


