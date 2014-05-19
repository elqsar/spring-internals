import cz.boris.demo.SimpleDaoImpl
import cz.boris.demo.SimpleDaoUser

/**
 * Created by Boris on 14.5.2014.
 */

beans {
    simpleDao(SimpleDaoImpl)
    simpleDaoUser(SimpleDaoUser) { bean ->
        bean.scope = 'prototype'
        simpleDao = simpleDao
    }
}
