package com.ifixit.android.sectionheaders;

import android.view.ViewGroup;
import android.view.View;

import android.widget.BaseAdapter;

public abstract class Section extends BaseAdapter {
   /**
    * Analogous to BaseAdapter's getItem method but for the header
    */
   public abstract Object getHeaderItem();

   /**
    * Analogous to BaseAdapter's getView method but for the header
    */
   public abstract View getHeaderView(View convertView, ViewGroup parent);
}
