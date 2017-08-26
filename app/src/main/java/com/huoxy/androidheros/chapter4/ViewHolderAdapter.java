package com.huoxy.androidheros.chapter4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huoxy.androidheros.R;

import java.util.List;

/**
 * Created by huoxy on 2017/8/26.
 */
public class ViewHolderAdapter extends BaseAdapter {

    private List<String> data;
    private LayoutInflater inflater;

    public ViewHolderAdapter(Context context, List<String> data){
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_list_view, null);
            holder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            holder.message = (TextView) convertView.findViewById(R.id.message);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        String string = data.get(position);
        holder.message.setText(string);
        return convertView;
    }

    final class ViewHolder{
        ImageView avatar;
        TextView message;
    }
}
