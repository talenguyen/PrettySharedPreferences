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
