package com.test.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

fun ViewGroup.inflate(@LayoutRes res: Int, attachToRoot: Boolean = false) =
    inflater().inflate(res, this, attachToRoot)

fun ViewGroup.inflater() = LayoutInflater.from(context)

fun Fragment.showFragment(@IdRes container: Int, fragment: Fragment) =
    requireActivity().supportFragmentManager.beginTransaction()
        .add(container, fragment)
        .addToBackStack(null)
        .commit()