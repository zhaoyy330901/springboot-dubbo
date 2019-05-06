package dubbo.server.service;

import com.alibaba.dubbo.config.annotation.Service;
import dubbo.api.CostService;

/**
 * dubbo服务接口 CostService
 * CostServiceImpl 服务的具体实现
 */
@Service
public class CostServiceImpl implements CostService {

    private final Integer totalCost = 1000;

    @Override
    public Integer add(int cost) {
        System.out.println("调用costservice的实现类...");
        System.out.println("dubbo服务实现类执行");
        return cost+totalCost;
    }
}
