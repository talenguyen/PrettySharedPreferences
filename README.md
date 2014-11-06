PrettySharedPreferences
=======================

PrettySharedPreferences is a lightweight library for help you deal with SharedPreferences more easy and reduce most of boilplace code.

Features
========

 * Easy to use
 * Reduce most of boilplace code.

Integration
===========
### Gradle
```groovy
dependencies {
    compile 'com.github.talenguyen:PrettySharedPreferences:1.0.1'
}
```
### Maven
``` xml
<dependency>
  <groupId>com.github.talenguyen</groupId>
  <artifactId>PrettySharedPreferences</artifactId>
  <version>1.0.1</version>
  <type>aar</type>
</dependency>
```

Usage
=====

Create a class and extends from PrettySharedPreferences class. Let's say PrefManager.

``` java
public class PrefManager extends PrettySharedPreferences {

    public PrefManager(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
    }

    public StringEditor<PrefManager> username() {
        return getStringEditor("username");
    }
    
    public LongEditor<PrefManager> userId() {
        return getLongEditor("userId");
    }

    ...
}

```
Create an instance 
``` java
    PrefManager prefManager = new PrefManager(getSharedPreferences("MyPref", MODE_PRIVATE));
```
To put a single value
``` java
    prefManager.username().put("tale").apply();
```
To put multiple values
``` java
    prefManager.username().put("tale")
        .userId().put(1)
        .apply();
```
To get value
``` java
    String username = prefManager.username().getOr("<default value>");
    long userId = prefManager.userId().getOr(0l);
```
That's it. Enjoy!

License
=======

    The MIT License (MIT)
    
    Copyright (c) 2014 Giang Nguyen
    
    Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
