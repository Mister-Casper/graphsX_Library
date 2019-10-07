package com.sgc.graphslibrary.Maths;

import com.sgc.graphslibrary.data.PieChartData;

import java.util.ArrayList;

public class AngleMath {

    /**
     *
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
     *Example: If getPercentageSpace () return 10,
     *getCompress () return 5. 10 * 5 angles of space occupied by the sector
     */
    public static float getCompress(ArrayList<PieChartData> data) {
        float sumPercent = 0;

        for (int i = 0; i < data.size(); i++) {
            sumPercent += data.get(i).getPercentageSpace();
        }

        int degreesOfCircle = 360;
        return degreesOfCircle / sumPercent;
    }
}
