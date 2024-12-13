package org.firstinspires.ftc.teamcode.IntoTheDeep.TeleOp;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.IntoTheDeep.Subsystems.ClimberSubsystem;
import org.firstinspires.ftc.teamcode.IntoTheDeep.Subsystems.ElevatorSubsystem;
import org.firstinspires.ftc.teamcode.IntoTheDeep.Subsystems.Globals;
import org.firstinspires.ftc.teamcode.IntoTheDeep.Subsystems.SamplePickupSubsystem;

@TeleOp(group = "advanced")
public class MainTest extends LinearOpMode {
    Pose2d currentPose = new Pose2d(0, 0, 0);
    public static double botHeading;

    MecanumDrive drive =null;
    ClimberSubsystem climber =null;
    ElevatorSubsystem elevator =null;
    SamplePickupSubsystem samplePickup =null;

    @Override
    public void runOpMode() throws InterruptedException {
        drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        climber = new ClimberSubsystem(hardwareMap, telemetry);
        elevator = new ElevatorSubsystem(hardwareMap, telemetry);
        samplePickup = new SamplePickupSubsystem(hardwareMap, telemetry);

        while (opModeInInit()) {
            gamepad1.rumble(1, 1, 400);
            telemetry.addData("Status", "Initialized");
            telemetry.update();
        }

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive() && !isStopRequested()) {
            botHeading = drive.getRawExternalHeading();
            drive.DriveFieldCentric(-gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x, botHeading);

            double elevatorPos = elevator.ExtenderMotor.getCurrentPosition();
            double elevatorTurnPos = elevator.ExtenderMotor.getCurrentPosition();
            double ClimberTurnPos = elevator.ExtenderMotor.getCurrentPosition();

            if (gamepad1.right_bumper) {
                if (elevatorPos >= 9999999) {
                    elevator.elevatorStop();
                }
                elevator.elevatorExtend();
            } else if (gamepad1.left_bumper) {
                if (elevatorPos <= -9999999) {
                    elevator.elevatorStop();
                }
                elevator.elevatorRetract();
            } else {
                elevator.elevatorStop();
            }
            if (gamepad1.left_trigger > 0.3) {
                elevator.elevatorTL();
            } else if (gamepad1.right_trigger > 0.3){
                elevator.elevatorTR();
            } else {
                elevator.elevatorTurnStop();
            }
            if (gamepad1.dpad_up) {
                climber.climberExtend();
            } else if (gamepad1.dpad_down) {
                climber.climberRetract();
            } else {
                climber.climberStop();
            }
            if (gamepad1.dpad_left) {
                climber.climberTL();
                telemetry.addData("DpadLeft: ", gamepad1.dpad_left);
            } else if (gamepad1.dpad_right) {
                climber.climberTR();
                telemetry.addData("DpadRight: ", gamepad1.dpad_right);
            } else {
                climber.climberTurnStop();
            }
            if (gamepad1.a) {
                samplePickup.spinnyR();
            } else if (gamepad1.b) {
                samplePickup.spinnyL();
            } else {
                samplePickup.spinnyStop();
            }
            if (gamepad1.x) {
                samplePickup.customTrapdoor(Globals.TrapdoorOpen);
            }
            if (gamepad1.y) {
                samplePickup.customTrapdoor(Globals.TrapdoorInnit);
            }

            telemetry.addData("heading: ", botHeading);
            telemetry.addData("elevatorPos", elevatorPos);
            telemetry.addData("elevatorTurnPos", elevatorTurnPos);
            telemetry.addData("climberPos", climber.ClimberMotor.getCurrentPosition());
            telemetry.addData("climberTurnPos", ClimberTurnPos);
            telemetry.addData("samplePickupPos", samplePickup.SpinnyServo.getPower());
            telemetry.addData("samplePickupPos", samplePickup.Trapdoor.getPosition());
            telemetry.addData("Status", "Running");
            telemetry.update();

        }
    }
}