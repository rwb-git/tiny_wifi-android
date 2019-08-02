package your package goes here .tiny_wifi;

import android.os.Handler;
import android.os.Message;

public class esp_screen_handler   extends Handler {

    public esp_screen_handler() {
	}

	@Override
	public void handleMessage(Message msg) {

        switch (msg.what) {

            case 4:

                MainActivity.add_a_text_line((String) msg.obj);   // this prepends "\n"

                break;
		}
	}
}
