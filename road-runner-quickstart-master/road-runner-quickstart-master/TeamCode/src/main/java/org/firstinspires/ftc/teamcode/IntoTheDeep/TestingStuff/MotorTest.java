package org.firstinspires.ftc.teamcode.IntoTheDeep.TestingStuff;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(group = "advanced")
public class MotorTest extends LinearOpMode {
    public DcMotorEx ExtenderMotor =null;
    public DcMotorEx ExtenderTurner =null;

    public DcMotorEx ClimberMotor =null;
    public DcMotorEx ClimberTurner =null;

    public CRServo SpinnyServo =null;
    public Servo Trapdoor =null;

    public MotorTest(HardwareMap hardwareMap, Telemetry telemetry) {
        ExtenderMotor = hardwareMap.get(DcMotorEx.class, "ExtenderMotor");
        ExtenderTurner = hardwareMap.get(DcMotorEx.class, "ExtenderTurner");

        ExtenderMotor.setMode(DcMotor.RunMode.RESET_ENCODERS);
        ExtenderTurner.setMode(DcMotor.RunMode.RESET_ENCODERS);

        ExtenderMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ExtenderTurner.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        ClimberMotor = hardwareMap.get(DcMotorEx.class, "ClimberMotor");
        ClimberTurner = hardwareMap.get(DcMotorEx.class, "ClimberTurner");

        ClimberMotor.setMode(DcMotor.RunMode.RESET_ENCODERS);
        ClimberTurner.setMode(DcMotor.RunMode.RESET_ENCODERS);

        ClimberMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ClimberTurner.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        SpinnyServo = hardwareMap.get(CRServo.class, "SpinnyServo");
        Trapdoor = hardwareMap.get(Servo.class, "Trapdoor");

    }

    @Override
    public void runOpMode() throws InterruptedException {

        while (opModeInInit()) {
            gamepad1.rumble(1, 1, 400);
            telemetry.addData("Status", "Initialized");
            telemetry.update();
        }

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive() && !isStopRequested()) {

            double elevatorPos = ExtenderMotor.getCurrentPosition();
            double elevatorTurnPos = ExtenderTurner.getCurrentPosition();
            double ClimberPos = ClimberMotor.getCurrentPosition();
            double ClimberTurnPos = ClimberTurner.getCurrentPosition();

            if (gamepad1.a) {
                ClimberMotor.setPower(1); //change to whatever motor required and duplicate if necessary
            } else if (gamepad1.b){
                ClimberMotor.setPower(-1);
            } else {
                ClimberMotor.setPower(0);
            }

            telemetry.addData("elevatorPos", elevatorPos);
            telemetry.addData("elevatorTurnPos", elevatorTurnPos);
            telemetry.addData("climberTurnPos", ClimberPos);
            telemetry.addData("climberTurnPos", ClimberTurnPos);
            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }
}