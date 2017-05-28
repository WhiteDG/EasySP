# EasySP
EasySP是一个简单的Android SharedPreferences工具类。可以使用它简化对SharedPreferences数据的操作，同时它也支持链式调用，可以通过一行代码写入一条或多条数据。

## 下载

在项目中的 build.gradle 文件中添加如下引用
```
dependencies {
    compile 'com.white:easysp:1.0.0'
}
```
## 使用

- 保存数据到sharedpreferences   
```
EasySP.init(context).putBoolean("boolean", true);

//可以使用字符串资源作为保存的键
EasySP.init(context).putBoolean(R.string.key_bool, true);

//可以自定义sharedpreferences的文件名
EasySP.init(context,"Custom").putBoolean("boolean", true);
```

- 一句代码保存多条数据（链式调用）
```
EasySP.init(context)
                .putBoolean(R.string.key_bool, true)
                .putInt(R.string.key_int, 1)
                .putString(R.string.key_string, "string")
                .putLong(R.string.key_long, 1000000000)
                .putFloat(R.string.key_float, 1.1f)
                .put("put", 100)
                .putStringSet(R.string.key_set, strings);
```

- 读取数据
```
boolean booleanData = EasySP.init(context).getBoolean("bool");

boolean booleanData = EasySP.init(context).getBoolean(R.string.key_bool,defValue);
```

- 移除某个键对应的数据
```
EasySP.init(context).remove("bool");

EasySP.init(context).remove(R.string.key_bool);
```
- 清除所有数据
```
EasySP.init(context).clear();
```

## License

[MIT License](https://github.com/WhiteDG/EasySP/blob/master/LICENSE) @[Wh1te](https://github.com/WhiteDG)