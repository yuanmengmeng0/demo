package cache;/*
 * @author  yuan meng meng
 * @description:
 * @date 2019/12/20
 * */

public class EntityCache {
    private Object datas;
    private long timeOut;
    private long lastRefreshTime;

    public EntityCache(Object datas, long timeOut, long lastRefreshTime) {
        this.datas = datas;
        this.timeOut = timeOut;
        this.lastRefreshTime = lastRefreshTime;
    }

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    public long getLastRefreshTime() {
        return lastRefreshTime;
    }

    public void setLastRefreshTime(long lastRefreshTime) {
        this.lastRefreshTime = lastRefreshTime;
    }
}
