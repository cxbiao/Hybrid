package cn.pedant.SafeWebViewBridge;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * Author：Cxb on 2016/5/26 15:44
 */
public class BridgeWebView extends WebView {
    public BridgeWebView(Context context) {
        super(context);
        init();
    }

    public BridgeWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BridgeWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setDatabaseEnabled(true);
        String cacheDirPath = getContext().getFilesDir().getAbsolutePath();
        getSettings().setDatabasePath(cacheDirPath);
        //设置  Application Caches 缓存目录
        getSettings().setAppCachePath(cacheDirPath);
        //开启 Application Caches 功能
        getSettings().setAppCacheEnabled(true);
    }
}
