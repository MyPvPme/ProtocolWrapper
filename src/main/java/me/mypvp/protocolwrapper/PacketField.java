package me.mypvp.protocolwrapper;

import com.comphenix.protocol.reflect.StructureModifier;

public class PacketField<T> {

  private final StructureModifier<T> modifier;
  private final int index;

  public PacketField(StructureModifier<T> modifier, int index) {
    this.modifier = modifier;
    this.index = index;
  }

  public StructureModifier<T> getModifier() {
    return modifier;
  }

  public int getIndex() {
    return index;
  }

  public void write(T value) {
    modifier.write(index, value);
  }

  public T read() {
    return modifier.read(index);
  }
}
