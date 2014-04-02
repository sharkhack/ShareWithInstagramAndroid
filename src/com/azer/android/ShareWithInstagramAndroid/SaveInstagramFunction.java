//
//  Created by Azer Bulbul on 12/29/13.
//  Copyright (c) 2013 Azer Bulbul. All rights reserved.
//
package com.azer.android.ShareWithInstagramAndroid;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

import com.adobe.fre.FREBitmapData;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class SaveInstagramFunction implements FREFunction {
	
	@Override
	public FREObject call(FREContext context, FREObject[] passedArgs) 
	{	
		
		try {

			ShInstagramExtension.context.inputValue = (FREBitmapData)passedArgs[0];
			ShInstagramExtension.context.inputValue.acquire();
			int srcWidth = ShInstagramExtension.context.inputValue.getWidth();
			int srcHeight =ShInstagramExtension.context.inputValue.getHeight();
			
			ShInstagramExtension.context.inputValue.release();
			ShInstagramExtension.context.inputValue.acquire();
			
			if(srcWidth>0){
				ShInstagramExtension.context.bm = Bitmap.createBitmap(srcWidth, srcHeight, Config.ARGB_8888);
				ShInstagramExtension.context.bm.copyPixelsFromBuffer( ShInstagramExtension.context.inputValue.getBits() );
				
				ShInstagramExtension.context.shareImageInstagram();
			} else {
				
				ShInstagramExtension.context.cleardata();
			}

		} catch (Exception e) {
			e.printStackTrace();
			ShInstagramExtension.context.cleardata();
			ShInstagramExtension.context.dispatchStatusEventAsync("ok", "status");
		}
		catch (Error e){
			
			e.printStackTrace(); 
			ShInstagramExtension.context.cleardata();
			ShInstagramExtension.context.dispatchStatusEventAsync("ok", "status");
		}
		finally{
			                       
		}

		
		return null;
	}
}
