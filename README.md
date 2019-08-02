To create an icon, in Android Studio click File - New - Image Asset, then click the Path folder and select tiny_wifi_icon.png. If it looks ok, click Next, or if the size is wrong click Trim and adjust the slider, then Next and Finish.

 

The xml files go in Res Layout.

You need to correct the package in AndroidManifest.xml and each of the java source files. Also, you need the IP for your esp8266 device. In my case, I configured my router to assign 100.0.0.200 to my esp8266 so that's what is hard-coded in led_bt.java. You should be able to find your IP in your router configuration.
