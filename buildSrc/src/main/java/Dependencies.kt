object Versions {
    //kotlin
    const val KOTLIN_VERSION = "1.5.0"
    const val KOTLINX_COROUTINES = "1.5.0"

    //build
    const val BUILD_GRADLE = "4.2.1"
    const val COMPILE_SDK_VERSION = 31
    const val BUILD_TOOLS_VERSION = "31.0.3"
    const val MIN_SDK_VERSION = 23
    const val TARGET_SDK_VERSION = 31

    //androidx
    const val CORE_KTX = "1.6.0"
    const val APP_COMPAT = "1.3.0"
    const val LEGACY_V4_SUPPORT = "1.0.0"
    const val ACTIVITY_KTX = "1.2.3"
    const val FRAGMENT_KTX = "1.3.4"
    const val LIFECYCLE_KTX = "2.2.0"
    const val ROOM = "2.3.0"
    const val VIEWPAGER2 = "1.0.0"
    const val CONSTRAINTLAYOUT = "2.0.1"
    const val PREFERENCE = "1.1.1"
    const val RECYCLERVIEW = "1.2.1"
    const val RECYCLERVIEW_SELECTION = "1.2.0-alpha01"
    const val PAGING = "3.0.0"
    const val HILT_VIEWMODEL = "1.0.0-alpha03"
    const val KAPT_HILT = "1.0.0"

    //google
    const val HILT = "2.38.1"
    const val MATERIAL = "1.3.0"

    //libraries
    const val RETROFIT = "2.9.0"
    const val OKHTTP = "5.0.0-alpha.2"
    const val GLIDE = "4.11.0"
    const val COIL = "1.3.2"
    const val RXJAVA = "2.2.8"
    const val RXANDROID = "2.1.1"
    const val STETHO = "1.6.0"
    const val SQLITE_JDBC = "3.34.0"


    //test
    const val JUNIT = "4.13.2"
    const val ANDROID_JUNIT = "1.1.2"
    const val ESPRESSO_CORE = "3.3.0"
}

object Kotlin {
    const val KOTLIN_STDLIB      = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_VERSION}"
    const val COROUTINES_CORE    = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KOTLINX_COROUTINES}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KOTLINX_COROUTINES}"
}

object AndroidX {
    const val CORE_KTX                = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val APP_COMPAT              = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"

    const val LEGACY_SUPPORT_V4 = "androidx.legacy:legacy-support-v4:${Versions.LEGACY_V4_SUPPORT}"


    const val ACTIVITY_KTX            = "androidx.activity:activity-ktx:${Versions.ACTIVITY_KTX}"
    const val FRAGMENT_KTX            = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"

    const val LIFECYCLE_VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_KTX}"
    const val LIFECYCLE_LIVEDATA_KTX  = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_KTX}"
    const val LIFECYCLE_RUNTIME  = "androidx.lifecycle:lifecycle-runtime:${Versions.LIFECYCLE_KTX}"
    const val LIFECYCLE_COMMON  = "androidx.lifecycle:lifecycle-common:${Versions.LIFECYCLE_KTX}"
    const val LIFECYCLE_EXT =  "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE_KTX}"

    const val ROOM_RUNTIME            = "androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_KTX                = "androidx.room:room-ktx:${Versions.ROOM}"
    const val ROOM_COMPILER           = "androidx.room:room-compiler:${Versions.ROOM}"
    const val ROOM_RXJAVA2           = "androidx.room:room-rxjava2:${Versions.ROOM}"
    const val ROOM_TESTING           = "androidx.room:room-testing:${Versions.ROOM}"

    const val VIEWPAGER2           = "androidx.viewpager2:viewpager2:${Versions.VIEWPAGER2}"

    const val CONSTRAINTLAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINTLAYOUT}"

    const val PREFERENCE = "androidx.preference:preference-ktx:${Versions.PREFERENCE}"

    const val RECYCLERVIEW_SELECTION = "androidx.recyclerview:recyclerview-selection:${Versions.RECYCLERVIEW_SELECTION}"
    const val RECYCLERVIEW = "androidx.recyclerview:recyclerview:${Versions.RECYCLERVIEW}"

    const val PAGING = "androidx.paging:paging-runtime-ktx:${Versions.PAGING}"
    const val PAGING_TEST = "androidx.paging:paging-common:${Versions.PAGING}"

    //For Hilt support for ViewModel
    const val HILT_VIEWMODEL = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.HILT_VIEWMODEL}"
    const val KAPT_HILT = "androidx.hilt:hilt-compiler:${Versions.KAPT_HILT}"

}

object Google {
    const val HILT_ANDROID          = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"

    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
}

object Libraries {
    const val RETROFIT                   = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_CONVERTER_GSON    = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val RETROFIT_ADAPTER_RXJAVA2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.RETROFIT}"

    const val OKHTTP                     = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
    const val OKHTTP_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    const val OKHTTP_URLCONNECTION = "com.squareup.okhttp3:okhttp-urlconnection:${Versions.OKHTTP}"

    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
    const val GLIDE_OKHTTP_INTERCEPTOR = "com.github.bumptech.glide:okhttp3-integration:${Versions.GLIDE}"
    const val KAPT_GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${Versions.GLIDE}"

    const val COIL = "io.coil-kt:coil:${Versions.COIL}"
    const val COIL_SVG = "io.coil-kt:coil-svg:${Versions.COIL}"

    const val RXJAVA2_RXJAVA = "io.reactivex.rxjava2:rxandroid:${Versions.RXANDROID}"
    const val RXJAVA2_RXANDROID = "io.reactivex.rxjava2:rxjava:${Versions.RXJAVA}"

    const val STETHO = "com.facebook.stetho:stetho:${Versions.STETHO}"
    const val STETHO_OKHTTP = "com.facebook.stetho:stetho-okhttp3:${Versions.STETHO}"

    const val SQLITE_JDBC = "org.xerial:sqlite-jdbc:${Versions.SQLITE_JDBC}"
}

object UnitTest {
    const val JUNIT         = "junit:junit:${Versions.JUNIT}"
}

object AndroidTest {
    const val ANDROID_JUNIT = "androidx.test.ext:junit:${Versions.ANDROID_JUNIT}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
}