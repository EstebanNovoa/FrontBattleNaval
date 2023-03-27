package frontend.controllers;

import java.util.Timer;
import java.util.TimerTask;

public class ServerListener {
    private TimerTask task;
    private Controller controller;

    public ServerListener(Controller controller) {
        this.controller = controller;
    }

    public void start(){
        createClockTask();
        new Timer().scheduleAtFixedRate(task, 1000, 500);
    }

    /**
     * Crea la tarea que se ejecutara para mantener a la escucha las respuestas del servidor
     * @return
     */
    private TimerTask createClockTask() {
        this.task = new TimerTask() {
            @Override
            public void run() {
                while (!controller.getSocket().isClosed()) {
                    String action = controller.getInputString();
                    if (action != null) {
                        System.out.println("HILO: " + Thread.currentThread().getName());
                        controller.serverAction(action);
                    }
                }
            }
        };
        return task;
    }
}
