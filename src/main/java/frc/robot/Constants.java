/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpiutil.math.Matrix;
import edu.wpi.first.wpiutil.math.Nat;
import edu.wpi.first.wpiutil.math.VecBuilder;
import edu.wpi.first.wpiutil.math.Vector;
import edu.wpi.first.wpiutil.math.numbers.N1;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final double LOOP_PERIOD = 0.02;
    public static final double NOMINAL_VOLTAGE = 12.0;

    public static class Drivetrain {
        public static final double TURN_MULTIPLIER = 0.25;

        public static final double kP = 0.2;
        public static final double kI = 0;
        public static final double kD = 0.02;
    }

    public static class Turret {
        public static final double kP = 0.2;
        public static final double kI = 0;
        public static final double kD = 0.02;

        public static final double TICKS_PER_DEGREE = 4096 / 360.0;
    }

    public static class Shooter {
        public static final double Kv = 0;
        public static final double Ka = 0;

        public static final Vector<N1> MODEL_TOLERANCE_VEC = VecBuilder.fill(
                0.8
        );
        public static final Vector<N1> SENSOR_TOLERANCE_VEC = VecBuilder.fill(
                0.2
        );
        public static final Matrix<N1, N1> MODEL_TOLERANCE_MAT = Matrix.mat(Nat.N1(), Nat.N1()).fill(
                0.8
        );
        public static final Matrix<N1, N1> SENSOR_TOLERANCE_MAT = Matrix.mat(Nat.N1(), Nat.N1()).fill(
                0.2
        );

        public static final double ballDensity = 0;
    }
}
