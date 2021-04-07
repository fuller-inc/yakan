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
  implementation "com.okuzawats:yakan:1.0.3"
}
```

## how to use
### Any
`unwrap()` unwraps nullable value.
```
any.unwrap()
```