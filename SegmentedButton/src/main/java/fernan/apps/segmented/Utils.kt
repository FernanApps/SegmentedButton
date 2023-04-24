package fernan.apps.segmented

import android.content.Context
import android.graphics.drawable.GradientDrawable
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

object Utils {

    fun tintDrawable(context: Context, @DrawableRes id: Int, @ColorInt color: Int): GradientDrawable {
        val backgroundDrawable = ContextCompat.getDrawable(context, id) as GradientDrawable
        backgroundDrawable.setColor(color)
        return backgroundDrawable
    }
}