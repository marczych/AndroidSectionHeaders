package com.ifixit.android.sectionheaders;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class SectionHeadersAdapter extends BaseAdapter {
   protected Section mSection;

   public void addSection(Section section) {
      mSection = section;
   }

   public int getCount() {
      // One more for the header
      return mSection.getCount() + 1;
   }

   public Object getItem(int position) {
      if (position == 0) {
         return mSection.getHeaderItem();
      } else {
         return mSection.getItem(position - 1);
      }
   }

   public long getItemId(int position) {
      return position;
   }

   public View getView(int position, View convertView, ViewGroup parent) {
      if (position == 0) {
         return mSection.getHeaderView();
      } else {
         return mSection.getView(position -1, convertView, parent);
      }
   }
}
