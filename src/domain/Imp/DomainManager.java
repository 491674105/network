package domain.Imp;

import com.alibaba.fastjson.JSONObject;
import attribute.Domain;
import domain.IConfiguration;
import domain.IDomainManager;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: Fearon
 * @create: 2018/9/19 15:44
 **/
public class DomainManager implements IDomainManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(DomainManager.class);

    @Override
    public void report(String domain, long elapsedTimeMillis, Exception exception) {

    }

    @Override
    public String getDomain() {
        return null;
    }

    @Override
    public Domain getDomain(IConfiguration config) {
        // 调用外部JSON文件避免重启服务端程序（文件路径视情况而定）
        InputStream inputStream = this.getClass().getResourceAsStream("/domain/domain.json");
        String domainCache = null, domain = null;
        try {
            String data = IOUtils.toString(inputStream, "UTF-8");
            JSONObject object = JSONObject.parseObject(data);

            domain = (String) object.get("primary_domain");
            domainCache = domain;

            // 测试域名及网络状态，必要时进行域名切换
//            report(domain, config.getHttpConnectTimeoutMs(), new Exception());

        } catch (IOException e) {
            LOGGER.error("getDomain : 域名获取失败！", (Object[]) e.getStackTrace());
        }

        return null == domain ? null : new Domain(domain, domain.equalsIgnoreCase(domainCache));
    }
}
