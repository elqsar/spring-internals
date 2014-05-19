package cz.boris.demo;

/**
 * Created by Boris on 14.5.2014.
 */
public class SimpleDaoUser {

    private SimpleDao simpleDao;

    public void setSimpleDao(SimpleDao simpleDao) {
        this.simpleDao = simpleDao;
    }

    public void callDao() {
        simpleDao.doWork();
    }
}
