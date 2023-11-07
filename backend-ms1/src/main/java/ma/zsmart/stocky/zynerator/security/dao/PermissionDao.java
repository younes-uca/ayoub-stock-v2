package ma.zsmart.stocky.zynerator.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ma.zsmart.stocky.zynerator.security.bean.Permission;

public interface PermissionDao extends JpaRepository<Permission, Long> {
    public Permission findByName(String name);
}
