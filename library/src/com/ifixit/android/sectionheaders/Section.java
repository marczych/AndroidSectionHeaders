package com.ifixit.android.sectionheaders;

import android.view.ViewGroup;
import android.view.View;

import android.widget.AdapterView;
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

   /**
    * Called from SectionHeaderAdapter.onItemClick. Position is relative
    * to the list and does not include the header
    */
   public void onItemClick(AdapterView<?> adapterView, View view,
    int position, long longid) {
      // Do nothing by default
   }
}
