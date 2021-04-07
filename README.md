# yakan
a small library extending Kotlin for Android.

## add dependency
include maven to your project `build.gradle`.
```
allprojects {
  repositories {
    maven {
      url 'http://okuzawats.github.io/yakan/repository'
    }
  }
}
```

then include `implementation` to your `app/build.gradle` or something.
```
dependencies {
  implementation "com.okuzawats:yakan:1.0.4"
}
```

## how to use
### Any
`unwrap()` unwraps nullable value.
```kotlin
any.unwrap()
```

`isNull()` returns true if null.
```kotlin
any.isNull()
```

`isNotNull()` returns true if not null.
```kotlin
any.isNotNull()
```

### Boolean
`isTrue()` returns true if not null and true.
```kotlin
boolean.isTrue()
```

`isFalse()` returns true if not null and false.
```kotlin
boolean.isFalse()
```

### Int
`succ()` returns successor.
```kotlin
int.succ()
```
`safeSucc()` returns successor or throw exception if the value is Int.MAX_VALUE.
```kotlin
int.safeSucc()
```
`pred()` and `safePred()` is the predecessor version of `succ()` and `safeSucc()`.

### Long
`succ()`, `safeSucc()`, `pred()`, and `safePred()` offers same function of that of Int.