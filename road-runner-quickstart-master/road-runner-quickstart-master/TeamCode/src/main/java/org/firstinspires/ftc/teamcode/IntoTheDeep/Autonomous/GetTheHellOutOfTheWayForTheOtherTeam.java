package org.firstinspires.ftc.teamcode.IntoTheDeep.Autonomous;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.IntoTheDeep.Subsystems.Globals;
import org.firstinspires.ftc.teamcode.MecanumDrive;

@Autonomous
public class GetTheHellOutOfTheWayForTheOtherTeam extends LinearOpMode {
    MecanumDrive drive =null;

    @Override
    public void runOpMode() throws InterruptedException {
        drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        waitForStart();

        while (opModeIsActive()) {
            drive.leftBack.setPower(Globals.regAutoSpeed);
            drive.leftFront.setPower(Globals.regAutoSpeed);
            drive.rightBack.setPower(Globals.regAutoSpeed);
            drive.rightFront.setPower(Globals.regAutoSpeed);
        }
    }
}
