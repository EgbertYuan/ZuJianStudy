package cn.egbert.corelibrary.adapter;

/**
 * @version V1.0
 * @description:
 * @author: Egbert
 * @date: 2018/9/30
 */

public interface MultiTypeSupport<T> {
    /**
     * 根据当前位置或者条目数据返回布局
     * @param item
     * @param position
     * @return
     */
    int getLayoutId(T item, int position);
}
