package org.firstinspires.ftc.teamcode.IntoTheDeep.Subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class ElevatorSubsystem {
    //TODO DECLARING ACTUATORS
    public DcMotorEx ExtenderMotor =null;
    public DcMotorEx ExtenderTurner =null;

    public ElevatorSubsystem(HardwareMap hardwareMap, Telemetry telemetry) {
        ExtenderMotor = hardwareMap.get(DcMotorEx.class, "ExtenderMotor");
        ExtenderTurner = hardwareMap.get(DcMotorEx.class, "ExtenderTurner");

        ExtenderMotor.setMode(DcMotor.RunMode.RESET_ENCODERS);
        ExtenderTurner.setMode(DcMotor.RunMode.RESET_ENCODERS);

        ExtenderMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ExtenderTurner.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    //TODO Extending Procedures
    public void elevatorExtend() {
        ExtenderMotor.setPower(Globals.elevatorExtend);
    }
    public void elevatorStop() {
        ExtenderMotor.setPower(Globals.elevatorStop);
    }
    public void elevatorRetract() {
        ExtenderMotor.setPower(Globals.elevatorRetract);
    }

    public void extendElevator(int targetPos) {
        ExtenderMotor.setTargetPosition(targetPos);
        ExtenderMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        ExtenderMotor.setPower(Globals.elevatorExtend);
    }

    //TODO Turning Procedures
    public void elevatorTR() {
        ExtenderTurner.setPower(Globals.elevatorTR);
    }
    public void elevatorTL() {
        ExtenderTurner.setPower(Globals.elevatorTL);
    }
    public void elevatorTurnStop() {
        ExtenderTurner.setPower(Globals.elevatorTurnStop);
    }

    //TODO Custom Elevators
    public void customElevator(int elevatorPos) {
        ExtenderMotor.setTargetPosition(elevatorPos);
    }
    public void customEleTurn(int TurnPos) {
        ExtenderTurner.setTargetPosition(TurnPos);
    }
}