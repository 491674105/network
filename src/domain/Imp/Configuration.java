package domain.Imp;

import domain.IConfiguration;
import domain.IDomainManager;

/**
 * @description:
 * @author: Fearon
 * @create: 2018/9/22 10:26
 **/
public class Configuration implements IConfiguration {

    @Override
    public IDomainManager getDomain() {
        return null;
    }

    @Override
    public long HttpConnectTimeoutMs() {
        return 0;
    }
}
