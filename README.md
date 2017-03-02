# EasySP
EasySP is a simple sharedpreferences util for android. You can use EasySP to simplify the operation of the SharedPreferences data. EasySP supports chain calls, you can write multiple data by one line of code.  

## Installation

Add the depedency in your build.gradle. The library is distributed via jCenter.
```
dependencies {
    compile 'com.white:easysp:1.0.0'
}
```
## Usage

- save data to sharedpreferences.xml   
```
EasySP.init(context).putBoolean("boolean", true);

// you can also use string resource value as the key
EasySP.init(context).putBoolean(R.string.key_bool, true);

// or specify a custom name for the preferences' name:
EasySP.init(context,"Custom").putBoolean("boolean", true);
```

- save multiple data by one line of code
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

- read data
```
boolean booleanData = EasySP.init(context).getBoolean("bool");

boolean booleanData = EasySP.init(context).getBoolean(R.string.key_bool,defValue);
```

- remove data
```
EasySP.init(context).remove(bool);

EasySP.init(context).remove(R.string.key_bool);
```
- clear data
```
EasySP.init(context).clear();
```

## License

[MIT License](https://github.com/WhiteDG/EasySP/blob/master/LICENSE) @[Wh1te](https://github.com/WhiteDG)
