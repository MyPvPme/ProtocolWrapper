package me.mypvp.protocolwrapper.types;

public enum GameEventAction {
  NO_RESPAWN_BLOCK(0),
  START_RAINING(1),
  STOP_RAINING(2),
  CHANGE_GAME_MODE(3),
  WIN_GAME(4),
  DEMO_EVENT(5),
  ARROW_HIT_PLAYER(6),
  RAIN_LEVEL_CHANGE(7),
  THUNDER_LEVEL_CHANGE(8),
  PUFFER_FISH_STING(9),
  GUARDIAN_ELDER_EFFECT(10),
  IMMEDIATE_RESPAWN(11);

  private final int id;

  GameEventAction(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }
}
