package fernan.apps.segmented


import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import fernan.apps.segmented.Utils.tintDrawable


class SegmentedButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private var initId = 12345
    private val tabItems = mutableMapOf<Int, TabLayout.Tab>()

    init {
        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.custom_tablayout, this, true)

        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.SegmentedButton)


        // Color Selected
        typedArray.getColor(R.styleable.SegmentedButton_colorSelected, -1).let {
            if (it != -1) {
                tabLayout.setSelectedTabIndicatorColor(it)
                tabLayout.setSelectedTabIndicator(
                    tintDrawable(
                        this.context,
                        R.drawable.shape_rounded_selected,
                        it
                    )
                )

            }
        }


        // Color Background
        typedArray.getColor(R.styleable.SegmentedButton_colorBackground, -1).let {

            if (it != -1) {
                tabLayout.background =
                    tintDrawable(this.context, R.drawable.shape_rounded_container, it)
            }
        }


        // Select Button Background
        typedArray.getDrawable(R.styleable.SegmentedButton_backgroundSelected)?.let {
            tabLayout.setSelectedTabIndicator(it)
        }

        // Container Background
        typedArray.getDrawable(R.styleable.SegmentedButton_backgroundContainer)?.let {
            tabLayout.background = it
        }


        var normalColor = ContextCompat.getColor(this.context, R.color.blue_grey_800)
        var selectedColor = Color.WHITE

        var IsNormalColor = false
        var IsSelectedColor = false

        // Color Text Selected
        typedArray.getColor(R.styleable.SegmentedButton_colorTextSelected, -1).let {

            if (it != -1) {
                tabLayout.setTabTextColors(normalColor, it)
                IsSelectedColor = true
                selectedColor = it
            }
        }

        // Color Text Default
        typedArray.getColor(R.styleable.SegmentedButton_colorTextDefault, -1).let {
            if (it != -1) {
                tabLayout.setTabTextColors(it, selectedColor)
                IsNormalColor = true
                normalColor = it
            }
        }
        if (IsNormalColor && IsSelectedColor) {
            tabLayout.setTabTextColors(normalColor, selectedColor)
        }


        typedArray.getString(R.styleable.SegmentedButton_items)?.let {
            val items = listOf(*it.split(",".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray())

            if (items.size != items.distinct().size) {
                throw Exception("Any of your items have the same name")
            }

            items.forEach {
                tabItems[initId] = tabLayout.newTab().apply {
                    tag = it
                    text = it
                }
                initId++

            }
        }


        typedArray.recycle()



        tabItems.forEach {
            tabLayout.addTab(it.value)
        }

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                listener?.onSelected(tab.tag.toString())
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

    }

    private var listener: SegmentedListen? = null

    fun setListener(listener: SegmentedListen?) {
        this.listener = listener
    }

    interface SegmentedListen {
        fun onSelected(nameItem: String)
    }


}
