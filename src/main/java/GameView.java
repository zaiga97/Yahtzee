interface GameView {
    public void draw(GameStatus gs);
    public void drawMenu();
    public void wrongInput();
    public void drawNewGame();
    public void drawPlayerNameRequest();
    public void drawGameStatus(GameStatus gs);

    void drawRerollRequest();
}
