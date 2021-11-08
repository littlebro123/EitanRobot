package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.controller.LinearQuadraticRegulator;
import edu.wpi.first.wpilibj.estimator.KalmanFilter;
import edu.wpi.first.wpilibj.system.LinearSystem;
import edu.wpi.first.wpilibj.system.LinearSystemLoop;
import edu.wpi.first.wpiutil.math.Matrix;
import edu.wpi.first.wpiutil.math.Nat;
import edu.wpi.first.wpiutil.math.numbers.N1;

import static frc.robot.Constants.LOOP_PERIOD;
import static frc.robot.Constants.NOMINAL_VOLTAGE;
import static frc.robot.Constants.Shooter.*;
import static frc.robot.Ports.Shooter.*;

public class Shooter {
    private double distance;
    private TalonSRX motor_main = new TalonSRX(MOTOR_MAIN);
    private TalonSRX motor_aux1 = new TalonSRX(MOTOR_AUX1);
    private TalonSRX motor_aux2 = new TalonSRX(MOTOR_AUX2);
    private LinearSystem<N1, N1, N1> flywheel;
    private LinearQuadraticRegulator<N1, N1, N1> lqr;
    private KalmanFilter<N1, N1, N1> kalmanFilter;
    private LinearSystemLoop<N1, N1, N1> m_loop;
    private Matrix<N1, N1> A;
    private Matrix<N1, N1> B;
    private Matrix<N1, N1> C;
    private Matrix<N1, N1> D;

    public Shooter(double distance) {
        this.distance = distance;

        motor_main.setInverted(MAIN_INVERTED);
        motor_aux1.setInverted(AUX1_INVERTED);
        motor_aux2.setInverted(AUX2_INVERTED);

        motor_main.setSensorPhase(MAIN_SENSOR_PHASE);
        motor_aux1.setSensorPhase(AUX1_SENSOR_PHASE);
        motor_aux2.setSensorPhase(AUX2_SENSOR_PHASE);

        A.fill(-Kv / Ka);
        B.fill(1 / Ka);
        C.fill(1);
        D.fill(0);

        flywheel = new LinearSystem<>(
                A,
                B,
                C,
                D
        );

        lqr = new LinearQuadraticRegulator<>(
                flywheel,
                MODEL_TOLERANCE_VEC,
                SENSOR_TOLERANCE_VEC,
                LOOP_PERIOD
        );

        kalmanFilter = new KalmanFilter<>(
                Nat.N1(),
                Nat.N1(),
                flywheel,
                MODEL_TOLERANCE_MAT,
                SENSOR_TOLERANCE_MAT,
                LOOP_PERIOD
        );

        m_loop = new LinearSystemLoop<>(
                flywheel,
                lqr,
                kalmanFilter,
                NOMINAL_VOLTAGE,
                LOOP_PERIOD
        );
    }


}
