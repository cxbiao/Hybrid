package cn.pedant.SafeWebViewBridge;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Author：Cxb on 2016/5/26 14:29
 */
public class NavWebViewClient extends WebViewClient {

    private String mProtocol="";

    public NavWebViewClient(String protocol){
        mProtocol=protocol;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(UriRouter.from(view.getContext(),mProtocol).toUri(url)){
            return true;
        }
        view.loadUrl(url);
        return true;
    }
}
