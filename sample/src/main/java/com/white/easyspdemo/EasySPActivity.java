package com.white.easyspdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.white.easysp.EasySP;

import java.util.HashSet;
import java.util.Set;

public class EasySPActivity extends AppCompatActivity {

    public static final String TAG = "EasySPActivity";

    private Button mBtnPutAll;
    private Button mBtnPutOne;
    private Button mBtnGet;
    private Button mBtnClear;
    private TextView mTvGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnPutAll = (Button) findViewById(R.id.btn_put_all);
        mBtnPutOne = (Button) findViewById(R.id.btn_put_one);
        mBtnGet = (Button) findViewById(R.id.btn_get);
        mBtnClear = (Button) findViewById(R.id.btn_clear);
        mTvGet = (TextView) findViewById(R.id.tv_get);

        mBtnPutAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Set<String> strings = new HashSet<>();
                strings.add("set str1");
                strings.add("set str2");
                strings.add("set str3");
//                EasySP.init(EasySPActivity.this)
//                        .putBoolean("bool", true)
//                        .putInt("int", 1)
//                        .putString("str", "string")
//                        .putLong("long", 1000000000)
//                        .putFloat("float", 1.1f)
//                        .put("put", 100)
//                        .putStringSet("set", strings);

                EasySP.init(EasySPActivity.this)
                        .putBoolean(R.string.key_bool, true)
                        .putInt(R.string.key_int, 1)
                        .putString(R.string.key_string, "string")
                        .putLong(R.string.key_long, 1000000000)
                        .putFloat(R.string.key_float, 1.1f)
                        .put("put", 100)
                        .putStringSet(R.string.key_set, strings);
            }
        });

        mBtnPutOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EasySP.init(EasySPActivity.this).putString("one", "String one");
            }
        });

        mBtnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EasySP easySP = EasySP.init(EasySPActivity.this);
                Log.i(TAG, "contains: " + easySP.contains("bool"));
                StringBuilder sb = new StringBuilder("SharedPreferencesData:\n");
                sb.append("bool:").append(easySP.getBoolean(R.string.key_bool)).append("\n")
                        .append("int:").append(easySP.getInt(R.string.key_int)).append("\n")
                        .append("str:").append(easySP.getString(R.string.key_string)).append("\n")
                        .append("long:").append(easySP.getLong(R.string.key_long)).append("\n")
                        .append("float:").append(easySP.getFloat(R.string.key_float)).append("\n")
                        .append("one:").append(easySP.getString("one")).append("\n");
                Set<String> stringSet = easySP.getStringSet(R.string.key_set);
                for (String str : stringSet) {
                    sb.append("set:").append(str).append("\n");
                }
                mTvGet.setText(sb.toString());
            }
        });

        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EasySP.init(EasySPActivity.this).clear();
            }
        });

    }
}
