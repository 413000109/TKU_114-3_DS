public class Q11_LabDevice {
    private String code;
    private String name;
    private int usageHours;
    private boolean active;

    public Q11_LabDevice(String code, String name, int usageHours, boolean active) {
        this.code = code;
        this.name = (name == null || name.trim().isEmpty()) ? "UNKNOWN" : name.trim();
        this.usageHours = Math.max(0, usageHours);
        this.active = active;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public int getUsageHours() { return usageHours; }
    public boolean isActive() { return active; }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name.trim();
    }

    public void addUsageHours(int hours) {
        if (hours > 0) this.usageHours += hours;
    }

    public void deactivate() { this.active = false; }

    public boolean needsMaintenance() { return usageHours >= 100; }

    @Override
    public String toString() {
        return code + " | " + name + " | " + usageHours + " hours | " + (active ? "active" : "inactive");
    }
}