package org.firstinspires.ftc.teamcode.IntoTheDeep.Subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class ClimberSubsystem {
    //TODO DECLARING ACTUATORS
    public DcMotorEx ClimberMotor =null;
    public DcMotorEx ClimberTurner =null;

    public ClimberSubsystem(HardwareMap hardwareMap, Telemetry telemetry) {

        //Setting motors
        ClimberMotor = hardwareMap.get(DcMotorEx.class, "ClimberMotor");
        ClimberTurner = hardwareMap.get(DcMotorEx.class, "ClimberTurner");

            //Motor modes (Resets encoders and BRAKES when no power is applied)
        ClimberMotor.setMode(DcMotor.RunMode.RESET_ENCODERS);
        ClimberTurner.setMode(DcMotor.RunMode.RESET_ENCODERS);

        ClimberMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ClimberTurner.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    //TODO Climber Procedures
    //Climber extend "functions"
    public void climberExtend() {
        ClimberMotor.setPower(Globals.climberExtend);
    }
    public void climberStop() {
        ClimberMotor.setPower(Globals.climberStop);
    }
    public void climberRetract() {
        ClimberMotor.setPower(Globals.climberRetract);
    }

    public void extendClimber(int targetPos) {
        ClimberMotor.setTargetPosition(targetPos);
        ClimberMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        ClimberMotor.setPower(Globals.elevatorExtend);
    }

    //TODO Turning Procedures
    //Climber turning "functions"
    public void climberTR() {
        ClimberTurner.setPower(Globals.climberTR);
    }
    public void climberTL() {
        ClimberTurner.setPower(Globals.climberTL);
    }
    public void climberTurnStop() {
        ClimberTurner.setPower(Globals.climberTurnStop);
    }

    //TODO Custom Climbers
    public void customClimber(int ClimberPos) {
        ClimberMotor.setTargetPosition(ClimberPos);
    }
    public void customClimbTurn(int TurnPos) {
        ClimberTurner.setTargetPosition(TurnPos);
    }
}