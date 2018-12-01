package com.amtkxa.springbootreladomo.infra.config;

import com.gs.fw.common.mithra.MithraManager;
import com.gs.fw.common.mithra.MithraManagerProvider;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.InputStream;

/**
 * Initialize Reladomo
 *
 * <p> Reladomo's runtime is configured via a MithraRuntime XML file.
 * Reladomo will cache an object as long as there is sufficient memory.
 * When there is a memory crunch, the cached objects will be garbage-collected.
 */
@Configuration
public class ReladomoConfig {

  /**
   * Use the MithraManager class to load the configuration and initialize Reladomo.
   *
   * @throws Exception
   */
  @PostConstruct
  public void initializeReladomo() throws Exception {
    MithraManager mithraManager = MithraManagerProvider.getMithraManager();
    mithraManager.setTransactionTimeout(60 * 1000);
    InputStream stream = loadReladomoXMLFromClasspath("reladomo/config/MithraRuntimeConfiguration.xml");
    MithraManagerProvider.getMithraManager().readConfiguration(stream);
    stream.close();
  }

  /**
   * Returns an input stream for reading the Reladomo runtime configuration file.
   *
   * @param fileName MithraRuntime XML file
   * @return stream
   * @throws Exception
   */
  private InputStream loadReladomoXMLFromClasspath(String fileName) throws Exception {
    InputStream stream = ReladomoConfig.class.getClassLoader().getResourceAsStream(fileName);
    if (stream == null) {
      throw new Exception("Failed to locate " + fileName + " in classpath");
    }
    return stream;
  }
}
