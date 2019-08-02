package your_package.tiny_wifi;

public class web {

    public static int msg = 0;

    public static espthread2 espThread;

    public static void esp_thread(){

        if (espThread != null) {

            if (espThread.isAlive()){

              return;
            }

            espThread = null;
        }

        espThread = new espthread2();

        espThread.start();
    }


    public static class espthread2 extends Thread {

        public espthread2() {

        }

        public void run() {

            led_bt.esp_socket(String.format("%d",msg));

            msg++;

            if (msg > 254){
                msg = 0;
            }
        }
    }
}
