package frontend.BatlleNaval;

public interface Actions {
    String BTN_PLAY = "play";
    String SEARCH_MATCH = "searchMatch";

    String START_MATCH = "startMatch";
    String WAIT_TURN ="waitTurn";
    String YOUR_TURN = "yourTurn";
    String CHANGE_TURN = "changeTurn";
    String END_MATH = "endMatch";
    String EXIT = "exit";
    String LOST = "lost";
    String WON = "won";
    String OPPONENT_IS_GONE = "opponentIsGone";

    String YOUR_BOARD = "yourBoard";
    String OPPONENT_BOARD = "opponentBoard";

    //SERVER ACTIONS
    String SET_TIME = "setTime";
    String TIME_OUT = "timeOut";
    String SHOOT = "shoot";
}
