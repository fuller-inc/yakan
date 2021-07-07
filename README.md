# yakan
a small library extending Kotlin for Android.

## add dependency
include maven to your project `build.gradle`.
```
allprojects {
  repositories {
    maven {
      url 'http://fuller-inc.github.io/yakan/repository'
    }
  }
}
```

then include `implementation` to your `app/build.gradle` or something.
```
dependencies {
  implementation "jp.co.fuller:yakan:x.y.x"
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
`pred()` and `safePred()` is the predecessor version of `succ()` and `safeSucc()`. Also, you can use `hasSucc()` and `hasPred()` to check if successor or predecessor exists.
`isEven` and `isOdd` returns a boolean that represents the number is even or odd.
```kotlin
int.isEven
int.isOdd
```

### Long
same as `Int`.