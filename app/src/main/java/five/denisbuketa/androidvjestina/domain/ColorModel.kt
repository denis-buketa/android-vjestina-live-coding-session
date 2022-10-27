package com.raywenderlich.android.jetnotes.domain.model

/**
 * Model class for one Color
 */
data class ColorModel(
  val id: Long,
  val hex: Long,
  val name: String
) {

  companion object {

    val DEFAULT_COLORS = listOf(
      ColorModel(1, 0xFFFFFFFF, "White"),
      ColorModel(2, 0xFFE57373, "Red"),
      ColorModel(3, 0xFFF06292, "Pink"),
      ColorModel(4, 0xFFCE93D8, "Purple"),
      ColorModel(5, 0xFF2196F3, "Blue"),
      ColorModel(6, 0xFF00ACC1, "Cyan"),
      ColorModel(7, 0xFF26A69A, "Teal"),
      ColorModel(8, 0xFF4CAF50, "Green"),
      ColorModel(9, 0xFF8BC34A, "Light Green"),
      ColorModel(10, 0xFFCDDC39, "Lime"),
      ColorModel(11, 0xFFFFEB3B, "Yellow"),
      ColorModel(12, 0xFFFF9800, "Orange"),
      ColorModel(13, 0xFFBCAAA4, "Brown"),
      ColorModel(14, 0xFF9E9E9E, "Gray")
    )
  }
}
