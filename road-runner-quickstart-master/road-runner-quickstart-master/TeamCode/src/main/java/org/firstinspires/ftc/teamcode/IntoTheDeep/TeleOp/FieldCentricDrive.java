package org.firstinspires.ftc.teamcode.IntoTheDeep.TeleOp;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.MecanumDrive;

@TeleOp(group = "advanced")
public class FieldCentricDrive extends LinearOpMode {
    Pose2d currentPose = new Pose2d(0, 0,0);
    public static double botHeading;

    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));

        while (opModeInInit()) {
            gamepad1.rumble(1, 1, 400);
        }

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive() && !isStopRequested()) {
            botHeading = drive.getRawExternalHeading();
            drive.DriveFieldCentric(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x, botHeading);

            telemetry.addData("heading", botHeading);
            telemetry.update();
        }
    }
}