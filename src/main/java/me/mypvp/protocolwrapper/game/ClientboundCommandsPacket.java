package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.google.common.collect.Queues;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.tree.RootCommandNode;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundCommandsPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.COMMANDS;

  private final PacketField<Integer> rootIndexField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<Object> entriesField = new PacketField<>(container().getModifier(), 1);

  public ClientboundCommandsPacket() {
  }

  public ClientboundCommandsPacket(RootCommandNode<?> rootCommandNode) {
    Object2IntMap<CommandNode<?>> object2IntMap = enumerateNodes(rootCommandNode);
    rootIndex(object2IntMap.getInt(rootCommandNode));
    entries(createEntries(object2IntMap));
  }

  public ClientboundCommandsPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundCommandsPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundCommandsPacket rootIndex(int index) {
    rootIndexField.write(index);
    return this;
  }

  public int rootIndex() {
    return rootIndexField.read();
  }

  public ClientboundCommandsPacket entries(List<?> entries) {
    entriesField.write(entries);
    return this;
  }

  public List<?> entries() {
    return (List) entriesField.read();
  }

  private static Object2IntMap<CommandNode<?>> enumerateNodes(RootCommandNode<?> commandTree) {
    Object2IntOpenHashMap<CommandNode<?>> object2IntOpenHashMap = new Object2IntOpenHashMap<>();
    Queue<CommandNode<?>> queue = Queues.newArrayDeque();
    queue.add(commandTree);
    CommandNode<?> commandNode;
    while ((commandNode = queue.poll()) != null) {
      if (object2IntOpenHashMap.containsKey(commandNode))
        continue;
      int size = object2IntOpenHashMap.size();
      object2IntOpenHashMap.put(commandNode, size);
      queue.addAll(commandNode.getChildren());
      if (commandNode.getRedirect() != null)
        queue.add(commandNode.getRedirect());
    }
    return object2IntOpenHashMap;
  }

  private static List<?> createEntries(Object2IntMap<CommandNode<?>> nodes) {
    Method method = findCreateEntriesMethod();
    if(method == null) {
      return new ArrayList<>();
    }
    method.setAccessible(true);
    try {
      Object result = method.invoke(null, nodes);
      return (List) result;
    } catch (IllegalAccessException | InvocationTargetException e) {
      throw new IllegalStateException("Failed to create commands packet", e);
    }
  }

  private static Method findCreateEntriesMethod() {
    Class<?> packetClass = TYPE.getPacketClass();
    for (Method method : packetClass.getDeclaredMethods()) {
      if(method.getParameterCount() != 1) {
        continue;
      }
      if(method.getParameterTypes()[0] != Object2IntMap.class) {
        continue;
      }
      if(method.getReturnType() == List.class) {
        return method;
      }
    }
    return null;
  }

}
