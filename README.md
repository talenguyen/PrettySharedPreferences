PrettySharedPreferences
=======================

PrettySharedPreferences is a lightweight library for help you deal with SharedPreferences more easy and reduce most of boilplace code.

Features
========

 * Easy to use
 * Reduce most of boilplace code.

Download
========
### JAR
Download [the latest JAR][1]

or

### Gradle
```groovy
dependencies {
    compile 'com.github.talenguyen:prettysharedpreferences:1.0.1'
}
```

or

### Maven
``` xml
 <dependency>
  <groupId>com.github.talenguyen</groupId>
  <artifactId>prettysharedpreferences</artifactId>
  <version>1.0.1</version>
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

    
    Copyright 2014 Giang Nguyen

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[1]: http://search.maven.org/remotecontent?filepath=com/github/talenguyen/prettysharedpreferences/1.0.1/prettysharedpreferences-1.0.1.jar
