package com.sgc.graphslibrary.Maths;

import com.sgc.graphslibrary.data.PieChartData;

import java.util.ArrayList;

public class AngleMath {

    /**
     * @param numberSector number sector for which the average angle is calculated
     * @return average angle sector
     */
    public static float getAngleOfSectorCenter(int numberSector, float startAngle, ArrayList<PieChartData> data) {
        float compress = getCompress(data);
        float startAngleSector = startAngle + 90;

        for (int i = 0; i <= numberSector; i++) {
            float startCurrentAngleSector = data.get(i).getPercentageSpace() * compress;
            if (i == numberSector)
                startAngleSector += startCurrentAngleSector / 2;
            else
                startAngleSector += startCurrentAngleSector;
        }

        return startAngleSector;
    }

    /**
     * @return Coefficient by which you need to multiply the percentage
     * of space occupied by the sector to get the angle of the sector.
     * Example: If getPercentageSpace () return 10,
     * getCompress () return 5. 10 * 5 angles of space occupied by the sector
     */
    public static float getCompress(ArrayList<PieChartData> data) {
        float sumPercent = 0;

        for (int i = 0; i < data.size(); i++) {
            sumPercent += data.get(i).getPercentageSpace();
        }

        int degreesOfCircle = 360;
        return degreesOfCircle / sumPercent;
    }

    public static double getAngleBetweenTwoLines(Line line1, Line line2, float startAngle) {
        double angle1 = Math.atan2(line1.getY1() - line1.getY2(),
                line1.getX1() - line1.getX2());
        double angle2 = Math.atan2(line2.getY1() - line2.getY2(),
                line2.getX1() - line2.getX2());
        double angle = Math.toDegrees(angle1 - angle2) + 270 - startAngle;
        if (angle < 0)
            angle = Math.abs(angle + 360);
        return angle;
    }

    public static PieChartData findSectorByAngle(double angle, ArrayList<PieChartData> sectors) {
        double angleSector = 0;
        float compress = getCompress(sectors);

        for (int i = 0; i < sectors.size() - 1; i++) {
            angleSector += sectors.get(i).getPercentageSpace() * compress;
            if (angleSector > angle)
                return sectors.get(i);
           /* if (angle <= angleSector && angle >= angleSector + sectors.get(i + 1).getPercentageSpace()*compress) {
                return sectors.get(i);
            }*/
        }
        return sectors.get(sectors.size() - 1);
    }
}
