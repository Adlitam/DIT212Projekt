package edu.gu.maze.model;

/**
 *
 * @author omega
 */
class Wall implements ISquare{

    @Override
    public int canIMoveHere() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean okayToTeleportHere() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String toString(){
        return "Wall";
    }
}
