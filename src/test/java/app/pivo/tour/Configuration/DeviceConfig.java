package app.pivo.tour.Configuration;

public class DeviceConfig {
    public static class dConfiguration {
        public String iOSVersion;
        public String deviceName;
        public String udid;
        public boolean hasLiDAR;
    }

    public enum Device {
        iPhoneSE2("14.7.1", "iphone SE2", "00008030-001A70802E3B802E", false),
        iPhone12Pro("14.7.1", "iphone 12 Pro", "00008101-000144580E52001E", true),
        iPhone11Pro("14.7.1", "iPhone 11 Pro", "00008030-001A70802E3B802E", false);

        Device(String iOSVersion, String deviceName, String udid, boolean hasLiDAR) {
            this.info = new DeviceInfo(iOSVersion, deviceName, udid, hasLiDAR);
        }

        private final DeviceInfo info;

        public DeviceInfo getInfo() {
            return this.info;
        }
    }
    ///Device device = Device.iPhone12Pro; // Change the name of the device accordingly
}