package domain;

/**
 * @description:
 * @author: Fearon
 * @create: 2018/9/22 10:25
 **/
public interface IConfiguration {
    public IDomainManager getDomain();

    public long HttpConnectTimeoutMs();
}
