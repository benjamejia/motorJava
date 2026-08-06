package games.toweDefense;

import java.util.ArrayList;
import java.util.List;

public class TowerSelector {
    private List<Tower> towers = new ArrayList<>();

    public void addTower(Tower tower){
        towers.add(tower);
    }

    public List<Tower> getTowers(){
        return towers;
    }
}
