# EasySP
[中文版点我](https://github.com/WhiteDG/EasySP/blob/master/README_ZH.md)

EasySP is a lightweight utility for handling SharedPreferences on Android. It simplifies SharedPreferences data operations, offering support for chain calls, enabling you to write multiple data entries with just one line of code.

## Installation

Add the depedency in your build.gradle. The library is distributed via jCenter.
```
dependencies {
    implementation 'com.white:easysp:1.0.0'
}
```
## Usage

- Save data to `sharedpreferences.xml`   
```
EasySP.init(context).putBoolean("boolean", true);

// you can also use a string resource value as the key
EasySP.init(context).putBoolean(R.string.key_bool, true);

// or specify a custom name for the preferences' name:
EasySP.init(context,"Custom").putBoolean("boolean", true);
```

- Save multiple data with one line of code
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

- Read data
```
boolean booleanData = EasySP.init(context).getBoolean("bool");

boolean booleanData = EasySP.init(context).getBoolean(R.string.key_bool,defValue);
```

- Remove data
```
EasySP.init(context).remove("bool");

EasySP.init(context).remove(R.string.key_bool);
```
- Clear data
```
EasySP.init(context).clear();
```

## License

[MIT License](https://github.com/WhiteDG/EasySP/blob/master/LICENSE) @[Wh1te](https://github.com/WhiteDG)
