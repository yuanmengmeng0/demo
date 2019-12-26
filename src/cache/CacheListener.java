package cache;/*
 * @author  yuan meng meng
 * @description:
 * @date 2019/12/20
 * */

import java.util.logging.Logger;

public class CacheListener {
    Logger logger=Logger.getLogger("cacheLog");
    private CacheManagerImpl cacheManager;
    public CacheListener(CacheManagerImpl cacheManager){
        this.cacheManager = cacheManager;
    }
    public void startListener(){
        new Thread(){
            @Override
            public void run() {
                while (true){
                    for(String key:cacheManager.getAllKeys()){
                        if(cacheManager.isTimeOut(key)){
                            cacheManager.clearByKey(key);
                            logger.info(key+"缓存被清除");
                        }
                    }
                }
            }
        }.start();
    }
}
