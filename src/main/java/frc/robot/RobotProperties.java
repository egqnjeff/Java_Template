package frc.robot;

import java.io.InputStream;
import java.util.Properties;

public class RobotProperties {
    
    private static Properties buildProperties = null;
    private static Properties applicationProperties = null;

    private static Properties getBuildProperties() {
        if(buildProperties == null) {
            try {
                InputStream inputStream = RobotProperties.class.getResourceAsStream("/build.properties");
                buildProperties = new Properties();
                buildProperties.load(inputStream);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        return buildProperties;
    }

    private static Properties getApplicationProperties() {
        if(applicationProperties == null) {
            try {
                InputStream inputStream = RobotProperties.class.getResourceAsStream("/application.properties");
                applicationProperties = new Properties();
                applicationProperties.load(inputStream);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        return applicationProperties;
    }

    private static String getProperty(String key, Properties properties) {
        String returnValue = "Not Set";
        if(properties != null) {
            returnValue = properties.getProperty(key);
        }
        return returnValue;
    }

    public static String getTime() {
        return getProperty("build.time", getBuildProperties());
    }

    public static String getComputer() {
        return getProperty("build.computer", getBuildProperties());
    }

    public static String getSubsystemOne() {
        return getProperty("subsystem.one", getApplicationProperties());
    }

}
