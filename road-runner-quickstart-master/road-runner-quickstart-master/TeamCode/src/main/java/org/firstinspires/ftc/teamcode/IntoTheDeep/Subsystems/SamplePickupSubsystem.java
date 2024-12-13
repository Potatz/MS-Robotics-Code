package org.firstinspires.ftc.teamcode.IntoTheDeep.Subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class SamplePickupSubsystem {
    //TODO DECLARING ACTUATORS
    public CRServo SpinnyServo =null;
    public Servo Trapdoor =null;

    public SamplePickupSubsystem(HardwareMap hardwareMap, Telemetry telemetry) {
        SpinnyServo = hardwareMap.get(CRServo.class, "SpinnyServo");
        Trapdoor = hardwareMap.get(Servo.class, "Trapdoor");
    }

    //TODO Spinny Procedures
    public void spinnyR() {
        SpinnyServo.setPower(Globals.SpinnyRight);
    }
    public void spinnyStop() {
        SpinnyServo.setPower(Globals.SpinnyStop);
    }
    public void spinnyL() {
        SpinnyServo.setPower(Globals.SpinnyLeft);
    }

    //TODO Trapdoor Procedure
    public void customTrapdoor(double TrapdoorPos) {
        Trapdoor.setPosition(TrapdoorPos);
    }
}