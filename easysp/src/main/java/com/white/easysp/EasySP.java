package com.white.easysp;
//
//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                           O\  =  /O
//                        ____/`---'\____
//                      .'  \\|     |//  `.
//                     /  \\|||  :  |||//  \
//                    /  _||||| -:- |||||-  \
//                    |   | \\\  -  /// |   |
//                    | \_|  ''\---/''  |   |
//                    \  .-\__  `-`  ___/-. /
//                  ___`. .'  /--.--\  `. . __
//               ."" '<  `.___\_<|>_/___.'  >'"".
//              | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//              \  \ `-.   \_ __\ /__ _/   .-` /  /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//                      佛祖保佑       永无BUG

//           佛曰:
//                  写字楼里写字间，写字间里程序员；
//                  程序人员写程序，又拿程序换酒钱。
//                  酒醒只在网上坐，酒醉还来网下眠；
//                  酒醉酒醒日复日，网上网下年复年。
//                  但愿老死电脑间，不愿鞠躬老板前；
//                  奔驰宝马贵者趣，公交自行程序员。
//                  别人笑我忒疯癫，我笑自己命太贱；
//                  不见满街漂亮妹，哪个归得程序员？
//

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.StringRes;
import android.support.v4.content.SharedPreferencesCompat;
import android.util.Log;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author White
 * Date 2017/2/28
 * Time 19:48
 */

public class EasySP {

    private static final String TAG = "EasySP";

    private static EasySP sEasySP;

    private static SharedPreferences sSharedPreferences;
    private static SharedPreferences.Editor sEditor;
    private static SharedPreferencesCompat.EditorCompat editorCompat = SharedPreferencesCompat.EditorCompat.getInstance();

    private static final String DEFAULT_SP_NAME = "SharedData";
    private static final int DEFAULT_INT = 0;
    private static final float DEFAULT_FLOAT = 0.0f;
    private static final String DEFAULT_STRING = "";
    private static final boolean DEFAULT_BOOLEAN = false;
    private static final Set<String> DEFAULT_STRING_SET = new HashSet<>(0);

    private static String mCurSPName = DEFAULT_SP_NAME;
    private static Context mContext;

    private EasySP(Context context) {
        this(context, DEFAULT_SP_NAME);
    }

    private EasySP(Context context, String spName) {
        mContext = context.getApplicationContext();
        sSharedPreferences = mContext.getSharedPreferences(spName, Context.MODE_PRIVATE);
        sEditor = sSharedPreferences.edit();
        mCurSPName = spName;
        Log.i(TAG, "EasySP: " + mCurSPName);
    }

    public static EasySP init(Context context) {
        if (sEasySP == null || !mCurSPName.equals(DEFAULT_SP_NAME)) {
            sEasySP = new EasySP(context);
        }
        return sEasySP;
    }

    public static EasySP init(Context context, String spName) {
        if (sEasySP == null) {
            sEasySP = new EasySP(context, spName);
        } else if (!spName.equals(mCurSPName)) {
            sEasySP = new EasySP(context, spName);
        }
        return sEasySP;
    }

    public EasySP put(@StringRes int key, Object value) {
        return put(mContext.getString(key), value);
    }

    public EasySP put(String key, Object value) {

        if (value instanceof String) {
            sEditor.putString(key, (String) value);
        } else if (value instanceof Integer) {
            sEditor.putInt(key, (Integer) value);
        } else if (value instanceof Boolean) {
            sEditor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Float) {
            sEditor.putFloat(key, (Float) value);
        } else if (value instanceof Long) {
            sEditor.putLong(key, (Long) value);
        } else {
            sEditor.putString(key, value.toString());
        }
        editorCompat.apply(sEditor);
        return sEasySP;
    }

    public Object get(@StringRes int key, Object defaultObject) {
        return get(mContext.getString(key), defaultObject);
    }

    public Object get(String key, Object defaultObject) {
        if (defaultObject instanceof String) {
            return sSharedPreferences.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sSharedPreferences.getInt(key, (int) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sSharedPreferences.getBoolean(key, (boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sSharedPreferences.getFloat(key, (float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sSharedPreferences.getLong(key, (long) defaultObject);
        }
        return null;
    }

    public EasySP putInt(String key, int value) {
        sEditor.putInt(key, value);
        editorCompat.apply(sEditor);
        return this;
    }

    public EasySP putInt(@StringRes int key, int value) {
        return putInt(mContext.getString(key), value);
    }

    public int getInt(@StringRes int key) {
        return getInt(mContext.getString(key));
    }

    public int getInt(@StringRes int key, int defValue) {
        return getInt(mContext.getString(key), defValue);
    }

    public int getInt(String key) {
        return getInt(key, DEFAULT_INT);
    }


    public int getInt(String key, int defValue) {
        return sSharedPreferences.getInt(key, defValue);
    }

    public EasySP putFloat(@StringRes int key, float value) {
        return putFloat(mContext.getString(key), value);
    }

    public EasySP putFloat(String key, float value) {
        sEditor.putFloat(key, value);
        editorCompat.apply(sEditor);
        return sEasySP;
    }

    public float getFloat(String key) {
        return getFloat(key, DEFAULT_FLOAT);
    }

    public float getFloat(String key, float defValue) {
        return sSharedPreferences.getFloat(key, defValue);
    }

    public float getFloat(@StringRes int key) {
        return getFloat(mContext.getString(key));
    }

    public float getFloat(@StringRes int key, float defValue) {
        return getFloat(mContext.getString(key), defValue);
    }

    public EasySP putLong(@StringRes int key, long value) {
        return putLong(mContext.getString(key), value);
    }

    public EasySP putLong(String key, long value) {
        sEditor.putLong(key, value);
        editorCompat.apply(sEditor);
        return sEasySP;
    }

    public long getLong(String key) {
        return getLong(key, DEFAULT_INT);
    }

    public long getLong(String key, long defValue) {
        return sSharedPreferences.getLong(key, defValue);
    }

    public long getLong(@StringRes int key) {
        return getLong(mContext.getString(key));
    }

    public long getLong(@StringRes int key, long defValue) {
        return getLong(mContext.getString(key), defValue);
    }

    public EasySP putString(@StringRes int key, String value) {
        return putString(mContext.getString(key), value);
    }

    public EasySP putString(String key, String value) {
        sEditor.putString(key, value);
        editorCompat.apply(sEditor);
        return sEasySP;
    }

    public String getString(String key) {
        return getString(key, DEFAULT_STRING);
    }

    public String getString(String key, String defValue) {
        return sSharedPreferences.getString(key, defValue);
    }

    public String getString(@StringRes int key) {
        return getString(mContext.getString(key), DEFAULT_STRING);
    }

    public String getString(@StringRes int key, String defValue) {
        return getString(mContext.getString(key), defValue);
    }

    public EasySP putBoolean(@StringRes int key, boolean value) {
        return putBoolean(mContext.getString(key), value);
    }

    public EasySP putBoolean(String key, boolean value) {
        sEditor.putBoolean(key, value);
        editorCompat.apply(sEditor);
        return sEasySP;
    }

    public boolean getBoolean(String key) {
        return getBoolean(key, DEFAULT_BOOLEAN);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return sSharedPreferences.getBoolean(key, defValue);
    }

    public boolean getBoolean(@StringRes int key) {
        return getBoolean(mContext.getString(key));
    }

    public boolean getBoolean(@StringRes int key, boolean defValue) {
        return getBoolean(mContext.getString(key), defValue);
    }

    public EasySP putStringSet(@StringRes int key, Set<String> value) {
        return putStringSet(mContext.getString(key), value);
    }

    public EasySP putStringSet(String key, Set<String> value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            sEditor.putStringSet(key, value);
            editorCompat.apply(sEditor);
        }
        return sEasySP;
    }

    public Set<String> getStringSet(String key) {
        return getStringSet(key, DEFAULT_STRING_SET);
    }


    public Set<String> getStringSet(String key, Set<String> defValue) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return sSharedPreferences.getStringSet(key, defValue);
        } else {
            return DEFAULT_STRING_SET;
        }
    }

    public Set<String> getStringSet(@StringRes int key) {
        return getStringSet(mContext.getString(key));
    }

    public Set<String> getStringSet(@StringRes int key, Set<String> defValue) {
        return getStringSet(mContext.getString(key), defValue);
    }


    public boolean contains(String key) {
        return sSharedPreferences.contains(key);
    }

    public boolean contains(@StringRes int key) {
        return contains(mContext.getString(key));
    }

    public Map<String, ?> getAll() {
        return sSharedPreferences.getAll();
    }

    public EasySP remove(@StringRes int key) {
        return remove(mContext.getString(key));
    }

    public EasySP remove(String key) {
        sEditor.remove(key);
        editorCompat.apply(sEditor);
        return sEasySP;
    }

    public EasySP clear() {
        sEditor.clear();
        editorCompat.apply(sEditor);
        return sEasySP;
    }

    public SharedPreferences getSharedPreferences() {
        return sSharedPreferences;
    }

}
