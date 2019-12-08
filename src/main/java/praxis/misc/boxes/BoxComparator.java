package praxis.misc.boxes;

import java.util.Comparator;

public class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box box1, Box box2) {

        return box2.getHeight() - box1.getHeight();

    }

}
