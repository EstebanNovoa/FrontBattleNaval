package frontend.controllers;

import java.util.Timer;
import java.util.TimerTask;

public class ServerListener {

    private Timer timer;
    private Controller controller;

    public ServerListener(Controller controller) {
        this.controller = controller;
        timer = new Timer();
    }

    public void start(){
        timer.scheduleAtFixedRate(createClockTask(), 1000, 250);
    }

    /**
     * Crea la tarea que se ejecutara para mantener a la escucha las respuestas del servidor
     * @return
     */
    private TimerTask createClockTask() {
        return new TimerTask() {
            @Override
            public void run() {
                if (controller.getSocket().isClosed()) {
                    timer.cancel();
                    return;
                }
                String action = controller.getInputString();
                if (action != null) {
                    //System.out.println("HILO: " + Thread.currentThread().getName());
                    controller.serverAction(action);
                }
            }
        };
    }
}
