package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AlarmTest {

    @Test
    public void isAlarmOn() {
        Alarm alarm = new Alarm(new Sensor());
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void checkPressureOk() {
        // ⚙ Arrange
        SensorPressurePsi sensorPressurePsiMock = Mockito.mock(SensorPressurePsi.class);
        Alarm alarm = new Alarm(sensorPressurePsiMock);
        Mockito.when(sensorPressurePsiMock.readValue()).thenReturn(20.0);

        // 👉 Act
        alarm.check();

        // ✅ Assert
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void checkLowPressure() {
        // ⚙ Arrange
        SensorPressurePsi sensorPressurePsiMock = Mockito.mock(SensorPressurePsi.class);
        Alarm alarm = new Alarm(sensorPressurePsiMock);
        Mockito.when(sensorPressurePsiMock.readValue()).thenReturn(16.0);

        // 👉 Act
        alarm.check();

        // ✅ Assert
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void checkHighPressure() {
        // ⚙ Arrange
        SensorPressurePsi sensorPressurePsiMock = Mockito.mock(SensorPressurePsi.class);
        Alarm alarm = new Alarm(sensorPressurePsiMock);
        Mockito.when(sensorPressurePsiMock.readValue()).thenReturn(22.0);

        // 👉 Act
        alarm.check();

        // ✅ Assert
        assertTrue(alarm.isAlarmOn());
    }

}
