package com.softteco.template.presentation.common

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment

/**
 * Base clas for navigation
 */
class StatelessNavHost : NavHostFragment() {
    /**
     * Method calls to do initial creation of a fragment
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(null)
    }
}
