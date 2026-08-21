package ch.jobich.automation.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.io.InputStream;

public final class ConfigReader {

  private static ConfigReader instance;

  private final EnvironmentConfig config;

  private ConfigReader() {
    this.config = loadConfig();
  }

  public static ConfigReader getInstance() {
    if (instance == null) {
      instance = new ConfigReader();
    }
    return instance;
  }

  public EnvironmentConfig config() {
    return config;
  }

  private EnvironmentConfig loadConfig() {
    String resource = "config/local.yaml";
    try (InputStream is = ConfigReader.class.getClassLoader().getResourceAsStream(resource)) {
      if (is == null) {
        throw new IllegalStateException("Config file not found: " + resource);
      }
      ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
      return mapper.readValue(is, EnvironmentConfig.class);
    } catch (IOException e) {
      throw new IllegalStateException("Failed to read config: " + resource, e);
    }
  }
}