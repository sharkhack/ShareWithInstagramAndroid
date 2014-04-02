//
//  Created by Azer Bulbul on 12/29/13.
//  Copyright (c) 2013 Azer Bulbul. All rights reserved.
//
package com.azer.android.ShareWithInstagramAndroid;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class ShInstagramExtension  implements FREExtension {
	
	public static ShInstagramExtensionContext context;
	
	
	public FREContext createContext(String contextType) {
		return context = new ShInstagramExtensionContext();
	}

	
	public void dispose() {
		
		if(context!=null){
			context.cleardata();
		}
		
		context = null;
	}

	
	public void initialize() {}
}
