package com.ifixit.android.sectionheaders;

import java.util.ArrayList;

import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView.OnItemClickListener;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;

public class SectionHeadersAdapter extends BaseAdapter
 implements OnItemClickListener {
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

   protected ArrayList<Section> mSections;

   public SectionHeadersAdapter() {
      mSections = new ArrayList<Section>();
   }

   public void addSection(Section section) {
      mSections.add(section);
   }

   public int getCount() {
      int count = 0;

      for (Section section : mSections) {
         // One more for the header
         count += section.getCount() + 1;
      }

      return count;
   }

   public Object getItem(int position) {
      SectionPosition section = getSectionPosition(position);

      if (section.position == HEADER_POSITION) {
         return section.section.getHeaderItem();
      } else {
         return section.section.getItem(section.position);
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

   public void onItemClick(AdapterView<?> adapterView, View view,
    int position, long id) {
      SectionPosition section = getSectionPosition(position);

      if (section.position == HEADER_POSITION) {
         return;
      } else {
         section.section.onItemClick(adapterView, view, section.position, id);
      }
   }

   /**
    * Returns the section and position within that section based on the
    * given absolute position in the list.
    */
   private SectionPosition getSectionPosition(int position) {
      for (Section section : mSections) {
         if (position == 0) {
            return new SectionPosition(section, HEADER_POSITION);
         } else if (position <= section.getCount()) {
            return new SectionPosition(section, position - 1);
         } else {
            position -= section.getCount() + 1;
         }
      }

      return null;
   }
}
