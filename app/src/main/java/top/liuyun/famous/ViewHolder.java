package top.liuyun.famous;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

//import com.squareup.picasso.Picasso;


public class ViewHolder
{
    private final SparseArray<View> mViews;

    private int mPosition;

    private View mConvertView;

    private ViewHolder(Context context, ViewGroup parent, int layoutId,
            int position)
    {
        this.mPosition = position;
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        // setTag
        mConvertView.setTag(this);
    }

    /**
     * 拿到一个ViewHolder对象
     *
     * @param context
     * @param convertView
     * @param parent
     * @param layoutId
     * @param position
     * @return
     */
    public static ViewHolder get(Context context, View convertView,
            ViewGroup parent, int layoutId, int position)
    {
        if (convertView == null)
        {
            return new ViewHolder(context, parent, layoutId, position);
        }
        return (ViewHolder) convertView.getTag();
    }

    public View getConvertView()
    {
        return mConvertView;
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId)
    {
        View view = mViews.get(viewId);
        if (view == null)
        {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param string
     * @return
     */
    public ViewHolder setText(int viewId, String string)
    {
        TextView view = getView(viewId);
        view.setText(string);
        return this;
    }

    /**
     * 获取edit文本
     *
     * @param viewId
     * @return
     */
    public String getEditText(int viewId)
    {
        EditText ed = getView(viewId);
        String str = ed.getText().toString();
        return str;
    }


    public void setRating(int viewId, int iScore){
        RatingBar ratingBar = getView(viewId);
        //ratingBar.setMax(10);
        ratingBar.setProgress(iScore);
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param drawableId
     * @return
     */
    public ViewHolder setImageResource(int viewId, int drawableId)
    {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @return
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bm)
    {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @return
     */
    public ViewHolder setImageByUrl(int viewId, String url,Context context)
    {
       ImageView iv = getView(viewId);
////        DisplayImageOptions options = new DisplayImageOptions.Builder()
////                .showImageOnLoading(R.mipmap.ic_launcher)
////                .showImageOnFail(R.mipmap.ic_launcher)
////                // 设置图片质量
////                .bitmapConfig(Bitmap.Config.RGB_565)
////                // 设置内存缓存
////                .cacheInMemory(true)
////                // 设置磁盘缓存
////                .cacheOnDisk(true)
////                // 设置图片特效
////                .displayer(new FadeInBitmapDisplayer(300)).build();
////        ImageLoader.getInstance().displayImage(url, new ImageViewAware(iv),
////                options);
//
////        NetworkImageView networkImageView = getView(viewId);
////        networkImageView.setDefaultImageResId(R.mipmap.ic_launcher);
////        networkImageView.setErrorImageResId(R.mipmap.ic_launcher);
////        networkImageView.setImageUrl(
////                url,
////                new ImageLoader(VolleyManager.getInstance().getRequestQueues(),
////                        VolleyManager.getInstance().getImageCache()));
//
//
//        if(!TextUtils.isEmpty(url)&&url!=null)
//        Picasso.with(context).load(url).into(iv);


        return this;
    }

    /**
     * 给view设置背景色
     *
     * @param viewId
     * @param color
     * @return
     */
    public ViewHolder setBackgroundColor(int viewId, int color)
    {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public int getPosition()
    {
        return mPosition;
    }

}
