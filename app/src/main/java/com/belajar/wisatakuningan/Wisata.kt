package com.belajar.wisatakuningan

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Wisata(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
