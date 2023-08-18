package com.softteco.template.presentation.features.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.softteco.template.presentation.features.login.loginComponents.login.LoginScreen
import dagger.hilt.android.AndroidEntryPoint

/**
 * Fragment for login screen
 */
@AndroidEntryPoint
class LoginComposeFragment : Fragment() {
    /**
     * Return the View for the fragment's UI
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                LoginScreen(onNavigateToRegistration = { dest -> findNavController().navigate(dest) })
            }
        }
    }
}
