package com.softteco.template.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.softteco.template.presentation.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * Base class for all Fragments
 * @property binding binds the views in a layout XML to fields
 */
@AndroidEntryPoint
abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {

    abstract val binding: ViewBinding

    private var snackBar: Snackbar? = null

    /**
     * Return the View for the fragment's UI
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setStatusBarColor()
        subscribeUi()
    }

    /**
     * Set a status bar color to this fragment.
     */
    protected open fun setStatusBarColor() {
        activity?.let {
            it.window.statusBarColor = it.getColor(
                R.color.background
            )
        }
    }

    /**
     * Initialize/Subscribe UI properties after Fragment's View created.
     */
    abstract fun subscribeUi()

    /**
     * Method to display error message
     */
    protected fun showError(msg: String, onRetry: () -> Unit) {
        view?.let {
            snackBar = Snackbar.make(it, msg, Snackbar.LENGTH_INDEFINITE)
            snackBar?.setAction("RETRY") {
                snackBar?.dismiss()
                onRetry.invoke()
            }
            snackBar?.show()
        }
    }

    /**
     * Method to display a message to the user via SnackBar.
     */
    protected fun showMessage(msg: String) {
        view?.let {
            hideError()
            snackBar = Snackbar.make(it, msg, Snackbar.LENGTH_SHORT)
            snackBar?.show()
        }
    }

    /**
     * Method to dismiss the displayed message.
     */
    private fun hideError() {
        snackBar?.dismiss()
    }
}
