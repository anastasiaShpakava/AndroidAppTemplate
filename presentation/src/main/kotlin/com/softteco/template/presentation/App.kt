package com.softteco.template.presentation

import android.app.Application
import androidx.viewbinding.BuildConfig
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.decode.SvgDecoder
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Base Activity
 */
@HiltAndroidApp
class App : Application(), ImageLoaderFactory {

    /**
     * Calls when the activity is starting
     */
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .components { add(SvgDecoder.Factory()) }
            .crossfade(true)
            .build()
    }
}
