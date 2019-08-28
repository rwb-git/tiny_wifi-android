this app works with sketch tiny_wifi-esp8266

To create an icon, in Android Studio click File - New - Image Asset, then click the Path folder and select tiny_wifi_icon.png. If it looks ok, click Next, or if the size is wrong click Trim and adjust the slider, then Next and Finish.

 

The esp_screen.xml file goes in Res Layout.

You need to correct the package in AndroidManifest.xml and each of the java source files. Also, you need the IP for your esp8266 device. In my case, I configured my router to assign 100.0.0.200 to my esp8266 so that's what is hard-coded in led_bt.java. You should be able to find your IP in your router configuration. This is pretty annoying if you have more than one device or the IP changes, so you might look at a more complex app I have, simple_wifi, which can scan over a range and detect the esp; it's not super-sophisticated, but it's a step above this app which is truly "tiny".
