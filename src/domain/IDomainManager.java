package domain;

import attribute.Domain;

/**
 * 域名管理
 */
public interface IDomainManager {
    /**
     * 上报域名网络状况
     *
     * @param domain            域名
     * @param elapsedTimeMillis 耗时
     * @param exception         网络请求中出现的异常。
     *                          null表示没有异常
     *                          ConnectException，表示建立网络连接异常
     *                          UnknownHostException， 表示dns解析异常
     */
    public void report(final String domain, long elapsedTimeMillis, final Exception exception);

    /**
     * 直接获取系统提前检测并注入的域名
     * 可搭配文件读写方式或数据库表管理方式完成该功能
     * 低命中，高效率
     */
    public String getDomain();

    /**
     * 通过当前配置获取域名
     * 临时获取域名的操作，此操作会进行网络检测
     * 高命中，低效率
     * @param config 配置
     * @return 域名
     */
    public Domain getDomain(final IConfiguration config);
}