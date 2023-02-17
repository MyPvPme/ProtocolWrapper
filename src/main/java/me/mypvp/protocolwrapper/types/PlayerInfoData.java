package me.mypvp.protocolwrapper.types;

import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.BukkitConverters;
import com.comphenix.protocol.wrappers.EnumWrappers.EnumConverter;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.bukkit.GameMode;

public class PlayerInfoData {
  private static Class<?> gameModeClass;
  private static Constructor<?> constructor;
  private final int latency;
  private final GameMode gameMode;
  private final WrappedGameProfile profile;
  private final WrappedChatComponent displayName;

  public PlayerInfoData(WrappedGameProfile profile, int latency, GameMode gameMode, WrappedChatComponent displayName) {
    this.profile = profile;
    this.latency = latency;
    this.gameMode = gameMode == null ? GameMode.SURVIVAL : gameMode;
    this.displayName = displayName;
  }

  public WrappedGameProfile getProfile() {
    return this.profile;
  }

  public int getPing() {
    return this.latency;
  }

  public int getLatency() {
    return this.latency;
  }

  public GameMode getGameMode() {
    return this.gameMode;
  }

  public WrappedChatComponent getDisplayName() {
    return this.displayName;
  }

  public static EquivalentConverter<PlayerInfoData> getConverter() {
    return new EquivalentConverter<PlayerInfoData>() {

      @Override
      public Object getGeneric(PlayerInfoData specific) {
        if(gameModeClass == null) {
          gameModeClass = MinecraftReflection.getMinecraftClass("world.level.EnumGamemode");
        }
        if (constructor == null) {
          try {
            List<Class<?>> args = new ArrayList<>();
            args.add(MinecraftReflection.getGameProfileClass());
            args.add(Integer.TYPE);
            args.add(gameModeClass);
            args.add(MinecraftReflection.getIChatBaseComponentClass());
            args.add(MinecraftReflection.getProfilePublicKeyDataClass());
            PlayerInfoData.constructor = MinecraftReflection.getPlayerInfoDataClass()
                .getConstructor(args.toArray(new Class[0]));
          } catch (Exception e) {
            throw new RuntimeException("Cannot find PlayerInfoData constructor.", e);
          }
        }

        try {
          EnumConverter<GameMode> gameModeConverter = new EnumConverter<>(gameModeClass, GameMode.class);
          Object gameMode = gameModeConverter.getGeneric(specific.getGameMode());
          Object displayName = specific.displayName != null ? specific.displayName.getHandle() : null;
          return PlayerInfoData.constructor.newInstance(specific.profile.getHandle(),
              specific.latency, gameMode, displayName, null);
        } catch (Exception var4) {
          throw new RuntimeException("Failed to construct PlayerInfoData.", var4);
        }
      }

      @Override
      public PlayerInfoData getSpecific(Object generic) {
        if (MinecraftReflection.isPlayerInfoData(generic)) {
          EnumConverter<GameMode> gameModeConverter = new EnumConverter<>(gameModeClass, GameMode.class);
          StructureModifier<Object> modifier = new StructureModifier<>(generic.getClass(), null,
              false).withTarget(generic);

          StructureModifier<WrappedGameProfile> gameProfiles = modifier.withType(
              MinecraftReflection.getGameProfileClass(), BukkitConverters.getWrappedGameProfileConverter());
          StructureModifier<Integer> ints = modifier.withType(Integer.TYPE);
          StructureModifier<WrappedChatComponent> displayNames = modifier.withType(
              MinecraftReflection.getIChatBaseComponentClass(), BukkitConverters.getWrappedChatComponentConverter());

          int latency = ints.read(0);
          WrappedGameProfile gameProfile = gameProfiles.read(0);
          GameMode gameMode = modifier.withType(gameModeClass, gameModeConverter).read(0);
          WrappedChatComponent displayName = displayNames.read(0);
          return new PlayerInfoData(gameProfile, latency, gameMode, displayName);
        } else {
          return null;
        }
      }

      @Override
      public Class<PlayerInfoData> getSpecificType() {
        return PlayerInfoData.class;
      }
    };
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    PlayerInfoData that = (PlayerInfoData) o;

    if (latency != that.latency) {
      return false;
    }
    if (gameMode != that.gameMode) {
      return false;
    }
    if (!Objects.equals(profile, that.profile)) {
      return false;
    }
    return Objects.equals(displayName, that.displayName);
  }

  @Override
  public int hashCode() {
    int result = latency;
    result = 31 * result + gameMode.hashCode();
    result = 31 * result + (profile != null ? profile.hashCode() : 0);
    result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
    return result;
  }

  public String toString() {
    return String.format("PlayerInfoData[latency=%s, gameMode=%s, profile=%s, displayName=%s]",
        this.latency, this.gameMode, this.profile, this.displayName);
  }
}
