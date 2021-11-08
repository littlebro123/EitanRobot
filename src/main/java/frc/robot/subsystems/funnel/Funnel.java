package frc.robot.subsystems.funnel;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import static frc.robot.Ports.Funnel.*;

public class Funnel {
    private TalonSRX motor_main = new TalonSRX(MOTOR_MAIN);
    private boolean funnelMode;

    public Funnel() {
        motor_main.setInverted(MAIN_INVERTED);

        motor_main.setSensorPhase(MAIN_SENSOR_PHASE);
    }

    public void setPower(double output){
        motor_main.set(ControlMode.PercentOutput, (funnelMode) ? output : -output);
    }

    public void setFunnelMode(boolean funnelMode) {
        this.funnelMode = funnelMode;
    }

    public void terminate(){
        motor_main.set(ControlMode.PercentOutput, 0);
    }
}
