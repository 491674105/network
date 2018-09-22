package attribute;

/**
 * @description:
 * @author: Fearon
 * @create: 2018/9/22 11:09
 **/
public class Domain {
    public String domain;
    public boolean primary;

    public Domain(String domain, boolean primary) {
        this.domain = domain;
        this.primary = primary;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    @Override
    public String toString() {
        return "Domain{"
                + "\"domain\"=\"" + domain
                + "\",\"primary\"=\"" + primary
                + "\"}";
    }
}
