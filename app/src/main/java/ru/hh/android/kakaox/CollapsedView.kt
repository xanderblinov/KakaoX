package ru.hh.android.kakaox

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CollapsedView : View {

    interface OnEndAnimationListener {
        fun onAnimationEnd()
    }

    private val DEFAULT_MIN_RADIUS_SCALE = 2
    private val DEFAULT_MAX_RADIUS_SCALE = 5

    private var thickness = 1F
    private var minRadius = 0F
    private var maxRadius = 0F
    private var dotColor: Int = Color.RED

    private var paint = Paint()
    private var bounds = RectF()
    private var size: Int = 0
    private var listeners: MutableSet<OnEndAnimationListener> = linkedSetOf()

    private var currentValue = 0f

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet) {
        init(attributeSet)
    }

    constructor(context: Context, attributeSet: AttributeSet?, defStyle: Int) : super(context, attributeSet, defStyle) {
        init(attributeSet)
    }

    private fun init(attributeSet: AttributeSet?) {
        if (attributeSet != null) {
            var typedArray: TypedArray? = null
            try {
                /*typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.DottedProgressView)
                thickness = typedArray.getDimension(R.styleable.DottedProgressView_thickness,
                    resources.getDimension(R.dimen.DottedProgressView_default_thickness))
                dotColor = typedArray.getColor(R.styleable.DottedProgressView_dotColor,
                    ContextCompat.getColor(context, R.color.DottedProgressView_default_dots_color))
                clockwise = typedArray.getBoolean(R.styleable.DottedProgressView_clockwise, clockwise)
                minRadius = typedArray.getDimension(R.styleable.DottedProgressView_minRadius,
                    (thickness * DEFAULT_MIN_RADIUS_SCALE))
                maxRadius = typedArray.getDimension(R.styleable.DottedProgressView_maxRadius,
                    thickness * DEFAULT_MAX_RADIUS_SCALE)*/
            } finally {
                typedArray?.recycle()
            }
        } else {
            thickness = 2f //resources.getDimension(R.dimen.DottedProgressView_default_thickness)
            dotColor = Color.RED //ContextCompat.getColor(context, R.color.DottedProgressView_default_dots_color)
            minRadius = thickness * DEFAULT_MIN_RADIUS_SCALE
            maxRadius = thickness * DEFAULT_MAX_RADIUS_SCALE
        }
        paint.color = dotColor
        paint.flags = Paint.ANTI_ALIAS_FLAG

        val animatorRotate = ValueAnimator.ofFloat(0f, 1f)
        animatorRotate.addUpdateListener{
            currentValue = it.animatedValue as Float
            invalidate()
        }
        animatorRotate.repeatCount = 100
        animatorRotate.repeatMode = ValueAnimator.REVERSE
        animatorRotate.start()

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val paddingX = paddingLeft + paddingRight
        val paddingY = paddingTop + paddingBottom
        val width = measuredWidth - paddingX
        val height = measuredHeight - paddingY
        size = if (width > height) height else width

        setMeasuredDimension(size + paddingX, size + paddingY)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        size = if (w > h) w else h
        bounds.set(
            thickness,
            thickness,
            (size - thickness),
            (size - thickness)
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(width/2f, height/2f, currentValue * width/2, paint)
    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
    }


    fun addOnStopListener(listener: OnEndAnimationListener) {
        listeners.add(listener)
    }

    fun removeOnStopListener(listener: OnEndAnimationListener) {
        listeners.remove(listener)
    }
}

