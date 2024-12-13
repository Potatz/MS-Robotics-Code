package org.firstinspires.ftc.teamcode.IntoTheDeep.Subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Config
public class Globals {
    //TODO -- EXTENDER SYSTEM --
    public static double elevatorExtend = -1;
    public static double elevatorStop = 0;
    public static double elevatorRetract = 1;
    public static double elevatorTR = 0.7;
    public static double elevatorTurnStop = 0.015;
    public static double elevatorTL = -0.3;

    //TODO -- CLIMBER SYSTEM --
    public static double climberExtend = 1;
    public static double climberStop = 0;
    public static double climberRetract = -1;
    public static double climberTR = 0.5;
    public static double climberTurnStop = 0;
    public static double climberTL = -0.5;

    //TODO -- SAMPLE PICKUP SYSTEM --
    public static double SpinnyRight = 1;
    public static double SpinnyStop = 0;
    public static double SpinnyLeft = -1;
    public static double TrapdoorInnit = 0; //TODO FIND THE VALUE OF INNIT
    public static double TrapdoorOpen = 0.35; //TODO FIND THE VALUE OF OPEN

    //TODO -- AUTONOMOUS STUFF --
    public static double regAutoSpeed = 0.3; //TODO SET SPEED VALUE
}