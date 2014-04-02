//  Created by Azer Bulbul on 12/29/13.
//  Copyright (c) 2013 Azer Bulbul. All rights reserved.
package com.azer.android
{
	import flash.display.BitmapData;
	import flash.display.BitmapDataChannel;
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	import flash.geom.Point;

	public class Share extends EventDispatcher implements IEventDispatcher
	{
		public var context:ExtensionContext;
		
		protected var tmp:BitmapData = null;
		
		public function Share()
		{
			context = ExtensionContext.createExtensionContext("com.azer.android.shareinstagram", null);
			if (context != null)
			{
				context.addEventListener(StatusEvent.STATUS, statusHandler);
			}
		}
		
		private function statusHandler(event:StatusEvent):void {
			dispatchEvent(event);
		}
		
		/**
		 * * @author Azer BULBUL https://github.com/sharkhack
		 * */
		public function isInstagramInstalled():Boolean{
			if (context != null)
			{
				return context.call("isInstagramAvailable");
			}
			return false;
		}
		
		/**
		 * @param b is BitmapData for Sharing
		 * 
		 * @author Azer BULBUL https://github.com/sharkhack
		 * */
		public function saveToInstagram(b:BitmapData):void{
			if (context == null) return;
			
			tmp = new BitmapData(b.width,b.height,false,0xFFFFFF);
			tmp.copyChannel(b,b.rect,new Point(0,0),BitmapDataChannel.BLUE,BitmapDataChannel.RED);
			tmp.copyChannel(b,b.rect,new Point(0,0),BitmapDataChannel.GREEN,BitmapDataChannel.GREEN);
			tmp.copyChannel(b,b.rect,new Point(0,0),BitmapDataChannel.RED,BitmapDataChannel.BLUE);
			context.addEventListener( StatusEvent.STATUS, statusHandler);
			context.call("saveToInstagram",tmp);
		}
		
		/**
		 * Dispose current temporary BitmapData and dispose Native Extension Context
		 * 
		 * @author Azer BULBUL https://github.com/sharkhack
		 * */
		public function dispose():void{
			if(context){
				context.removeEventListener(StatusEvent.STATUS,statusHandler);
				try{context.dispose();} catch(err:*){}
				context = null;
			}
			
			if(tmp){
				try{tmp.dispose(); } catch(err:*){}
				tmp = null;
			}
		}
		
	}
}