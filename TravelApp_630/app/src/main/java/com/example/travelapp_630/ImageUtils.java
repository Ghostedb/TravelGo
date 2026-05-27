package com.example.travelapp_630;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

public class ImageUtils {

    public static void setSafeBackground(View view, int resId) {
        if (resId == 0) return;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(view.getContext().getResources(), resId, options);

            int reqWidth = 1024;
            int reqHeight = 1024;
            int inSampleSize = 1;

            if (options.outHeight > reqHeight || options.outWidth > reqWidth) {
                final int halfHeight = options.outHeight / 2;
                final int halfWidth = options.outWidth / 2;
                while ((halfHeight / inSampleSize) >= reqHeight || (halfWidth / inSampleSize) >= reqWidth) {
                    inSampleSize *= 2;
                }
            }

            options.inSampleSize = inSampleSize;
            options.inJustDecodeBounds = false;
            options.inScaled = false;

            Bitmap bitmap = BitmapFactory.decodeResource(view.getContext().getResources(), resId, options);
            if (bitmap != null) {
                Drawable drawable = new BitmapDrawable(view.getContext().getResources(), bitmap);
                view.setBackground(drawable);
            } else {
                view.setBackgroundResource(resId);
            }
        } catch (Exception e) {
            try {
                view.setBackgroundResource(resId);
            } catch (Throwable t) {
            }
        }
    }

    public static void setSafeImage(ImageView imageView, int resId) {
        if (resId == 0) return;
        
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(imageView.getContext().getResources(), resId, options);

            int reqWidth = 1024;
            int reqHeight = 1024;
            int inSampleSize = 1;

            if (options.outHeight > reqHeight || options.outWidth > reqWidth) {
                final int halfHeight = options.outHeight / 2;
                final int halfWidth = options.outWidth / 2;

                while ((halfHeight / inSampleSize) >= reqHeight || (halfWidth / inSampleSize) >= reqWidth) {
                    inSampleSize *= 2;
                }
            }

            options.inSampleSize = inSampleSize;
            options.inJustDecodeBounds = false;
            options.inScaled = false; 

            Bitmap bitmap = BitmapFactory.decodeResource(imageView.getContext().getResources(), resId, options);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else {
                imageView.setImageResource(resId);
            }
        } catch (Exception e) {
            try {
                imageView.setImageResource(resId);
            } catch (Throwable t) {
                imageView.setImageBitmap(null);
            }
        }
    }
}
