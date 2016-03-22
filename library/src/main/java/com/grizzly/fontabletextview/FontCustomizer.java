package com.grizzly.fontabletextview;

import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by FcoPardo on 3/21/16.
 */
public interface FontCustomizer {

    FontCustomizer DEFAULT_BEHAVIOR = new FontCustomizer() {

        private String customFont;
        private TextView view;

        @Override
        public void setCustomFont() {
            if(customFont!=null && !customFont.trim().equalsIgnoreCase("")){
                setCustomFont(customFont);
            }
            else{
                if(FontCustomizator.font!=null && !FontCustomizator.font.trim().equalsIgnoreCase("")){
                    setCustomFont(FontCustomizator.font);
                }

            }
        }

        @Override
        public void setCustomFont(String font) {
            try{
                customFont = font;
                Typeface face = Typeface.createFromAsset(view.getContext().getAssets(),
                        font);
                view.setTypeface(face);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public void setTextView(TextView textView) {
            view = textView;
        }
    };

    void setCustomFont();
    void setCustomFont(String font);
    void setTextView(TextView textView);

}
