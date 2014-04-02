//
//  Created by Azer Bulbul on 12/29/13.
//  Copyright (c) 2013 Azer Bulbul. All rights reserved.
//
package com.azer.android.ShareWithInstagramAndroid;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREWrongThreadException;

public class IsInstagramAvailableFunction  implements FREFunction
{
    @Override
    public FREObject call(FREContext context, FREObject[] args)
    {
            try
            {
                 return FREObject.newObject(ShInstagramExtension.context.isInstagram());
            }
            catch (FREWrongThreadException e)
            {
            	e.printStackTrace();
            	return null;
            }
    }
}
