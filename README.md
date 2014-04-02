# Android Sharing With Instagram App ANE
===============

Android sharing for Instagram - Adobe Air Native Extension

If your application creates photos and you'd like your users to share these photos using Instagram, you can use the Document Interaction API to open your photo in Instagram's sharing flow.

ENJOY! :)

Adobe Air Native Extension Help
http://help.adobe.com/en_US/air/build/WS597e5dadb9cc1e0253f7d2fc1311b491071-8000.html

The easiest way to integrate Android Development is via [Android](http://developer.android.com/index.html).
And using ActionScript Mobile Library via [Apache Flex SDK](http://flex.apache.org/).

If you're still living in the Android (Java style), add the following files to your project:

- Add External Referance Jar Library File `FlashRuntimeExtensions.jar (Your Flexsdk path/sdks/4.11.0/lib/android/ )`
- `ShInstagramExtension.java`
- `ShInstagramExtensionContext.java`
- `IsInstagramAvailableFunction.java`
- `SaveInstagramFunction.java`

See `SaveInstagramFunction` in the Android Library project for details of how to use this class. In short, though:

        shareIntent = new Intent(android.content.Intent.ACTION_SEND);
		shareIntent.setType("image/*");
		//created temporary image file path....
		shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://"+fl.getPath()));
		shareIntent.setPackage("com.instagram.android");


ActionScript Flex Mobile Library Project functions:

- isInstagramInstalled : The installation instagram checks whether there
- saveToInstagram : Open your image with instagram app for share (BitmapData)

----

USAGE The Ane File:


		import com.azer.android.Share;

		private var androidShareCls:*;
       	function shareWithInstagram(bmp:BitmapData):void{
	        //Image BitmapData data Share with Instagram.
	        if(androidShareCls == null){androidShareCls = new Share();}
	        if(androidShareCls.isInstagramInstalled())
	        {
	              androidShareCls.addEventListener(StatusEvent.STATUS, onStatusHandler);
	              androidShareCls.postToInstagram(bmp);
	        }
        }

        function onStatusHandler(event:StatusEvent):void{
              androidShareCls.removeEventListener(StatusEvent.STATUS, onStatusHandler);
              androidShareCls.dispose();
        }
		
		shareWithInstagram(new BitmapData(612,612,false,0xFF0000));
		

-----

Read [Android Intent](http://developer.android.com/reference/android/content/Intent.html) documentation.
