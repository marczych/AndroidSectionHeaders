package com.ifixit.android.sectionheaders;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class SectionHeadersAdapter extends BaseAdapter {
   // Needed because Java can't return two values from a function
   private static class SectionPosition {
      public Section section;
      public int position;

      public SectionPosition(Section section, int position) {
         this.section = section;
         this.position = position;
      }
   }

   private static final int HEADER_POSITION = -1;
   private static final int VIEW_TYPES = 2;
   private static final int HEADER_VIEW_TYPE = 0;
   private static final int ITEM_VIEW_TYPE = 1;

   protected Section mSection;

   public void addSection(Section section) {
      mSection = section;
   }

   public int getCount() {
      // One more for the header
      return mSection.getCount() + 1;
   }

   public Object getItem(int position) {
      SectionPosition section = getSectionPosition(position);

      if (section.position == HEADER_POSITION) {
         return section.section.getHeaderItem();
      } else {
         return mSection.getItem(section.position);
      }
   }

   public long getItemId(int position) {
      return position;
   }

   @Override
   public int getViewTypeCount() {
      return VIEW_TYPES;
   }

   @Override
   public int getItemViewType(int position) {
      SectionPosition section = getSectionPosition(position);

      if (section.position == HEADER_POSITION) {
         return HEADER_VIEW_TYPE;
      } else {
         return ITEM_VIEW_TYPE;
      }
   }

   @Override
   public boolean areAllItemsEnabled() {
      return false;
   }

   public boolean isEnabled(int position) {
      SectionPosition section = getSectionPosition(position);

      if (section.position == HEADER_POSITION) {
         return false;
      } else {
         return true;
      }
   }

   public View getView(int position, View convertView, ViewGroup parent) {
      SectionPosition section = getSectionPosition(position);

      if (section.position == HEADER_POSITION) {
         return section.section.getHeaderView(convertView, parent);
      } else {
         return section.section.getView(section.position, convertView, parent);
      }
   }

   /**
    * Returns the section and position within that section based on the
    * given absolute position in the list.
    */
   private SectionPosition getSectionPosition(int position) {
      if (position == 0) {
         return new SectionPosition(mSection, HEADER_POSITION);
      } else {
         return new SectionPosition(mSection, position - 1);
      }
   }
}
