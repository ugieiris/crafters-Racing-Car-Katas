package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    private static final double LOW_PRESSURE_THRESHOLD = 17;
    private static final double HIGH_PRESSURE_THRESHOLD = 21;

    private SensorPressurePsi sensorPressurePsi;

    protected boolean alarmOn = false;

    public Alarm(SensorPressurePsi sensorPressurePsi) {
        this.sensorPressurePsi = sensorPressurePsi;
    }

    public void check()
    {
        double psiPressureValue = sensorPressurePsi.readValue();

        if (psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
