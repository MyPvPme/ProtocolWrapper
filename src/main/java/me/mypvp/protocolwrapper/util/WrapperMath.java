package me.mypvp.protocolwrapper.util;

public class WrapperMath {

  public static short getDeltaPosition(int from, int to) {
    return (short) ((to * 32 - from * 32) * 128);
  }

  public static byte getAngle(float value) {
    return (byte) (int) (value * 256F / 360F);
  }

}
