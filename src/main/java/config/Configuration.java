package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({"classpath:config.properties"})
public interface Configuration extends Config{

    @Key("url.base")
    String baseUrl();

    @Key("browser")
    String browser();
    @Key("enable.tracing")
    boolean enableTracing();

}
