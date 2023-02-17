package me.mypvp.protocolwrapper.util;

public class WrapperMath {

  public static short getDeltaPosition(double from, double to) {
    return (short) ((to - from) * 4096);
  }

  public static byte getAngle(float value) {
    return (byte) (int) (value * 256F / 360F);
  }

  public static int compressPosition(double position) {
    return (int) Math.floor(position * 32D);
  }

}
