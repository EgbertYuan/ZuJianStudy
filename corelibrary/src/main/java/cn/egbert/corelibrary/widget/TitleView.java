package cn.egbert.corelibrary.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.egbert.corelibrary.R;

/**
 * @version V1.0
 * @类名称：TitleView
 * @类描述: 一个标题的类，左右是图片，中间文字。
 * @创建人: EgbertYuan
 * @创建时间: 2017/10/13
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class TitleView extends LinearLayout implements View.OnClickListener {
    private ImageView leftImg, rightImg;
    private TextView title, rightTxt;
    private LinearLayout layout;
    private RelativeLayout bodyLayout;
    private OnTitleViewLeftClickListener leftListener;
    private OnTitleViewRightClickListener rightListener;
    private OnTitleViewRightTextClickListener rightTextListener;
    private Context mContext;

    public TitleView(Context context) {
        super(context);
        init(context);
    }

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        init(context);
        //获取自定义的属性
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.Core_TitleView);
        CharSequence text = array.getText(R.styleable.Core_TitleView_core_centertitle);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text.toString());
            setTitleGone(false);
        }
        CharSequence rightText = array.getText(R.styleable.Core_TitleView_core_righttxt);
        if (!TextUtils.isEmpty(rightText)) {
            rightTxt.setOnClickListener(this);
            setRightTxt(rightText.toString());
            setRightTxtGone(false);
            setRightImgGone(true);
        }
        Drawable drawableLeft = array.getDrawable(R.styleable.Core_TitleView_core_leftImage);
        if (drawableLeft != null) {
            leftImg.setImageDrawable(drawableLeft);
            leftImg.setOnClickListener(this);
            setLeftImgGone(false);
        }
        Drawable drawableRight = array.getDrawable(R.styleable.Core_TitleView_core_rightImage);
        if (drawableRight != null) {
            rightImg.setImageDrawable(drawableRight);
            rightImg.setOnClickListener(this);
            setRightTxtGone(true);
            setRightImgGone(false);
        }
        int color = array.getColor(R.styleable.Core_TitleView_core_body_background, ContextCompat.getColor(context, R.color.core_title_bar_color));
        if (color != 0) {
            bodyLayout.setBackgroundColor(color);
        }
        array.recycle();
    }


    private void init(Context context) {
        mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.widget_titleview, this, true);
        leftImg = (ImageView) view.findViewById(R.id.titleview_leftImg);
        rightImg = (ImageView) view.findViewById(R.id.titleview_rightImg);
        title = (TextView) view.findViewById(R.id.titleview_title);
        rightTxt = (TextView) view.findViewById(R.id.titleview_rightTxt);
        layout = (LinearLayout) findViewById(R.id.titleview_ll);
        bodyLayout = (RelativeLayout) findViewById(R.id.titleview_body_ll);
    }

    public void setRightTxtGone(boolean b) {
        if (b) {
            rightTxt.setVisibility(View.GONE);
        } else {
            rightTxt.setVisibility(View.VISIBLE);
        }
    }

    public void setRightTxtInvisibie(boolean b) {
        if (b) {
            rightTxt.setVisibility(View.INVISIBLE);
        } else {
            rightTxt.setVisibility(View.VISIBLE);
        }
    }

    public void setLeftImgGone(boolean b) {
        if (b) {
            leftImg.setVisibility(View.GONE);
        } else {
            leftImg.setVisibility(View.VISIBLE);
        }

    }

    public void setLeftImgInVisiable(boolean b) {
        if (b) {
            leftImg.setVisibility(View.INVISIBLE);
        } else {
            leftImg.setVisibility(View.VISIBLE);
        }

    }

    public void setRightImgGone(boolean b) {
        if (b) {
            rightImg.setVisibility(View.GONE);
        } else {
            rightImg.setVisibility(View.VISIBLE);
        }

    }

    public void setRightImgInvisibie(boolean b) {
        if (b) {
            rightImg.setVisibility(View.INVISIBLE);
        } else {
            rightImg.setVisibility(View.VISIBLE);
        }

    }

    public void setTitleGone(boolean b) {
        if (b) {
            title.setVisibility(View.INVISIBLE);
        } else {
            title.setVisibility(View.VISIBLE);
        }
    }

    public void setLeftImgRes(int rId) {
        leftImg.setImageResource(rId);
        leftImg.setOnClickListener(this);
    }

    public void setRightImgRes(int rId) {
        rightImg.setImageResource(rId);
    }

    public void setTitle(String string) {
        title.setText(string);
    }

    public void setRightTxt(String s) {
        rightTxt.setText(s);
        setRightTxtGone(false);
        rightTxt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.titleview_leftImg) {
            if (null != leftListener) {
                leftListener.onTitleViewLeftClick();
            }
        } else if (id == R.id.titleview_rightImg) {
            if (null != rightListener) {
                rightListener.onTitleViewRightClick();
            }
        } else if (id == R.id.titleview_rightTxt) {
            if (null != rightTextListener) {
                rightTextListener.onTitleViewRightTextClick();
            }
        }
    }

    public void setLeftListener(OnTitleViewLeftClickListener listener) {
        this.leftListener = listener;
    }

    public void setRightListener(OnTitleViewRightClickListener listener) {
        this.rightListener = listener;
    }

    public void setRightTextListener(OnTitleViewRightTextClickListener listener) {
        this.rightTextListener = listener;
    }


    public interface OnTitleViewLeftClickListener {
        void onTitleViewLeftClick();
    }

    public interface OnTitleViewRightClickListener {
        void onTitleViewRightClick();
    }

    public interface OnTitleViewRightTextClickListener {
        void onTitleViewRightTextClick();
    }

    /**
     * 让title中实际有用的隐藏
     *
     * @param gone
     */
    public void setAllTitleGone(boolean gone) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (gone) {
                bodyLayout.setVisibility(GONE);
            } else {
                bodyLayout.setVisibility(VISIBLE);
            }
        } else {
            if (gone) {
                layout.setVisibility(GONE);
            } else {
                layout.setVisibility(VISIBLE);
            }
        }
    }

    /**
     * 修改标题栏的颜色
     *
     * @param color
     */
    public void setTitleColor(@ColorRes int color) {
        bodyLayout.setBackgroundColor(ContextCompat.getColor(mContext, color));
    }
}