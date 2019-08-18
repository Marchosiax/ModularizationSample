package com.xvermilion.modulesample.navigation.loaders

import androidx.fragment.app.Fragment

internal fun String.loadFragmentOrNull(): Fragment? =
    try {
        this.loadClassOrNull<Fragment>()?.newInstance()
    } catch (e: ClassNotFoundException) {
        null
    }
