# yakan
a small library extending Kotlin for Android.

## add dependency
include maven to your project `build.gradle`.
```
allprojects {
  repositories {
    maven {
      url 'https://fuller-inc.github.io/yakan/repository'
    }
  }
}
```

then include `implementation` to your `app/build.gradle` or something.
```
dependencies {
  implementation "jp.co.fuller:yakan:x.y.x"
  // View extensions
  implementation "jp.co.fuller:yakan.view:x.y.x"
  // LiveData extensions
  implementation "jp.co.fuller:yakan.livedata:x.y.x"
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
`toStringWithSeparator()` returns to string with specified country's separators.
if the value is 123456, and locale is jp, returns to "123,456".
default locale is `Locale.US`
```kotlin
int.toStringWithSeparator(locale = Locale.JAPAN)
```

### Long
same as `Int`.

### View
`View.setOnSingleClickListener` set view a click listener that ignores "double click" event.

```kotlin
button.setOnSingleClickListener {
  // some events
}
```

### LiveData
`EventLiveData<T>` is a subtype of `MutableLiveData` that do not hold a value after emitting a value.

```kotlin
val liveData = EventLiveData<Boolean>()
liveData.value = true // emitting once, and don't hold a value.
```

`LiveData<T>.filter` filter LiveData that emits value by predicate.

```kotlin
liveData.filter { it == true }
```

`merge` merges any number of `LiveData` and emits latest values.

```kotlin
val mergedData = merge(liveData1, liveData2)
liveData1.value = true // mergedData emits `true`.
```

`map` converts `LiveData` the type parameter `T` to `R`.

```kotlin
liveData.value = 123
val convertedData = liveData.map { it.toString() } // convertedData emits "123", String type.
```

`combineLatest` combine some `LiveData` and returns a new value.

```kotlin
val combinedData = combineLatest(liveData1, liveData2) { live1, live2 ->
  "${live1} and ${live2}"
}
liveData1.value = "test"
liveData2.value = true // combinedData is the "test and true".
```
