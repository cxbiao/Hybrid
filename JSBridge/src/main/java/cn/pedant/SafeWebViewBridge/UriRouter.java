package cn.pedant.SafeWebViewBridge;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/**
 * Author：Cxb on 2016/5/26 14:32
 */
public class UriRouter {

    private final Context mContext;
    private final Intent mIntent;
    private String mProtocol="";
    public static final String PARAM="param";


    public static UriRouter from(Context context,String protocol ){
         return  new UriRouter(context,protocol);
    }

    private UriRouter( Context context,String protocol) {
        mContext = context;
        mProtocol=protocol;
        mIntent = new Intent(Intent.ACTION_VIEW);
    }


    public boolean toUri(final String uri) {
        try {
            if(TextUtils.isEmpty(uri)) return false;
            int index=uri.indexOf(":");
            if(index==-1){
                return false;
            }else {
                String protocol=uri.substring(0,index);
                index=uri.indexOf("=");
                if(mProtocol.equals(protocol)){
                    mIntent.setData(Uri.parse(uri));
                    if(index>0){
                        String param=uri.substring(index+1);
                        mIntent.putExtra(PARAM,param);
                    }
                    mContext.startActivity(mIntent);
                    return true;
                }
            }
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

}
